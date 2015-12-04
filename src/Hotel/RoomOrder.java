package Hotel;



public class RoomOrder {
  private Room room;

  public RoomOrder(Room room) {
    setRoom(room);
  }

  public Room getRoom() {
    return(room);
  }

  protected void setRoom(Room room) {
    this.room = room;
  }

  public String getRoomID() {
    return(getRoom().getRoomID());
  }

  public double getPrice() {
    return(getRoom().getPrice());
  }

  public String getRoomNumber() {
    return(getRoom().getRoomNumber());
  }

  public String getStyle() {
    return(getRoom().getStyle());
  }
  
}
