/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecaweb.model;


public class Livro {
    
    private int codigo_de_barra;
    private int isbn;
    private String descricao;
    private Midia midia;
    private Editora editora;
    

    public int getCodigo_de_barra() {
        return codigo_de_barra;
    }

    public void setCodigo_de_barra(int codigo_de_barra) {
        this.codigo_de_barra = codigo_de_barra;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
