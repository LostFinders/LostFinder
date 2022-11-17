package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import NT.LostFinder.DTO.Lostfinderfile;
import NT.LostFinder.DTO.Location;
import NT.LostFinder.DTO.Lostfinderboard;
import NT.LostFinder.DTO.Servicefile;
import NT.LostFinder.DTO.Tag;

public class LostfinderboardDAO {
	public static LostfinderboardDAO sb=null;
	private LostfinderboardDAO() {
	}
	synchronized public static LostfinderboardDAO getBoardDAO() {
		if(sb==null)
			sb=new LostfinderboardDAO();
		return sb;
	}
	synchronized public static boolean example(Lostfinderboard data) {
		String sql="sql commend";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static boolean createBoard(Lostfinderboard data, ArrayList<Lostfinderfile> file) {
		String sql="insert into lostfinderboard values(lostfinderboard_seq.nextval,?,?,?,?,?,sysdate,default)";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, data.getBoard_title());
			ps.setString(2, data.getMember_id());
			ps.setString(3, data.getBoard_tag());
			ps.setInt(4, data.getLocation_no());
			ps.setString(5, data.getBoard_content());
			if(ps.executeUpdate()==1){
				for(int i=0;i<file.size();i++) {
					sql="insert into lostfinderfile values(?,lostfinderboard_seq.currval,?,?,sysdate)";
					try(PreparedStatement psFile=con.prepareStatement(sql)){
						psFile.setString(1, file.get(i).getBoardfile_uuid());
						psFile.setString(2, file.get(i).getMember_id());
						psFile.setString(3, file.get(i).getBoardfile_name());
						if(psFile.executeUpdate()!=1)
							return false;
					}
				}
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static boolean createBoard(Lostfinderboard data) {
		String sql="insert into lostfinderboard values(lostfinderboard_seq.nextval,?,?,?,?,?,sysdate,default)";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, data.getBoard_title());
			ps.setString(2, data.getMember_id());
			ps.setString(3, data.getBoard_tag());
			ps.setInt(4, data.getLocation_no());
			ps.setString(5, data.getBoard_content());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static ArrayList<Lostfinderboard> list() {
		String sql="select * from Lostfinderboard order by board_createdate desc";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs = ps.executeQuery()){
			ArrayList<Lostfinderboard> AL = new ArrayList<Lostfinderboard>();
			if(rs.next()) {
				do {
					AL.add(new Lostfinderboard(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),Integer.parseInt(rs.getString(5)),rs.getString(6),rs.getTimestamp(7),Integer.parseInt(rs.getString(8))));
				}while(rs.next()); 
				return AL;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	synchronized public static Lostfinderboard view(int data) {
		String sql="select * from Lostfinderboard where board_no='"+data+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery()){
			if(rs.next())
				return new Lostfinderboard(
						Integer.parseInt(rs.getString(1)),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						Integer.parseInt(rs.getString(5)),
						rs.getString(6),
						rs.getTimestamp(7),
						Integer.parseInt(rs.getString(8)));
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	synchronized public static boolean delete(int board_no, String member_id) {
		String sql="delete from Lostfinderboard where board_no='"+board_no+"' and member_id='"+member_id+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
			if(ps.executeUpdate()==1)	
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static boolean update(Lostfinderboard data) {
		String sql="update lostfinderboard set board_title='"+data.getBoard_title()+"',location_no='"+data.getLocation_no()+"', board_content='"+data.getBoard_content()+"' where board_no='"+data.getBoard_no()+"' and member_id='"+data.getMember_id()+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
			if(ps.executeUpdate()==1)
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static ArrayList<Location> locationlist() {
		String sql="select * from location order by location_no";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs = ps.executeQuery()){
			ArrayList<Location> lors=new ArrayList<Location>();
			while(rs.next())
				lors.add(new Location(Integer.parseInt(rs.getString(1)),rs.getString(2)));
			return lors;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	synchronized public static ArrayList<Tag> taglist() {
		String sql="select * from tag";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs = ps.executeQuery()){
			ArrayList<Tag> tal=new ArrayList<Tag>();
			while(rs.next())
				tal.add(new Tag(rs.getString(1)));
			return tal;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	synchronized public static boolean addBoardViewCount(int data) {
		String sql="update lostfinderboard set board_viewcount=board_viewcount+1 where board_no='"+data+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static String downloadFile(Lostfinderfile data) {
		String sql="select * from lostfinderfile where boardfile_uuid='"+data.getBoardfile_uuid()+"' and boardfile_name='"+data.getBoardfile_name()+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery();){
			if(rs.next())
				return rs.getString(1)+"_"+rs.getString(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	synchronized public static ArrayList<Lostfinderfile> viewFileBoard(int data) {
		String sql="select * from lostfinderfile where board_no='"+data+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery()){
			ArrayList<Lostfinderfile> bf=new ArrayList<Lostfinderfile>();
			while(rs.next())
				bf.add(new Lostfinderfile(rs.getString(1),Integer.parseInt(rs.getString(2)),rs.getString(3),rs.getString(4),rs.getTimestamp(5)));
			return bf;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	synchronized public static int listPageBoard(String data){
		String sql="select count(*) from lostfinderboard where member_id='"+data+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery()){
			if(rs.next())
				return Integer.parseInt(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	synchronized public static int listPageBoard(){
		String sql="select count(*) from lostfinderboard";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery()){
			if(rs.next())
				return Integer.parseInt(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	synchronized public static Lostfinderboard viewPageBoard(int data) {
		String sql="select * from lostfinderboard where board_no='"+data+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery()){
			if(rs.next())
				return new Lostfinderboard(
						Integer.parseInt(rs.getString(1)),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						Integer.parseInt(rs.getString(5)),
						rs.getString(6),
						rs.getTimestamp(7),
						Integer.parseInt(rs.getString(8)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	synchronized public static ArrayList<Lostfinderboard> listBoard(int data){
		String sql="select board_no, board_title, member_id, board_tag, location_no, board_content, board_createdate, board_viewcount from (select rownum as rum, board_no, board_title, member_id, board_tag, location_no, board_content, board_createdate, board_viewcount from (select * from lostfinderboard order by board_no)) where rum <= (select count(*) from lostfinderboard) -"+((data-1)*10)+" and rum > (select count(*) from lostfinderboard) -"+(data*10)+" order by rum desc";		
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery()){
			ArrayList<Lostfinderboard> lists=new ArrayList<Lostfinderboard>();
			if(rs.next()) {
				do 
					lists.add(new Lostfinderboard(Integer.parseInt(rs.getString(1)),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							Integer.parseInt(rs.getString(5)),
							rs.getString(6),
							rs.getTimestamp(7),
							Integer.parseInt(rs.getString(8))));
				while(rs.next());
				return lists;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}