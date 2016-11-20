

package br.com.bibliotecaweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    private static Connection connection = null;

    public  static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                /*
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/Usuario";
                String user = "root";
                String password = "";
                */
                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/bibliotecaweb";
                String user = "postgres";
                String password = "1234567";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
    public boolean conecta(){
        if(connection != null){
          return false;
        }else{
           return true;
        }
            
    }
}
