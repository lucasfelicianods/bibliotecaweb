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
import java.util.Iterator;
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
    

    public Aluno incluirAluno(Aluno aluno) {
       
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into aluno("
                            + "matricula,"
                            + "curso)"
                            + "values"
                            + "( ?, ?)");
            
            preparedStatement.setString(1, aluno.getMatricula());
            preparedStatement.setString(2, aluno.getCurso());
            preparedStatement.executeUpdate();
            
            return consultarPorMatricula(aluno.getMatricula());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
   public Iterator<Pessoa> TodosAlunos() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from aluno");
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setRg(rs.getString("email"));
                pessoa.setDataCadastro(rs.getDate("datacadastro"));
                pessoa.setTelefoneResidecial(rs.getString("teleforesidencial"));
                pessoa.setTelefoneCelular(rs.getString("telefocelular"));
                pessoa.setTelefoneComercial(rs.getString("telefocomercial"));
                pessoa.setLogin(rs.getString("login"));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setRua(rs.getString("rua"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setComplementacao(rs.getString("complemento"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstado(rs.getString("estado"));

                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas.iterator();
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


