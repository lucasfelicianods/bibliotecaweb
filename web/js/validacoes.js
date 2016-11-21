
//FUN��O DE VALIDA��O CAMPO NOME
function valida_campo_nome() {

    var x = document.getElementById("nome").value;
    if (x == null || x == "" || x == " ") {
        alert("O campo nome e obrigadorio! Deve ser preenchido!");
        document.getElementById("nome").focus();
        return false;
    }

    var nome = document.getElementById("nome").value
    if (isNaN(nome) == false) {
        alert("Por favor, digite somente letras")
        document.getElementById("nome").focus();
        document.getElementById("nome").value = "";
        return false;
    }

    if (document.getElementById("nome").value.length <= 2) {
        alert("Por favor, preencha o campo nome com mais 3 letras!");
        document.getElementById("nome").focus();
        return false;
    }
}

//VALIDA��O DO CAMPO NOME SOMENTE COM LETRAS 
function valida_letras(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    var tecla = new Number();
    if (window.event) {
        tecla = e.keyCode;
    }
    else if (e.which) {
        tecla = e.which;
    }
    else {
        return true;
    }
    if ((tecla >= "48") && (tecla <= "57")) {
        return false;
    }
}

/* === FIM VALIDA��O DE NOME === */



/* ===  VALIDA��O DE EMAIL === */

// FUN��O DE VALIDA��O CAMPO EMAIL
function valida_campo_email() {

    var x = document.getElementById("email").value;
    if (x == null || x == "" || x == " ") {
        alert("O campo email e obrigadorio! Deve ser preenchido!");
        document.getElementById("email").focus();
        return false;
    }

    var str = document.getElementById("email").value;
    var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    if (filter.test(str))
        valido = true;
    else {
        alert("Este endere�o de e-mail n�o � v�lido!");
        document.getElementById("email").focus();
        document.getElementById("email").value = "";
        valido = false;
    }
    return valido;

    var valido;
}
/* ===  FIM VALIDA��O DE EMAIL === */


//FUN��O VALIDA��O COMPO DATA 
function verifica_campo_dataNascimento() {

    //VALIDA��O DE O CAMPO ESTA VAZIO OU COM ESPA�O 
    var x = document.getElementById("data").value;
    if (x == null || x == "" || x == " ") {
        alert(" O campo data e obrigadorio! Deve ser preenchido!");
        document.getElementById("data").focus();
        document.getElementById("data").value = "";
        return false;
    }

    //VALIDA��O DE FORMATO DE DATA DD/MM/AAAA E VALIDA��O DE DATA ATUAL 
    erro = 0;
    hoje = new Date();
    dataAtual = new Date();
    anoAtual = hoje.getFullYear();
    barras = document.getElementById("data").value.split("/");

    if (barras.length == 3) {
        dia = barras[0];
        mes = barras[1];
        ano = barras[2];
        resultado = (!isNaN(dia) && (dia > 0) && (dia < 32)) && (!isNaN(mes) && (mes > 0) && (mes < 13)) && (!isNaN(ano) && (ano.length == 4) && (ano <= anoAtual && ano >= 1900));
        if (!resultado) {
            alert("Formato de data invalido!");
            document.getElementById("data").focus();
            document.getElementById("data").value = "";
            return false;
        }

        if (new Date(ano, mes - 1, dia) > new Date(dataAtual.getFullYear(), dataAtual.getMonth(), dataAtual.getDate())) {
            alert("Data n�o pode ser maior que data atual");
            document.getElementById("data").focus();
            document.getElementById("data").value = "";
            return false;
        }

        //VALIDA��O DE ANO BISSEXTO
        if ((mes == 02)) {
            if ((dia < 01) || (dia > 28)) {
                alert("Data invalida! Ano Bissexto");
                document.getElementById("data").focus();
                document.getElementById("data").value = "";
            }
        }
    }

    else {
        alert("Formato de data invalido!");
        document.getElementById("data").focus();
        document.getElementById("data").value = "";
        return false;
    }
}

//FUN��O COLOCA MASCA NO CAMPO DATA 
function mascaraData(campoData) {
    var dtnascimento = campoData.value;
    if (dtnascimento.length == 2) {
        dtnascimento = dtnascimento + '/';
        document.forms[0].dtnascimento.value = dtnascimento;
        return true;
    }
    if (dtnascimento.length == 5) {
        dtnascimento = dtnascimento + '/';
        document.forms[0].dtnascimento.value = dtnascimento;
        return true;
    }
}
function mascaraTelefone(campo) {

    function trata(valor, isOnBlur) {

        valor = valor.replace(/\D/g, "");
        valor = valor.replace(/^(\d{2})(\d)/g, "($1)$2");

        if (isOnBlur) {

            valor = valor.replace(/(\d)(\d{4})$/, "$1-$2");
        } else {

            valor = valor.replace(/(\d)(\d{3})$/, "$1-$2");
        }
        return valor;
    }

    campo.onkeypress = function (evt) {

        var code = (window.event) ? window.event.keyCode : evt.which;
        var valor = this.value;

        if (code > 57 || (code < 48 && code != 8)) {
            return false;
        } else {
            this.value = trata(valor, false);
        }
    };

    campo.onblur = function () {

        var valor = this.value;
        if (valor.length < 13) {
            this.value = "";
        } else {
            this.value = trata(this.value, true);
        }
    };

    campo.maxLength = 14;
}
function MascaraCPF(cpf){
        if(mascaraInteiro(cpf)==false){
                event.returnValue = false;
        }       
        return formataCampo(cpf, '000.000.000-00', event);
}
/* === FIM VALIDA��O DE DATA === */

/* == SOMENTE NUMEROS NO CAMPO INPUT == */

function SomenteNumeros(e)
{
	var tecla=new Number();
	if(window.event) {
		tecla = e.keyCode;
	}
	else if(e.which) {
		tecla = e.which;
	}
	else {
		return true;
	}
	if((tecla >= "97") && (tecla <= "122")){
		return false;
	}
}

 function verificarCPF(c){
    var i;
    s = c;
    var c = s.substr(0,9);
    var dv = s.substr(9,2);
    var d1 = 0;
    var v = false;
 
    for (i = 0; i < 9; i++){
        d1 += c.charAt(i)*(10-i);
    }
    if (d1 == 0){
        alert("CPF Invalido")
        v = true;
        return false;
    }
    d1 = 11 - (d1 % 11);
    if (d1 > 9) d1 = 0;
    if (dv.charAt(0) != d1){
        alert("CPF Invalido")
        v = true;
        return false;
    }
 
    d1 *= 2;
    for (i = 0; i < 9; i++){
        d1 += c.charAt(i)*(11-i);
    }
    d1 = 11 - (d1 % 11);
    if (d1 > 9) d1 = 0;
    if (dv.charAt(1) != d1){
        alert("CPF Invalido")
        v = true;
        return false;
    }
    if (!v) {
        alert(c + " CPF Valido")
    }
}















