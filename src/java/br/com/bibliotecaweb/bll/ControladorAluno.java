package br.com.bibliotecaweb.bll;


import br.com.bibliotecaweb.dal.AlunoDao;
import br.com.bibliotecaweb.model.Pessoa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


@WebServlet("/ControladorAluno")
public class ControladorAluno extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/cliente.jsp";
    private static String LIST_CLIENTE = "/showCliente.jsp";
    private AlunoDao alunoDao;
    private PersistenciaPessoa daoPessoa;

    public ControladorAluno() throws SQLException{
        super();
        daoAluno = new AlunoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("codigo"));
            daoAluno.deleteAluno(id);
            forward = LIST_CLIENTE;
            request.setAttribute("cliente", daoAluno.getTodosAlunos());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Pessoa pessoa = daoAluno.getClienteById(id);
            request.setAttribute("lucas", pessoa);
        } else if (action.equalsIgnoreCase("showCliente")) {
            forward = LIST_CLIENTE;
            
            List<Pessoa> todosClientes = daoAluno.getTodosAlunos();
            for(Pessoa c: todosClientes){
                System.out.println("lucas:" + c.getNome());
            }
            
            request.setAttribute("cliente", daoAluno.getTodosAlunos());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Pessoa pessoas = new Pessoa();
       
       pessoas.setCpf(request.getParameter("cpf")); 
       pessoas.setNome(request.getParameter("nome"));
       pessoas.setRg(request.getParameter("rg"));
       
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            pessoas.setDataCadastro((java.sql.Date) sdf.parse(request.getParameter("datacadastro")));
        } catch (ParseException ex) {
            System.out.println("Erro ao converter a data: \n" 
                    + ex.getMessage());
            Logger.getLogger(ControladorAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        pessoas.setTelefoneResidecial(request.getParameter("telefoneresidecial"));
        pessoas.setTelefoneCelular(request.getParameter("telefonecelular"));
        pessoas.setTelefoneComercial(request.getParameter("telefonecomercial"));
        pessoas.setLogin(request.getParameter("login"));
        pessoas.setSenha(request.getParameter("senha"));
        pessoas.setRua(request.getParameter("rua"));
        pessoas.setBairro(request.getParameter("bairro"));
        pessoas.setComplementacao(request.getParameter("complemento"));
        pessoas.setCidade(request.getParameter("cidade"));
        pessoas.setEstado(request.getParameter("estado"));
        
        

        String codigo = request.getParameter("codigo");
        if (codigo == null || codigo.isEmpty()) {
            
            daoAluno.incluirPessoaAluno(pessoas);
        } else {
            pessoas.setCodigo(Integer.parseInt(codigo));
            daoAluno.updateAlunos(pessoas);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENTE);
        request.setAttribute("cliente", daoAluno.getTodosAlunos());
        view.forward(request, response);
    }
}
