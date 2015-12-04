package Hotel;

@SuppressWarnings("serial")
public class Room implements java.io.Serializable{
  private String RoomID;
  private double Price;
  private String RoomNumber;
  private String Style;

  public Room(String RoomID, double Price,
                     String RoomNumber, String Style ) {
    setRoomID(RoomID);
    setPrice(Price);
    setRoomNumber(RoomNumber);
    setStyle(Style);
  }
    
  public String getRoomID() {
    return RoomID;
  }

  protected void setRoomID(String RoomID) {
    this.RoomID = RoomID;
  }

  public double getPrice() {
    return Price;
  }

  protected void setPrice(double Price) {
    this.Price = Price;
  }

  public String getRoomNumber() {
    return RoomNumber;
  }

  protected void setRoomNumber(String RoomNumber) {
    this.RoomNumber = RoomNumber;
  }

  public String getStyle() {
    return Style ;
  }

  protected void setStyle(String Style) {
    this.Style = Style;
  }
}
