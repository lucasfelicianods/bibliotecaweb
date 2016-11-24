/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecaweb.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.bibliotecaweb.model.Aluno;
import br.com.bibliotecaweb.model.Pessoa;
import br.com.bibliotecaweb.util.Conexao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luks_
 */
public class AlunoDao {

    private Connection connection;

    public AlunoDao() {
        connection = Conexao.getConnection();
    }

        //---------- DAO ALUNO ---------------------//
    

    public void incluirAluno(Aluno aluno) {
       
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into aluno"
                            + "(matricula,curso)"
                            + "values)");
            preparedStatement.setString(1, aluno.getMatricula());
            preparedStatement.setString(2, aluno.getCurso());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void updateAlunos(Pessoa pessoa) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update cliente set nome=?,cpf=?,datanascimento=?,telefone=?,celular=?,endereco=?,bairro=?,cep=?,email=?,obs=? "
                            + "where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, pessoa.getCpf());
            preparedStatement.setString(2, pessoa.getNome());
            preparedStatement.setString(3, pessoa.getRg());
            preparedStatement.setDate(4, new java.sql.Date(pessoa.getDataCadastro().getTime()));
            preparedStatement.setString(5, pessoa.getTelefoneResidecial());
            preparedStatement.setString(6, pessoa.getTelefoneCelular());
            preparedStatement.setString(7, pessoa.getTelefoneComercial());
            preparedStatement.setString(8, pessoa.getLogin());
            preparedStatement.setString(9, pessoa.getSenha());
            preparedStatement.setString(10, pessoa.getRua());
            preparedStatement.setString(11, pessoa.getBairro());
            preparedStatement.setString(12, pessoa.getComplementacao());
            preparedStatement.setString(13, pessoa.getCidade());
            preparedStatement.setString(14, pessoa.getEstado());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // MOSTAR TODOS OS CLIENTE
    public List<Pessoa> getTodosAlunos() {
        List<Pessoa> pessoa = new ArrayList<Pessoa>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cliente");
            while (rs.next()) {
                Pessoa pessoas = new Pessoa();
                pessoas.setCpf(rs.getString("cpf"));
                pessoas.setNome(rs.getString("nome"));
                pessoas.setRg(rs.getString("rg"));
                pessoas.setDataCadastro(rs.getDate("datacadastro"));
                pessoas.setTelefoneResidecial(rs.getString("teleforesidencial"));
                pessoas.setTelefoneCelular(rs.getString("telefocelular"));
                pessoas.setTelefoneComercial(rs.getString("telefocomercial"));
                pessoas.setLogin(rs.getString("login"));
                pessoas.setSenha(rs.getString("senha"));
                pessoas.setRua(rs.getString("rua"));
                pessoas.setBairro(rs.getString("bairro"));
                pessoas.setComplementacao(rs.getString("complemento"));
                pessoas.setCidade(rs.getString("cidade"));
                pessoas.setEstado(rs.getString("estado"));

                pessoa.add(pessoas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoa;
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
