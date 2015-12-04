

<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>You Hotel Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <% String welcome_name=(String)session.getAttribute("welcome_name");%>
        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        

    </head>

    <body>

        <div class="page-container">
            <h1>Login</h1>
            <form action="LoginService" method="Post">
                <input type="text" name="username" class="username" placeholder="Username">
                <input type="password" name="password" class="password" placeholder="Password">
                 <button type="submit">Sign in</button>
               
                <div class="error"><span>+</span></div>
            </form>
            <form action="reset.jsp" method="post">
                <button type="submit">Forget password</button>
                                <div class="error"><span>+</span></div>
            </form>
            
                  <form action="register.jsp" method="post">
              
                 <button type="submit">Create a new account</button>
                                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
                <form action="HomePage.jsp" method="post">
              
                 <button type="submit">Back To HomePage</button>
            </div>
        </div>
        <br>
        <div align="center">Author:You Wu Team copyright@ 2014-2020 for Your Hotel</div>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>

</html>

