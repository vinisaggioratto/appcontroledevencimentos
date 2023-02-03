/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.model;

import java.util.Date;

/**
 *
 * @author FROTA01-PC
 */
public class DocumentoMotorista {
    
    private Documento documento;
    private Motorista motorista;
    private String numero;
    private Date data_emissao;
    private Date data_validade;
    private String ativo;

    public DocumentoMotorista(Documento documento, Motorista motorista, String numero, Date data_emissao, Date data_validade, String ativo) {
        this.documento = documento;
        this.motorista = motorista;
        this.numero = numero;
        this.data_emissao = data_emissao;
        this.data_validade = data_validade;
        this.ativo = ativo;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    public Date getData_validade() {
        return data_validade;
    }

    public void setData_validade(Date data_validade) {
        this.data_validade = data_validade;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    
}
