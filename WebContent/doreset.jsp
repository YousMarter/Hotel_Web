
<!DOCTYPE html>
<head>
<title>Reset Password</title>
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
	<h1 class="margin-bottom-15">Reset Password</h1>
	<div class="container">
		<div class="col-md-12">
			<form
				class="form-horizontal templatemo-create-account templatemo-container"
				role="form" action="NewPassword" method="post">
				<div class="form-inner">
					<div class="form-group">
						<div class="col-md-12">
							<label for="username" class="control-label">Email</label> <input
								type="email" class="form-control" name="email" placeholder="">
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-6">
							<label for="password" class="control-label">Temp_Password</label> <input
								type="password" class="form-control" name="tpassword"
								placeholder="">
						</div>
						
						<div class="col-md-6">
							<label for="password" class="control-label">New_Password</label> <input
								type="password" class="form-control" name="password1"
								placeholder="">
						</div>
						
						<div class="col-md-6">
							<label for="password" class="control-label">Confirm new_Password</label> <input
								type="password" class="form-control" name="password2"
								placeholder="">
						</div>
					</div>

					<input type="submit" value="Submit" class="btn btn-danger">
                    <br><br>
					
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