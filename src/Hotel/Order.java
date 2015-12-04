package Hotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class Order implements java.io.Serializable {
	private String email;
	private Date checkin;
	private Date checkout;
	private double roomcost;
	private String roomid;
	private String code;
	public static int s1=0;
	public static String array = "orderlist";
	public ArrayList<Order> orderlist;

	public Order(String email, Date checkin, Date checkout, double roomcost,
			String roomid, String code) {
		this.email = email;
		this.checkin = checkin;
		this.checkout = checkout;
		this.roomcost = roomcost;
		this.roomid = roomid;
		this.code=code;
	}

	public Date getcheckin() {
		return checkin;
	}

	public Date getcheckout() {
		return checkout;
	}

	public String getemail() {
		return email;
	}

	public double getroomcost() {
		return roomcost;
	}

	public String getRoomID() {
		return roomid;
	}
	
	public String getCode() {
		return code;
	}

	/*
	 * save orders
	 */
	public int saveorder(Order order) {
		orderlist = new ArrayList<Order>();// create a new arraylist//
		try {
			orderlist = getlist();
			System.out.println(">>>>>>>I am here 10");
		} catch (FileNotFoundException e) {
			System.out.println(">>>>>>>I am here 4");
		}

		System.out.println(">>>>>>>I am here 5");
		
if(s1==0){
	orderlist.add(order);
	writelist(orderlist);
	return 1;
	
}
if(s1==1){
		if(roombusy(order,orderlist)==false){	
	    orderlist.add(order);
		writelist(orderlist);
		System.out.println(">>>>>>>I am here 6");
		return 1;
		}
		else{System.out.println(">>>>>>>I am here 7");
		return 0;	
		
	
		}}
else{return 0;}
  
	}

	@SuppressWarnings({ "unchecked", "resource" })
	public static ArrayList<Order> getlist()
			throws java.io.FileNotFoundException {

		ArrayList<Order> Listbuffer = new ArrayList<Order>();
		try {
			FileInputStream fileIn = new FileInputStream("C:\\apache-tomcat-7.0.34/temp/YourHotel/order/" + array
					+ ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			s1=1;
			try {
				Listbuffer = (ArrayList<Order>) in.readObject();
				System.out.println(">>>>>>>I am here 2");
			} catch (ClassNotFoundException e) {
				return Listbuffer;
			}
			in.close();
			fileIn.close();

		} catch (IOException i) {

			return Listbuffer;

		}

		System.out.println(">>>>>>>I am here 1");
		return Listbuffer;

	}

	public static void writelist(ArrayList<Order> orderlist) {

		try {

			// File f = File.createTempFile(item.getItemID(), ".ser");

			File path = new File("C:\\apache-tomcat-7.0.34/temp/YourHotel/order/");

			if (!path.exists()) {
				path.mkdir();
			}

			File f = new File(path, array + ".ser");
			if (!f.exists()) {
				f.createNewFile();
			}

			FileOutputStream fileOut = new FileOutputStream(f);

			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(orderlist);
			out.close();
			fileOut.close();

			System.out.println("Serialized data is saved in "
					+ f.getAbsolutePath());
		} catch (IOException i1) {
			i1.printStackTrace();

		}

	}

	public boolean roombusy(Order order, ArrayList<Order> orderlist) {
		Date t1 = getcheckin();
		Date t2 = getcheckout();
		boolean s = true;
		for (int i = 0; i < orderlist.size(); i++) {
            
			System.out.println(t1);
			System.out.println(t2);
			System.out.println(orderlist.get(i).checkin);
			System.out.println(orderlist.get(i).checkout);
			System.out.println(">>>>>>>I am here 9");
			System.out.println((t1.getTime() < orderlist.get(i).checkin.getTime() && t2
					.getTime() < orderlist.get(i).checkin.getTime()));
			System.out.println((t2.getTime() > orderlist.get(i).checkout.getTime() & t2
					.getTime() > orderlist.get(i).checkout.getTime()));
			
			
			
			if ((t1.getTime() < orderlist.get(i).checkin.getTime() && t2
					.getTime() < orderlist.get(i).checkin.getTime())
					||(t2.getTime() > orderlist.get(i).checkout.getTime() & t2
							.getTime() > orderlist.get(i).checkout.getTime())==true) {

				s = false;
				System.out.println(">>>>>>>I am here 8");
			}else{s=true;}

		}
		return s;

	}
	
	public static void delete(String code){
		
		try {
			for(int i =0; i<Order.getlist().size();i++){
				if(code.equals(Order.getlist().get(i))){
					
					ArrayList<Order> update=new ArrayList<Order>(); 
							update=Order.getlist();
							update.remove(i);
							Order.writelist(update);
				}
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
}
