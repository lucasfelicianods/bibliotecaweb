
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<%
        // verificando se tem um atributo login na sessao
    // se tiver vai continuar e mostrar o menu
    if (session.getAttribute("login") != null) {
%>
<html lang="en">
    <head>
        <title>Cliente</title>
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
            });</script>

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
                            <marquee>CONSULTE NOSSO ACERVO</marquee>
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

                                        <li>
                                            <label>Par�metros de Pesquisa</label>
                                            <select name="field4" class="field-select">
                                                <option value="Advertise"></option>
                                                <option value="Advertise">Autor</option>
                                                <option value="Partnership">Editora</option>
                                                <option value="General Question">ISBN</option>
                                                <option value="General Question">Titulo</option>
                                            </select>
                                        </li>

                                        <li>
                                            <input type="submit" value="Consultar" />
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
            <table>
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nome </th>
                        <th>Cpf </th>
                        <th>data Nascimento </th>
                        <th>Telefone </th>
                        <th>Celular </th>
                        <th>Endereco </th>
                        <th>Bairro </th>
                        <th>Cep </th>
                        <th>E-mail </th>
                        <th>Obs </th>
                        <th>Editar </th>
                        <th>Excluir </th>
                    </tr>
                </thead>

                <c:forEach items="${cliente}" var="lucas">
                    <tr class="record">

                    <tr>
                        <td class="overflow"><c:out value="${lucas.id}" /></td>
                    <td class="overflow"><c:out value="${lucas.nome}" /></td>
                    <td class="overflow"><c:out value="${lucas.cpf}" /></td>
                    <td class="overflow"><c:out value="${lucas.dataNascimento}" /></td>
                    <td class="overflow"><c:out value="${lucas.telefone}" /></td>
                    <td class="overflow"><c:out value="${lucas.celular}" /></td>
                    <td class="overflow"><c:out value="${lucas.endereco}" /></td>
                    <td class="overflow"><c:out value="${lucas.bairro}" /></td>
                    <td class="overflow"><c:out value="${lucas.cep}" /></td>
                    <td class="overflow"><c:out value="${lucas.email}" /></td>
                    <td class="overflow"><c:out value="${lucas.obs}" /></td>
                    <td>
                        <a href="ControladorCliente?action=edit&id=<c:out value="${lucas.id}"/>">
                    <center> <img class="filter" src="images/editar.png" width="26" /></center>
                    </a>
                    </td>
                    <td>
                        <a href="ControladorCliente?action=delete&id=<c:out value="${lucas.id}"/>">
                    <center> <img class="filter" src="images/deletar.png" width="26" /></center>
                    </a>
                    </td>
                    </tr>
                    </thead>

                </c:forEach>
            </table>

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
<%
        // se n�o existir um login na sessao, 
    // vai enviar para a p�gina de login novamente
} else {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
    }
%>