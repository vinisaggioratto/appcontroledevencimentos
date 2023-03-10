/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author FROTA01-PC
 */
public class Emissor {
    private int id;
    private String nome;
    public List<Emissor> listEmissor = new ArrayList<>();

    public Emissor() {

    }
    
    public Emissor(int id){
        this.id = id;
    }

    public Emissor(int id, String nome) {
        this.id = id;
        this.nome = nome;
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
    
    @Override
    public String toString(){
        return
                this.getId()
                +" - "
                + this.getNome();
    } 
}
