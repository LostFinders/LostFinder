package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.DTO.PWquestion;

public class PWquestionDAO {
	public static PWquestionDAO pwq=null;
	private PWquestionDAO() {
	}
	synchronized public static PWquestionDAO getBoardDAO() {
		if(pwq==null)
			pwq=new PWquestionDAO();
		return pwq;
	}
	synchronized public static boolean example(PWquestion data) {
		String sql="sql commend";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
