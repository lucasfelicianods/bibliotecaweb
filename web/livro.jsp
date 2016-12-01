<!DOCTYPE html>
<%
	// verificando se tem um atributo login na sessao
	// se tiver vai continuar e mostrar o menu
	if(session.getAttribute("login") != null) {
%>
<html lang="en">
    <head>
        <title>Livro</title>
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

                                        <li class="current"><a href="index.jsp">Home</a></li>
                                        <li><a href="cadastrarItem.jsp">Cadastrar Acervo</a></li>
                                        <li><a href="cadastrase.jsp">Cadastra-se</a></li>
                                        <li><a href="consultarArcevo.jsp">Consultar Acervo</a></li>
                                        <li><a href="emprestimo.jsp">Emprestimo</a></li>
                                        <li><a href="reserva.jsp">Reserva</a></li>
                                        <li><a href="relatorio.jsp">Relat�rios</a></li>
                                        <li><a href="localizacao.jsp">Localiza��o</a></li>
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
                            <marquee>CADASTRAR LIVRO</marquee>
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

                                        <li><label>Titulo <span class="required">*</span></label>
                                            <input type="text"  name="titulo" class="field-divided" placeholder="Titulo" size="150"/></li>
                                        
                                        <li><label>Codigo De Barras</label>
                                            <input type="text"  name="codigobarras" class="field-divided" placeholder="codigo" size="150"/></li>
                                        <li>
                                        <li><label>Isbn <span class="required">*</span></label>
                                            <input type="text"  name="isbn" class="field-divided" placeholder="Isbn" size="150"/></li>
                                        <li>
                                        <li><label>Descri��o <span class="required">*</span></label>
                                            <input type="text"  name="descricao" class="field-divided" placeholder="Descri��o" size="150"/></li>
                                        <li>
                                            <select id="editora" name="editora" style="width:49%;">
                                                <option value="Selecione uma Editora">Selecione Uma Editora</option>				
                                                <c:forEach items="${editoras}" var="editora" size="150">
                                                    <option value="${editora.nome}">${editora.nome}</option>								
                                                </c:forEach>
                                            </select>
                                                <br>
                                                <br>
                                            <select id="autores" name="autor" style="width:49%;">
                                                <option value="Selecione um Autor">Selecione Um Autor</option>				
                                                <c:forEach items="${autores}" var="autor">
                                                    <option value="${autor.nome}">${autor.nome}</option>								
                                                </c:forEach>
                                                            
                                            </select>
                                                                
                                            <li>
                                            <label>Exemplar Interno</label>
                                            <input type="checkbox" name="exemplarconsultainterna" value="Milk"> Sim
                                        </li>
                                         <li><label>Quantidade Exemplares <span class="required">*</span></label>
                                            <input type="text"  name="quantidadeexemplares" class="field-divided" placeholder="Quantidade Exemplares" size="150"/></li>
                                        <li>
                                        

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
                      roda p�
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
	// se n�o existir um login na sessao, 
	// vai enviar para a p�gina de login novamente
	} else {
%>
	<jsp:forward page="login.jsp"></jsp:forward>
<%
}
%>