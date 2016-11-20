<!DOCTYPE html>
<html lang="en">
<head>
<title>Emprestimo</title>
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
              Stuck menu
  =================================-->
    <div class="container">
      <div class="row">
        <div class="grid_12 ">
          <div class="navigation ">
            <nav>
              <ul class="sf-menu">
            
               <li class="current"><a href="index.jsp">Home</a></li>
               <li><a href="cadastrarItem.jsp">Cadastrar Item</a></li>
               <li><a href="cliente.jsp">Cliente</a></li>
               <li><a href="funcionario.jsp">Funcionario</a></li>
               <li><a href="emprestimo.jsp">Emprestimo</a></li>
               <li><a href="reserva.jsp">Reserva</a></li>
               <li><a href="relatorio.jsp">Relatórios</a></li>
               <li><a href="localizacao.jsp">Lozalização</a></li>
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
              <marquee>CADASTRO DE EMPRESTIMO</marquee>
          </h3>
		  </div>
		 
    </div>
	 
  </div>
  <article class="content_gray offset__1">
    <div class="container">
      <div class="row">
      
 
        <div class="grid_4">
          <div class="block-3">
               
			   <form>
<ul class="form-style-1">
    <li><label>Codigo</label>
	<input type="text"  name="coidgo" class="field-divided" placeholder="codigo" size="150"/></li>
    <li>
        <label>Data Do Emprestimo <span class="required">*</span></label>
        <input type="email" name="dataDoEmprestimo" class="field-long" />
    </li>
        <li>
        <label>Data Estimada Da Devolução <span class="required">*</span></label>
        <input type="email" name="dataEstimadaDaDevolucao" class="field-long" />
    </li>
       </li>
        <li>
        <label>Data Real Da Devolução <span class="required">*</span></label>
        <input type="email" name="dataRealDaDevolucao" class="field-long" />
    </li>
    <li>
        <label>Nome Da Pessoa</label>
        <select name="field4" class="field-select">
        <option value="Advertise">Lucas</option>
        <option value="Partnership">Jaire</option>
        <option value="General Question">Thiago</option>
        </select>
    </li>
 
    <li>
        <input type="submit" value="Cadastrar" />
		<input type="submit" value="Limpar" />
    </li>
</ul>
</form>
        
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
              footer
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