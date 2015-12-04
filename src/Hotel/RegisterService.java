package Hotel;

	import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

	public class RegisterService extends HttpServlet implements java.io.Serializable {
		
		UserInfo ui=new UserInfo();
		
	    public static String getCurrentTime() {

            String returnStr = null;

            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	long date = new Date().getTime()+1209600000;
	    	System.out.println("this is date:>>>>>>"+date);
	    	returnStr = f.format(date);
	    	return returnStr;
	    }			    	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
                String firstname = request.getParameter("first_name");
			    ui.setfirstname(firstname);
			    
			    String lastname = request.getParameter("last_name");
			    ui.setlastname(lastname);
			    
			    String email=request.getParameter("email");
			    ui.setemail(email);
			    
			    String password1=request.getParameter("password");
			    String password2=request.getParameter("password_confirm");
			    
			    { if(password1.equals(password2)){
			    	
			    	String password=password1;
			    	ui.setpassword(password);
			    	
			    	 {

			    		
			    			try {

			    				// File f = File.createTempFile(item.getItemID(), ".ser");

			    				File path = new File("C:\\apache-tomcat-7.0.34/temp/YourHotel/user/");
			    	//			File path1 = new File("/temp/YourHotel/user/email.ser");
			    				if (!path.exists()) {
			    					path.mkdir();
			    				}
			    				
			    				File f = new File(path, email + ".ser");
			    				if (!f.exists()) {
			    					f.createNewFile();
			    				

			    				FileOutputStream fileOut = new FileOutputStream(f);

			    				ObjectOutputStream out1 = new ObjectOutputStream(fileOut);
			    				out1.writeObject(ui);
			    				out1.close();
			    				fileOut.close();
			    				
						    	try {
						    		response.setCharacterEncoding("utf-8");
							    	PrintWriter out = response.getWriter();
							    	out.print("<script>alert('Your Account has been actived'); window.location='HomePage.jsp' </script>");
							    	out.flush();
							    	out.close();
						    		
						    		
						    		response.sendRedirect("HomePage.jsp");
								} catch (IOException e) {
									e.printStackTrace();
								}
			    				
			    				System.out.println("Serialized data is saved in " + f.getAbsolutePath());}
			    				
			    				if(f.exists()){
			    					response.setCharacterEncoding("utf-8");
			    			    	PrintWriter out = response.getWriter();
			    			    	out.print("<script>alert('Sorry.This email has been registered.'); window.location='register.jsp' </script>");
			    			    	out.flush();
			    			    	out.close();
			    	//		    	response.sendRedirect("register.jsp");
			    					
			    				}
			    				
			    				
			    			} catch (IOException i1) {
			    				i1.printStackTrace();

			    			}

			    		}

			    	
			    	
			    	
			    }else{
			    try {
			    	response.setCharacterEncoding("utf-8");
			    	PrintWriter out = response.getWriter();
			    	out.print("<script>alert('Sorry.two times passwords un-match, re-input again.'); window.location='register.jsp' </script>");
			    	out.flush();
			    	out.close();
		//	    	response.sendRedirect("register.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			    	
			    }
			    }			    
			 
			   }
						  
					
}

		
		
