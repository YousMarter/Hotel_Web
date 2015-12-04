package Hotel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewPassword extends HttpServlet implements java.io.Serializable {

	public UserInfo ui = new UserInfo();

	
	
	/*
	public static String getCurrentTime() {

		String returnStr = null;

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long date = new Date().getTime() + 1209600000;
		System.out.println("this is date:>>>>>>" + date);
		returnStr = f.format(date);
		return returnStr;
	}*/ //to get the time maybe use in  the sending service

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, java.io.FileNotFoundException {
        
		String email = request.getParameter("email");
		String tpassword = request.getParameter("tpassword");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		try {
			FileInputStream fileIn = new FileInputStream("C:\\apache-tomcat-7.0.34/temp/YourHotel/user/" + email
					+ ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			try {
				ui = (UserInfo) in.readObject();
				
				System.out.println(ui.temppassword);
				System.out.println(tpassword);
				if(ui.temppassword.equals(tpassword)){
					System.out.println(">>>>>>>>>>>>>>i am here1");
					if(password1.equals(password2)){
						
						ui.password=password1;
						ui.temppassword=createpassword();
						writepassword();
						response.setCharacterEncoding("utf-8");
						PrintWriter out = response.getWriter();
						out.print("<script>alert('Password has been reset.Use it to login.'); window.location='HomePage.jsp' </script>");
						out.flush();
						out.close();
						
						
		//				response.sendRedirect("HomePage.jsp");
						
					}else{
						
						response.setCharacterEncoding("utf-8");
						PrintWriter out = response.getWriter();
						out.print("<script>alert('new password 2 times no match.'); window.location='doreset.jsp' </script>");
						out.flush();
						out.close();
						
						
				//		response.sendRedirect("doreset.jsp");
						
					}
					
					
				}else{
					
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('temp password error.See the temp password in your email.'); window.location='doreset.jsp' </script>");
					out.flush();
					out.close();
			//		response.sendRedirect("dorest.jsp");
					
				}
				
			} catch (ClassNotFoundException e) {
				response.sendRedirect("reset.jsp");
				e.printStackTrace();
			}
			in.close();
			fileIn.close();

		

		} catch (IOException i) {
			i.printStackTrace();
			try {
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('No email found, Make sure you input the registered email.'); window.location='doreset.jsp' </script>");
				out.flush();
				out.close();
		//		response.sendRedirect("doreset.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	public String createpassword(){
		String password = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < 8; i++) {     
	        int number = random.nextInt(password.length());     
	        sb.append(password.charAt(number));     
	    }     
	    return sb.toString();
		
	}
	
	public void writepassword(){
		
		try {

			// File f = File.createTempFile(item.getItemID(), ".ser");

			File path = new File("C:\\apache-tomcat-7.0.34/temp/YourHotel/user/");
			
			if (!path.exists()) {
				path.mkdir();
			}
			
			File f = new File(path, ui.email + ".ser");
			if (!f.exists()) {
				f.createNewFile();
			}

			FileOutputStream fileOut = new FileOutputStream(f);

			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(ui);
			out.close();
			fileOut.close();
			
			System.out.println("Serialized data is saved in " + f.getAbsolutePath());
		} catch (IOException i1) {
			i1.printStackTrace();

		}

		
	}

}
