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
public class Emprestimo {
    
    private int codigo;
    private Date data_emprestimo;
    private Date data_estimada_devolucao;
    private Date data_real_Devolucao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public Date getData_estimada_devolucao() {
        return data_estimada_devolucao;
    }

    public void setData_estimada_devolucao(Date data_estimada_devolucao) {
        this.data_estimada_devolucao = data_estimada_devolucao;
    }

    public Date getData_real_Devolucao() {
        return data_real_Devolucao;
    }

    public void setData_real_Devolucao(Date data_real_Devolucao) {
        this.data_real_Devolucao = data_real_Devolucao;
    }
    
    
    
}
