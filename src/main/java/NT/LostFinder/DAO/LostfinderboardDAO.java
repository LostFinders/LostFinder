package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.DTO.Lostfinderboard;

public class LostfinderboardDAO {
	public static LostfinderboardDAO lfb=null;
	private LostfinderboardDAO() {
	}
	synchronized public static LostfinderboardDAO getBoardDAO() {
		if(lfb==null)
			lfb=new LostfinderboardDAO();
		return lfb;
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
}