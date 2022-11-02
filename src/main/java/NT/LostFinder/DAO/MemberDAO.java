package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import NT.LostFinder.DTO.Member;

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
	synchronized public static Member loginCheck(Member data) {
		String sql="select * from member where member_id='"+data.getMember_id()+"' and member_pw='"+data.getMember_pw()+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery();){
			if(rs.next())
				return new Member(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),Integer.parseInt(rs.getString(9)),Integer.parseInt(rs.getString(10)),rs.getString(11));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
