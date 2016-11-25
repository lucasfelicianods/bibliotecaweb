/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecaweb.dal;


import br.com.bibliotecaweb.model.Pessoa;
import br.com.bibliotecaweb.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author luks_
 */
public class ValidaLogin {

    private Connection connection;

    public ValidaLogin() {
        connection = Conexao.getConnection();
    }

    public boolean ValidarLogin(Pessoa pessoa) throws SQLException {
        try {

            try {

                PreparedStatement preparedStatement = connection
                        .prepareStatement("select login, senha from pessoa where login = ? and senha = ?");
                // Parameters start with 1
                preparedStatement.setString(1, pessoa.getLogin());
                preparedStatement.setString(2, pessoa.getSenha());

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    return true;
                } else {
                    return false;
                    
                }
            } finally {
                //connection.close();
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado.\nConfira os dados e tente novamente.\n");
            return false;
        }
    }
}
