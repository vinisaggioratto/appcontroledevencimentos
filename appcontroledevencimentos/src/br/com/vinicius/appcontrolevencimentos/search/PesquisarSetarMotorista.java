/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.search;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroMotorista;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author FROTA01-PC
 */
public class PesquisarSetarMotorista {

    TelaCadastroMotorista telaMotorista = null;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void pesquisarMotorista() {
        conexao = ModuloConexao.conector();

        String sql = "select id as ID, nome as Nome, ativo as Ativo from "
                + "motorista where nome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, telaMotorista.txtPesquisarMotorista.getText() + "%");
            rs = pst.executeQuery();
            telaMotorista.tblCadastroMotorista.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Motorista. " + e);
        }
    }

    public void setarCampos() {
        int setar = telaMotorista.tblCadastroMotorista.getSelectedRow();
        telaMotorista.txtIdMotorista.setText(telaMotorista.tblCadastroMotorista.
                getModel().getValueAt(setar, 0).toString());
        telaMotorista.txtMotorista.setText(telaMotorista.tblCadastroMotorista.
                getModel().getValueAt(setar, 1).toString());
        telaMotorista.cboAtivoMotorista.setSelectedItem(telaMotorista.tblCadastroMotorista.
                getModel().getValueAt(setar, 2).toString());

        if (telaMotorista.cboAtivoMotorista.getSelectedItem().equals("Não")) {
            telaMotorista.txtIdMotorista.setEnabled(false);
            telaMotorista.txtMotorista.setEnabled(false);
        } else {
            telaMotorista.txtIdMotorista.setEnabled(true);
            telaMotorista.txtMotorista.setEnabled(true);
        }
    }
}
