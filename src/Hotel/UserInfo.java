package Hotel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;



public class UserInfo implements java.io.Serializable{
	public String firstname;
	public String lastname;
	public String ad1;
	public String ad2;
	public String city;
	public String state;
	public String zipcode; 	
    public ArrayList<Order> order=new ArrayList<Order>();
	public String email;
	public String card;
	public String password;
	public String temppassword;
	
	public void setcard(String card){
		
		this.card=card;
	}
	
	
	
	public void setfirstname(String firstname){
		
		this.firstname=firstname;
	}
	

	public void setlastname(String lastname){
		
		this.lastname=lastname;
	}
	

	public void setad(String ad1,String ad2){
		
		this.ad1=ad1;
		this.ad2=ad2;
	}
	

	public void setciry(String city){
		
		this.city=city;
	}
	

	public void setstate(String state){
		
		this.state=state;
	}
	

	public void setzipcode(String zipcode){
		
		this.zipcode=zipcode;
	}

	public void setemail(String email){
		
		this.email=email;
	}
	
	public void setpassword(String password){
		
		this.password=password;
	}
	
public void settemppassword(String temppassword){
		
		this.temppassword=temppassword;
	}
	
public static UserInfo getUser(String name) {
	UserInfo ui = null;
	if (name == null) {
		return (null);
	}
	try {
		FileInputStream fileIn = new FileInputStream("C:\\apache-tomcat-7.0.34/temp/YourHotel/user/" + name
				+ ".ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		ui = (UserInfo) in.readObject();
		in.close();
		fileIn.close();
		System.out.println("user got!!!");

	} catch (IOException i) {
		i.printStackTrace();

	} catch (ClassNotFoundException c) {
		System.out.println("user can not found");
		c.printStackTrace();

	}
	return ui;

}
	
	
}
