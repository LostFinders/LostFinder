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

import NT.LostFinder.DAO.ServiceboardDAO;
import NT.LostFinder.DAO.ServicereplyDAO;
import NT.LostFinder.DTO.Serviceboard;
import NT.LostFinder.DTO.Servicereply;

@WebServlet("*.servicereply")
@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*5,
		maxRequestSize=1024*1024*10,
		location="C:\\resource\\"
		)
public class ServicereplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServicereplyController() {
        super();
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession(); // hs. = HttpSession 
		String order=request.getRequestURI().toString().substring(request.getRequestURI().toString().lastIndexOf("/")+1,request.getRequestURI().toString().indexOf("."));
		switch(order) {
			case "create":
				String uuid=UUID.randomUUID().toString();
				ServicereplyDAO.createServicereply(new Servicereply(uuid,Integer.parseInt(request.getParameter("service_no")), hs.getAttribute("member_id").toString(),request.getParameter("reply_content"), null));
			break;
			
			case "list":
					request.setAttribute("servicereplyData", ServicereplyDAO.listServicereply()); // 프론트로 들어갈 객체의 이름, 프론트로 들어갈 값 
					request.getRequestDispatcher("servicereplylist.jsp").forward(request, response);
			break;
			
			case "view":
				request.setAttribute("servicereplyData", ServicereplyDAO.listServicereply(Integer.parseInt(request.getParameter("service_no")))); 
				request.getRequestDispatcher("servicereplyview.jsp").forward(request, response);
			break;
			
			case "delete":
				try(PrintWriter pw=new PrintWriter(response.getWriter())){
					System.out.println(request.getParameter("reply_uuid")+hs.getAttribute("member_id"));
					pw.print(ServicereplyDAO.deleteReply(new Servicereply(request.getParameter("reply_uuid"),0,hs.getAttribute("member_id").toString()," ",null)));
				}
			break;	
			
			case "update": 
		         try(PrintWriter pw=new PrintWriter(response.getWriter())){
		            System.out.println(request.getParameter("reply_uuid")+request.getParameter("reply_content")+request.getParameter("service_no")+hs.getAttribute("member_id").toString()); 
		            ServicereplyDAO.updateReply(new Servicereply(request.getParameter("reply_uuid"), Integer.parseInt(request.getParameter("service_no")), hs.getAttribute("member_id").toString(), request.getParameter("reply_content"), null));
		         }
		         break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
