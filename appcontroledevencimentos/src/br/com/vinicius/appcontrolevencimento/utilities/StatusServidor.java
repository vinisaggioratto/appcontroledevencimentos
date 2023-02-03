/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimento.utilities;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaLogin;
import br.com.vinicius.appcontrolevencimentos.view.TelaPrincipal;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author FROTA01-PC
 */
public class StatusServidor {

    Connection conexao = null;

    public void checarStatusServidorLogin() {
        TelaLogin telaLogin = null;
        conexao = ModuloConexao.conector();

        if (conexao != null) {
            telaLogin.LabelServidorStatus.setText("Online");
            telaLogin.LabelServidorStatus.setForeground(Color.blue);

        } else {
            telaLogin.LabelServidorStatus.setText("Offline");
            telaLogin.LabelServidorStatus.setForeground(Color.red);

        }

    }

    public void checarStatusServidorTelaPrincipal() {
        TelaPrincipal telaPrincipal = null;
        conexao = ModuloConexao.conector();

        if (conexao != null) {
            telaPrincipal.labelStatusDB.setText("Online");
            telaPrincipal.labelStatusDB.setForeground(Color.blue);

        } else {
            telaPrincipal.labelStatusDB.setText("Offline");
            telaPrincipal.labelStatusDB.setForeground(Color.red);
        }

    }

}
