
<!DOCTYPE html>
<head>
<title>Create Account</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css">
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-gray">
	<h1 class="margin-bottom-15">Create Account</h1>
	<div class="container">
		<div class="col-md-12">
			<form
				class="form-horizontal templatemo-create-account templatemo-container"
				role="form" action="RegisterService" method="post">
				<div class="form-inner">
					<div class="form-group">
						<div class="col-md-6">
							<label for="first_name" class="control-label">First Name</label>
							<input type="text" class="form-control" name="first_name"
								placeholder="">
						</div>
						<div class="col-md-6">
							<label for="last_name" class="control-label">Last Name</label> <input
								type="text" class="form-control" name="last_name" placeholder="">
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<label for="username" class="control-label">Email</label> <input
								type="email" class="form-control" name="email" placeholder="">
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-6">
							<label for="password" class="control-label">Password</label> <input
								type="password" class="form-control" name="password"
								placeholder="">
						</div>
						<div class="col-md-6">
							<label for="password" class="control-label">Confirm
								Password</label> <input type="password" class="form-control"
								name="password_confirm" placeholder="">
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-6 templatemo-radio-group">
							<label class="radio-inline"> <input type="radio"
								name="optionsRadios" id="optionsRadios1" value="option1">
								Male
							</label> <label class="radio-inline"> <input type="radio"
								name="optionsRadios" id="optionsRadios2" value="option2">
								Female
							</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<label><input type="checkbox">I agree to the <a
								href="javascript:;" data-toggle="modal"
								data-target="#templatemo_modal">Terms of Service</a>
								<div class="modal hide fade">
  							</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12">
							<input type="submit" value="Create account" class="btn btn-info">
							<a href="HomePage.jsp" class="pull-right">HomePage</a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="templatemo_modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Terms of Service</h4>
					
				</div>
								 <div class="modal-body">
    <p>We offer the service of leasing rooms and reserve all the right to make changes to the services we provide.<br> <br>You Hotel  2014  Dedong Zhao & You Wu</p>
  </div>
				
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>