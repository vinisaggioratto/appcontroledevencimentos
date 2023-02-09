/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.model.Emissor;
import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class EmissorDAO {

    ModuloConexao con = new ModuloConexao();
    LimparCampos limparCampos = new LimparCampos();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void cadastrarEmissor(Emissor emissor) {

        String sql = "insert into emissor (nome) values(?)";
        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                if ((emissor.getNome().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                } else {
                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, emissor.getNome());
                    int adicionado = pst.executeUpdate();

                    if (adicionado > 0) {

                        JOptionPane.showMessageDialog(null, "Novo Emissor cadastrado com"
                                + " sucesso.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Emissor."
                    + e + JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
    }

    public boolean alterarEmissor(Emissor emissor) {
        boolean alterou = true;

        String sql = "update emissor set nome = ? where id = ?";
        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                if ((emissor.getNome().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                } else {
                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, emissor.getNome());
                    pst.setInt(2, emissor.getId());
                    int adicionado = pst.executeUpdate();

                    if (adicionado > 0) {
                        alterou = false;
                        JOptionPane.showMessageDialog(null, "Emissor alterado com"
                                + " sucesso.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar Emissor."
                    + e + JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
        return alterou;
    }

    public void excluirEmissor(Emissor emissor) {
        conexao = ModuloConexao.conector();

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que "
                + "deseja excluir o emissor?", "Atenção!", JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from emissor where id = ?";  //'"+emissor.getId()+"'

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, emissor.getId());
                int apagado = pst.executeUpdate();

                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Emissor excluído com sucesso");
                }
                limparCampos.limparCamposEmissor();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar excluir Emissor. " + e);
            } finally {
                con.fecharConexao(conexao);
            }

        }
    }
}
