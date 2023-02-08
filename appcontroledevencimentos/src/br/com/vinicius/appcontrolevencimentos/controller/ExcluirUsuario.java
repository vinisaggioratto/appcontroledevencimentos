/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class ExcluirUsuario {
    
    LimparCampos limparCampos = new LimparCampos();
    TelaCadastroUsuario telaUsuario = null;
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection conexao = null;
    
    
    public void excluirUsuario(){
        conexao = ModuloConexao.conector();
        
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que "
                + "deseja remover o usuário?","Atenção", JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION){
            String sql = "delete from usuario where id = ?";
            
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, telaUsuario.txtIdUsuario.getText());
                int apagado = pst.executeUpdate();
                
                if(apagado > 0){
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso.");
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao excluir o usuário." + e);
            }
        }
    }
    
}
