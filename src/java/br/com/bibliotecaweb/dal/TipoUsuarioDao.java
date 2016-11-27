
package br.com.bibliotecaweb.dal;

import br.com.bibliotecaweb.model.Pessoa;
import br.com.bibliotecaweb.model.TipoUsuario;
import br.com.bibliotecaweb.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TipoUsuarioDao {
    private Connection connection;

    public TipoUsuarioDao() {
        connection = Conexao.getConnection();
    }

        //------- TIPO USUARIO DAO ------------------//
    
    

    public void incluirTipoUsuario(Pessoa pessoa) {
        
        TipoUsuario tipoUsuario = new TipoUsuario();
       
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            
                            "insert into tipousuario("
                                    +"tipocadastro,"
                                    +"codigo_pessoa)"
                                    + "values "
                                    + "(?,?)");
            preparedStatement.setString(1, tipoUsuario.getTipocadastro());
            preparedStatement.setInt(2, tipoUsuario.getPessoa().getCodigo());
                  
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
    

