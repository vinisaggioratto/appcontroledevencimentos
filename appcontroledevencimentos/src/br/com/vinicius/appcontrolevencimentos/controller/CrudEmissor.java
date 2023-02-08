/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroEmissor;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius-dev
 */
public class CrudEmissor {

    TelaCadastroEmissor telaEmissor = null;
    LimparCampos limparCampos = new LimparCampos();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void cadastrarEmissor() {
        conexao = ModuloConexao.conector();
        String sql = "insert into emissor (nome) values(?)";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, telaEmissor.txtEmissor.getText());

            if ((telaEmissor.txtEmissor.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            } else {
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Novo Emissor cadastrado com"
                            + " sucesso.");
                }
                limparCampos.limparCamposEmissor();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o "
                    + "novo Emissor." + e);
        }

    }

    public void editarEmissor() {
        conexao = ModuloConexao.conector();

        String sql = "update emissor set nome = ? where id = ?";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, telaEmissor.txtEmissor.getText());
            pst.setString(2, telaEmissor.txtIdEmissor.getText());

            if ((telaEmissor.txtEmissor.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            } else {
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
                }
                limparCampos.limparCamposEmissor();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar os dados "
                    + "do Emissor." + e);
        }

    }

    public void excluirEmissor() {
        conexao = ModuloConexao.conector();

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que "
                + "deseja excluir o emissor?", "Atenção!", JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from emissor where id = ?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, telaEmissor.txtIdEmissor.getText());
                int apagado = pst.executeUpdate();

                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Emissor excluído com sucesso");
                }
                limparCampos.limparCamposEmissor();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar excluir Emissor. " + e);
            }
        }

    }

}
