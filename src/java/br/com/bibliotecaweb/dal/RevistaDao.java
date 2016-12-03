
package br.com.bibliotecaweb.dal;

import br.com.bibliotecaweb.model.Midia;
import br.com.bibliotecaweb.model.Pessoa;
import br.com.bibliotecaweb.model.Revista;
import br.com.bibliotecaweb.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RevistaDao {
    
      private Connection connection;

    public RevistaDao() {
        connection = Conexao.getConnection();
    }

      //  ---------- Revista Dao---------------------//
       

    public Revista incluirRevista(Revista revista) {
     
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            
                            "insert into revista("
                                    + "edicao,"
                                    + "numero_edicao,"
                                    + "data_publicacao,"
                                    + "codigo_editora)"
                                    + "values"
                                    + "(?,?,?,?)");
                                               
            // verificar o tipo de midia que esta sendo cadastrado
            preparedStatement.setString(1, revista.getEdicao());
            preparedStatement.setString(2, revista.getNumero_edicao());
            preparedStatement.setDate(3, new java.sql.Date(revista.getPublicao().getTime()));
            preparedStatement.setInt(4, revista.getEditora().getCodigo());
                   
            preparedStatement.executeUpdate();
            
            return consultarPorCodigo(revista.getCodigo());

        } catch (SQLException e) {
            e.printStackTrace();
        }
         return null;
    }
    
    public Revista consultarPorCodigo(int codigo) {
        
        Revista revista = new Revista();
        try {
            EditoraDao editoraDao = new EditoraDao();
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from revista where codigo=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                revista.setCodigo(rs.getInt("codigo"));
                revista.setEdicao(rs.getString("edicao"));
                revista.setPublicao(rs.getDate("datapublicacao"));
                revista.setEditora(editoraDao.consultaPorCodigo((rs.getInt("codigoeditora"))));
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return revista;
        

    } 
     public List<Revista> TodosRevistas() {
        List<Revista> revistas = new ArrayList<Revista>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from revista");
            while (rs.next()) {
                Revista revista = new Revista();
                revista.setCodigo(rs.getInt("codigo"));
                revista.setEdicao(rs.getString("edicao"));
                revista.setEditora(null);
              

                revistas.add(revista);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return revistas;
    }
}
    


    

