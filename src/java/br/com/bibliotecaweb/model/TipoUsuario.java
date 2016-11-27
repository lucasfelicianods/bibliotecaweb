
package br.com.bibliotecaweb.model;

public class TipoUsuario {
    
    private int codigo;
    
    private Pessoa pessoa;
    
    private String tipocadastro;

    public String getTipocadastro() {
        return tipocadastro;
    }

    public void setTipocadastro(String tipocadastro) {
        this.tipocadastro = tipocadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
    
}
