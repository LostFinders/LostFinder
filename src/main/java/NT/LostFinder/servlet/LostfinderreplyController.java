package NT.LostFinder.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import NT.LostFinder.DAO.LostfinderreplyDAO;
import NT.LostFinder.DTO.Lostfinderreply;

@WebServlet("*.lostfinderreply")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024
		* 10, location = "C:\\resource\\")
public class LostfinderreplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LostfinderreplyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		String order=request.getRequestURI().toString().substring(request.getRequestURI().toString().lastIndexOf("/")+1,request.getRequestURI().toString().indexOf("."));
		switch(order) {
		case "create":
			if(LostfinderreplyDAO.createReply(new Lostfinderreply("reply_uuid",0, hs.getAttribute("member_id").toString(),request.getParameter("reply_content"),null)))
				response.sendRedirect("lostfinderboardreply.jsp?page=1");
			else
				response.sendRedirect("lostfinderboardcreate.jsp");
			break;
			
		case "list":
				request.setAttribute("lostfinderreplyData", LostfinderreplyDAO.listLostfinderReply());
				request.getRequestDispatcher("lostfinderboardreplylist.jsp").forward(request, response);
			break;
			
			
		case "view":
				request.setAttribute("lostfinderreplyData", LostfinderreplyDAO.listLostfinderReply(Integer.parseInt(request.getParameter("board_no"))));
				request.getRequestDispatcher("lostfinderboardreplyview.jsp").forward(request, response);
			break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	


}