package br.com.bibliotecaweb.bll;


import br.com.bibliotecaweb.dal.AlunoDao;
import br.com.bibliotecaweb.dal.EditoraDao;
import br.com.bibliotecaweb.dal.PessoaDao;
import br.com.bibliotecaweb.dal.TipoUsuarioDao;
import br.com.bibliotecaweb.model.Aluno;
import br.com.bibliotecaweb.model.Editora;
import br.com.bibliotecaweb.model.Pessoa;
import br.com.bibliotecaweb.model.Revista;
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

import javax.servlet.annotation.WebServlet;


@WebServlet("/ServletRevista")
public class ServletRevista extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/revista.jsp";
    private static String LIST_CLIENTE = "/index.jsp";
    private EditoraDao editoraDao;

    public ServletRevista() throws SQLException{
        super();
        editoraDao = new EditoraDao();
    }
 
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("acao");

        if (action.equalsIgnoreCase("abrir")) {
            forward = INSERT_OR_EDIT;
            List<Editora> revistas = editoraDao.TodosEditoras();
            request.setAttribute("editoras", revistas);
        }
//        } else if (action.equalsIgnoreCase("edit")) {
//            forward = INSERT_OR_EDIT;
//            int id = Integer.parseInt(request.getParameter("id"));
//            Aluno pessoa = revistaDao.consultaPorCodigo(id);
//            request.setAttribute("lucas", pessoa);
//        } else if (action.equalsIgnoreCase("showCliente")) {
//            forward = LIST_CLIENTE;
//            
//            List<Pessoa> todosClientes = revistaDao.getTodosAlunos();
//            for(Pessoa c: todosClientes){
//                System.out.println("lucas:" + c.getNome());
//            }
//            
//            request.setAttribute("cliente", revistaDao.getTodosAlunos());
//        } else {
//            forward = INSERT_OR_EDIT;
//        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        
        Pessoa pessoa = new Pessoa();
        Revista revista = new Revista();
       // revista.
        
        
   try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                pessoa.setDataCadastro(sdf.parse(request.getParameter("datacadastro")));
            } catch (ParseException ex) {
                System.out.println("Erro de conversÃ£o da data: "
                        + "\nMessage: " + ex.getMessage());
            }
       
     
//        if (codigo == null || codigo.isEmpty()) {
//            Aluno alunoIncluido = revistaDao.incluirAluno(aluno);
//            pessoa.setAluno(alunoIncluido);
//            Pessoa pessoaIncluida = pessoaDao.incluirPessoa(pessoa);
//            tipoUsuario.setPessoa(pessoaIncluida);
//            tipoUsuarioDao.incluirTipoUsuario(pessoa);
//            
//        } else {
//            pessoa.setCodigo(Integer.parseInt(codigo));
//            revistaDao.updateAlunos(pessoa);
//        }
//       pessoaDao.incluirPessoa(pessoa);
        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENTE);
        //request.setAttribute("cliente", alunoDao.getTodosAlunos());
        view.forward(request, response);
    }
}
