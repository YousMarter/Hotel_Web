package Hotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginService extends HttpServlet implements java.io.Serializable {

	public UserInfo ui = new UserInfo();
	public String welcome_name;
	public String log_status;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		HttpSession session=request.getSession();
	
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username);//test
		System.out.println(password);//test
		  try {
				FileInputStream fileIn = new FileInputStream("C:\\apache-tomcat-7.0.34/temp/YourHotel/user/" + username
						+ ".ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				ui = (UserInfo) in.readObject();
				System.out.println(ui.password);//test
				  if(ui.password.equals(password)){
						try {
							 response.setCharacterEncoding("utf-8");
						    	PrintWriter out = response.getWriter();
						    	out.print("<script>alert('Welcome "+ui.firstname+".'); window.location='HomePage.jsp' </script>");
						    	out.flush();
						    	out.close();
							welcome_name=ui.email;
							log_status="1";
							session.setAttribute("welcome_name", welcome_name);
							session.setAttribute("status", log_status);
			//				response.sendRedirect("HomePage.jsp");
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				  if(!ui.password.equals(password)){
					  log_status="0";
					  session.setAttribute("status", log_status);
					  response.setCharacterEncoding("utf-8");
				    	PrintWriter out = response.getWriter();
				    	out.print("<script>alert('Password un-match please input again.'); window.location='login.jsp' </script>");
				    	out.flush();
				    	out.close();
			//	    	 response.sendRedirect("login.jsp");
				  }
				
				
				
				in.close();
				fileIn.close();
			} catch (java.io.FileNotFoundException i) {
				System.out.println("User can not found");
				  log_status="0";
				  session.setAttribute("status", log_status);
				 response.setCharacterEncoding("utf-8");
			    	PrintWriter out = response.getWriter();
			    	out.print("<script>alert('User can not be found.Make sure the email address has been registered'); window.location='login.jsp' </script>");
			    	out.flush();
			    	out.close();
			  //  	response.sendRedirect("login.jsp");
				i.printStackTrace();

			} catch (Exception c) {
				
				c.printStackTrace();

			}
		  
		  
		

}
}