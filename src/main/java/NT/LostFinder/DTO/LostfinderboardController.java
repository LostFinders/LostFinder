package NT.LostFinder.DTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import com.google.gson.Gson;

import NT.LostFinder.DAO.LostfinderboardDAO;
import NT.LostFinder.DAO.ServiceboardDAO;
import NT.LostFinder.DTO.FilePart;
import NT.LostFinder.DTO.Lostfinderboard;
import NT.LostFinder.DTO.Serviceboard;
import NT.LostFinder.DTO.Servicefile;

@WebServlet("*.lostfinderboard")
@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*5,
		maxRequestSize=1024*1024*10,
		location="C:\\resource\\"
		)
public class LostfinderboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LostfinderboardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		if (hs.getAttribute("member_id") == null)
			response.sendRedirect("/LostFinder");
		String order = request.getRequestURI().toString().substring(
				request.getRequestURI().toString().lastIndexOf("/") + 1,
				request.getRequestURI().toString().indexOf("."));
		switch (order) {
		case "create":
			if(LostfinderboardDAO.createBoard(new Lostfinderboard(request.getParameter("board_title"),hs.getAttribute("member_id").toString(),request.getParameter("board_content"))))
				response.sendRedirect("list.lostfinderboard?page=1");
			else
				response.sendRedirect("lostfinderboardcreate.jsp");
		break;
		case "list":
			request.setAttribute("lostfinderboardListData", LostfinderboardDAO.list());
			request.getRequestDispatcher("lostfinderboard.jsp").forward(request, response);
			
		break;
		case "view":
			request.setAttribute("lostfinderboardData", LostfinderboardDAO.view(Integer.parseInt(request.getParameter("board_no"))));
			request.getRequestDispatcher("lostfinderboardview.jsp").forward(request, response);
		break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
