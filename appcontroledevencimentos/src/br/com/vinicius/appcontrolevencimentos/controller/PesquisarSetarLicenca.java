/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroLicenca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author FROTA01-PC
 */
public class PesquisarSetarLicenca {

    TelaCadastroLicenca telaLicenca = null;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void pesquisarLicenca() {
        conexao = ModuloConexao.conector();

        String sql = "select lic.id as ID, lic.nome as Licença, emi.nome as Emissor, "
                + "lic.ativo as Ativo from licenca lic join emissor emi on "
                + "lic.emissor_id = emi.id where lic.nome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            //passando o conteudo da caixa de pesquisa para o ?
            //atenção, ao "%" - continuação da String sql
            pst.setString(1, telaLicenca.txtPesquisarLicenca.getText() + "%");
            rs = pst.executeQuery();
            //a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            telaLicenca.tblCadastroLicenca.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar licença. " + e);
        }
    }

    //MÉTODO PARA SETAR OS CAMPOS DO FORMULARIO COM O CONTEUDO DA TABELA
    public void setarLicenca() {

        int setar = telaLicenca.tblCadastroLicenca.getSelectedRow(); //a variavel recebe os valores da linha da tabela
        telaLicenca.txtIdLicenca.setText(telaLicenca.tblCadastroLicenca.getModel().getValueAt(setar, 0).toString());
        telaLicenca.txtNomeLicenca.setText(telaLicenca.tblCadastroLicenca.getModel().getValueAt(setar, 1).toString());
        telaLicenca.cboEmissor.setSelectedItem(telaLicenca.tblCadastroLicenca.getModel().getValueAt(setar, 2).toString());
        telaLicenca.cboAtivo.setSelectedItem(telaLicenca.tblCadastroLicenca.getModel().getValueAt(setar, 3).toString());


        if (telaLicenca.cboAtivo.getSelectedItem().equals("Não")) {
            telaLicenca.txtIdLicenca.setEnabled(false);
            telaLicenca.txtNomeLicenca.setEnabled(false);
            telaLicenca.cboEmissor.setEnabled(false);
        } else {
            telaLicenca.txtIdLicenca.setEnabled(true);
            telaLicenca.txtNomeLicenca.setEnabled(true);
            telaLicenca.cboEmissor.setEnabled(true);
        }
    }
    
        public void preencherComboBox() {
        conexao = ModuloConexao.conector();

        String sql = "select * from emissor";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
               //telaLicenca.cboEmissor.addItem(rs.getString("id"));
               telaLicenca.cboEmissor.addItem(rs.getString("nome"));
               telaLicenca.cboEmissor.updateUI();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao carregar dados no combobox."+ e);
        }
    }
}
