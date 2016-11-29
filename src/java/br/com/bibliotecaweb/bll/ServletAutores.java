/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecaweb.bll;

import br.com.bibliotecaweb.dal.AlunoDao;
import br.com.bibliotecaweb.dal.AutoresDao;
import br.com.bibliotecaweb.dal.EditoraDao;
import br.com.bibliotecaweb.dal.PessoaDao;
import br.com.bibliotecaweb.dal.TipoUsuarioDao;
import br.com.bibliotecaweb.model.Aluno;
import br.com.bibliotecaweb.model.Autores;
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


@WebServlet("/ServletAutores")

public class ServletAutores extends HttpServlet {
 private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/autores.jsp";
    private static String LIST_CLIENTE = "/index.jsp";
   
    private AutoresDao autoresDao;

    public ServletAutores() throws SQLException{
        super();
        autoresDao = new AutoresDao();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("codigo"));
           autoresDao.deleteAluno(id);
            forward = LIST_CLIENTE;
            request.setAttribute("cliente", autoresDao.TodosEditoras());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Aluno pessoa = autoresDao.consultaPorCodigo(id);
            request.setAttribute("lucas", pessoa);
        } else if (action.equalsIgnoreCase("showCliente")) {
            forward = LIST_CLIENTE;
            
            List<Editora> todosClientes = autoresDao.TodosEditoras();
            for(Editora c: todosClientes){
                System.out.println("lucas:" + c.getNome());
            }
            
            request.setAttribute("cliente", autoresDao.TodosEditoras());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
       Autores autores = new Autores();
       
        autores.setNome(request.getParameter("nome"));
        autores.setDescricao(request.getParameter("descricao"));
        String codigo = request.getParameter("codigo");
        
     
     
        if (codigo == null || codigo.isEmpty()) {
          autoresDao.incluirAutor(autores);
                       
        } else {
            autores.setCodigo(Integer.parseInt(codigo));
            autoresDao.updateAlunos(autores);
        }
//       pessoaDao.incluirPessoa(pessoa);
        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENTE);
        //request.setAttribute("cliente", alunoDao.getTodosAlunos());
        view.forward(request, response);
    }
}
