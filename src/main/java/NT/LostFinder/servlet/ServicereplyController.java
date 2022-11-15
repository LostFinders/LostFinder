package NT.LostFinder.servlet;

import java.io.IOException;

import NT.LostFinder.DAO.ServicereplyDAO;
import NT.LostFinder.DTO.Servicereply;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
				if(ServicereplyDAO.createServicereply(new Servicereply("reply_uuid", 0, hs.getAttribute("member_id").toString(),request.getParameter("service_content"), null)))
					response.sendRedirect("serviceboardreply.jsp?page=1");				// member_id의 속성을 String 값으로 받아온다
				else
					response.sendRedirect("serviceboardCreate.jsp");
			break;
			
			case "list":
					request.setAttribute("servicereplyData", ServicereplyDAO.listServicereply()); // 프론트로 들어갈 객체의 이름, 프론트로 들어갈 값 
					request.getRequestDispatcher("ServiceboardreplyList.jsp").forward(request, response);
			break;
			
			case "view":
				request.setAttribute("servicereplyData", ServicereplyDAO.listServicereply()); 
				request.getRequestDispatcher("ServicereplyView.jsp").forward(request, response);
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
