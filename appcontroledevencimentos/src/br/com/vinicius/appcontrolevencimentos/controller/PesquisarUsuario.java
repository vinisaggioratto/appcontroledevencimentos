/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario;
import static br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario.tblCadastroUsuario;
import static br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario.txtPesquisarUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author FROTA01-PC
 */
public class PesquisarUsuario {

    TelaCadastroUsuario telaUsuario = null;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //método para pesquisar clientes
    public void pesquisarUsuario() {
        conexao = ModuloConexao.conector();

        String sql = "select id as Id, usuario as Usuario, senha as Senha, ativo as Ativo"
                + " from usuario where usuario like ?";

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
            telaUsuario.cboAtivo.setSelectedItem(tblCadastroUsuario.getModel().getValueAt(setar, 3).toString());

            //A LINHA ABAIXO DESABILITA O BOTAO DE ADICIONAR CLIENTES
            //telaUsuario.lblBotaoSalvar.setEnabled(false);
            
            if (telaUsuario.cboAtivo.getSelectedItem().equals("Não")) {
            telaUsuario.txtIdUsuario.setEnabled(false);
            telaUsuario.txtUsuario.setEnabled(false);
            telaUsuario.txtSenha.setEnabled(false);
            }
    }
}
