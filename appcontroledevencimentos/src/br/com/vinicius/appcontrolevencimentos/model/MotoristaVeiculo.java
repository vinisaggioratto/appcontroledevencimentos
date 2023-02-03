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
public class MotoristaVeiculo {
    
    private Motorista motorista;
    private Veiculo veiculo;
    private Date data_inicial;
    private Date data_final;
    private String ativo;

    public MotoristaVeiculo(Motorista motorista, Veiculo veiculo, Date data_inicial, Date data_final, String ativo) {
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
        this.ativo = ativo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(Date data_inicial) {
        this.data_inicial = data_inicial;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    
}
