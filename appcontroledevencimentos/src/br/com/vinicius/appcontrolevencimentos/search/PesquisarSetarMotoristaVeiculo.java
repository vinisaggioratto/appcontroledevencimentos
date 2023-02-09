/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.search;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaVincularMotoristaVeiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author FROTA01-PC
 */
public class PesquisarSetarMotoristaVeiculo {

    TelaVincularMotoristaVeiculo telaMotoristaVeiculo = null;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void pesquisarMotoristaVeiculo() {
        conexao = ModuloConexao.conector();

        String sql = "select mot.nome as Motorista, vei.placa as Placa, mv.data_inicial as 'Data Inicial', mv.data_final as 'Data Final', mv.ativo as Ativo " +
" from motorista mot join motorista_veiculo mv on mv.motorista_id = mot.id " +
"join veiculo vei on mv.veiculo_id = vei.id join usuario usu on mv.usuario_id = usu.id where mot.nome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            //passando o conteudo da caixa de pesquisa para o ?
            //atenção, ao "%" - continuação da String sql
            pst.setString(1, telaMotoristaVeiculo.txtPesquisarMotoristaVeiculo.getText() + "%");
            rs = pst.executeQuery();
            //a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
           
            telaMotoristaVeiculo.tblvincularMotoristaVeiculo.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar licença. " + e);
        }
    }

    //MÉTODO PARA SETAR OS CAMPOS DO FORMULARIO COM O CONTEUDO DA TABELA
    public void setarMotoristaVeiculo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
        int setar = telaMotoristaVeiculo.tblvincularMotoristaVeiculo.getSelectedRow(); //a variavel recebe os valores da linha da tabela
        telaMotoristaVeiculo.cboMotorista.setSelectedItem(telaMotoristaVeiculo.tblvincularMotoristaVeiculo.getModel().getValueAt(setar, 0).toString());
        telaMotoristaVeiculo.cboVeiculo.setSelectedItem(telaMotoristaVeiculo.tblvincularMotoristaVeiculo.getModel().getValueAt(setar, 1).toString());
        telaMotoristaVeiculo.ftxtDataInicial.setText(sdf.format(telaMotoristaVeiculo.tblvincularMotoristaVeiculo.getModel().getValueAt(setar, 2)));
        telaMotoristaVeiculo.ftxtDataFinal.setText(telaMotoristaVeiculo.tblvincularMotoristaVeiculo.getModel().getValueAt(setar, 3).toString());
        telaMotoristaVeiculo.cboAtivo.setSelectedItem(telaMotoristaVeiculo.tblvincularMotoristaVeiculo.getModel().getValueAt(setar, 4).toString());

        if (telaMotoristaVeiculo.cboAtivo.getSelectedItem().equals("Não")) {
            telaMotoristaVeiculo.cboMotorista.setEnabled(false);
            telaMotoristaVeiculo.cboVeiculo.setEnabled(false);
            telaMotoristaVeiculo.ftxtDataInicial.setEnabled(false);
            telaMotoristaVeiculo.ftxtDataFinal.setEnabled(false);
        } else {
            telaMotoristaVeiculo.cboMotorista.setEnabled(true);
            telaMotoristaVeiculo.cboVeiculo.setEnabled(true);
            telaMotoristaVeiculo.ftxtDataInicial.setEnabled(true);
            telaMotoristaVeiculo.ftxtDataFinal.setEnabled(true);
        }
    }

    public void preencherComboBoxMotorista() {
        conexao = ModuloConexao.conector();

        String sql = "select * from motorista";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                //telaLicenca.cboEmissor.addItem(rs.getString("id"));
                telaMotoristaVeiculo.cboMotorista.addItem(rs.getString("nome"));
                telaMotoristaVeiculo.cboMotorista.updateUI();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados no combobox." + e);
        }
    }

    public void preencherComboBoxVeiculo() {
        conexao = ModuloConexao.conector();

        String sql = "select * from veiculo";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                //telaLicenca.cboEmissor.addItem(rs.getString("id"));
                telaMotoristaVeiculo.cboVeiculo.addItem(rs.getString("placa"));
                telaMotoristaVeiculo.cboVeiculo.updateUI();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados no combobox." + e);
        }
    }

    public int retornarIdMotorista() {
        int posicaoId = telaMotoristaVeiculo.cboMotorista.getSelectedIndex();
        return posicaoId + 1;
    }

    public int retornarIdVeiculo() {
        int posicaoId = telaMotoristaVeiculo.cboVeiculo.getSelectedIndex();
        return posicaoId + 1;
    }
}
