<!DOCTYPE html>
<html lang="en">
<head>
<title>Lozalização</title>
<meta charset="utf-8">
<meta name="format-detection" content="telephone=no" />
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/form-style-1.css">


<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/script.js"></script> 
<script src="js/superfish.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.mobilemenu.js"></script>
<script src="js/tmStickUp.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<script src="js/validacoes.js"></script>
<script>
 $(window).load(function(){
  $().UItoTop({ easingType: 'easeOutQuart' });
  $('#stuck_container').tmStickUp({});  
 }); 
</script>

</head>
<body>
<!--==============================
              header
=================================-->
<header>
  <div class="container">
    <div class="row">
      <div class="grid_12 rel">
        <h1>
          <a href="index.html">
            <img src="images/logo.png" alt="Logo alt">
          </a>
        </h1>
      </div>
    </div>
  </div>
  <section id="stuck_container">
  <!--==============================
               menu
  =================================-->
    <div class="container">
      <div class="row">
        <div class="grid_12 ">
          <div class="navigation ">
            <nav>
              <ul class="sf-menu">
            
               <li class="current"><a href="index.jsp">Home</a></li>
               <li><a href="cadastrarItem.jsp">Cadastrar Acervo</a></li>
               <li><a href="cadastrase.jsp">Cadastra-se</a></li>
               <li><a href="consultarArcevo.jsp">Consultar Acervo</a></li>
               <li><a href="emprestimo.jsp">Emprestimo</a></li>
               <li><a href="reserva.jsp">Reserva</a></li>
               <li><a href="relatorio.jsp">Relatórios</a></li>
               <li><a href="localizacao.jsp">Localização</a></li>
             </ul>
            </nav>
            <div class="clear"></div>
          </div>       
         <div class="clear"></div>  
        </div>
     </div> 
    </div> 
  </section>
</header>
<!--=====================
          Content
======================-->
<section id="content"><div class="ic"></div>
  <div class="container">
    <div class="row">
	
	<div class="greet">
  <h3 class="head__1">
              <marquee>LOZALIZAÇÃO</marquee>
          </h3>
		  </div>
		 
    </div>
	 
  </div>
  <article class="content_gray offset__1">
    <div class="container">
      <div class="row">
      
 
        <div class="grid_4">
          <div class="block-3">
               
				
				<br><br><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d955.5255939774315!2d-49.2390954660498!3d-16.671759675322917!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x935ef19ba01328eb%3A0x6cf6b0499e87a7cd!2sSenai+Fatesg!5e0!3m2!1spt-BR!2sbr!4v1478453927964" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
        
          </div>
        </div>
        <div class="grid_4">
      
        </div>
      </div>
    </div>
  </article>
  <div class="container">

  </div>
</section>
<!--==============================
              roda pé
=================================-->
<footer id="footer">
  <div class="container">
    <div class="row">
      <div class="grid_12"> 
        <center><div class="copyright"><span class="brand">Biblioteca Web Tec</span> &copy; <span id="copyright-year"></span><a href="#"></a>
          <div class="sub-copy">Construidos Por <a href="#" rel="nofollow">Lucas, Jaire, Thiago</a></div>
            </div></center>
      </div>
    </div>
  </div>  
</footer>
<a href="#" id="toTop" class="fa fa-chevron-up"></a>
</body>
</html>
