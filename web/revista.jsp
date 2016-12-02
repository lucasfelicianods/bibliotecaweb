
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
        // verificando se tem um atributo login na sessao
    // se tiver vai continuar e mostrar o menu
    if (session.getAttribute("login") != null) {
%>
<html lang="en">
    <head>
        <title>Revista</title>
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
            $(window).load(function () {
                $().UItoTop({easingType: 'easeOutQuart'});
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

                                        <li class="current"><a href="revista.jsp">Home</a></li>
                                        <li><a href="cadastrarItem.jsp">Cadastrar Acervo</a></li>
                                        <li><a href="cadastrase.jsp">Cadastra-se</a></li>
                                        <li><a href="consultarArcevo.jsp">Consultar Acervo</a></li>
                                        <li><a href="emprestimo.jsp">Emprestimo</a></li>
                                        <li><a href="reserva.jsp">Reserva</a></li>
                                        <li><a href="relatorio.jsp">Relatórios</a></li>
                                        <li><a href="localizacao.jsp">Localização</a></li>
                                        <li><a href="login.jsp">Entrar</a></li>
                                        <li><a href="ServletLogin?acao=logout">Sair</a></li>
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
                            <marquee>CADASTRAR REVISTA</marquee>
                        </h3>
                    </div>

                </div>

            </div>
            <article class="content_gray offset__1">
                <div class="container">
                    <div class="row">


                        <div class="grid_4">
                            <div class="block-3">

                              <form method="POST" action="ServletRevista" name="cadastrorevista">
                                    <ul class="form-style-1">

                                        
                                         <li><label> Titulo <span class="required">*</span></label>
                                            <input type="text"  name="titulo" class="field-divided" placeholder="Titulo" size="150"/></li>
                                        
                                        <li><label>Edição</label>
                                            <input type="text"  name="edicao" class="field-divided" placeholder="edição" size="150"/></li>
                                        <li>
                                        <li><label>Numero de Edição <span class="required">*</span></label>
                                            <input type="text"  name="numerodaedicao" class="field-divided" placeholder="numerodaedicao" size="150"/></li>
                                        <li>
                                        <li><label>Data Da Publicação <span class="required">*</span></label>
                                            <input type="text"  name="dataDaPublicacao" class="field-divided" placeholder="Data Da Publicação" size="150"/></li>
                                        <li>
                                        <div>
                                            <li>
						<select id="editora" name="editora">
							<option value="Selecione uma Editora">Selecione Uma Editora</option>				
							<c:forEach items="${editoras}" var="editora">
								<option value="${editora.nome}">${editora.nome}</option>								
							</c:forEach>
                                                </select>
                                                <br>
                                            <li>  <a href="editora.jsp">Inserir nova editora</a></li>
                                            </li>
					
                                            <br
                                            <br>
                                            <li>
                                            <input type="submit" value="Cadastrar" />
                                            <input type="submit" value="Limpar" />

                                        </li>
                                        </div>
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
<%
        // se não existir um login na sessao, 
    // vai enviar para a página de login novamente
} else {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
    }
%>