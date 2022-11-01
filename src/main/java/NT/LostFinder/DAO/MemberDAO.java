package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import NT.LostFinder.Member;

public class MemberDAO {
	public static MemberDAO md=null;
	private MemberDAO() {
	}
	synchronized public static MemberDAO getBoardDAO() {
		if(md==null)
			md=new MemberDAO();
		return md;
	}
	synchronized public static boolean example(Member data) {
		String sql="sql commend";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
