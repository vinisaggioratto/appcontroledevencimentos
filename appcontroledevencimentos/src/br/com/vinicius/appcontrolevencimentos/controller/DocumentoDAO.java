/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.model.Documento;
import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class DocumentoDAO {

    ModuloConexao con = new ModuloConexao();
    LimparCampos limparCampos = new LimparCampos();
    Documento documento = new Documento();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void cadastrarDocumento(Documento documento) {

        String sql = "insert into documento (nome, emissor_id, ativo) values(?,?,?)";
        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                if ((documento.getNome().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                } else {
                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, documento.getNome());
                    pst.setInt(2, documento.getEmissor());
                    pst.setString(3, documento.getAtivo());

                    int adicionado = pst.executeUpdate();

                    if (adicionado > 0) {

                        JOptionPane.showMessageDialog(null, "Novo documento cadastrado com"
                                + " sucesso.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar documento."
                    + e + JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
    }

    public void alterarDocumento(Documento documento) {

        String sql = "update documento set nome = ?, emissor_id = ?, ativo = ? where id = ?";
        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                if ((documento.getNome().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                } else {
                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, documento.getNome());
                    pst.setInt(2, documento.getEmissor());
                    pst.setString(3, documento.getAtivo());
                    pst.setInt(4, documento.getId());
                    int adicionado = pst.executeUpdate();

                    if (adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Documento alterado com"
                                + " sucesso.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar documento."
                    + e + JOptionPane.ERROR_MESSAGE);
        } finally {
            con.fecharConexao(conexao);
        }
    }

    public void excluirDocumento(Documento documento) {
        conexao = ModuloConexao.conector();

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que "
                + "deseja excluir o documento?", "Atenção!", JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from documento where id = ?";  //'"+emissor.getId()+"'

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, documento.getId());
                int apagado = pst.executeUpdate();

                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Documento excluído com sucesso");
                }
                limparCampos.limparCamposDocumento();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar excluir documento. " + e);
            } finally {
                con.fecharConexao(conexao);
            }

        }
    }
}
