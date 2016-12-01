package br.com.bibliotecaweb.dal;

import br.com.bibliotecaweb.model.Aluno;
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

public class EditoraDao {

    private Connection connection;

    public EditoraDao() {
        connection = Conexao.getConnection();
    }

        //---------- Midia Dao---------------------//
    public Editora incluirEditora(Editora editora) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            "insert into editora("
                            + "nome,"
                            + "descricao)"
                            + "values "
                            + "(?,?)");

            // verificar o tipo de midia que esta sendo cadastrado
            preparedStatement.setString(1, editora.getNome());
            preparedStatement.setString(2, editora.getDescricao());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editora;
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

    public void updateEditoras(Editora editora) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update editora set nome=?,descricao? "
                            + "where cogigo=?");
            // Parameters start with 1
            preparedStatement.setInt(1, editora.getCodigo());
            preparedStatement.setString(1, editora.getNome());
            preparedStatement.setString(1, editora.getDescricao());

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
            ResultSet rs = statement.executeQuery("select * from editora");
            while (rs.next()) {
                Editora ed = new Editora();
                ed.setCodigo(rs.getInt("codigo"));
                ed.setNome(rs.getString("nome"));
                ed.setDescricao(rs.getString("descricao"));
                editoras.add(ed);

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
