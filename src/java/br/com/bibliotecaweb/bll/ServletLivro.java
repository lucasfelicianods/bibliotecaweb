/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecaweb.bll;



import br.com.bibliotecaweb.dal.AlunoDao;
import br.com.bibliotecaweb.dal.EditoraDao;
import br.com.bibliotecaweb.dal.MidiaDao;
import br.com.bibliotecaweb.dal.PessoaDao;
import br.com.bibliotecaweb.dal.RevistaDao;
import br.com.bibliotecaweb.dal.TipoUsuarioDao;
import br.com.bibliotecaweb.model.Aluno;
import br.com.bibliotecaweb.model.Editora;
import br.com.bibliotecaweb.model.Midia;
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
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;


@WebServlet("/ServletLivro")
public class ServletLivro extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/livro.jsp";
    private static String LIST_CLIENTE = "/index.jsp";
    private EditoraDao editoraDao;
    private MidiaDao midiaDao;
    private RevistaDao revistaDao;
    
    
    public ServletLivro() throws SQLException{
        super();
        editoraDao = new EditoraDao();
       // midiaDao = new MidiaDao();
      
      
    }
 
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("acao");

        if (action.equalsIgnoreCase("abrir")) {
            forward = INSERT_OR_EDIT;
            List<Editora> editoras = editoraDao.TodosEditoras();
            request.setAttribute("editoras", editoras);
        
    

        
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Revista revista  = revistaDao.consultarPorCodigo(codigo);
            request.setAttribute("codigo", revista);
        } else if (action.equalsIgnoreCase("showCliente")) {
            forward = LIST_CLIENTE;
            
            List<Revista> todasRevistas = revistaDao.TodosRevistas();
            for(Revista c: todasRevistas){
                System.out.println("revista:" + c.getCodigo());
            }
//            
            request.setAttribute("revista", revistaDao.TodosRevistas());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Midia midia = new Midia();
        midia.setTitulo(request.getParameter("titulo"));
        
        Revista revista = new Revista();
        
        String codigo = request.getParameter("codigo");      
        revista.setEdicao(request.getParameter("edicao"));
        revista.setNumero_edicao(request.getParameter("numero_edicao"));
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            revista.setPublicao(sdf.parse(request.getParameter("publicacao")));
        } catch (ParseException ex) {
            System.out.println("Erro de conversão da data: "
                    + "\nMessage: " + ex.getMessage());
        }
        
        
        if (codigo == null || codigo.isEmpty()) {
            Midia midiaIncluido = midiaDao.incluirMidia(midia);
            revista.setMidia(midiaIncluido);
            revista.getEditora().getCodigo();
            revistaDao.incluirRevista(revista);
            
            
        } else {
            revista.setCodigo(Integer.parseInt(codigo));
          //  revistaDao.consultarPorCodigo(codigo);
        }
  
        RequestDispatcher view = request.getRequestDispatcher(LIST_CLIENTE);
        request.setAttribute("revista", revistaDao.TodosRevistas());
        view.forward(request, response);
    }
}
