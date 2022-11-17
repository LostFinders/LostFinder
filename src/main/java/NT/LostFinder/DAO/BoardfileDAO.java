package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.DTO.Lostfinderfile;

public class BoardfileDAO {
	public static BoardfileDAO bfd=null;
	private BoardfileDAO() {
	}
	synchronized public static BoardfileDAO getBoardDAO() {
		if(bfd==null)
			bfd=new BoardfileDAO();
		return bfd;
	}
	synchronized public static boolean example(Lostfinderfile data) {
		String sql="sql commend";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
