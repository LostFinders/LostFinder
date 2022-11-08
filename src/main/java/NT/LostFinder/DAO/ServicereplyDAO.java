package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.DTO.Servicereply;

public class ServicereplyDAO {
	public static ServicereplyDAO sr=null;
	private ServicereplyDAO() {
	}
	synchronized public static ServicereplyDAO getBoardDAO() {
		if(sr==null)
			sr=new ServicereplyDAO();
		return sr;
	}
	synchronized public static boolean example(Servicereply data) {
		String sql="sql commend";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
