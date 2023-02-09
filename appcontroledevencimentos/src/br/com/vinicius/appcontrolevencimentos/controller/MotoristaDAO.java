/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.model.Motorista;
import java.sql.*;
import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroMotorista;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class MotoristaDAO {

    TelaCadastroMotorista telaMotorista = null;
    Motorista motorista = new Motorista();
    LimparCampos limparCampos = new LimparCampos();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void cadastrarMotorista(Motorista motorista) {
        conexao = ModuloConexao.conector();

        String sql = "insert into motorista (nome, ativo) values(?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, motorista.getNome());
            pst.setString(2, motorista.getAtivo());

            if ((motorista.getNome().isEmpty())
                    || (motorista.getAtivo().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Novo motorista cadastrado com sucesso.");
                }
                limparCampos.limparCamposUsuario();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o "
                    + " motorista." + e);
        }
    }

    public void editarMotorista(Motorista motorista) {
        conexao = ModuloConexao.conector();
        String sql = "update motorista set nome = ?, ativo = ? where id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, motorista.getNome());
            pst.setString(2, motorista.getAtivo());
            pst.setInt(3, motorista.getId());

            if ((motorista.getNome().isEmpty())
                    || (motorista.getAtivo().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
                }
                limparCampos.limparCamposUsuario();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar os dados"
                    + " do motorista." + e);
        }

    }

    public void excluirMotorista(Motorista motorista) {
        conexao = ModuloConexao.conector();

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir "
                + "o cadastro?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from motorista where id = ?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, motorista.getId());
                int apagado = pst.executeUpdate();

                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Motorista excluído com sucesso.");
                    limparCampos.limparCamposMotorista();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir motorista." + e);
            }
        }
    }

}
