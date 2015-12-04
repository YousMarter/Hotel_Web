package Hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckLog extends HttpServlet implements java.io.Serializable  {
	
	
     String status; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		HttpSession session = request.getSession();
		 status=(String)session.getAttribute("status");
		 
		if(status!="1"){
			try {
				;
				 response.setCharacterEncoding("utf-8");
			    	PrintWriter out = response.getWriter();
			    	out.print("<script>alert('Login first before start booking'); window.location='login.jsp' </script>");
			    	out.flush();
			    	out.close();
			//    	response.sendRedirect("login.jsp");
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	 
			if(status=="0"){
				
				try {
			
					 response.setCharacterEncoding("utf-8");
				    	PrintWriter out = response.getWriter();
				    	out.print("<script>alert('Login first before start booking'); window.location='login.jsp' </script>");
				    	out.flush();
				    	out.close();
			//	    	response.sendRedirect("login.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(status=="1"){
				try {
					response.sendRedirect("room.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		 }
	}

