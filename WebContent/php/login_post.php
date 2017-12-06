<!DOCTYPE html>
<html>
  <head>
    <title>Bar</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/test.css" rel="stylesheet" media="screen">
  </head>
  <body>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/getmethod.js"></script>
        <script src="https://use.typekit.net/ayg4pcz.js"></script>
    <script>try{Typekit.load({ async: true });}catch(e){}</script>
    

    <div class="container">
             <h1 class="welcome text-center" align="center">Welcome to <br> Bar Admin Panel</h1>
    
        <div class="card card-container">
        <h2 class='login_title text-center' align="left">Login</h2>
        <hr>
            <form class="form-signin" action="php/login_post.php" method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <p class="input_title">Email</p>
                <input type="text" id="inputEmail" class="login_box" placeholder="abc@example.com" required autofocus>
                <p class="input_title">Password</p>
                <input type="password" id="inputPassword" class="login_box" placeholder="******" required>
                <div id="remember" class="checkbox">
                    <label>
                        
                    </label>
                </div>
               
                <button class="btn btn-lg btn-primary" type="submit" id="submit_button" onclick="click">Login</button>
                <p id="demo"></p>
                 <script type="text/javascript">
               
                var em= $('#inputEmail').val();
                var pas= $('#inputPassword').val();

                $('#submit_button').on('click', function(event) {
                	 event.preventDefault();
                	 var  email= document.getElementById('inputEmail').value;
                     var  password= document.getElementById('inputPassword').value;
                	//  alert(email+" / "+password);
                	 console.log("value..."+email);
                	 document.location.href = 'php/login_post.php';
                	 // document.getElementById("demo").innerHTML ="Email and password are: "+email+"Password is : "+password;
                	});
                </script>
            </form><!-- /form -->
        </div><!-- /card-container -->
    </div><!-- /container -->
 

  </body>
</html>