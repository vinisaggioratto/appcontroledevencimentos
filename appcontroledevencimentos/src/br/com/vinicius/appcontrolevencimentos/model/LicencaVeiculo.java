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
public class LicencaVeiculo {
    
    private Licenca licenca;
    private Veiculo veiculo;
    private int numero;
    private Date data_emissao;
    private Date data_validade;
    private String ativo;

    public LicencaVeiculo(Licenca licenca, Veiculo veiculo, int numero, Date data_emissao, Date data_validade, String ativo) {
        this.licenca = licenca;
        this.veiculo = veiculo;
        this.numero = numero;
        this.data_emissao = data_emissao;
        this.data_validade = data_validade;
        this.ativo = ativo;
    }

    public Licenca getLicenca() {
        return licenca;
    }

    public void setLicenca(Licenca licenca) {
        this.licenca = licenca;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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
