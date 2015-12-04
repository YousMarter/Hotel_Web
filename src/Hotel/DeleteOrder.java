package Hotel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class DeleteOrder extends HttpServlet implements java.io.Serializable  {
	UserInfo user=new UserInfo();
    boolean status;
	long days;
	Date checkoutdate;
	Date checkindate;
	String roomid;
	String email;
	double price;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, FileNotFoundException {
		   
           HttpSession session=request.getSession();
           this.email=(String)session.getAttribute("welcome_name");
           String d=request.getParameter("count");
           
           user=UserInfo.getUser(email);
           this.checkindate = user.order.get(Integer.parseInt(d)).getcheckin();
           
           this.checkoutdate = user.order.get(Integer.parseInt(d)).getcheckout();
           
           if(System.currentTimeMillis()-checkindate.getTime()>604800000){
        	   String code=user.order.get(Integer.parseInt(d)).getCode();
        	   user.order.remove(Integer.parseInt(d));
        	   Order.delete(code);
        	   
        	   try {

   				// File f = File.createTempFile(item.getItemID(), ".ser");

   				File path = new File("C:\\apache-tomcat-7.0.34/temp/YourHotel/user/");
   				
   				if (!path.exists()) {
   					path.mkdir();
   				}
   				
   				File f = new File(path, email + ".ser");
   				if (!f.exists()) {
   					f.createNewFile();
   				}

   				FileOutputStream fileOut = new FileOutputStream(f);

   				ObjectOutputStream out = new ObjectOutputStream(fileOut);
   				out.writeObject(user);
   				out.close();
   				fileOut.close();
   				
   				System.out.println("Serialized data is saved in " + f.getAbsolutePath());} catch (IOException i1) {
   					i1.printStackTrace();

   				}
        	   
        	   try {
	    			response.setCharacterEncoding("utf-8");
	   				PrintWriter out1 = response.getWriter();
	   				out1.print("<script>alert('Your order has been canceled.'); window.location='myorder.jsp' </script>");
	   				out1.flush();
	   				out1.close();
	        	//	   response.sendRedirect("book.jsp");
	    		  
			} catch (IOException e) {
				
				e.printStackTrace();
			}
           } else{
        	   
        	   try {
	    			response.setCharacterEncoding("utf-8");
	   				PrintWriter out = response.getWriter();
	   				out.print("<script>alert('Your order can`t be canceled due to less than one week.'); window.location='myorder.jsp' </script>");
	   				out.flush();
	   				out.close();
	        	//	   response.sendRedirect("book.jsp");
	    		  
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        	   
           }
           
              
        	    	   
	}
}