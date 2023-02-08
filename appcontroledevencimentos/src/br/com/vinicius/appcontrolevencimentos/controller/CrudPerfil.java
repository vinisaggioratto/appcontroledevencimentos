/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroPerfil;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class CrudPerfil {
    TelaCadastroPerfil telaPerfil = null;
    LimparCampos limparCampos = new LimparCampos();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void cadastrarPerfil(){
        conexao = ModuloConexao.conector();
        
        String sql = "insert into perfil(nome, descricao) values (?, ?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, telaPerfil.txtPerfil.getText());
            pst.setString(2, telaPerfil.txtDescricao.getText());
            
            if((telaPerfil.txtPerfil.getText().isEmpty())
                    || (telaPerfil.txtDescricao.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            }else{
                int adicionado = pst.executeUpdate();
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Novo usuário cadastrado com sucesso.");
                }
                limparCampos.limparCamposPerfil();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o "
                    + " novo perfil." + e);
        }
        
    }
    
    public void editarPerfil(){
        conexao = ModuloConexao.conector();
        String sql = "";
        
    }
    
    public void excluirPerfil(){
        conexao = ModuloConexao.conector();
        String sql = "";
        
    }
    
}
