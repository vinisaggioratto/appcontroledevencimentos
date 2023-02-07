/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.utilities;

import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario;
import static br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario.tblCadastroUsuario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FROTA01-PC
 */
public class LimparCamposUsuario {

    TelaCadastroUsuario telaUsuario = null;

    public void limparCampos() {
        telaUsuario.txtIdUsuario.setText(null);
        telaUsuario.txtUsuario.setText(null);
        telaUsuario.txtSenha.setText(null);
        telaUsuario.cboAtivo.setSelectedItem("Sim");
        ((DefaultTableModel) tblCadastroUsuario.getModel()).setRowCount(0);
        telaUsuario.lblBotaoSalvar.setEnabled(true);

        telaUsuario.txtIdUsuario.setEnabled(true);
        telaUsuario.txtUsuario.setEnabled(true);
        telaUsuario.txtSenha.setEnabled(true);
    }

}
