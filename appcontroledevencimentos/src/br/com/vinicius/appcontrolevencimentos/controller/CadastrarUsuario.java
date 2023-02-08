/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class CadastrarUsuario {

    TelaCadastroUsuario telaUsuario = null;
    LimparCampos limpaCampos = new LimparCampos();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void cadastrarUsuario() {

        conexao = ModuloConexao.conector();

        String sql = "insert into usuario (usuario, senha, perfil_id, ativo) values (?,?,?,?)";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, telaUsuario.txtUsuario.getText());
            pst.setString(2, telaUsuario.txtSenha.getText());

            if (telaUsuario.cboPerfil.getSelectedItem().equals("Gestor")) {
                pst.setString(3, "1");
            } else if (telaUsuario.cboPerfil.getSelectedItem().equals("Operacional I")) {
                pst.setString(3, "2");
            } else if (telaUsuario.cboPerfil.getSelectedItem().equals("Operacional II")) {
                pst.setString(3, "3");
            }

            //pst.setInt(3, telaUsuario.cboPerfil.getSelectedItem().toString().charAt(0));
            pst.setString(4, telaUsuario.cboAtivo.getSelectedItem().toString());

            if ((telaUsuario.txtUsuario.getText().isEmpty())
                    || (telaUsuario.txtSenha.getText().isEmpty())
                    || (telaUsuario.cboAtivo.getSelectedItem().toString().isEmpty())
                    || (telaUsuario.cboPerfil.getSelectedItem().toString().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Novo usuário cadastrado com sucesso.");
                }
                limpaCampos.limparCamposUsuario();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o "
                    + " novo usuário." + e);
        }
    }

}
