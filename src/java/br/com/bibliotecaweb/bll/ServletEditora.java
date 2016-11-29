/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecaweb.bll;

import br.com.bibliotecaweb.dal.AlunoDao;
import br.com.bibliotecaweb.dal.EditoraDao;
import br.com.bibliotecaweb.dal.PessoaDao;
import br.com.bibliotecaweb.dal.TipoUsuarioDao;
import br.com.bibliotecaweb.model.Aluno;
import br.com.bibliotecaweb.model.Editora;
import br.com.bibliotecaweb.model.Pessoa;
import br.com.bibliotecaweb.model.TipoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jaire
 */
@WebServlet("/ServletEditora")

public class ServletEditora extends HttpServlet {
 private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/editora.jsp";
    private static String LIST_CLIENTE = "/index.jsp";
   
    private EditoraDao editoraDao;

    public ServletEditora() throws SQLException{
        super();
        editoraDao = new EditoraDao();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("codigo"));
           editoraDao.deleteAluno(id);
            forward = LIST_CLIENTE;
            request.setAttribute("cliente", editoraDao.TodosEditoras());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Aluno pessoa = editoraDao.consultaPorCodigo(id);
            request.setAttribute("lucas", pessoa);
        } else if (action.equalsIgnoreCase("showCliente")) {
            forward = LIST_CLIENTE;
            
            List<Editora> todosClientes = editoraDao.TodosEditoras();
            for(Editora c: todosClientes){
                System.out.println("lucas:" + c.getNome());
            }
            
            request.setAttribute("cliente", editoraDao.TodosEditoras());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        Editora editora = new Editora();
       
        editora.setNome(request.getParameter("nome"));
        editora.setDescricao(request.getParameter("descricao"));
        String codigo = request.getParameter("codigo");
        
     
     
        if (codigo == null || codigo.isEmpty()) {
          editoraDao.incluirEditora(editora);
                       
        } else {
            editora.setCodigo(Integer.parseInt(codigo));
            editoraDao.updateAlunos(editora);
        }
//       pessoaDao.incluirPessoa(pessoa);
        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENTE);
        //request.setAttribute("cliente", alunoDao.getTodosAlunos());
        view.forward(request, response);
    }
}
