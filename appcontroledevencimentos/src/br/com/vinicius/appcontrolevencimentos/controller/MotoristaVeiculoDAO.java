/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.model.Licenca;
import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class MotoristaVeiculoDAO {

    ModuloConexao con = new ModuloConexao();
    LimparCampos limparCampos = new LimparCampos();
    Licenca licenca = new Licenca();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void cadastrarLicenca(Licenca licenca) {

        String sql = "insert into licenca (nome, emissor_id, ativo) values(?,?,?)";
        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                if ((licenca.getNome().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                } else {
                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, licenca.getNome());
                    pst.setInt(2, licenca.getEmissor());
                    pst.setString(3, licenca.getAtivo());

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

    public void alterarLicenca(Licenca licenca) {

        String sql = "update licenca set nome = ?, emissor_id = ?, ativo = ? where id = ?";
        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                if ((licenca.getNome().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                } else {
                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, licenca.getNome());
                    pst.setInt(2, licenca.getEmissor());
                    pst.setString(3, licenca.getAtivo());
                    pst.setInt(4, licenca.getId());
                    int adicionado = pst.executeUpdate();

                    if (adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Licença alterada com"
                                + " sucesso.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar licença."
                    + e + JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
    }

    public void excluirLicenca(Licenca licenca) {
        conexao = ModuloConexao.conector();

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que "
                + "deseja excluir a licença?", "Atenção!", JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from licenca where id = ?";  //'"+emissor.getId()+"'

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, licenca.getId());
                int apagado = pst.executeUpdate();

                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Licença excluída com sucesso");
                }
                limparCampos.limparCamposEmissor();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar excluir licença. " + e);
            } finally {
                con.fecharConexao(conexao);
            }

        }
    }
}
