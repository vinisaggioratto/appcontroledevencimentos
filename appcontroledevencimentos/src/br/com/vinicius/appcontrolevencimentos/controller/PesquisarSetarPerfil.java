/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroPerfil;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author FROTA01-PC
 */
public class PesquisarSetarPerfil {
    
    TelaCadastroPerfil telaPerfil = null;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void pesquisarPerfil(){
        conexao = ModuloConexao.conector();
        
        String sql = "select id as ID, nome as Perfil, descricao as Descricao "
                + "from perfil where nome like ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,telaPerfil.txtPesquisarPerfil.getText() + "%");
            rs = pst.executeQuery();
            telaPerfil.tblCadastroPerfil.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Perfil."+ e);
        }
    }
    
    public void setarPerfil(){
        int setar = telaPerfil.tblCadastroPerfil.getSelectedRow();
        telaPerfil.txtIdPerfil.setText(telaPerfil.tblCadastroPerfil.getModel().getValueAt(setar, 0).toString());
        telaPerfil.txtPerfil.setText(telaPerfil.tblCadastroPerfil.getModel().getValueAt(setar, 1).toString());
        telaPerfil.txtDescricao.setText(telaPerfil.tblCadastroPerfil.getModel().getValueAt(setar, 2).toString());
    }
    
    
}
