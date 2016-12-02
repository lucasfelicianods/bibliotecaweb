/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecaweb.model;

import java.sql.Date;

/**
 *
 * @author luks_
 */
public class Revista {
    
    private int codigo;
    private String edicao;
    private String numero_edicao;
    private Date data_publicao;
    private Midia midia;
    private Editora editora;
    

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getNumero_edicao() {
        return numero_edicao;
    }

    public void setNumero_edicao(String numero_edicao) {
        this.numero_edicao = numero_edicao;
    }

    public Date getData_publicao() {
        return data_publicao;
    }

    public void setData_publicao(Date data_publicao) {
        this.data_publicao = data_publicao;
    }

    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    
    
    
}
