package Hotel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class BookService extends HttpServlet implements java.io.Serializable  {
	
    boolean status;
	long days;
	String checkoutdate;
	String checkindate;
	String roomid;
	String email;
	double price;
	DateCheck datecheck1=new DateCheck();
	DateCheck datecheck2=new DateCheck();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, FileNotFoundException {
		
           HttpSession session=request.getSession();
           this.email=(String)session.getAttribute("welcome_name");
           this.price=(Double)session.getAttribute("Price");
           this.roomid=(String)session.getAttribute("RoomID");
           String a=request.getParameter("day1");
           String b=request.getParameter("month1");
           String c=request.getParameter("year1");
           this.checkindate = String.format("%s-%s-%s", c, b, a);
           
           String d=request.getParameter("day2");
           String y=request.getParameter("month2");
           String f=request.getParameter("year2");
           this.checkoutdate = String.format("%s-%s-%s", f, y, d);

           status=((datecheck1.isValidDate(checkindate))&&(datecheck2.isValidDate(checkoutdate))); 
           if(status==true){
        	   System.out.println(checkindate);
    	       System.out.println(checkoutdate);
        	   try  
        	   {  
        	       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        	       Date date1 = sdf.parse(checkindate);  
        	       Date date2 = sdf.parse(checkoutdate); 
        	       long i=date1.getTime();
        	       long j=date2.getTime();
        	       System.out.println(i);
        	       System.out.println(j);
        	       days=((j-i)/86400000);
        	       if((j-i)<43200000){
        	    	   try {
        	    			response.setCharacterEncoding("utf-8");
        	   				PrintWriter out = response.getWriter();
        	   				out.print("<script>alert('You can`t stay less than 12 hours in our hotel.'); window.location='book.jsp' </script>");
        	   				out.flush();
        	   				out.close();
        	        	//	   response.sendRedirect("book.jsp");
        	    		  
					} catch (IOException e) {
						
						e.printStackTrace();
					}
        	       }else{
        	    	   
        	    	   Order order=new Order(email, date1, date2, price,roomid,ResetService.createpassword());
        	    	   int s=order.saveorder(order);
        	    	   
        	    	   if(s==1){
        	    		   response.setCharacterEncoding("utf-8");
       	   				PrintWriter out;
						try {
							out = response.getWriter();
							out.print("<script>alert('Room Useable.Turn to Payment.'); window.location='pay.jsp' </script>");
							session.setAttribute("order", order);
	       	   				out.flush();
	       	   				out.close();
	       	        //		   response.sendRedirect("pay.jsp");
						} catch (IOException e) {
							
							e.printStackTrace();
						}
        	    		   
        	    	   }
        	    	   if(s==0){
        	    		   
        	    		   response.setCharacterEncoding("utf-8");
       	   				PrintWriter out;
						try {
							out = response.getWriter();
							out.print("<script>alert('Room not avalible in the time peroid.'); window.location='book.jsp' </script>");
	       	   				out.flush();
	       	   				out.close();
	       	        	//	   response.sendRedirect("book.jsp");
	        	    		   
						} catch (IOException e) {
							
							e.printStackTrace();
						}
       	   			
        	    		   
        	    		   
        	    	   }
        	    	   
        	       }
        	       
        	   }  
        	   catch (ParseException e)  
        	   {  
        	       System.out.println(e.getMessage());  
        	   }  
        	   
           }else{
        	   
        	   try {
   				response.setCharacterEncoding("utf-8");
   				PrintWriter out = response.getWriter();
   				out.print("<script>alert('Invalid date entered'); window.location='book.jsp' </script>");
   				out.flush();
   				out.close();
        		//   response.sendRedirect("book.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
        	   
           }
           
		
	}
}
