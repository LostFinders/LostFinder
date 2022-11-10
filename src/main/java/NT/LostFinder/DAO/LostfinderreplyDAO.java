package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.DTO.Lostfinderreplay;

public class LostfinderreplyDAO {
	public static LostfinderreplyDAO lfr=null;
	private LostfinderreplyDAO() {
	}
	synchronized public static LostfinderreplyDAO getBoardDAO() {
		if(lfr==null)
			lfr=new LostfinderreplyDAO();
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
