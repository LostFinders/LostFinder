package NT.LostFinder.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import NT.LostFinder.SqlManager;
import NT.LostFinder.DTO.Serviceboard;
import NT.LostFinder.DTO.Servicefile;

public class ServiceboardDAO {
	public static ServiceboardDAO sb=null;
	private static SqlSessionFactory ssf = SqlManager.getInstance();
	private ServiceboardDAO() {
	}
	synchronized public static ServiceboardDAO getBoardDAO() {
		if(sb==null)
			sb=new ServiceboardDAO();
		return sb;
	}
	synchronized public static boolean example(Serviceboard data) {
		try(SqlSession session=ssf.openSession(true);){
				return true;
		} 
	}
	synchronized public static boolean createBoard(Serviceboard data, ArrayList<Servicefile> files) {
		try(SqlSession session=ssf.openSession(true)){
			if(session.insert("serviceboard_create",data)==1) {
				if(files.size()!=0)
					for(Servicefile file:files)
						session.insert("servicefile_create",file);
				return true;
			}
		}
		return false;
	}
	synchronized public static boolean createBoard(Serviceboard data) {
		try(SqlSession session=ssf.openSession(true)){
			if(session.insert("serviceboard_create",data)==1)
				return true;
		}
		return false;
	}
	synchronized public static ArrayList<Serviceboard> listBoard(int data, String id){
		try(SqlSession session=ssf.openSession(true);){
			HashMap<String,String> list=new HashMap<String,String>();
			ArrayList<Serviceboard> sb= new ArrayList<Serviceboard>(); 
			list.put("data",Integer.toString(data));
			list.put("id", id);
			sb.addAll(session.selectList("serviceboard_lists",list));
			return sb;
		} 
	}
	synchronized public static ArrayList<Serviceboard> listBoard(int data){
		try(SqlSession session=ssf.openSession(true);){
			ArrayList<Serviceboard> sb= new ArrayList<Serviceboard>(); 
			sb.addAll(session.selectList("serviceboard_listsAdmin",data));
			return sb;
		} 
	}
	synchronized public static int listPageBoard(String data){
		try(SqlSession session=ssf.openSession(true);){
			if((int)session.selectOne("serviceboard_listsPageAdmin")>1)
				return session.selectOne("serviceboard_listsPage",data);
		} 
		return 1;
	}
	synchronized public static int listPageBoard(){
		try(SqlSession session=ssf.openSession(true);){
			if((int)session.selectOne("serviceboard_listsPageAdmin")>1)
				return session.selectOne("serviceboard_listsPageAdmin");
		} 
		return 1;
	}
	synchronized public static Serviceboard viewPageBoard(int data) {
		try(SqlSession session=ssf.openSession(true);){
			return session.selectOne("serviceboard_viewboard",data);
		} 
	}
	synchronized public static ArrayList<Servicefile> viewFileBoard(int data) {
		try(SqlSession session=ssf.openSession(true);){
			ArrayList<Servicefile> sf= new ArrayList<Servicefile>();
			sf.addAll(session.selectList("serviceboard_viewfile",data));
			return sf;
		} 
	}
	synchronized public static boolean deleteBoard(int service_no, String member_id) {
		try(SqlSession session=ssf.openSession(true);){
			HashMap<String,String> delete=new HashMap<String,String>();
			delete.put("service_no", Integer.toString(service_no));
			delete.put("member_id", member_id);
			if(session.delete("serviceboard_deleteboard",delete)==1)
				return true;
		} 
		return false;
	}
	synchronized public static boolean updateBoard(Serviceboard data) {
		try(SqlSession session=ssf.openSession(true);){
			if(session.update("serviceboard_updateboard",data)==1)
				return true;
		}
		return false;
	}
	synchronized public static String downloadFile(Servicefile data) {
		try(SqlSession session=ssf.openSession(true);){
			Servicefile sf=session.selectOne("servicefile_download",data);
			return sf.getServicefile_uuid()+"_"+sf.getServicefile_name();
		}
	}
	synchronized public static boolean addBoardViewCount(int data) {
		try(SqlSession session=ssf.openSession(true);){
			if(session.update("serviceboard_addcount",data)==1)
				return true;
		}
		return false;
	}
}