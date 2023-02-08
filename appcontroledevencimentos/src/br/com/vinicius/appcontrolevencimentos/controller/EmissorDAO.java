/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.model.Emissor;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class EmissorDAO {

    ModuloConexao con = new ModuloConexao();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean cadastrarEmissor(Emissor emissor) {

        boolean salvou = true;

        String sql = "insert into emissor (nome) values('" + emissor.getNome() + "')";
        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                if ((emissor.getNome().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                } else {
                    pst = conexao.prepareStatement(sql);
                    int adicionado = pst.executeUpdate();

                    if (adicionado > 0) {
                        salvou = false;
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
        return salvou;
    }

    public boolean alterarEmissor(Emissor emissor) {
        boolean alterou = true;

        String sql = "update emissor set nome = '" + emissor.getNome() + "' "
                + "where id = '" + emissor.getId() + "'";
        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                if ((emissor.getNome().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                } else {
                    pst = conexao.prepareStatement(sql);
                    int adicionado = pst.executeUpdate();

                    if (adicionado > 0) {
                        alterou = false;
                        JOptionPane.showMessageDialog(null, "Emissor alterado com"
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
        return alterou;
    }
}
