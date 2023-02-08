/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroVeiculo;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius-dev
 */
public class CrudVeiculo {

    TelaCadastroVeiculo telaVeiculo = null;
    LimparCampos limparCampos = new LimparCampos();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void cadastrarVeiculo() {

        conexao = ModuloConexao.conector();

        String sql = "insert into veiculo (placa, modelo, tipo_id, bottom, ativo) "
                + "values (?,?,?,?,?)";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, telaVeiculo.txtPlaca.getText());
            pst.setString(2, telaVeiculo.txtModeloVeiculo.getText());
            //tipo utilitário
            if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Utilitário")) {
                pst.setString(3, "1");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Toco")) {
                pst.setString(3, "2");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Truck")) {
                pst.setString(3, "3");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Quarto Eixo")) {
                pst.setString(3, "4");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Cavalo Mecânico")) {
                pst.setString(3, "5");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Vanderléia")) {
                pst.setString(3, "6");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Bi-trem")) {
                pst.setString(3, "7");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Rodo-Trem")) {
                pst.setString(3, "8");
            }
            
            pst.setString(4, telaVeiculo.cboBottom.getSelectedItem().toString());
            pst.setString(5, telaVeiculo.cboAtivo.getSelectedItem().toString());

            if ((telaVeiculo.txtPlaca.getText().isEmpty())
                    || (telaVeiculo.txtModeloVeiculo.getText().isEmpty())
                    || (telaVeiculo.cboTipoVeiculo.getSelectedItem().toString().isEmpty())
                    || (telaVeiculo.cboBottom.getSelectedItem().toString().isEmpty())
                    || (telaVeiculo.cboAtivo.getSelectedItem().toString().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Novo veículo cadastrado com sucesso.");
                }
                limparCampos.limparCamposVeiculo();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o "
                    + " novo veículo." + e);
        }
    }

    public void editarVeiculo() {

        conexao = ModuloConexao.conector();

        String sql = "update veiculo set placa = ?, modelo = ?, tipo_id = ?, "
                + "bottom = ?, ativo = ? where id = ?";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, telaVeiculo.txtPlaca.getText());
            pst.setString(2, telaVeiculo.txtModeloVeiculo.getText());
            //tipo utilitário
            if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Utilitário")) {
                pst.setString(3, "1");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Toco")) {
                pst.setString(3, "2");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Truck")) {
                pst.setString(3, "3");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Quarto Eixo")) {
                pst.setString(3, "4");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Cavalo Mecânico")) {
                pst.setString(3, "5");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Vanderléia")) {
                pst.setString(3, "6");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Bi-trem")) {
                pst.setString(3, "7");
            } else if (telaVeiculo.cboTipoVeiculo.getSelectedItem().equals("Rodo-Trem")) {
                pst.setString(3, "8");
            }
            
            pst.setString(4, telaVeiculo.cboBottom.getSelectedItem().toString());
            pst.setString(5, telaVeiculo.cboAtivo.getSelectedItem().toString());
            pst.setString(6, telaVeiculo.txtIdVeiculo.getText());
            

            if ((telaVeiculo.txtPlaca.getText().isEmpty())
                    || (telaVeiculo.txtModeloVeiculo.getText().isEmpty())
                    || (telaVeiculo.cboTipoVeiculo.getSelectedItem().toString().isEmpty())
                    || (telaVeiculo.cboBottom.getSelectedItem().toString().isEmpty())
                    || (telaVeiculo.cboAtivo.getSelectedItem().toString().isEmpty())) {
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
                    + " do veículo." + e);
        }
    }

    public void excluirVeiculo() {
        conexao = ModuloConexao.conector();

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que "
                + "deseja excluir o veículo?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from veiculo where id = ?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, telaVeiculo.txtIdVeiculo.getText());
                int apagado = pst.executeUpdate();

                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Veiculo excluído com sucesso.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o veículo." + e);
            }
        }
    }

}
