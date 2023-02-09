/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.utilities;

import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroEmissor;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroLicenca;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroMotorista;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroPerfil;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario;
import static br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario.tblCadastroUsuario;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroVeiculo;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FROTA01-PC
 */
public class LimparCampos {

    TelaCadastroUsuario telaUsuario = null;
    TelaCadastroPerfil telaPerfil = null;
    TelaCadastroEmissor telaEmissor = null;
    TelaCadastroMotorista telaMotorista = null;
    TelaCadastroVeiculo telaVeiculo = null;
    TelaCadastroLicenca telaLicenca = null;

    public void limparCamposUsuario() {
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

    public void limparCamposPerfil() {
        telaPerfil.txtIdPerfil.setText(null);
        telaPerfil.txtPerfil.setText(null);
        telaPerfil.txtDescricao.setText(null);
        ((DefaultTableModel) telaPerfil.tblCadastroPerfil.getModel()).setRowCount(0);
    }

    public void limparCamposEmissor() {
        telaEmissor.txtIdEmissor.setText(null);
        telaEmissor.txtEmissor.setText(null);
        ((DefaultTableModel) telaEmissor.tblCadastroEmissor.getModel()).setRowCount(0);
    }

    public void limparCamposMotorista() {
        telaMotorista.txtIdMotorista.setText(null);
        telaMotorista.txtMotorista.setText(null);
        telaMotorista.cboAtivoMotorista.setSelectedItem("Sim");
        ((DefaultTableModel) telaMotorista.tblCadastroMotorista.getModel()).setRowCount(0);
    }

    public void limparCamposVeiculo() {
        telaVeiculo.txtIdVeiculo.setText(null);
        telaVeiculo.txtPlaca.setText(null);
        telaVeiculo.txtModeloVeiculo.setText(null);
        telaVeiculo.cboTipoVeiculo.setSelectedItem("Toco");
        telaVeiculo.cboBottom.setSelectedItem("Sim");
        telaVeiculo.cboAtivo.setSelectedItem("Sim");
        ((DefaultTableModel) telaVeiculo.tblCadastroVeiculo.getModel()).setRowCount(0);
    }
    
        public void limparCamposLicenca() {
        telaLicenca.txtIdLicenca.setText(null);
        telaLicenca.txtNomeLicenca.setText(null);
        telaLicenca.cboEmissor.setSelectedItem(null);
        telaLicenca.cboAtivo.setSelectedItem("Sim");
        ((DefaultTableModel) telaLicenca.tblCadastroLicenca.getModel()).setRowCount(0);
    }
    
    
}
