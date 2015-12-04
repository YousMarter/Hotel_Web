package Hotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PaymentService extends HttpServlet implements java.io.Serializable {

	 String name;
	 String card;
	 Order order;
	 UserInfo ui;
	 String user;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	
	HttpSession session=request.getSession();
	
	name=(String)request.getParameter("card_name");
	card=(String)request.getParameter("card_number");
	order=(Order)session.getAttribute("order");
	user=(String)session.getAttribute("welcome_name");
	System.out.println(name+">>>>>>>>>>>>>"+card);
	//I assume that the payment is successful.
	finalsave(card,order);
	try {
		System.out.println(ui.email);
		System.out.println(ui.order.get(0).getroomcost());
		System.out.println(card);
		response.sendRedirect("confirm.jsp");
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	
	
	
	public void finalsave(String card,Order order){
		
		ArrayList<Order> buffer=new ArrayList<Order>();
		
		try {
			FileInputStream fileIn = new FileInputStream("C:\\apache-tomcat-7.0.34/temp/YourHotel/user/" + user
					+ ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
		    ui = (UserInfo) in.readObject();
		    buffer=ui.order;
			in.close();
			fileIn.close();

		} catch (IOException i) {
			i.printStackTrace();

		} catch (ClassNotFoundException c) {
			System.out.println("User can not found");
			c.printStackTrace();

		}
		
		
		buffer.add(order);
		ui.card=card;
		ui.order=buffer;
		
		try {

			// File f = File.createTempFile(item.getItemID(), ".ser");

			File path = new File("C:\\apache-tomcat-7.0.34/temp/YourHotel/user/");
			
			if (!path.exists()) {
				path.mkdir();
			}
			
			File f = new File(path, user + ".ser");
			if (!f.exists()) {
				f.createNewFile();
			}

			FileOutputStream fileOut = new FileOutputStream(f);

			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(ui);
			out.close();
			fileOut.close();
			
			System.out.println("Serialized data is saved in " + f.getAbsolutePath());
			SendMail s=new SendMail();
			s.send(1, ui);
			
		} catch (IOException i1) {
			i1.printStackTrace();

		}
		
		
		
	}
	
}