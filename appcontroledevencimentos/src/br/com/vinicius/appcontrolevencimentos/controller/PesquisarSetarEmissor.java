/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroEmissor;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author vinicius-dev
 */
public class PesquisarSetarEmissor {

    TelaCadastroEmissor telaEmissor = null;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void pesquisarEmissor() {
        conexao = ModuloConexao.conector();

        String sql = "select id as ID, nome as Emissor from emissor where nome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, telaEmissor.txtEmissor.getText() + "%");
            rs = pst.executeQuery();
            telaEmissor.tblCadastroEmissor.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Emissor.");
        }
    }

    public void setarEmissor() {
        int setar = telaEmissor.tblCadastroEmissor.getSelectedRow();
        telaEmissor.txtIdEmissor.setText(telaEmissor.tblCadastroEmissor.getModel().getValueAt(setar, 0).toString());
        telaEmissor.txtEmissor.setText(telaEmissor.tblCadastroEmissor.getModel().getValueAt(setar, 1).toString());

    }
}
