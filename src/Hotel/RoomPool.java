package Hotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@SuppressWarnings("serial")
public class RoomPool implements java.io.Serializable {

	private static Room[] room = {
			new Room("r001", 150.00, "101", "single"),
			new Room("r002", 150.00, "102", "single"),
			new Room("r003", 150.00, "201", "couple"),
			new Room("r004", 150.00, "201", "couple"), };

	public static void setroom() {

		for (int i = 0; i < room.length; i++) {
			Room roombase = room[i];
			try {

				// File f = File.createTempFile(item.getItemID(), ".ser");

				File path = new File("C:\\apache-tomcat-7.0.34/temp/YourHotel/room/");
				
				if (!path.exists()) {
					path.mkdir();
				}
				
				File f = new File(path, roombase.getRoomID() + ".ser");
				if (!f.exists()) {
					f.createNewFile();
				}

				FileOutputStream fileOut = new FileOutputStream(f);

				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(roombase);
				out.close();
				fileOut.close();
				
				System.out.println("Serialized data is saved in " + f.getAbsolutePath());
			} catch (IOException i1) {
				i1.printStackTrace();

			}

		}

	}

	public static Room getRoomByID(String RoomID) {
		Room room = null;
		if (RoomID == null) {
			return (null);
		}
		try {
			FileInputStream fileIn = new FileInputStream("C:\\apache-tomcat-7.0.34/temp/YourHotel/room/" + RoomID
					+ ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			room = (Room) in.readObject();
			in.close();
			fileIn.close();

		} catch (IOException i) {
			i.printStackTrace();

		} catch (ClassNotFoundException c) {
			System.out.println("room can not found");
			c.printStackTrace();

		}
		return room;

	}

}

