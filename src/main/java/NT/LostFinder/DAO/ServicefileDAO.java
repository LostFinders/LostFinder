package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.Servicefile;

public class ServicefileDAO {
	public static ServicefileDAO sf=null;
	private ServicefileDAO() {
	}
	synchronized public static ServicefileDAO getBoardDAO() {
		if(sf==null)
			sf=new ServicefileDAO();
		return sf;
	}
	synchronized public static boolean example(Servicefile data) {
		String sql="sql commend";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
