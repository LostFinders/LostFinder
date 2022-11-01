package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.Servicereplay;

public class ServicereplayDAO {
	public static ServicereplayDAO sr=null;
	private ServicereplayDAO() {
	}
	synchronized public static ServicereplayDAO getBoardDAO() {
		if(sr==null)
			sr=new ServicereplayDAO();
		return sr;
	}
	synchronized public static boolean example(Servicereplay data) {
		String sql="sql commend";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
