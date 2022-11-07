package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.DTO.Serviceboard;

public class ServiceboardDAO {
	public static ServiceboardDAO sb=null;
	private ServiceboardDAO() {
	}
	synchronized public static ServiceboardDAO getBoardDAO() {
		if(sb==null)
			sb=new ServiceboardDAO();
		return sb;
	}
	synchronized public static boolean example(Serviceboard data) {
		String sql="sql commend";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static boolean createboard(Serviceboard data) {
		String sql="insert into serviceboard values(serviceboard_seq.nextval,?,?,?,sysdate,default)";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, data.getService_title());
			ps.setString(2, data.getMember_id());
			ps.setString(3, data.getService_content());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}