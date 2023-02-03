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
    String senhaCriptoInformada;
    String senhaCriptoRecuperada;
    String nomeRecuperado;
    String senhaRecuperada;

    public boolean validarUsuario(String usuario, String senha) {
        CriptografarSenha criptoSenha = new CriptografarSenha();  //new CriptografarSenha()
        conexao = ModuloConexao.conector();
        String sql = "select * from usuario where usuario = ? and senha = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario);
            //String senha1 = new String(senha);
            pst.setString(2, senha);

            rs = pst.executeQuery();
            
            if (rs.next()) {
                nomeRecuperado = rs.getString("usuario");
                senhaRecuperada = rs.getString("senha");
                senhaCriptoRecuperada = criptoSenha.criptografarSenha(senhaRecuperada);
                senhaCriptoInformada = criptoSenha.criptografarSenha(senha);

                if (nomeRecuperado.equals(usuario) && senhaCriptoRecuperada.equals(senhaCriptoInformada)) {  //IgnoreCase
                    valido = true;

                } else {
                    JOptionPane.showMessageDialog(null, "Usuário/Senha inválidos.");
                    valido = false;

                }
                return valido;
            } else {

                JOptionPane.showMessageDialog(null, "Usuário/Senha inválidos.");
                conexao.close();
                return valido;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar usuário." + e);
        }
        return valido;
    }
}
