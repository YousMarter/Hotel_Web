<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html lang="en-us">
<head>
<title>Your Hotel</title>
<meta charset="utf-8">
<meta name="description" content="YourHotel">
<meta name="keywords" content="YourHotel">
<meta name="author" content="YourHotel">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<% String welcome_name=(String)session.getAttribute("welcome_name");%>

<%@page import="java.util.*,Hotel.*"%>
<%   
Room room =new Room(null,0,null,null) ;
String RoomID=(String)session.getAttribute("RoomID");
if(RoomID!=null){room = RoomPool.getRoomByID(RoomID);
double  price=room.getPrice();
session.setAttribute("Price", price);
}

     if(RoomID==null){
    	RoomID=request.getParameter("RoomID");//
        room = RoomPool.getRoomByID(RoomID);
        session.setAttribute("RoomID", RoomID);
         
        double  price=room.getPrice();
        session.setAttribute("Price", price);
       
   }
%>













<link rel="stylesheet" href="css/room1.css">
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<!--[if lt IE 8]>
<div style=' clear: both; text-align:center; position: relative;'>
 <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
   <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
</a>
</div>
<![endif]-->
<!--[if lt IE 9]>
    <script type="text/javascript" src="js/html5.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="css/ie.css">
<![endif]-->
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
</div>
<!--/container--> </header>
<h3 style="color: black">Welcome To Your
	Booking</h3>


</html>

<p align="center" style="color: black">
	welcome :<%=welcome_name%></b>
</p>
<hr>
<form align="center" action="BookService" mothod="get">
	<input type="HIDDEN" name="RoomID" value=<%= room.getRoomID()%>>
	<h2 style="color: black" align="center">
		<b>Room style:<%=room.getStyle() %> <br>Room Price:($<%=room.getPrice() %>)
			<br>Room Number:<%= room.getRoomNumber() %></b>
	</h2>
	<center>
		<P style="color: black">Choose the Day you want to checkin</p>
		<P style="color: red">
			Month: <select style="color: blue" name="month1" />
			<option value="01">01</option>
			<option value="02">02</option>
			<option value="03">03</option>
			<option value="04">04</option>
			<option value="05">05</option>
			<option value="06">06</option>
			<option value="07">07</option>
			<option value="08">08</option>
			<option value="09">09</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			</select> Day: <input type="text" size="1px" name="day1"> Year: <select
				style="color: blue" name="year1" />
			<option value="2014">2014</option>
			<option value="2015">2015</option>
			<option value="2016">2016</option>
			</select>
	</center>

	<center>

		<P style="color: black">Choose the Day you want to leave</p>
		<P style="color: red">
			Month: <select style="color: green" name="month2" />
		<option value="01">01</option>
			<option value="02">02</option>
			<option value="03">03</option>
			<option value="04">04</option>
			<option value="05">05</option>
			<option value="06">06</option>
			<option value="07">07</option>
			<option value="08">08</option>
			<option value="09">09</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			</select> Day: <input type="text" size="1px" name="day2"> Year: <select
				style="color: green" name="year2" />
			<option value="2014">2014</option>
			<option value="2015">2015</option>
			<option value="2016">2016</option>
			</select>
	</center>
	<center>
		<input type="SUBMIT" value="Confirm">
	</center>
</form>

<p align="center" style="color: black">
	welcome :<%=welcome_name%></b>
</p>
<hr>
<p align="right" style="color: black">Author You Wu Team copyright@
	2014-2016 ...Your Hotel made for csp595.</p>


</body>
</html>