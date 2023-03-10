/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.search;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario;
import static br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario.tblCadastroUsuario;
import static br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario.txtPesquisarUsuario;
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
public class PesquisarSetarUsuario {

    TelaCadastroUsuario telaUsuario = null;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //método para pesquisar clientes
    public void pesquisarUsuario() {
        conexao = ModuloConexao.conector();

        String sql = "select us.id as ID, us.usuario as Usuario, us.senha as Senha, "
                + "pf.nome as Perfil, us.ativo as Ativo from usuario us "
                + "join perfil pf on us.perfil_id = pf.id where usuario like ?";

        try {
            pst = conexao.prepareStatement(sql);
            //passando o conteudo da caixa de pesquisa para o ?
            //atenção, ao "%" - continuação da String sql
            pst.setString(1, txtPesquisarUsuario.getText() + "%");
            rs = pst.executeQuery();
            //a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tblCadastroUsuario.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar cliente. " + e);
        }
    }

    //MÉTODO PARA SETAR OS CAMPOS DO FORMULARIO COM O CONTEUDO DA TABELA
    public void setarCampos() {

        int setar = tblCadastroUsuario.getSelectedRow(); //a variavel recebe os valores da linha da tabela
        telaUsuario.txtIdUsuario.setText(tblCadastroUsuario.getModel().getValueAt(setar, 0).toString());
        telaUsuario.txtUsuario.setText(tblCadastroUsuario.getModel().getValueAt(setar, 1).toString());
        telaUsuario.txtSenha.setText(tblCadastroUsuario.getModel().getValueAt(setar, 2).toString());
        telaUsuario.cboPerfil.setSelectedItem(tblCadastroUsuario.getModel().getValueAt(setar, 3).toString());
        telaUsuario.cboAtivo.setSelectedItem(tblCadastroUsuario.getModel().getValueAt(setar, 4).toString());

        if (telaUsuario.cboAtivo.getSelectedItem().equals("Não")) {
            telaUsuario.txtIdUsuario.setEnabled(false);
            telaUsuario.txtUsuario.setEnabled(false);
            telaUsuario.txtSenha.setEnabled(false);
            telaUsuario.cboPerfil.setEnabled(false);
        } else {
            telaUsuario.txtIdUsuario.setEnabled(true);
            telaUsuario.txtUsuario.setEnabled(true);
            telaUsuario.txtSenha.setEnabled(true);
            telaUsuario.cboPerfil.setEnabled(true);
        }
    }

    public void preencherComboBox() {
        conexao = ModuloConexao.conector();

        String sql = "select * from perfil";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                //telaLicenca.cboEmissor.addItem(rs.getString("id"));
                telaUsuario.cboPerfil.addItem(rs.getString("nome"));
                telaUsuario.cboPerfil.updateUI();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados no combobox." + e);
        }
    }

    public int retornarIdEmissor() {
        int posicaoId = telaUsuario.cboPerfil.getSelectedIndex();
        return posicaoId + 1;
    }
}
