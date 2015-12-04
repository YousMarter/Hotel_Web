

<!DOCTYPE html>

    <head>
        <meta charset="utf-8">
        
        <% String welcome_name=(String)session.getAttribute("welcome_name");
        String button= "Sign~me~out!";
        String action= "LogOut";
        if (welcome_name==null) {welcome_name="Valued Customer!";
        		button="Sign~me~up!";
        		action="register.jsp";
        };%>
        
        <%@ page import="Hotel.*,java.util.Date,java.util.*"%>
        <% RoomPool.setroom();%>
        <title>You Hotel </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">


        
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/templatemo_main.css">
    </head>
    <body>

        <div id="main-wrapper">

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center templatemo-logo margin-top-20">
                <h1 style="color:white" style="font-size:300%">
                   <b>Your Hotel</b>
                </h1>
            
            </div>
                	
            <div class="image-section">
                <div class="image-container">
                    <img src="images/HomePage.jpg" id="menu-img" class="main-img inactive" alt="Your Hotel">
                </div>
            </div>
            
<hr><br><br><form align="middle" style="color:white; font-size:15px" action=<%=action %>><br><br><br><br> Welcome :<%=welcome_name%></b><br><input align="middle" style="color: black" type="submit"
		value=<%=button %>></form>
            <div class="container">
                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-md-offset-2 col-lg-offset-2 templatemo-content-wrapper">
                    <div class="templatemo-content">
                        
                        <section id="menu-section" class="active">
                            <div class="row">
                                <div class="col-xs-6 col-sm-3 col-md-3 col-lg-3 margin-bottom-20">
                                    <a href="HomePage.jsp">
                                        <div class="black-bg btn-menu">
                                         
                                            <h2>HomePage</h2>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-xs-6 col-sm-3 col-md-3 col-lg-3 margin-bottom-20">
                                    <a href="CheckLogAgain">
                                        <div class="black-bg btn-menu">
                                        <h2>My Order</h2>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-xs-6 col-sm-3 col-md-3 col-lg-3 margin-bottom-20">
                                    <a href="DoubleCheck" >
                                        <div class="black-bg btn-menu">
                                          
                                            <h2>Room Service</h2>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-xs-6 col-sm-3 col-md-3 col-lg-3 margin-bottom-20">
                                    <a href="contact.jsp" >
                                        <div class="black-bg btn-menu">
                                           
                                            <h2>Contact us</h2>
                                        </div>
                                    </a>
                                </div>
                            
                                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 margin-bottom-20">
                                    <a href="login.jsp" >
                                        <div class="black-bg btn-menu">
                                            <h2>Login/Register</h2>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 margin-bottom-20">
                                    <a href="CheckLog" >
                                        <div class="black-bg btn-menu">
                                            <h2>Start Booking</h2>
                                        </div>
                                    </a>
                                </div>
                              
                            </div>

						



						<div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 footer">
               <p align="center" style="color: black">

</form>
            <p style="color:white">      Author:You Wu & Dedong Zhao Team copyright@ 2014-2020 for Your Hotel<a href="HomePage.jsp" target="_blank"><br>
           </p>
                </div><!-- /.footer --> 
            </div>

		</div><!-- /#main-wrapper -->
        
        <div id="preloader">
            <div id="status">&nbsp;</div>
        </div><!-- /#preloader -->
        
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.backstretch.min.js"></script>
        <script src="js/templatemo_script.js"></script>

    </body> 
</html>