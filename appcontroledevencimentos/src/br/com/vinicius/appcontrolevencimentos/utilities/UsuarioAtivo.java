/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.utilities;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.model.Usuario;
import br.com.vinicius.appcontrolevencimentos.view.TelaLogin;
import java.sql.*;

/**
 *
 * @author FROTA01-PC
 */
public class UsuarioAtivo {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Usuario usuario = new Usuario();
    TelaLogin login = null;
    
    int idUsuario;

    public String getUsuarioAtivoLogin() {

        TelaLogin login = null;

        String usuario = login.txtUsuario.getText();
        return usuario;
    }

    public int getUsuarioAtivoLoginId() {

        conexao = ModuloConexao.conector();

        String sql = "select * from usuario";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                idUsuario = rs.getInt("id");
            }

        } catch (Exception e) {
        }
        return idUsuario;

    }
}
