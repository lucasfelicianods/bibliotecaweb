
package br.com.bibliotecaweb.dal;

import br.com.bibliotecaweb.model.Midia;
import br.com.bibliotecaweb.model.Revista;
import br.com.bibliotecaweb.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RevistaDao {
    
      private Connection connection;

    public RevistaDao() {
        connection = Conexao.getConnection();
    }
}
        //---------- Revista Dao---------------------//
       

//    public Revista incluirRevista(Revista revista) {
     
//        try {
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement(
//                            
//                            "insert into revista("
//                                    + "titulo )"
//                                    + "values "
//                                    + "(?)");
//                                               
//            // verificar o tipo de midia que esta sendo cadastrado
//            preparedStatement.setString(1, midia.getTitulo());
//            preparedStatement.executeUpdate();
//            
//            return consultarPorCodigo(midia.getCodigo());
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//         return null;
//    }
    
//     public Midia consultarPorCodigo(Integer codigo) {
// 
//        Midia midia = new Midia();
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from midia where codigo=?");
//            preparedStatement.setInt(1, codigo);
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()) {
//           midia.setCodigo(rs.getInt("codigo"));
//           midia.setTitulo(rs.getString("titulo"));
//                           
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return midia;
//    
//
//    } 
//}
    


    

