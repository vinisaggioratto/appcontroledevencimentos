/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroVeiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author FROTA01-PC
 */
public class PesquisarSetarVeiculo {

    TelaCadastroVeiculo telaVeiculo = null;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //método para pesquisar clientes
    public void pesquisarVeiculo() {
        conexao = ModuloConexao.conector();

        String sql = "select vei.id as ID, vei.placa as Placa, vei.modelo as Modelo, "
                + "tip.nome as Tipo, vei.bottom as Bottom, vei.ativo as Ativo from "
                + "veiculo vei join tipo_veiculo tip on vei.tipo_id = tip.id "
                + "where vei.placa like ?";

        try {
            pst = conexao.prepareStatement(sql);
            //passando o conteudo da caixa de pesquisa para o ?
            //atenção, ao "%" - continuação da String sql
            pst.setString(1, telaVeiculo.txtPesquisarVeiculo.getText() + "%");
            rs = pst.executeQuery();
            //a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            telaVeiculo.tblCadastroVeiculo.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar veículo. " + e);
        }
    }

    //MÉTODO PARA SETAR OS CAMPOS DO FORMULARIO COM O CONTEUDO DA TABELA
    public void setarVeiculo() {

        int setar = telaVeiculo.tblCadastroVeiculo.getSelectedRow(); //a variavel recebe os valores da linha da tabela
        telaVeiculo.txtIdVeiculo.setText(telaVeiculo.tblCadastroVeiculo.getModel().getValueAt(setar, 0).toString());
        telaVeiculo.txtPlaca.setText(telaVeiculo.tblCadastroVeiculo.getModel().getValueAt(setar, 1).toString());
        telaVeiculo.txtModeloVeiculo.setText(telaVeiculo.tblCadastroVeiculo.getModel().getValueAt(setar, 2).toString());
        telaVeiculo.cboTipoVeiculo.setSelectedItem(telaVeiculo.tblCadastroVeiculo.getModel().getValueAt(setar, 3).toString());
        telaVeiculo.cboBottom.setSelectedItem(telaVeiculo.tblCadastroVeiculo.getModel().getValueAt(setar, 4).toString());
        telaVeiculo.cboAtivo.setSelectedItem(telaVeiculo.tblCadastroVeiculo.getModel().getValueAt(setar, 5).toString());

        if (telaVeiculo.cboAtivo.getSelectedItem().equals("Não")) {
            telaVeiculo.txtIdVeiculo.setEnabled(false);
            telaVeiculo.txtPlaca.setEnabled(false);
            telaVeiculo.txtModeloVeiculo.setEnabled(false);
            telaVeiculo.cboTipoVeiculo.setEnabled(false);
            telaVeiculo.cboBottom.setEnabled(false);
        } else {
            telaVeiculo.txtIdVeiculo.setEnabled(true);
            telaVeiculo.txtPlaca.setEnabled(true);
            telaVeiculo.txtModeloVeiculo.setEnabled(true);
            telaVeiculo.cboTipoVeiculo.setEnabled(true);
            telaVeiculo.cboBottom.setEnabled(true);
        }
    }
}
