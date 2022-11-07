package NT.LostFinder.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.gson.Gson;

import NT.LostFinder.DAO.MemberDAO;
import NT.LostFinder.DTO.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("*.member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		String order=request.getRequestURI().toString().substring(request.getRequestURI().toString().lastIndexOf("/")+1,request.getRequestURI().toString().indexOf("."));
		switch(order) {
			case "create":
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(request.getParameter("member_pw").getBytes());
				if(MemberDAO.signup(new Member(request.getParameter("member_id"),String.format("%064x", new BigInteger(1, md.digest())),request.getParameter("member_name"),request.getParameter("member_phone"),request.getParameter("member_email"),request.getParameter("member_zipcode"),request.getParameter("member_address"),request.getParameter("member_building"),1,Integer.parseInt(request.getParameter("pwquestion_no")),request.getParameter("member_pwanswer"))))
					response.sendRedirect("/LostFinder");
				else
					response.sendRedirect("signUp.jsp?sign=fail");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			break;
			case "login":
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
				md.update(request.getParameter("member_pw").getBytes());
				Member member=MemberDAO.loginCheck(new Member(request.getParameter("member_id"),String.format("%064x", new BigInteger(1, md.digest()))));
				if(member!=null) {
					hs.setAttribute("member_id",member.getMember_id());
					hs.setAttribute("member_pw",member.getMember_pw());
					hs.setAttribute("member_name",member.getMember_name());
					hs.setAttribute("member_phone",member.getMember_phone());
					hs.setAttribute("member_email",member.getMember_email());
					hs.setAttribute("member_zipcode",member.getMember_zipcode());
					hs.setAttribute("member_address",member.getMember_address());
					hs.setAttribute("member_building",member.getMember_building());
					hs.setAttribute("member_level",member.getMember_level());
					hs.setAttribute("pwquestion_no",member.getPwquestion_no());
					hs.setAttribute("member_pwanswer",member.getMember_pwanswer());
					response.sendRedirect("mypage.jsp");
				}else
					response.sendRedirect("/LostFinder");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			break;
			case "logout":
			break;
			case "idcheck":
				try(PrintWriter pw=new PrintWriter(response.getWriter())){
					pw.print(MemberDAO.idCheck(request.getParameter("member_id")));
				}
			break;
			case "phonecheck":
				try(PrintWriter pw=new PrintWriter(response.getWriter())){
					pw.print(MemberDAO.phoneCheck(request.getParameter("member_phone")));
				}
			break;
			case "emailcheck":
				try(PrintWriter pw=new PrintWriter(response.getWriter())){
					pw.print(MemberDAO.emailCheck(request.getParameter("member_email")));
				}
			break;
			case "pwquestionlist":
				try(PrintWriter pw=new PrintWriter(response.getWriter())){
					pw.print(new Gson().toJson(MemberDAO.pwquestionList()));
				}
			break;
		}
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
