package br.com.bibliotecaweb.bll;


import br.com.bibliotecaweb.dal.AlunoDao;
import br.com.bibliotecaweb.dal.EditoraDao;
import br.com.bibliotecaweb.dal.PessoaDao;
import br.com.bibliotecaweb.dal.TipoUsuarioDao;
import br.com.bibliotecaweb.model.Aluno;
import br.com.bibliotecaweb.model.Pessoa;
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
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("abrir")) {
            forward = INSERT_OR_EDIT;
            request.setAttribute("editoras", editoraDao.TodosEditoras());
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
        
        pessoa.setCpf(request.getParameter("cpf"));
        pessoa.setNome(request.getParameter("nome"));
        pessoa.setRg(request.getParameter("rg"));
        pessoa.setEmail(request.getParameter("email"));
   try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                pessoa.setDataCadastro(sdf.parse(request.getParameter("datacadastro")));
            } catch (ParseException ex) {
                System.out.println("Erro de conversÃ£o da data: "
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
        
        TipoUsuario tipoUsuario =  new TipoUsuario();
        tipoUsuario.setTipocadastro(request.getParameter("tipocadastro"));
     
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
