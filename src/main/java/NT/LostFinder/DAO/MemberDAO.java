package NT.LostFinder.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import NT.LostFinder.SqlManager;
import NT.LostFinder.DTO.Member;
import NT.LostFinder.DTO.PWquestion;

public class MemberDAO {
	public static MemberDAO md=null;
	private static SqlSessionFactory ssf = SqlManager.getInstance();
	private MemberDAO() {
	}
	synchronized public static MemberDAO getBoardDAO() {
		if(md==null)
			md=new MemberDAO();
		return md;
	}
	synchronized public static boolean example(Member data) {
		try(SqlSession session=ssf.openSession(true);){
			return true;
		}
	}
	synchronized public static Member loginCheck(Member data) {
		try(SqlSession session=ssf.openSession(true);) {
			HashMap<String,String> loginMap=new HashMap<String,String>();
			loginMap.put("member_id", data.getMember_id());
			loginMap.put("member_pw", data.getMember_pw());
			Member mb=session.selectOne("member_loginCheck",loginMap);
			return mb;
		}
	}
	synchronized public static boolean idCheck(String data) {
		try(SqlSession session=ssf.openSession(true)){
			Member mb=session.selectOne("member_idCheck",data);
			if(mb==null)
				return true;
		}
		return false;
	}
	synchronized public static boolean phoneCheck(String data) {
		try(SqlSession session=ssf.openSession(true)){
			Member mb=session.selectOne("member_phoneCheck",data);
			if(mb==null)
				return true;
		}
		return false;
	}
	synchronized public static boolean emailCheck(String data) {
		try(SqlSession session=ssf.openSession(true)){
			Member mb=session.selectOne("member_emailCheck",data);
			if(mb==null)
				return true;
		}
		return false;
	}
	synchronized public static ArrayList<PWquestion> pwquestionList() {
		try(SqlSession session=ssf.openSession(true)){
			ArrayList<PWquestion> pwls=new ArrayList<PWquestion>();
			if(session.selectList("pwquestion_list")!=null) {
				pwls.addAll(session.selectList("pwquestion_list"));
				return pwls;
			}
		}
		return null;
	}
	synchronized public static boolean signup(Member data) {
		try(SqlSession session=ssf.openSession(true)){
			if(session.insert("member_signup",data)==1)
				return true;
		}
		return false;
	}
	synchronized public static boolean memberDelete(String member_id) {
		try(SqlSession session=ssf.openSession(true)){
			if(session.delete("member_delete",member_id)==1)
				return true;
		}
		return false;
	}
	synchronized public static Member memberData(String data) {
		try(SqlSession session=ssf.openSession(true)){
			return (Member) session.selectOne("member_data",data);
		}
	}
	synchronized public static boolean memberedit(Member data) {
		try(SqlSession session=ssf.openSession(true)){
			if(session.update("member_update",data)==1)
				return true;
		}
		return false;
	}
}