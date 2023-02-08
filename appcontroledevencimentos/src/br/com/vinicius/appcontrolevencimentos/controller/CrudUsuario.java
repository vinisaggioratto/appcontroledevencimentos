/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroUsuario;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius-dev
 */
public class CrudUsuario {

    TelaCadastroUsuario telaUsuario = null;
    LimparCampos limparCampos = new LimparCampos();
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
                limparCampos.limparCamposUsuario();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o "
                    + " novo usuário." + e);
        }
    }

    public void editarUsuario() {

        conexao = ModuloConexao.conector();

        String sql = "update usuario set usuario = ?, senha = ?,perfil_id = ?, ativo = ? "
                + "where id = ?";

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
            pst.setString(4, telaUsuario.cboAtivo.getSelectedItem().toString());
            pst.setString(5, telaUsuario.txtIdUsuario.getText());

            if ((telaUsuario.txtUsuario.getText().isEmpty())
                    || (telaUsuario.txtSenha.getText().isEmpty())
                    || (telaUsuario.cboAtivo.getSelectedItem().toString().isEmpty())
                    || (telaUsuario.cboPerfil.getSelectedItem().toString().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            } else {
                int adicionado = pst.executeUpdate();//recebe 0 ou 1 se deu certo a alteração no banco
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
                }
                //limpaCampos.limparCampos();   
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar os dados"
                    + " do usuário." + e);
        }
    }

    public void excluirUsuario() {
        conexao = ModuloConexao.conector();

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que "
                + "deseja excluir o usuário?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from usuario where id = ?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, telaUsuario.txtIdUsuario.getText());
                int apagado = pst.executeUpdate();

                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o usuário." + e);
            }
        }
    }

}
