<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
 <html>
 
<HEAD><TITLE>Choose a Room</TITLE></HEAD>
 



<%@ page import="Hotel.*,java.util.Date" %>
        <% String welcome_name=(String)session.getAttribute("welcome_name");%>

	<%
		String[] ids = { "r001", "r002", "r003", "r004" };
		
		Room room1 = RoomPool.getRoomByID("r001");
		Room room2 = RoomPool.getRoomByID("r002");
		Room room3 = RoomPool.getRoomByID("r003");
		Room room4 = RoomPool.getRoomByID("r004");
	%>



<!DOCTYPE HTML>
<html lang="en-us">
<head>
    <title>Your Hotel</title>
  	<meta charset="utf-8">
    <meta name="description" content="YourHotel">
    <meta name="keywords" content="YourHotel">
    <meta name="author" content="YourHotel">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>	
   



    <link rel="stylesheet" href="css/bookroom.css">
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/script.js"></script>

</head>
       
		<header class="home_page">
			<div class="container">
            	<div class="row">
                    <div class="span12">
                        <a class="logo" href="room.jsp">Your Hotel</a>
                        
                        <ul class="menu">
                            <li><a class="home" href="HomePage.jsp">HomePage</a></li>
                            <li><a class="about" href="room.jsp">Book Room</a></li>
                            <li><a class="work" href="DoubleCheck">Room Service</a></li>
                            <li><a class="contact" href="contact.jsp">Contact us</a></li>
                        </ul>
                    </div>
                </div>
			</div><!--/container-->
		</header>		
                    <h3 style="color:black">Welcome to Your Booking</h3>
                   

</html>
<form align="middle" action=myorder.jsp>
 <p style="color: black" align="center"> <b> Welcome :<%=welcome_name%><b></p>
<input align="middle" type="submit" value="See My Order">
</form>     
<hr>
<form action="book.jsp">
<input type="HIDDEN" name="RoomID" value=<%= room1.getRoomID() %>>
<h2 style="color:red" align="center">Room style:<%=room1.getStyle() %> 
<br>Room Price:($<%=room1.getPrice() %>)
<br>Room Number:<%= room1.getRoomNumber() %></h2>
<center>
<input type="SUBMIT" value="Book the Room">   
</center>
</form>
<hr>


<hr>
<form action="book.jsp">
<input type="HIDDEN" name="RoomID" value=<%= room2.getRoomID() %>>
<h2 style="color:red" align="center">Room style:<%=room2.getStyle() %> 
<br>Room Price:($<%=room2.getPrice() %>)
<br>Room Number:<%= room2.getRoomNumber() %></h2>
<center>
<input type="SUBMIT" value="Book the Room">   
</center>
</form>
<hr>

<hr>
<form action="book.jsp">
<input type="HIDDEN" name="RoomID" value=<%= room3.getRoomID() %>>
<h2 style="color:red" align="center">Room style:<%=room3.getStyle() %> 
<br>Room Price:($<%=room3.getPrice() %>)
<br>Room Number:<%= room3.getRoomNumber() %></h2>
<center>
<input type="SUBMIT" value="Book the Room">   
</center>
</form>
<hr>

<hr>
<form action="book.jsp">
<input type="HIDDEN" name="RoomID" value=<%= room4.getRoomID() %>>
<h2 style="color:red" align="center">Room style:<%=room4.getStyle() %> 
<br>Room Price:($<%=room4.getPrice() %>)
<br>Room Number:<%= room4.getRoomNumber() %></h2>
<center>
<input type="SUBMIT" value="Book the Room">   
</center>
</form>
<hr>
<br><br> 
<p style="color:black"  align="center">
                                Author You Wu & Dedong Zhao Team copyright@ 2014-2016 ...Your Hotel made for csp595. 
</p>
</body>
 </html>