/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.model;

/**
 *
 * @author FROTA01-PC
 */
public class Documento {
    
    private int id;
    private String nome;
    private int emissor;
    private String ativo;

    public Documento() {
    }

    public Documento(int id) {
        this.id = id;
    }

    public Documento(int id, String nome, int emissor, String ativo) {
        this.id = id;
        this.nome = nome;
        this.emissor = emissor;
        this.ativo = ativo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEmissor() {
        return emissor;
    }

    public void setEmissor(int emissor) {
        this.emissor = emissor;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    
    
}
