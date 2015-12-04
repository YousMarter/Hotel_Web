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
<% String welcome_name=(String)session.getAttribute("welcome_name");String button= "Sign~me~out!";
        String action= "LogOut";
        if (welcome_name==null) {welcome_name="Valued customer!";
        		button="Sign~me~up!";
        		action="register.jsp";
        };%>












<link rel="stylesheet" href="css/contact.css">
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/script.js"></script>

</head>

<style type="text/css">
<!--
td {
	font-size: 12px;
	color: #666666;
}
-->
</style>

<header class="home_page">
<div class="container">
	<div class="row">
		<div class="span12">
			<a class="logo" href="contact.jsp">Your Hotel</a>

			<ul class="menu">
				<li><a class="home" href="HomePage.jsp">HomePage</a></li>
				<li><a class="about" href="CheckLog">Book Room</a></li>
				<li><a class="work" href="DoubleCheck">Room Service</a></li>
				<li><a class="contact" href="contact.jsp">Contact us</a></li>
			</ul>
		</div>
	</div>
</div>
<!--/container--> </header>
<h3 style="color: black">We Are Glad To
	Hear Your Voice.</h3>	
	<p align="center" style="color: black">
	<b> Welcome:  <%=welcome_name%></b><form  align="middle" action=<%=action %>>
	<input align="middle" style="color: black" type="submit"
		value=<%=button %>>
</form>
<hr>
<p style="color: red" align="center">
	<b>Your Hotel Location : 401E 32nd Street Chicago IL.<b><br>
		<b>Contact Number : 1-312-646-9843 <b>
</p>



<form  align="middle">

<img align="center" width="700" height="500" src="images/map.png">

</form>
<hr><br>

</p>
<p style="color: black" align="middle">Author You Wu & Dedong Zhao Team copyright@
	2014-2016 ...Your Hotel made for csp595.</p>
</body>
</html>