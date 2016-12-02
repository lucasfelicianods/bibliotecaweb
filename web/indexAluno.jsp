<%-- 
    Document   : index
    Created on : 20/11/2016, 09:14:19
    Author     : lucas
--%>

<!DOCTYPE html>


<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="format-detection" content="telephone=no" />
<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.1.1.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/script.js"></script> 
<script src="js/superfish.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.mobilemenu.js"></script>
<script src="js/tmStickUp.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<script>
 $(window).load(function(){
  $().UItoTop({ easingType: 'easeOutQuart' });
  $('#stuck_container').tmStickUp({});  
 }); 
</script>

</head>
<body class="page1" id="top">
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
                  
                  
                    <%
	// verificando se tem um atributo login na sessao
	// se tiver vai continuar e mostrar o menu
	if(session.getAttribute("login") == null) {
            
%>
               
               <li><a href="consultarArcevo.jsp">Consultar Acervo</a></li>
               <li><a href="cadastrase.jsp">Cadastra-se</a></li>
               <li><a href="login.jsp">Entrar</a></li>
               <%
        } else{
            %>
               
               
               
               <li><a href="consultarArcevo.jsp">Consultar Acervo</a></li>
               <li><a href="emprestimo.jsp">Emprestimo</a></li>
               <li><a href="reserva.jsp">Reserva</a></li>
               <li><a href="localizacao.jsp">Localização</a></li>
               <li><a href="ServletLogin?acao=logout">Sair</a></li>
               <%
        }
        %>
             </ul>
            </nav>
            <div class="clear"></div>
          </div>       
         <div class="clear"></div>  
        </div>
     </div> 
    </div> 
  </section>
  <section class="page1_header">
    <div class="container">
      <div class="row">
        <div class="grid_4">
          <a href="cadastrarItem.jsp" class="banner "><div class="maxheight">
            <div class="fa fa-globe"></div>Cadastros</div>
          </a>
          <a href="relatorio.jsp" class="banner "><div class="maxheight">
            <div class="fa fa-lightbulb-o"></div>Relatórios</div>
          </a>
          <a href="emprestimo.jsp" class="banner "><div class="maxheight1">
            <div class="fa fa-cog"></div>Emprestimos</div>
          </a>
          <a href="reserva.jsp" class="banner "><div class="maxheight1">
            <div class="fa fa-briefcase"></div>Reservas</div>
          </a>
        </div>
        <div class="grid_5">
          <h2>Biblioteca <br> Web <br> Tec</h2><br><br><br>
          "A leitura engrandece a alma".
        </div>
      </div>
    </div>
  </section>
</header>
<div class="block-1">
  <div class="container">
    <div class="row">
    
      <div class="grid_3">
        
      </div>
      <div class="grid_3">
        
      </div>
      <div class="grid_3">
       
      </div>
    </div>
  </div>
</div>

<section id="content"><div class="ic"></div>
  <div class="container">
    <div class="row">
      <div class="grid_10 preffix_1 ta__center">
        <div class="greet">
          <h3 class="head__1">
              <marquee>BIBLIOTECA WEBTEC, BEM VINDO ALUNO</marquee>
          </h3>
     
        </div>
      </div>
    </div>
  </div>
  <article class="content_gray">
    <div class="container">
      <div class="row">
        <div class="grid_7">
          <h3>Vantagens</h3>
          <div class="block-2">
            <img src="images/page1_img1.jpg" alt="" class="img_inner fleft">
            <div class="extra_wrapper">
              <div class="text1"><a href="#">Descrição</a></div>
              <p>Em nossa Biblioteca Você é capaz de Reservar o Livro, Artigo, Revista é Video. 
                <p> Realizar Cosulta de alguns itens.
                </p> Para Consultar o acervo <a href>CLIQUE AQUI</a>
              <br>
              
            </div>
          </div>
          <div class="block-2">
            <img src="images/page1_img2.jpg" alt="" class="img_inner fleft">
            <div class="extra_wrapper">
              <div class="text1"><a href="#">Objetivo</a></div>
              <p>Tornar de forma simples é rapida a consulta de nossos grandes arcevos de livros, video, artigo é revista.
              </p>Sem sair do conforto de sua casa
              <br>
              
            </div>
          </div>
        </div>
        <div class="grid_4 preffix_1">
          <h3>Depoimentos</h3>
          <blockquote class="bq1">
            <p>?Site Incrivel, é muito pratico, não preciso ir até a bibliote fisica para realizar pesquisa de item, ou ate mesmo realizar uma reserva ?</p>
            <span>Eliza Martins</span>
          </blockquote>
          <blockquote class="bq1">
            <p>?Maior arcevo de livros que já encontrei, sem falar os grandes serviços web que são disponibilizados para nos ajudar..?</p>
            <span>Marcelo Henrique</span>
          </blockquote>
        </div>
      </div>
    </div>
  </article>
  <div class="container">
    <div class="row">
      <div class="grid_5">
        <h4>Sobre Nós</h4>
        <img src="images/page1_img3.jpg" alt="" class="img_inner fleft">
          <p>Trabalho de Conclução do 4 Periodo de ADS</p>
          <p class="offset__1">Alunos:</p>
          Lucas Feliciano de Souza, Jaire Reis, Thiago Rodrigues
      </div>
      <div class="grid_4">
        <h4>Soluções</h4>
        <p>Prover Acesso web centralizado ao acervo da biblioteca</p>
      </div>
      <div class="grid_3">
        <h4>Contato</h4>
        <address>
          <ul class="cont_address">
            <li>SENAI - FATESG - GOIÂNIA</li>
            <li><a href="#">Biblioteca</a></li>
          </ul>
        </address>
      </div>
    </div>
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
