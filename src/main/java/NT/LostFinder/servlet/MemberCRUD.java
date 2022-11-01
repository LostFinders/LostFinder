package NT.LostFinder.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		String order=request.getRequestURI().toString().substring(request.getRequestURI().toString().lastIndexOf("/")+1,request.getRequestURI().toString().indexOf("."));;
		switch(order) {
			case "create":
			break;
		}
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
