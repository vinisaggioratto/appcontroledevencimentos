/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimento.utilities;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class ValidarUsuario {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    boolean valido;

    public boolean validarUsuario(String usuario, String senha) {

        conexao = ModuloConexao.conector();
        String sql = "select * from usuario where usuario = ? and senha = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario);
            String senha1 = new String(senha);
            pst.setString(2, senha1);

            rs = pst.executeQuery();

            if (rs.next()) {
                String nomeRecuperado = rs.getString("usuario");
                String senhaRecuperada = rs.getString("senha");

                if (nomeRecuperado.equals(usuario) && senhaRecuperada.equals(senha)) {
                    valido = true;

                } else {
                    JOptionPane.showMessageDialog(null, "Usuário/Senha inválidos.");
                    valido = false;

                }
                return valido;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                conexao.close();
                return valido;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar usuário." + e);
        }
        return valido;
    }
}
