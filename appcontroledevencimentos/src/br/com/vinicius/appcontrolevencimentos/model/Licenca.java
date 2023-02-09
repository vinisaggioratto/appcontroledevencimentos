/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.model;

/**
 *
 * @author FROTA01-PC
 */
public class Licenca {
    
    private int id;
    private String nome;
    private Emissor emissor;
    private String ativo;

    public Licenca() {
    }

    public Licenca(int id) {
        this.id = id;
    }

    public Licenca(int id, String nome, Emissor emissor, String ativo) {
        this.id = id;
        this.nome = nome;
        this.emissor = emissor;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Emissor getEmissor() {
        return emissor;
    }

    public void setEmissor(Emissor emissor) {
        this.emissor = emissor;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
}
