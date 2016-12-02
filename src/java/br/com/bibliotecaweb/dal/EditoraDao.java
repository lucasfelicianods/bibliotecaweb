package br.com.bibliotecaweb.dal;

import br.com.bibliotecaweb.model.Aluno;
import br.com.bibliotecaweb.model.Editora;
import br.com.bibliotecaweb.model.Midia;
import br.com.bibliotecaweb.model.OrdenarEditora;
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
    private OrdenarEditora ordenarEditora; 
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
//
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

    public void deleteEditora(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from editora where codigo=?");
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
                    .prepareStatement("update editora set nome=?,descricao=? where codigo=?");
            // Parameters start with 1
            
            preparedStatement.setString(1, editora.getNome());
            preparedStatement.setString(2, editora.getDescricao());
            preparedStatement.setInt(3, editora.getCodigo());
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
                
                OrdenarEditora teste = new OrdenarEditora(ed.getNome());
                for (int i = 0; i < editoras.size()-1; i++) {
                    for (int j = i+1; j < editoras.size(); j++) {
                        if(!teste.ePrimeiro(editoras.get(i), editoras.get(j))){
                            Editora temp = editoras.get(j);
                            editoras.set(j, editoras.get(i));
                            editoras.set(i, temp);
                        }
                    }
                }
              
                

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return editoras;
    }

    public Editora consultaPorCodigo(int codigo) {
        Editora editora = new Editora();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from editora where codigo=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                editora.setCodigo(codigo);
                editora.setDescricao("descricao");
                editora.setNome("nome");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return editora;
    }
    
     public Editora getEditoraById(int editoraId) {
		Editora editora = new Editora();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from editora where codigo=?");
			preparedStatement.setInt(1, editoraId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				
                                editora.setCodigo(rs.getInt("codigo"));
                                editora.setNome(rs.getString("nome"));
				editora.setDescricao(rs.getString("descricao"));
                            
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return editora;
	}
    

}
