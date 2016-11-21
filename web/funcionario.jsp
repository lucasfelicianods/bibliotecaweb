<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Funcionario</title>
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
                                        <li><a href="cadastrarItem.jsp">Cadastrar Item</a></li>
                                        <li><a href="cliente.jsp">Cliente</a></li>
                                        <li><a href="funcionario.jsp">Funcionario</a></li>
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
                            <marquee>CADASTRO DE FUNCIONÁRIO</marquee>
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
                                            <label>Nome Completo <span class="required">*</span></label>
                                            <input type="email" required name="nome" class="field-long" onblur="valida_campo_nome()" onKeypress="return valida_letras(event)" placeholder="Digite seu Nome Completo"/>

                                        </li>
                                        <li>
                                            <label>Email <span class="required">*</span></label>
                                            <input type="email" required name="email" class="field-long" placeholder="Digite seu e-mail" />

                                        </li>

                                        <label>Cpf <span class="required">*</span></label>
                                        <input type="email" required name="cpf" class="field-long" onkeypress="return SomenteNumeros(event)" placeholder="Digite seu cpf" onblur="return verificarCPF(this.value)"/>
                                        </li>
                                        <li>
                                            <label>rg <span class="required">*</span></label>
                                            <input type="email" required name="rg" class="field-long" onkeypress="return SomenteNumeros(event)" placeholder="Digite seu rg"/>
                                        </li>
                                        <li>
                                            <label>dataCadastro <span class="required">*</span></label>
                                            <input type="email" required name="dataCadastro" class="field-long" placeholder="Informe a data do cadastro"/>
                                        </li>
                                        <li>
                                            <label>Telefone Residencial <span class="required">*</span></label>
                                            <input type="email" required name="TelefoneResidencial" class="field-long" onkeypress="return SomenteNumeros(event)" onkeyup="mascaraTelefone(this)"  placeholder="(99)9999-9999"/>
                                        </li>
                                        <li>
                                            <label>Telefone Celular <span class="required">*</span></label>
                                            <input type="email" required name="TelefoneCelular" class="field-long" onkeypress="return SomenteNumeros(event)" onkeyup="mascaraTelefone(this)"  placeholder="(99)9999-9999"/>
                                        </li>
                                        <li>
                                            <label>Telefone Comercial <span class="required">*</span></label>
                                            <input type="email" required name="TelefoneComercial" class="field-long" onkeypress="return SomenteNumeros(event)" onkeyup="mascaraTelefone(this)"  placeholder="(99)9999-9999"/>
                                        </li>
                                        <li>
                                            <label>Rua <span class="required">*</span></label>
                                            <input type="email" required name="Rua" class="field-long" placeholder="Digite seu Rua"/>
                                        </li>
                                        <li>
                                            <label>Bairro <span class="required">*</span></label>
                                            <input type="email" required name="Bairro" class="field-long" placeholder="Digite seu Bairro"/>
                                        </li>
                                        <li>
                                            <label>Complemento <span class="required">*</span></label>
                                            <input type="email" required name="Complemento" class="field-long" placeholder="Digite seu Complemento"/>
                                        </li>
                                        <li>
                                            <label>Cidade <span class="required">*</span></label>
                                            <input type="email" required name="Cidade" class="field-long" placeholder="Digite sua Cidade"/>
                                        </li>
                                        <li>
                                            <label>Estado <span class="required">*</span></label>
                                            <input type="email" required name="Estado" class="field-long" placeholder="Digite seu Estado"/>
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