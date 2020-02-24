package servlet;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.*;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		int id = Integer.parseInt(request.getParameter("id"));
		try 
		{
			Emp e = EmpDao.getEmployee(id);
			out.print("<h1 align=\"center\">Update Employee</h1>");
			out.print("<table align=\"center\"><form action='EditServlet2' method='post'>");
			out.print("<tr><td>Id:</td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
			out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
			out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");
			out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
			out.print("<tr><td>Country:</td><td>"
					+ "<select name='country' style='width:147px''>"
					+ "<option>India<option>"
					+ "<option>USA<option>"
					+ "<option>UK<option>"
					+ "<option>others<option>"
					+ "</select></td></tr>");
			out.print("<tr><td>"
					+ "<input type='submit' value='Update'/>"
					+ "</td></tr>");
			out.print("</form></table>");
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		out.close();
	}

}
