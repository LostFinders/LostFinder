package NT.LostFinder.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import com.google.gson.Gson;

import NT.LostFinder.DAO.LostfinderboardDAO;
import NT.LostFinder.DTO.FilePart;
import NT.LostFinder.DTO.Lostfinderboard;
import NT.LostFinder.DTO.Lostfinderfile;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

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
			Collection<Part> parts=request.getParts();
			if(parts.size()>0) {
				ArrayList<FilePart> fp=new ArrayList<FilePart>();
				for(Part p:parts) {
					if(p.getHeader("Content-Disposition").contains("filename=")) {
						if(p.getSize()>0) {
							String uuid=UUID.randomUUID().toString();
							fp.add(new FilePart(uuid,"C:\\resource\\"+uuid+"_"+p.getSubmittedFileName(),p.getSubmittedFileName(),p));
						}
					}
				}
				ArrayList<Lostfinderfile> bfile=new ArrayList<Lostfinderfile>();
				for(int i=0;i<fp.size();i++) {
					bfile.add(new Lostfinderfile(fp.get(i).getUUID(),0,hs.getAttribute("member_id").toString(),fp.get(i).getFileName(),null));
					fp.get(i).getPart().write(fp.get(i).getFilePart());
				}
				if(LostfinderboardDAO.createBoard(new Lostfinderboard(0,request.getParameter("board_title"),hs.getAttribute("member_id").toString(),request.getParameter("board_tag"),Integer.parseInt(request.getParameter("location_no")),request.getParameter("board_content"),null,0),bfile))
					response.sendRedirect("list.lostfinderboard?page=1");
				else
					response.sendRedirect("list.lostfinderboard?page=1");
			}
			else {
			if(LostfinderboardDAO.createBoard(new Lostfinderboard(0,request.getParameter("board_title"),hs.getAttribute("member_id").toString(),request.getParameter("board_tag"),Integer.parseInt(request.getParameter("location_no")),request.getParameter("board_content"),null,0)))
				response.sendRedirect("list.lostfinderboard?page=1");
			else
				response.sendRedirect("lostfinderboardcreate.jsp");
			}
		break;
		case "list":
			request.setAttribute("lostfinderboardList", LostfinderboardDAO.listBoard(Integer.parseInt(request.getParameter("page"))));
			request.setAttribute("lostfinderboardListPage", (LostfinderboardDAO.listPageBoard()+9)/10);
			request.getRequestDispatcher("lostfinderboard.jsp").forward(request, response);
			
		break;
		case "view":
			LostfinderboardDAO.addBoardViewCount(Integer.parseInt(request.getParameter("board_no")));
			request.setAttribute("lostfinderboardData", LostfinderboardDAO.view(Integer.parseInt(request.getParameter("board_no"))));
			request.setAttribute("locationData", LostfinderboardDAO.locationlist());
			request.setAttribute("lostfinderboardTag", LostfinderboardDAO.taglist());
			request.setAttribute("lostfinderfileData", LostfinderboardDAO.viewFileBoard(Integer.parseInt(request.getParameter("board_no"))));
			request.getRequestDispatcher("lostfinderboardview.jsp").forward(request, response);
		break;
		case "delete":
			LostfinderboardDAO.delete(Integer.parseInt(request.getParameter("board_no")),hs.getAttribute("member_id").toString());
		break;
		case "update":
			LostfinderboardDAO.update(new Lostfinderboard(
				Integer.parseInt(request.getParameter("board_no")),
				request.getParameter("board_title"),
				hs.getAttribute("member_id").toString(),
				request.getParameter("board_tag"),
				Integer.parseInt(request.getParameter("location_no")),
				request.getParameter("board_content"),
				null,
				0));	
		break;
		case "download":
			String downPath=LostfinderboardDAO.downloadFile(new Lostfinderfile(
					request.getParameter("boardfile_uuid"),
					request.getParameter("boardfile_name")));
			if(downPath!=null){
				response.setHeader("content-Disposition","attachment;filename="+new String(request.getParameter("boardfile_name").getBytes("utf8"),"ISO-8859-1"));
				File file=new File("C:\\resource\\"+downPath);
				try(OutputStream os = response.getOutputStream();FileInputStream fis = new FileInputStream(file);DataInputStream dis=new DataInputStream(fis)){
					byte[] fileContents= new byte[(int)file.length()];
					dis.readFully(fileContents);
					os.write(fileContents);
					os.flush();
				}
			}
		break;
	    case "locationlist":
		try (PrintWriter pw = new PrintWriter(response.getWriter())) {
			pw.print(new Gson().toJson(LostfinderboardDAO.locationlist()));
		break;
		}
	}
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
