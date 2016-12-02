package br.com.bibliotecaweb.bll;

import br.com.bibliotecaweb.dal.PessoaDao;
import br.com.bibliotecaweb.dal.ValidaLogin;
import br.com.bibliotecaweb.model.Funcionario;
import br.com.bibliotecaweb.model.Pessoa;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static sun.security.jgss.GSSUtil.login;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ValidaLogin dal;
    private PessoaDao perfilLogin;

    public ServletLogin() {
        super();
        dal = new ValidaLogin();
        perfilLogin = new PessoaDao();
    }
    Funcionario funcionario = new Funcionario();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String pagina = "logininvalido.jsp";
        // Validando se o usuário é igual a "admin" e a senha é igual a "senha"

        if (request.getParameter("acao").equals("login")) {

            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            Pessoa pessoa = new Pessoa();
            pessoa.setLogin(login);
            pessoa.setSenha(senha);
            dal.ValidarLogin(pessoa);
            //perfilLogin.retornaPerfilCadastro(login);

            if (dal.ValidarLogin(pessoa) == true) {
                HttpSession sessao = request.getSession();
                // setando um atributo da sessao
                sessao.setAttribute("login", request.getParameter("login"));
                if (perfilLogin.validaTipoAluno(login) == true) {
                    RequestDispatcher r = request.getRequestDispatcher("indexAluno.jsp");
                    r.forward(request, response);
                }
                if (perfilLogin.validaTipoProfessor(login) == true) {
                    RequestDispatcher r = request.getRequestDispatcher("indexProfessor.jsp");
                    r.forward(request, response);
                }
                if (perfilLogin.validaTipoFuncionario(login) == true ) {
                    RequestDispatcher r = request.getRequestDispatcher("indexFuncionario.jsp");
                    r.forward(request, response);
                }
                 if (perfilLogin.validaTipoAdministrador(login) == true) {
                    RequestDispatcher r = request.getRequestDispatcher("indexAdministrador.jsp");
                    r.forward(request, response);
                }
////                

                pagina = "index.jsp";

            // como obtive sucesso, chamo a página principal
            } else {
                request.getSession().invalidate();
            }

        } else if (request.getParameter("acao").equals("logout")) {
            // no logout invalido a sessao
            HttpSession sessao = request.getSession();
            sessao.invalidate();
            // chamo novamente a pagina principal, que deve chamar a página index
            // que ira mostrar o formulario para o usuário logar
            pagina = "index.jsp";
        }

        response.sendRedirect(pagina);

    }
}
