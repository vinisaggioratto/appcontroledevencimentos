/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.search;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroDocumento;
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
public class PesquisarSetarDocumento {

    TelaCadastroDocumento telaDocumento = null;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void pesquisarDocumento() {
        conexao = ModuloConexao.conector();

        String sql = "select doc.id as ID, doc.nome as Nome, emi.nome as Emissor, "
                + "doc.ativo as Ativo from documento doc join emissor emi "
                + "on doc.emissor_id = emi.id where doc.nome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            //passando o conteudo da caixa de pesquisa para o ?
            //atenção, ao "%" - continuação da String sql
            pst.setString(1, telaDocumento.txtPesquisarDocumento.getText() + "%");
            rs = pst.executeQuery();
            //a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            telaDocumento.tblCadastroDocumento.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar documento. " + e);
        }
    }

    //MÉTODO PARA SETAR OS CAMPOS DO FORMULARIO COM O CONTEUDO DA TABELA
    public void setarDocumento() {

        int setar = telaDocumento.tblCadastroDocumento.getSelectedRow(); //a variavel recebe os valores da linha da tabela
        telaDocumento.txtIdDocumento.setText(telaDocumento.tblCadastroDocumento.getModel().getValueAt(setar, 0).toString());
        telaDocumento.txtNomeDocumento.setText(telaDocumento.tblCadastroDocumento.getModel().getValueAt(setar, 1).toString());
        telaDocumento.cboEmissorDocumento.setSelectedItem(telaDocumento.tblCadastroDocumento.getModel().getValueAt(setar, 2).toString());
        telaDocumento.cboAtivo.setSelectedItem(telaDocumento.tblCadastroDocumento.getModel().getValueAt(setar, 3).toString());


        if (telaDocumento.cboAtivo.getSelectedItem().equals("Não")) {
            telaDocumento.txtIdDocumento.setEnabled(false);
            telaDocumento.txtNomeDocumento.setEnabled(false);
            telaDocumento.cboEmissorDocumento.setEnabled(false);
        } else {
            telaDocumento.txtIdDocumento.setEnabled(true);
            telaDocumento.txtNomeDocumento.setEnabled(true);
            telaDocumento.cboEmissorDocumento.setEnabled(true);
        }
    }
    
        public void preencherComboBox() {
        conexao = ModuloConexao.conector();

        String sql = "select * from documento";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
               //telaLicenca.cboEmissor.addItem(rs.getString("id"));
               telaDocumento.cboEmissorDocumento.addItem(rs.getString("nome"));
               telaDocumento.cboEmissorDocumento.updateUI();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao carregar dados no combobox."+ e);
        }
    }
        
        public int retornarIdEmissor(){
            int posicaoId = telaDocumento.cboEmissorDocumento.getSelectedIndex();
            return posicaoId + 1;
        }
}
