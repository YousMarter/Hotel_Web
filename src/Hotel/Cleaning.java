package Hotel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Cleaning  implements java.io.Serializable{
    
	long ordertime;
	String roomnumber;
	String email;
	String worktime;
	static String filename="Clean_work_list";
	public Cleaning(long ordertime,String worktime,String roomnumber,String email){
	this.ordertime=ordertime;
	this.worktime=worktime;
	this.roomnumber=roomnumber;
	this.email=email;
	}
	
	public void write_worklist(Cleaning onework){
		
		ArrayList<Cleaning>Tlist=new ArrayList<Cleaning>();
		
		Tlist.add(onework);
		
		try {

			// File f = File.createTempFile(item.getItemID(), ".ser");

			File path = new File("C:\\apache-tomcat-7.0.34/temp/YourHotel/clean/");
			
			if (!path.exists()) {
				path.mkdir();
			}
			
			File f = new File(path,  filename+ ".ser");
			if (!f.exists()) {
				f.createNewFile();
			}

			FileOutputStream fileOut = new FileOutputStream(f);

			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Tlist);
			out.close();
			fileOut.close();
			
			System.out.println("Serialized data is saved in " + f.getAbsolutePath());
		} catch (IOException i1) {
			i1.printStackTrace();

		}
	}
}
