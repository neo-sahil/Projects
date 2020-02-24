package servlet;

import java.io.*;
import java.util.*;
import employee.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		List<Emp> list = EmpDao.getAllemployee();
		
		out.print("<head>"
				+ "<link rel=\"stylesheet\" href=\"NewFile.css\"/>"
				+ "</head>");
		out.print("<body>");
		out.print("<h5 align=\"center\"><a href='index.html'>Add new Employee</a></h5>");
		out.print("<table align=\"center\" border='1' width='65%'>");
		out.print("<tr>"
				+ "<th>N</th><th>Name</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th>"
				+ "</tr>");
		
		for(Emp e : list)
		{
			out.print("<tr>"
					+ "<td>*</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td>"
							+ "<td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>"
							+ "<td><a href='DeleteServlet?id="+e.getId()+"'>Delete</a></td>"
					+ "</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.close();
	}

}
