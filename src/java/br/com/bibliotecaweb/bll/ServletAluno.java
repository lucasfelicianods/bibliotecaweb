package br.com.bibliotecaweb.bll;


import br.com.bibliotecaweb.dal.AlunoDao;
import br.com.bibliotecaweb.dal.PessoaDao;
import br.com.bibliotecaweb.model.Aluno;
import br.com.bibliotecaweb.model.Pessoa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;


@WebServlet("/ServletAluno")
public class ServletAluno extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/aluno.jsp";
    private static String LIST_CLIENTE = "/login.jsp";
    private AlunoDao alunoDao;
    private PessoaDao pessoaDao;

    public ServletAluno() throws SQLException{
        super();
        alunoDao = new AlunoDao();
        pessoaDao = new PessoaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("codigo"));
           alunoDao.deleteAluno(id);
            forward = LIST_CLIENTE;
            request.setAttribute("cliente", alunoDao.getTodosAlunos());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Aluno pessoa = alunoDao.consultaPorCodigo(id);
            request.setAttribute("lucas", pessoa);
        } else if (action.equalsIgnoreCase("showCliente")) {
            forward = LIST_CLIENTE;
            
            List<Pessoa> todosClientes = alunoDao.getTodosAlunos();
            for(Pessoa c: todosClientes){
                System.out.println("lucas:" + c.getNome());
            }
            
            request.setAttribute("cliente", alunoDao.getTodosAlunos());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        Aluno aluno = new Aluno();
        aluno.setMatricula(request.getParameter("matricula"));
        aluno.setCurso(request.getParameter("curso"));
        String codigo = request.getParameter("codigo");
        
        
        Pessoa pessoa = new Pessoa();
        
        pessoa.setCpf(request.getParameter("cpf"));
        pessoa.setNome(request.getParameter("nome"));
        pessoa.setRg(request.getParameter("rg"));
        pessoa.setEmail(request.getParameter("email"));
   try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                pessoa.setDataCadastro(sdf.parse(request.getParameter("datacadastro")));
            } catch (ParseException ex) {
                System.out.println("Erro de conversão da data: "
                        + "\nMessage: " + ex.getMessage());
            }
        pessoa.setTelefoneResidecial(request.getParameter("telefoneresidencial"));
        pessoa.setTelefoneCelular(request.getParameter("telefonecelular"));
        pessoa.setTelefoneComercial(request.getParameter("telefonecomercial"));
        pessoa.setLogin(request.getParameter("login"));
        pessoa.setSenha(request.getParameter("senha"));
        pessoa.setRua(request.getParameter("rua"));
        pessoa.setBairro(request.getParameter("bairro"));
        pessoa.setComplementacao(request.getParameter("complemento"));
        pessoa.setCidade(request.getParameter("cidade"));
        pessoa.setEstado(request.getParameter("estado"));
        
        
        if (codigo == null || codigo.isEmpty()) {
            alunoDao.incluirAluno(aluno);
            pessoa.setAluno(alunoDao.consultarPorMatricula(aluno.getMatricula()));
            pessoaDao.incluirPessoa(pessoa);
            
        } else {
            pessoa.setCodigo(Integer.parseInt(codigo));
            alunoDao.updateAlunos(pessoa);
        }
//       pessoaDao.incluirPessoa(pessoa);
        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENTE);
        //request.setAttribute("cliente", alunoDao.getTodosAlunos());
        view.forward(request, response);
    }
}
