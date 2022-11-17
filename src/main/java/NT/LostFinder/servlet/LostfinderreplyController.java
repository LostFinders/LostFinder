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
import java.util.UUID;

import com.google.gson.Gson;

import NT.LostFinder.DAO.LostfinderreplyDAO;
import NT.LostFinder.DTO.Lostfinderreply;

@WebServlet("*.lostfinderreply")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024* 10, location = "C:\\resource\\")
public class LostfinderreplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LostfinderreplyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		String order=request.getRequestURI().toString().substring(request.getRequestURI().toString().lastIndexOf("/")+1,request.getRequestURI().toString().indexOf("."));
		switch(order) {
		
		case "list":
			request.setAttribute("lostfinderreplyData", LostfinderreplyDAO.listLostfinderReply());
			request.getRequestDispatcher("lostfinderreplylist.jsp").forward(request, response);
		break;
		
		
		case "view":
			request.setAttribute("lostfinderreplyData", LostfinderreplyDAO.listLostfinderReply(Integer.parseInt(request.getParameter("board_no"))));
			request.getRequestDispatcher("lostfinderreplyview.jsp").forward(request, response);
		break;
		

		case "create":
			String uuid=UUID.randomUUID().toString();
			if(LostfinderreplyDAO.createReply(new Lostfinderreply(uuid,Integer.parseInt(request.getParameter("board_no")), hs.getAttribute("member_id").toString(),request.getParameter("reply_content"),null)))
				response.sendRedirect("view.lostfinderreply?board_no=0");//연동시 수정할듯
			else
				response.sendRedirect("view.lostfinderreply?board_no=0");//항상 0번이 아니니까
			break;

			
		case "update": 
			try(PrintWriter pw=new PrintWriter(response.getWriter())){
				System.out.println(request.getParameter("reply_uuid")+request.getParameter("reply_content")+request.getParameter("board_no")+hs.getAttribute("member_id").toString()); 
				LostfinderreplyDAO.updateReply(new Lostfinderreply(request.getParameter("reply_uuid"), Integer.parseInt(request.getParameter("board_no")), hs.getAttribute("member_id").toString(), request.getParameter("reply_content"), null));
			}
			break;
			

		case "delete":
			try(PrintWriter pw=new PrintWriter(response.getWriter())){
				System.out.println(request.getParameter("reply_uuid")+hs.getAttribute("member_id"));
				pw.print(LostfinderreplyDAO.deleteReply(new Lostfinderreply(request.getParameter("reply_uuid"),0,hs.getAttribute("member_id").toString()," ",null)));
			}
		break;
		}
		
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
			