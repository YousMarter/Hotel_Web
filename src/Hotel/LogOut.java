package Hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogOut extends HttpServlet implements java.io.Serializable  {
	
	
     String status; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		HttpSession session = request.getSession();
		 session.setAttribute("status",null);
		 session.setAttribute("welcome_name", null);
         try {
			response.sendRedirect("HomePage.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		}
	}

