<!DOCTYPE html>
<%
	// verificando se tem um atributo login na sessao
	// se tiver vai continuar e mostrar o menu
	if(session.getAttribute("login") != null) {
%>
<html lang="en">
    <head>
        <title>Cadastro de Professor</title>
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
                            <marquee>CADASTRO DE PROFESSOR</marquee>
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
                                            <label>Tipo De Cadastro </label>
                                            <input type="email" required name="nome" class="field-long" readonly="" placeholder="PROFESSOR"/>

                                        </li>
                                        <li>
                                        <label>Nome Completo <span class="required">*</span></label>
                                        <input type="text" required name="nome" class="field-long" onblur="valida_campo_nome()" onKeypress="return valida_letras(event)" placeholder="Digite seu Nome Completo" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"   />

                                        </li>
                                        <li>
                                            <label>Email <span class="required">*</span></label>
                                            <input type="email" required name="email" class="field-long" placeholder="Digite seu e-mail" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'" />

                                        </li>
                                        <li>

                                            <label>Cpf <span class="required">*</span></label>
                                            <input type="text" required name="cpf" class="field-long"  onkeypress="return SomenteNumeros(event)"  placeholder="Digite seu cpf" onblur="return verificarCPF(this.value)" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>

                                        <li>
                                            <label>Rg <span class="required">*</span></label>    
                                            <input type="text" required name="rg" class="field-long" onkeypress="return SomenteNumeros(event)"  placeholder="Digite seu rg" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Data Cadastro <span class="required">*</span></label>
                                            <input type="text" required name="datacadastro" class="field-long" onblur="verifica_campo_dataNascimento()" onkeyup="mascaraData(this)" placeholder="Informe a data do cadastro" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Telefone Residencial <span class="required">*</span></label>
                                            <input type="text" required name="telefoneresidencial" class="field-long" onkeypress="return SomenteNumeros(event)" onkeyup="mascaraTelefone(this)"  placeholder="(99)9999-9999" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Telefone Celular <span class="required">*</span></label>
                                            <input type="text" required name="telefonecelular" class="field-long" onkeypress="return SomenteNumeros(event)" onkeyup="mascaraTelefone(this)"  placeholder="(99)9999-9999" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Telefone Comercial <span class="required">*</span></label>
                                            <input type="text" required name="telefonecomercial" class="field-long" onkeypress="return SomenteNumeros(event)" onkeyup="mascaraTelefone(this)"  placeholder="(99)9999-9999" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Rua <span class="required">*</span></label>
                                            <input type="text" required name="rua" class="field-long" placeholder="Digite seu Rua" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Bairro <span class="required">*</span></label>
                                            <input type="text" required name="bairro" class="field-long" placeholder="Digite seu Bairro" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Complemento <span class="required">*</span></label>
                                            <input type="text" required name="complemento" class="field-long" placeholder="Digite seu Complemento" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Cidade <span class="required">*</span></label>
                                            <input type="text" required name="cidade" class="field-long" placeholder="Digite sua Cidade" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Estado <span class="required">*</span></label>
                                            <input type="text" required name="estado" class="field-long" placeholder="Digite seu Estado" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Materia <span class="required">*</span></label>
                                            <input type="text" required name="matira" class="field-long" placeholder="Digite seu Estado" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Titulação <span class="required">*</span></label>
                                            <input type="text" required name="titulacao" class="field-long" placeholder="Digite seu Estado" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        
                                        <li>
                                            <label>Login <span class="required">*</span></label>
                                            <input type="text" required name="login" class="field-long" placeholder="Digite seu Login" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
                                        </li>
                                        <li>
                                            <label>Senha <span class="required">*</span></label>
                                            <input type="password" required name="senha" class="field-long" placeholder="Digite sua Senha" onfocus="this.style.backgroundColor = '#D3D3D3'" onblur="this.style.backgroundColor = '#ffffff'"/>
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
<%
	// se não existir um login na sessao, 
	// vai enviar para a página de login novamente
	} else {
%>
	<jsp:forward page="login.jsp"></jsp:forward>
<%
}
%>