package NT.LostFinder.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import NT.LostFinder.DTO.Lostfinderreply;
import lombok.NonNull;

public class LostfinderreplyDAO {
	public static LostfinderreplyDAO lfr=null;
	public LostfinderreplyDAO() {
	}
	synchronized public static LostfinderreplyDAO getBoardDAO() {
		if(lfr==null)
			lfr=new LostfinderreplyDAO();
		return lfr;
	}
	synchronized public static boolean example(Lostfinderreply data) {
		String sql="sql end";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static boolean createReply(Lostfinderreply data) {
		String sql="insert into lostfinderreply values(?,?,?,?,sysdate)";
		try(Connection con=Connect.getInstance(); PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, data.getReply_uuid());
			ps.setString(2, Integer.toString(data.getBoard_no()));
			ps.setString(3, data.getMember_id());
			ps.setString(4, data.getReply_content());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	synchronized public static boolean deleteReply(Lostfinderreply data) {
		String sql="delete from lostfinderreply where reply_uuid='"+data.getReply_uuid()+"' and member_id='"+data.getMember_id()+"'";
		try(Connection con=Connect.getInstance(); PreparedStatement ps=con.prepareStatement(sql);){
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	synchronized public static boolean updateReply(Lostfinderreply data) {
		
		String sql="update lostfinderreply set reply_content = '"+data.getReply_content()+"'  where reply_uuid ='"+data.getReply_uuid()+"'and board_no ='"+data.getBoard_no()+"' and member_id='"+data.getMember_id()+"' ";
		try(Connection con=Connect.getInstance(); PreparedStatement ps=con.prepareStatement(sql);){
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	synchronized public static ArrayList<Lostfinderreply>listLostfinderReply() {
		String sql="select * from lostfinderreply order by reply_createdate desc";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery()){
			ArrayList<Lostfinderreply> lists=new ArrayList<Lostfinderreply>();
			if(rs.next()) {
				do
					lists.add(new Lostfinderreply(rs.getString(1),Integer.parseInt(rs.getString(2)),rs.getString(3),rs.getString(4),rs.getTimestamp(5)));
				while(rs.next());
				return lists;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	synchronized public static ArrayList<Lostfinderreply> listLostfinderReply(int data) {
		String sql="select * from lostfinderreply where board_no='"+data+"' order by reply_createdate asc";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery()){
			ArrayList<Lostfinderreply> lists=new ArrayList<Lostfinderreply>();
			if(rs.next()) {
				do
					lists.add(new Lostfinderreply(rs.getString(1),Integer.parseInt(rs.getString(2)),rs.getString(3),rs.getString(4),rs.getTimestamp(5)));
				while(rs.next());
				return lists;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
} 