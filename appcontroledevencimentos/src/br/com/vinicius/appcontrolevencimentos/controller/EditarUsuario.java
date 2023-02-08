/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class EditarUsuario {

    TelaCadastroUsuario telaUsuario = null;
    LimparCampos limpaCampos = new LimparCampos();
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void editarUsuario() {
        
        conexao = ModuloConexao.conector();
        
        String sql = "update usuario set usuario = ?, senha = ?,perfil = ?, ativo = ? "
                + "where id = ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, telaUsuario.txtUsuario.getText());
            pst.setString(2, telaUsuario.txtSenha.getText());
            pst.setString(3, telaUsuario.cboAtivo.getSelectedItem().toString());
            pst.setString(4, telaUsuario.cboPerfil.getSelectedItem().toString());
            pst.setString(5, telaUsuario.txtIdUsuario.getText());
            
            if ((telaUsuario.txtUsuario.getText().isEmpty())
                    || (telaUsuario.txtSenha.getText().isEmpty())
                    || (telaUsuario.cboAtivo.getSelectedItem().toString().isEmpty())
                    || (telaUsuario.cboPerfil.getSelectedItem().toString().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            }else{
                int adicionado = pst.executeUpdate();//recebe 0 ou 1 se deu certo a alteração no banco
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
                }
             //limpaCampos.limparCampos();   
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar os dados"
                    + " do usuário."+e);
        }
    }

}
