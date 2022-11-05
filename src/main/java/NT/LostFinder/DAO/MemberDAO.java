package NT.LostFinder.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import NT.LostFinder.DTO.Member;
import NT.LostFinder.DTO.PWquestion;

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
	synchronized public static boolean idCheck(String data) {
		String sql="select * from member where member_id='"+data+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery();){
			if(rs.next())
				return false;
			else
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static boolean phoneCheck(String data) {
		String sql="select * from member where member_phone='"+data+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery();){
			if(rs.next())
				return false;
			else
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static boolean emailCheck(String data) {
		String sql="select * from member where member_email='"+data+"'";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery();){
			if(rs.next())
				return false;
			else
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	synchronized public static ArrayList<PWquestion> pwquestionList() {
		String sql="select * from pwquestion";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery();){
			ArrayList<PWquestion> pwrs=new ArrayList<PWquestion>();
			while(rs.next())
				pwrs.add(new PWquestion(Integer.parseInt(rs.getString(1)),rs.getString(2)));
			return pwrs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	synchronized public static boolean signup(Member data) {
		String sql="insert into member values(?,?,?,?,?,?,?,?,default,?,?)";
		try(Connection con=Connect.getInstance();PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, data.getMember_id());
			ps.setString(2, data.getMember_pw());
			ps.setString(3, data.getMember_name());
			ps.setString(4, data.getMember_phone());
			ps.setString(5, data.getMember_email());
			ps.setString(6, data.getMember_zipcode());
			ps.setString(7, data.getMember_address());
			ps.setString(8, data.getMember_building());
			ps.setString(9, Integer.toString(data.getPwquestion_no()));
			ps.setString(10, data.getMember_pwanswer());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
