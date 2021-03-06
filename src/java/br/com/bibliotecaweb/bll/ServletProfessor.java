package br.com.bibliotecaweb.bll;


import br.com.bibliotecaweb.dal.AlunoDao;
import br.com.bibliotecaweb.dal.PessoaDao;
import br.com.bibliotecaweb.dal.ProfessorDao;
import br.com.bibliotecaweb.dal.TipoUsuarioDao;
import br.com.bibliotecaweb.model.Aluno;
import br.com.bibliotecaweb.model.Pessoa;
import br.com.bibliotecaweb.model.Professor;
import br.com.bibliotecaweb.model.TipoUsuario;
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

                
@WebServlet("/ServletProfessor")
public class ServletProfessor extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/professor.jsp";
    private static String LIST_CLIENTE = "/index.jsp";
    private PessoaDao pessoaDao;
    private ProfessorDao professorDao; 
    private TipoUsuarioDao tipoUsuarioDao; 
    

    public ServletProfessor() throws SQLException{
        super();
        professorDao = new ProfessorDao();
        pessoaDao = new PessoaDao();
        tipoUsuarioDao = new TipoUsuarioDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("codigo"));
            professorDao.deleteProfessor(id);
            forward = LIST_CLIENTE;
            request.setAttribute("cliente", professorDao.getTodosAlunos());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Aluno pessoa = professorDao.consultaPorCodigo(id);
            request.setAttribute("lucas", pessoa);
        } else if (action.equalsIgnoreCase("showCliente")) {
            forward = LIST_CLIENTE;
            
            List<Pessoa> todosClientes = professorDao.getTodosAlunos();
            for(Pessoa c: todosClientes){
                System.out.println("lucas:" + c.getNome());
            }
            
            request.setAttribute("cliente", professorDao.getTodosAlunos());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              
        Professor professor = new Professor();
        professor.setMateria(request.getParameter("materia"));
        professor.setTitulacao(request.getParameter("titulacao"));
        String codigo = request.getParameter("codigo");
        
        
        
        Pessoa pessoa = new Pessoa();
               
        pessoa.setNome(request.getParameter("nome"));
        pessoa.setCpf(request.getParameter("cpf"));
        pessoa.setEmail(request.getParameter("email"));
        pessoa.setRg(request.getParameter("rg"));
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
         TipoUsuario tipoUsuario =  tipoUsuarioDao.consultarPorDescricao(request.getParameter("tipocadastro"));
        pessoa.setTipoUsuario(tipoUsuario);
        
        if (codigo == null || codigo.isEmpty()) {
            
            Professor professorIncluido = professorDao.incluirProfessor(professor);
            pessoa.setProfessor(professorIncluido);
            pessoaDao.incluirPessoa(pessoa);
    
        } else {
            pessoa.setCodigo(Integer.parseInt(codigo));
            professorDao.updateAlunos(pessoa);
        }
//       pessoaDao.incluirPessoa(pessoa);
        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENTE);
        //request.setAttribute("cliente", alunoDao.getTodosAlunos());
        view.forward(request, response);
    }
}