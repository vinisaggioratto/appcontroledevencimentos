/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimento.utilities.UsuarioAtivo;
import br.com.vinicius.appcontrolevencimento.utilities.StatusServidor;
import br.com.vinicius.appcontrolevencimento.utilities.ValidarUsuario;
import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class ExecutarLogin {

    TelaPrincipal telaPrincipal = new TelaPrincipal();
    UsuarioAtivo usuarioAtivo = new UsuarioAtivo();
    ValidarUsuario validarUsuario = new ValidarUsuario();

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void logarSistema(String usuario, String senha) {
        StatusServidor statusServidor = new StatusServidor();

        conexao = ModuloConexao.conector();

        try {

            if (validarUsuario.validarUsuario(usuario, senha) == true) {
                telaPrincipal.setVisible(true);
                statusServidor.checarStatusServidorTelaPrincipal();
                telaPrincipal.labelUsuarioLogado.setText(usuarioAtivo.getUsuarioAtivoLogin());
                conexao.close();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o sistema" + e);
        }
    }
}
