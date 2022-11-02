package NT.LostFinder.servlet;

import java.io.IOException;

import NT.LostFinder.DAO.MemberDAO;
import NT.LostFinder.DTO.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.NonNull;

@WebServlet("*.member")
@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*5,
		maxRequestSize=1024*1024*10,
		location="D:\\resource\\"
		)
public class MemberCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberCRUD() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		String order=request.getRequestURI().toString().substring(request.getRequestURI().toString().lastIndexOf("/")+1,request.getRequestURI().toString().indexOf("."));
		switch(order) {
			case "create":
			break;
			case "login":
				Member member=MemberDAO.loginCheck(new Member(request.getParameter("member_id"),request.getParameter("member_pw")));
				if(member!=null) {
					hs.setAttribute("member_id",member.getMember_id());
					hs.setAttribute("member_pw",member.getMember_id());
					hs.setAttribute("member_name",member.getMember_id());
					hs.setAttribute("member_phone",member.getMember_id());
					hs.setAttribute("member_email",member.getMember_id());
					hs.setAttribute("member_zipcode",member.getMember_id());
					hs.setAttribute("member_address",member.getMember_id());
					hs.setAttribute("member_building",member.getMember_id());
					hs.setAttribute("member_level",member.getMember_id());
					hs.setAttribute("pwquestion_no",member.getMember_id());
					hs.setAttribute("member_pwanswer",member.getMember_id());
					response.sendRedirect("mypage.jsp");
				}else
					response.sendRedirect("/LostFinder");
			break;
			case "logout":
			break;
		}
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
