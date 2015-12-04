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

<%@page import="java.util.*,Hotel.* "%>
<%   
Order order=(Order)session.getAttribute("order");
String username=order.getemail();
Date ind=order.getcheckin();
Date outd=order.getcheckout();
double price=order.getroomcost();
double cost=((outd.getTime()-ind.getTime())/86400000)*price;
%>




<!DOCTYPE html>
<head>
	<title>Payment Form</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-gray">

	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">Entry Your Hotel Payment Infomation</h1>
			<br><p align="center"> <b> Welcome :<%=welcome_name%><b></p>
			<form class="form-horizontal templatemo-payment-form templatemo-container" role="form" action="PaymentService" method="post">	
				<pre class="text-center">UserName:<%=username %>           Total Cost:<%=cost %></pre>
				<br><br><pre class="text-center">Checkin Date:<%=ind%>          Checkout Date:<%=outd %></pre>
                <br><br><p class="text-center">Please enter your payment information below.</p>
				<hr>
				<div class="form-group">
					<label class="col-sm-3 control-label">Payment Options</label>
					<div class="col-sm-9">
						<div class="templatemo-radio-container">
							<label class="radio templatemo-no-padding-top">
			          			<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1">
			          			<img src="images/visa.png" alt="visa logo">
			          			<img src="images/mastercard.png" alt="mastercard logo">
			          			<img src="images/jcb.png" alt="jcb logo">
			          			<img src="images/amex.png" alt="amex logo">
			          		</label>
						</div>
			          </div> 
				</div>		
		        <div class="form-group">
		        	<label class="col-sm-3 control-label">Credit Card</label>
		          	<div class="col-sm-9 templatemo-card-details">
		          		<div class="col-md-12 form-group">
		          			<label for="card_name" class="control-label">Name on card</label>
			            	<input type="text" class="form-control" name="card_name" placeholder="">
		          		</div>
		          		<div class="col-md-12 form-group">
				            <label for="card_number" class="control-label">Card number</label>
				            <input type="text" class="form-control" name="card_number" placeholder="">	            
				         </div>
				         <div class="col-md-12 form-group">				         				         
					         <div class="templatemo-inline-group">
					         	<label class="control-label">Expiry</label>
					         	<div class="col-sm-12 templatemo-select-container">
					         		<select>
						         		<option>-</option>
										<option value="2014">2014</option>
										<option value="2015">2015</option>
										<option value="2016">2016</option>
										<option value="2017">2017</option>
										<option value="2018">2018</option>
										<option value="2019">2019</option>
										<option value="2020">2020</option>
										<option value="2021">2021</option>
										<option value="2022">2022</option>
										<option value="2023">2023</option>
										<option value="2024">2024</option>
									</select> /
									<select>
										<option>-</option>
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
									</select>
					         	</div>
							</div>
							<div class="templatemo-inline-group cvv2-group">
								<div>
									<label for="cvv2" class="control-label text-left">Security Code</label>
									<input type="text" maxlength="3" class="cvv2 form-control" name="cvv2" placeholder="">
									<img src="images/cvv2.jpg" alt="cvv2">
								</div>
					         </div>
				         </div>				         
			         </div>			                        
		        </div>
		        <div class="form-group">
			          <div class="col-sm-9 col-sm-offset-3">
			            <input type="submit" value="Submit" class="btn btn-success btn-round">
			          </div>
			        </div>	
		      </form>
		</div>
	</div>
	
	    
	
	
</body>
</html>