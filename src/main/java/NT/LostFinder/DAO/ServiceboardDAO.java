package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.Serviceboard;

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
}