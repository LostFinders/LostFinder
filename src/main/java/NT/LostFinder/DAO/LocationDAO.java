package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.Location;

public class LocationDAO {
	public static LocationDAO ld=null;
	private LocationDAO() {
	}
	synchronized public static LocationDAO getBoardDAO() {
		if(ld==null)
			ld=new LocationDAO();
		return ld;
	}
	synchronized public static boolean example(Location data) {
		String sql="sql commend";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}