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
public class Boleto {
    
    private int codigo;
    private String local_De_Pagamento;
    private String cedente;
    private Date data_emissao;
    private long numero_do_documento;
    private String especie_Documento;
    private String aceite;
    private Date data_processamento;
    private String carteira;
    private float especie_moeada;
    private String valor_moeda;
    private String responsabilidade_cedente;
    private String sacado;
    private Date vencimento;
    private String nosso_numero;
    private long valor_do_documento;
    private long desconto;
    private long valor_multa;
    private long valor_cobrado;
    private long codigo_de_barra;
    private int codigo_do_cliente;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLocal_De_Pagamento() {
        return local_De_Pagamento;
    }

    public void setLocal_De_Pagamento(String local_De_Pagamento) {
        this.local_De_Pagamento = local_De_Pagamento;
    }

    public String getCedente() {
        return cedente;
    }

    public void setCedente(String cedente) {
        this.cedente = cedente;
    }

    public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    public long getNumero_do_documento() {
        return numero_do_documento;
    }

    public void setNumero_do_documento(long numero_do_documento) {
        this.numero_do_documento = numero_do_documento;
    }

    public String getEspecie_Documento() {
        return especie_Documento;
    }

    public void setEspecie_Documento(String especie_Documento) {
        this.especie_Documento = especie_Documento;
    }

    public String getAceite() {
        return aceite;
    }

    public void setAceite(String aceite) {
        this.aceite = aceite;
    }

    public Date getData_processamento() {
        return data_processamento;
    }

    public void setData_processamento(Date data_processamento) {
        this.data_processamento = data_processamento;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public float getEspecie_moeada() {
        return especie_moeada;
    }

    public void setEspecie_moeada(float especie_moeada) {
        this.especie_moeada = especie_moeada;
    }

    public String getValor_moeda() {
        return valor_moeda;
    }

    public void setValor_moeda(String valor_moeda) {
        this.valor_moeda = valor_moeda;
    }

    public String getResponsabilidade_cedente() {
        return responsabilidade_cedente;
    }

    public void setResponsabilidade_cedente(String responsabilidade_cedente) {
        this.responsabilidade_cedente = responsabilidade_cedente;
    }

    public String getSacado() {
        return sacado;
    }

    public void setSacado(String sacado) {
        this.sacado = sacado;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getNosso_numero() {
        return nosso_numero;
    }

    public void setNosso_numero(String nosso_numero) {
        this.nosso_numero = nosso_numero;
    }

    public long getValor_do_documento() {
        return valor_do_documento;
    }

    public void setValor_do_documento(long valor_do_documento) {
        this.valor_do_documento = valor_do_documento;
    }

    public long getDesconto() {
        return desconto;
    }

    public void setDesconto(long desconto) {
        this.desconto = desconto;
    }

    public long getValor_multa() {
        return valor_multa;
    }

    public void setValor_multa(long valor_multa) {
        this.valor_multa = valor_multa;
    }

    public long getValor_cobrado() {
        return valor_cobrado;
    }

    public void setValor_cobrado(long valor_cobrado) {
        this.valor_cobrado = valor_cobrado;
    }

    public long getCodigo_de_barra() {
        return codigo_de_barra;
    }

    public void setCodigo_de_barra(long codigo_de_barra) {
        this.codigo_de_barra = codigo_de_barra;
    }

    public int getCodigo_do_cliente() {
        return codigo_do_cliente;
    }

    public void setCodigo_do_cliente(int codigo_do_cliente) {
        this.codigo_do_cliente = codigo_do_cliente;
    }
    
    
    
    
}
