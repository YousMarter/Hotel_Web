
 
<HEAD><TITLE>Choose a Room</TITLE></HEAD>
 



<%@ page import="Hotel.*,java.util.Date, java.util.ArrayList;" %>
        <% String welcome_name=(String)session.getAttribute("welcome_name");%>

	<%
		UserInfo user=new UserInfo();
		user=UserInfo.getUser(welcome_name);
	
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
			</div><!--/container-->
		</header>		
                    <h3 style="color:black">Welcome To Your Booking</h3>
                   

</html>

<p style="color: black" align="center"> <b> Welcome :<%=welcome_name%><b></p><hr>
<% for(int i =0; i<user.order.size();i++) {%>
<form action="DeleteOrder" align="middle" style="color:black" style="font-size:250%">

 

<input type="HIDDEN" name="count" value=<%=i %>>
<tr align="left" style="color:red" >

<td><pre>           </pre> <b>Order number:  </b><%=i%></td>
<td><pre>           </pre><b>Room number:  </b><%=user.order.get(i).getRoomID()%></td>
<td ><pre>           </pre><b>Check in time:</b><%=user.order.get(i).getcheckin()%></td>
<td ><pre>           </pre><b>Check out time:</b><%=user.order.get(i).getcheckout()%></td>

</tr>
<br><hr>
<input align="center" style="color:red"  type="submit" value="Cancel this room">
</form>     
<%
}
%>
 </table>
<hr>



<br><br><br><br>
    

     
<p style="color:black"  align="middle">
                                Author You Wu Team copyright@ 2014-2016 ...Your Hotel made for csp595. 
</p>
</body>
 </html>