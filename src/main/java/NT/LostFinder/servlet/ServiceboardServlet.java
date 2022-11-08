package NT.LostFinder.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import NT.LostFinder.DAO.ServiceboardDAO;
import NT.LostFinder.DTO.Serviceboard;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("*.serviceboard")
@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*5,
		maxRequestSize=1024*1024*10,
		location="C:\\resource\\"
		)
public class ServiceboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServiceboardServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		String order=request.getRequestURI().toString().substring(request.getRequestURI().toString().lastIndexOf("/")+1,request.getRequestURI().toString().indexOf("."));
		switch(order) {
			case "create":
				if(ServiceboardDAO.createBoard(new Serviceboard(request.getParameter("service_title"),hs.getAttribute("member_id").toString(),request.getParameter("service_content"))))
					response.sendRedirect("serviceboard.jsp?page=1");
				else
					response.sendRedirect("serviceboardCreate.jsp");
			break;
			case "list":
				try(PrintWriter pw=new PrintWriter(response.getWriter())){
					if(Integer.parseInt(hs.getAttribute("member_level").toString())==9)
						pw.print(new Gson().toJson(ServiceboardDAO.listBoard(Integer.parseInt(request.getParameter("page")))));
					else
						pw.print(new Gson().toJson(ServiceboardDAO.listBoard(Integer.parseInt(request.getParameter("page")),hs.getAttribute("member_id").toString())));
				}
			break;
			case "listpage":
				try(PrintWriter pw=new PrintWriter(response.getWriter())){
					pw.print((ServiceboardDAO.listPageBoard()+9)/10);
				}
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
