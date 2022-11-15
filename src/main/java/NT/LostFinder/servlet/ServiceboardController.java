package NT.LostFinder.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import NT.LostFinder.DAO.ServiceboardDAO;
import NT.LostFinder.DTO.FilePart;
import NT.LostFinder.DTO.Serviceboard;
import NT.LostFinder.DTO.Servicefile;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("*.serviceboard")
@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*5,
		maxRequestSize=1024*1024*10,
		location="C:\\resource\\"
		)
public class ServiceboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServiceboardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		if(hs.getAttribute("member_id")==null)
			response.sendRedirect("/LostFinder");
		String order=request.getRequestURI().toString().substring(request.getRequestURI().toString().lastIndexOf("/")+1,request.getRequestURI().toString().indexOf("."));
		switch(order) {
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
					ArrayList<Servicefile> sfile=new ArrayList<Servicefile>();
					for(int i=0;i<fp.size();i++) {
						sfile.add(new Servicefile(fp.get(i).getUUID(),0,hs.getAttribute("member_id").toString(),fp.get(i).getFileName(),null));
						fp.get(i).getPart().write(fp.get(i).getFilePart());
					}
					if(ServiceboardDAO.createBoard(new Serviceboard(request.getParameter("service_title"),hs.getAttribute("member_id").toString(),request.getParameter("service_content")),sfile))
						response.sendRedirect("list.serviceboard?page=1");
					else
						response.sendRedirect("serviceboardCreate.jsp");
				}
				else{
				if(ServiceboardDAO.createBoard(new Serviceboard(request.getParameter("service_title"),hs.getAttribute("member_id").toString(),request.getParameter("service_content"))))
					response.sendRedirect("list.serviceboard?page=1");
				else
					response.sendRedirect("serviceboardCreate.jsp");
				}
			break;
			case "list":
					if(hs.getAttribute("member_level")==null)
						response.sendRedirect("/LostFinder");
					else {
						if(Integer.parseInt(hs.getAttribute("member_level").toString())==9) {
							request.setAttribute("serviceboardListData", ServiceboardDAO.listBoard(Integer.parseInt(request.getParameter("page"))));
							request.setAttribute("serviceboardListPage", (ServiceboardDAO.listPageBoard()+9)/10);
							request.getRequestDispatcher("serviceboard.jsp").forward(request, response);
						}else {
							request.setAttribute("serviceboardListData", ServiceboardDAO.listBoard(Integer.parseInt(request.getParameter("page")),hs.getAttribute("member_id").toString()));
							request.setAttribute("serviceboardListPage", (ServiceboardDAO.listPageBoard(hs.getAttribute("member_id").toString())+9)/10);
							request.getRequestDispatcher("serviceboard.jsp").forward(request, response);
						}
					}
			break;
			case "view":
				if(ServiceboardDAO.addBoardViewCount(Integer.parseInt(request.getParameter("service_no")))) {
					request.setAttribute("serviceboardData", ServiceboardDAO.viewPageBoard(Integer.parseInt(request.getParameter("service_no"))));
					request.setAttribute("servicefileData", ServiceboardDAO.viewFileBoard(Integer.parseInt(request.getParameter("service_no"))));
					request.getRequestDispatcher("serviceboardview.jsp").forward(request, response);
				}else
					response.sendRedirect("/LostFinder");
			break;
			case "delete":
				ServiceboardDAO.deleteBoard(Integer.parseInt(request.getParameter("service_no")),hs.getAttribute("member_id").toString());
			break;
			case "update":
				ServiceboardDAO.updateBoard(new Serviceboard(Integer.parseInt(request.getParameter("service_no")),request.getParameter("service_title"),hs.getAttribute("member_id").toString(),request.getParameter("service_content"),null,0));
			break;
			case "download":
				String downPath=ServiceboardDAO.downloadFile(new Servicefile(request.getParameter("servicefile_uuid"),request.getParameter("servicefile_name")));
				if(downPath!=null){
					response.setHeader("content-Disposition","attachment;filename="+new String(request.getParameter("servicefile_name").getBytes("utf8"),"ISO-8859-1"));
					File file=new File("C:\\resource\\"+downPath);
					try(OutputStream os = response.getOutputStream();FileInputStream fis = new FileInputStream(file);DataInputStream dis=new DataInputStream(fis)){
						byte[] fileContents= new byte[(int)file.length()];
						dis.readFully(fileContents);
						os.write(fileContents);
						os.flush();
					}
				}
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
