package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.DTO.Lostfinderreplay;

public class LostfinderreplayDAO {
	public static LostfinderreplayDAO lfr=null;
	private LostfinderreplayDAO() {
	}
	synchronized public static LostfinderreplayDAO getBoardDAO() {
		if(lfr==null)
			lfr=new LostfinderreplayDAO();
		return lfr;
	}
	synchronized public static boolean example(Lostfinderreplay data) {
		String sql="sql commend";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
