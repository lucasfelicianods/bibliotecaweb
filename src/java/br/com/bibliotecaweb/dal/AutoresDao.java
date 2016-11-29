
package br.com.bibliotecaweb.dal;

import br.com.bibliotecaweb.model.Aluno;
import br.com.bibliotecaweb.model.Autores;
import br.com.bibliotecaweb.model.Editora;
import br.com.bibliotecaweb.model.Midia;
import br.com.bibliotecaweb.model.Pessoa;
import br.com.bibliotecaweb.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AutoresDao {
    private Connection connection;
    
    public AutoresDao() {
        connection = Conexao.getConnection();
    }

        //---------- Midia Dao---------------------//
    
    

    public Autores incluirAutor(Autores autores) {
     
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            
                            "insert into autor_atores("
                                    + "nome,"
                                    + "descricao)"
                                    + "values "
                                    + "(?,?)");
                                               
            // verificar o tipo de midia que esta sendo cadastrado
            preparedStatement.setString(1, autores.getNome());
            preparedStatement.setString(2, autores.getDescricao());
            preparedStatement.executeUpdate();
                        

        } catch (SQLException e) {
            e.printStackTrace();
        }
         return autores;
    }
    public Aluno consultarPorMatricula(String matricula) {
        Aluno aluno = new Aluno();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from aluno where matricula=?");
            preparedStatement.setString(1, matricula);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                aluno.setCodigo(rs.getInt("codigo"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setCurso(rs.getString("curso"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aluno;
    

    } 
    

    public void deleteAluno(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from cliente where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAlunos(Autores autores) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update cliente set nome=?,cpf=?,datanascimento=?,telefone=?,celular=?,endereco=?,bairro=?,cep=?,email=?,obs=? "
                            + "where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, autores.getCodigo());
            preparedStatement.setString(2, autores.getNome());
            preparedStatement.setString(3, autores.getDescricao());
            
           
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // MOSTAR TODOS OS CLIENTE
    public List<Editora> TodosEditoras() {
        List<Editora> editoras = new ArrayList<Editora>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cliente");
            while (rs.next()) {
             
              
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return editoras;
    }

    public Aluno consultaPorCodigo(int codigo) {
        Aluno aluno = new Aluno();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from aluno where id=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                aluno.setCodigo(codigo);
                aluno.setMatricula("matricula");
                aluno.setCurso("matricula");
                  
          

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aluno;
    }
}
