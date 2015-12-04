<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">





<html lang="en-us">
<head>
<title>Your Hotel</title>
<meta charset="utf-8">
<meta name="description" content="YourHotel">
<meta name="keywords" content="YourHotel">
<meta name="author" content="YourHotel">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


<%@page import="java.util.*,Hotel.*,Hotel.Cleaning"%>
<% String welcome_name=(String)session.getAttribute("welcome_name");%>
<%   

    UserInfo user=(UserInfo)session.getAttribute("userinfo");
    ArrayList<Order> order=new ArrayList<Order>();
    order=user.order;
    String worktime=(String)request.getParameter("cleantime");
    System.out.println(">>>>>>>>>>>"+worktime+(String)request.getParameter("cleantime"));
    String roomid=(String)session.getAttribute("checkinroom");
    String roomnumber=RoomPool.getRoomByID(roomid).getRoomNumber();
    Cleaning clean=new Cleaning(System.currentTimeMillis(),worktime,roomnumber,user.email);
    clean.write_worklist(clean);
    %>

	<link rel="stylesheet" href="css/roomservice.css">
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
	
</head>



<header class="home_page">
<div class="container">

	<div class="row">
		<div class="span12">
			<a class="logo" href="roomservice.jsp">Your Hotel</a>

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
<h3 style="color: black" >Enjoy Your Stay
	with Our Service.</h3>
	<br><p style="color: black" align="center">
	<b> Welcome : <%=welcome_name%></b>
</p>

</header>



<P style="color:black" align="center" >  Your Room <%=roomnumber %> will be Cleaned at <%=worktime %>. 

<form align="center"  action="HomePage.jsp">
<input  type="submit" value="Back To Home Page" >
</form>

</P>
<br>
<br>
<br>
<br>

<br>
<br>

<p align="center" style="color: black">Author You Wu Team & Dedong Zhao copyright@	2014-2016 ...Your Hotel made for csp595.</p>


</body>
</html>