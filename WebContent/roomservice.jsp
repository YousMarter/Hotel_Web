<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">







<html lang="en-us">
<head>
<title>Your Hotel</title>
<meta charset="utf-8">
<meta name="description" content="YourHotel">
<meta name="keywords" content="YourHotel">
<meta name="author" content="YourHotel">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


<%@page import="java.util.*,Hotel.*"%>
<% String welcome_name=(String)session.getAttribute("welcome_name");%>
<% String roomid=(String)session.getAttribute("checkinroom");%>
<%   

    UserInfo user=(UserInfo)session.getAttribute("userinfo");
    ArrayList<Order> order=new ArrayList<Order>();
    order=user.order;
    
   
    // ArrayList<Order>validorder=new ArrayList<Order>();
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
<h3 style="color: blaCK">Enjoy Your Stay
	with Our Service.</h3>
</header>


<Form method="get" action="service_process.jsp" >
<% 
     //for(int i=0;i<order.size();i++){
  	 //  if(order.get(i).getcheckin().getTime()<=time&&order.get(i).getcheckout().getTime()>=time)}
  	 
  	 
  	 %>

<p style="color:black; font-size:18px" align="center">Welcome    <%=welcome_name %>,<br> You are now living in room <%=RoomPool.getRoomByID(roomid).getRoomNumber()%> <br>Please choose a time to clean your room</p>
<br>
<h3 align="center">Clean Time:
 <select style="color: blue" name="cleantime" />
			<option value="1pm~2pm">1pm~2pm</option>
			<option value="2pm~3pm">2pm~3pm</option>
			<option value="3pm~4pm">3pm~4pm</option>
			<option value="4pm~5pm">4pm~5pm</option>
</select>
	
 <input type="submit" value="Comfirm">  

</Form>






<br>

<br>
<br>

<p align="middle" style="color: black; font-size:18px">Author You Wu  & Dedong Zhao Team copyright@	2014-2016 ...Your Hotel made for csp595.</p>


</body>
</html>