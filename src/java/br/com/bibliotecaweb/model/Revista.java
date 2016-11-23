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
    
    private int edicao;
    private int numero_edicao;
    private Date data_publicao;

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getNumero_edicao() {
        return numero_edicao;
    }

    public void setNumero_edicao(int numero_edicao) {
        this.numero_edicao = numero_edicao;
    }

    public Date getData_publicao() {
        return data_publicao;
    }

    public void setData_publicao(Date data_publicao) {
        this.data_publicao = data_publicao;
    }
    
    
    
}
