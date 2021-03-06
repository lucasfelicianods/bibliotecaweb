package br.com.bibliotecaweb.dal;

import br.com.bibliotecaweb.model.Aluno;
import br.com.bibliotecaweb.model.Funcionario;
import br.com.bibliotecaweb.model.Pessoa;
import br.com.bibliotecaweb.model.TipoUsuario;
import br.com.bibliotecaweb.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao {

    private Connection connection;

    public PessoaDao() {
        connection = Conexao.getConnection();
    }

    //---------- PERSISTENCIA PESSOA ---------------------//
    public Pessoa incluirPessoa(Pessoa pessoa) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            "insert into pessoa("
                            + "nome, "
                            + "rg, "
                            + "email,"
                            + "datacadastro,"
                            + "telefonecelular,"
                            + "telefoneresidencial,"
                            + "telefonecomercial,"
                            + "rua,"
                            + "complemento,"
                            + "bairro,"
                            + "estado,"
                            + "cidade,"
                            + "codigo_aluno,"
                            + "codigo_funcionario,"
                            + "codigo_professor,"
                            + "cpf,"
                            + "login,"
                            + "senha,"
                            + "codigo_tipousuario) "
                            + "values "
                            + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            // Parameters start with 1
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getRg());
            preparedStatement.setString(3, pessoa.getEmail());
            preparedStatement.setDate(4, new java.sql.Date(pessoa.getDataCadastro().getTime()));
            preparedStatement.setString(5, pessoa.getTelefoneCelular());
            preparedStatement.setString(6, pessoa.getTelefoneResidecial());
            preparedStatement.setString(7, pessoa.getTelefoneComercial());
            preparedStatement.setString(8, pessoa.getRua());
            preparedStatement.setString(9, pessoa.getComplementacao());
            preparedStatement.setString(10, pessoa.getBairro());
            preparedStatement.setString(11, pessoa.getEstado());
            preparedStatement.setString(12, pessoa.getCidade());
            if (pessoa.getAluno().getCodigo() != null) {
                preparedStatement.setInt(13, pessoa.getAluno().getCodigo());
            } else {
                preparedStatement.setNull(13, java.sql.Types.INTEGER);
            }
            if (pessoa.getFuncionario().getCodigo() != null) {
                preparedStatement.setInt(14, pessoa.getFuncionario().getCodigo());
            } else {
                preparedStatement.setNull(14, java.sql.Types.INTEGER);
            }
            if (pessoa.getProfessor().getCodigo() != null) {
                preparedStatement.setInt(15, pessoa.getProfessor().getCodigo());
            } else {
                preparedStatement.setNull(15, java.sql.Types.INTEGER);
            }
            preparedStatement.setString(16, pessoa.getCpf());
            preparedStatement.setString(17, pessoa.getLogin());
            preparedStatement.setString(18, pessoa.getSenha());

            preparedStatement.setInt(19, pessoa.getTipoUsuario().getCodigo());

            preparedStatement.executeUpdate();
            return consultarPorCpf(pessoa.getCpf());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pessoa consultarPorCpf(String cpf) {

        Pessoa pessoa = new Pessoa();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from pessoa where cpf=?");
            preparedStatement.setString(1, pessoa.getCpf());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                pessoa.setNome(rs.getString("nome"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setDataCadastro(rs.getDate("datacadastro"));
                pessoa.setTelefoneCelular(rs.getString("telefonecelular"));
                pessoa.setTelefoneResidecial(rs.getString("telefoneresidencial"));
                pessoa.setTelefoneComercial(rs.getString("telefonecomercial"));
                pessoa.setRua(rs.getString("rua"));
                pessoa.setComplementacao(rs.getString("complemento"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setEstado(rs.getString("estado"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setCodigo(rs.getInt("codigo"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setLogin(rs.getString("login"));
                pessoa.setSenha(rs.getString("senha"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoa;

    }

    public TipoUsuario retornaPerfilCadastro(String descricao) {

        TipoUsuario tipousuario = new TipoUsuario();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select descricao from pessoa p join tipousuario tp on p.codigo_tipousuario = tp.codigo where login = ?");
            preparedStatement.setString(1, descricao);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tipousuario.setDescricao(rs.getString("descricao"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipousuario;
    }

    public boolean validaTipoAluno(String descricao) {

        TipoUsuario tipousuario = new TipoUsuario();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select descricao from pessoa p join tipousuario tp on p.codigo_tipousuario = tp.codigo where login = ?");
            preparedStatement.setString(1, descricao);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tipousuario.setDescricao(rs.getString("descricao"));
                if (tipousuario.getDescricao().equals("ALUNO")) {
                    return true;
                }

            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean validaTipoProfessor(String descricao) {

        TipoUsuario tipousuario = new TipoUsuario();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select descricao from pessoa p join tipousuario tp on p.codigo_tipousuario = tp.codigo where login = ?");
            preparedStatement.setString(1, descricao);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tipousuario.setDescricao(rs.getString("descricao"));
                if (tipousuario.getDescricao().equals("PROFESSOR")) {
                    return true;
                }

            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean validaTipoFuncionario(String descricao) {
        Funcionario funcionario = new Funcionario();
        TipoUsuario tipousuario = new TipoUsuario();
        
        
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select descricao from pessoa p join tipousuario tp on p.codigo_tipousuario = tp.codigo  where login = ?");
            preparedStatement.setString(1, descricao);
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tipousuario.setDescricao(rs.getString("descricao"));
                if (tipousuario.getDescricao().equals("FUNCIONARIO")) {
                    return true;
                }

            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean validaTipoAdministrador(String descricao) {
        Funcionario funcionario = new Funcionario();
        TipoUsuario tipousuario = new TipoUsuario();
        
        
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select descricao,administrador from pessoa p join tipousuario tp on p.codigo_tipousuario = tp.codigo  join funcionario f on f.codigo = p.codigo_tipousuario where login = ?");
            preparedStatement.setString(1, descricao);
            preparedStatement.setBoolean(2, true);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tipousuario.setDescricao(rs.getString("descricao"));
                if (tipousuario.getDescricao().equals("FUNCIONARIO") && funcionario.isAdministrador()) {
                    return true;
                }

            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    
}

//    public void deleteAluno(int codigo_pessoa) {
//        try {
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("delete from pessoa where id=?");
//            // Parameters start with 1
//            preparedStatement.setInt(1, codigo_pessoa);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void updateAlunos(Pessoa pessoa) {
//        try {
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("update pessoa set nome=?,cpf=?,datanascimento=?,telefone=?,celular=?,endereco=?,bairro=?,cep=?,email=?,obs=? "
//                            + "where id=?");
//            // Parameters start with 1
//            preparedStatement.setString(1, pessoa.getCpf());
//            preparedStatement.setString(2, pessoa.getNome());
//            preparedStatement.setString(3, pessoa.getRg());
//            preparedStatement.setDate(4, new java.sql.Date(pessoa.getDataCadastro().getTime()));
//            preparedStatement.setString(5, pessoa.getTelefoneResidecial());
//            preparedStatement.setString(6, pessoa.getTelefoneCelular());
//            preparedStatement.setString(7, pessoa.getTelefoneComercial());
//            preparedStatement.setString(8, pessoa.getLogin());
//            preparedStatement.setString(9, pessoa.getSenha());
//            preparedStatement.setString(10, pessoa.getRua());
//            preparedStatement.setString(11, pessoa.getBairro());
//            preparedStatement.setString(12, pessoa.getComplementacao());
//            preparedStatement.setString(13, pessoa.getCidade());
//            preparedStatement.setString(14, pessoa.getEstado());
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // MOSTAR TODOS OS CLIENTE
//    public Pessoa listarPessoa() {
//        List<Pessoa> pessoas = new ArrayList<Pessoa>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from pessoa");
//            while (rs.next()) {
//                Pessoa pessoa = new Pessoa();
//                pessoa.setCpf(rs.getString("cpf"));
//                pessoa.setNome(rs.getString("nome"));
//                pessoa.setRg(rs.getString("rg"));
//                pessoa.setDataCadastro(rs.getDate("datacadastro"));
//                pessoa.setTelefoneResidecial(rs.getString("teleforesidencial"));
//                pessoa.setTelefoneCelular(rs.getString("telefocelular"));
//                pessoa.setTelefoneComercial(rs.getString("telefocomercial"));
//                pessoa.setLogin(rs.getString("login"));
//                pessoa.setSenha(rs.getString("senha"));
//                pessoa.setRua(rs.getString("rua"));
//                pessoa.setBairro(rs.getString("bairro"));
//                pessoa.setComplementacao(rs.getString("complemento"));
//                pessoa.setCidade(rs.getString("cidade"));
//                pessoa.setEstado(rs.getString("estado"));
//
//                pessoas.add(pessoa);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//         return null;
//     
//
//   
//    }
//
//    public Pessoa getClienteById(int clienteId) {
//        Pessoa pessoas = new Pessoa();
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from cliente where id=?");
//            preparedStatement.setInt(1, clienteId);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//
//                pessoas.setCpf(rs.getString("cpf"));
//                pessoas.setNome(rs.getString("nome"));
//                pessoas.setRg(rs.getString("rg"));
//                pessoas.setDataCadastro(rs.getDate("datacadastro"));
//                pessoas.setTelefoneResidecial(rs.getString("teleforesidencial"));
//                pessoas.setTelefoneCelular(rs.getString("telefocelular"));
//                pessoas.setTelefoneComercial(rs.getString("telefocomercial"));
//                pessoas.setLogin(rs.getString("login"));
//                pessoas.setSenha(rs.getString("senha"));
//                pessoas.setRua(rs.getString("rua"));
//                pessoas.setBairro(rs.getString("bairro"));
//                pessoas.setComplementacao(rs.getString("complemento"));
//                pessoas.setCidade(rs.getString("cidade"));
//                pessoas.setEstado(rs.getString("estado"));
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return pessoas;
//    }
//
//}
