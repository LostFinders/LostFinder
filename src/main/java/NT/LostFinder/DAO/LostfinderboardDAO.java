package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import NT.LostFinder.DTO.Lostfinderboard;

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
	synchronized public static boolean createBoard(Lostfinderboard data) {
		String sql="insert into lostfinderboard values(lostfinderboard_seq.nextval,?,?,' ',0,?,sysdate,default)";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, data.getBoard_title());
			ps.setString(2, data.getMember_id());
			ps.setString(3, data.getBoard_content());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static ArrayList<Lostfinderboard> list() {
		String sql="select * from Lostfinderboard";
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
}