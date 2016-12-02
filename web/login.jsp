<%-- 
    Document   : login
    Created on : 25/11/2016, 12:59:52
    Author     : luks_
--%>

<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>LOGIN BIBLIOTECA</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="css/stylelogin.css">

  
</head>

<body>
  
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>LOGIN BIBLIOTECA</h1>
</div>

<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">LOGIN:</h1>
    <form  method="post" action="ServletLogin">
      <div class="input-container">
        <input type="text"  name="login" id="Username" required="required"/>
        <label for="Username">Username</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" name="senha" id="Password" required="required"/>
        <label for="Password">Senha:</label>
        <div class="bar"></div>
      </div>
      <div class="button-container">
        <button><span>Entrar</span></button>
      </div>
      <div class="footer"><a href="#">Esqueceu sua Senha?</a></div>
      <input type="hidden" name="acao" value="login" />
    </form>
  </div>
  <div class="card alt">
    <div class="toggle"></div>
   
      </div>
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

      <script src="js/index.js"></script>

</body>
</html>

