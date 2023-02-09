/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.utilities;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.view.TelaLogin;
import br.com.vinicius.appcontrolevencimentos.view.TelaPrincipal;
import static br.com.vinicius.appcontrolevencimentos.view.TelaPrincipal.tblUsuariosOnline;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 * Classe para mostrar os usuários ativos.
 *
 * @author FROTA01-PC
 */
public class UsuariosOnline {

    TelaLogin login = null;
    TelaPrincipal TelaPrincipal = null;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String id_Recuperado;

    public String buscarIdUsuario(String usuario) {
        conexao = ModuloConexao.conector();
        String sql = "select * from usuario where usuario = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                id_Recuperado = rs.getString("id");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Id não encontrado.");

        }
        System.out.println("id rec: " + id_Recuperado);
        return id_Recuperado;
    }

    public void alterarStatusOnline(String usuario_id) {
        conexao = ModuloConexao.conector();

        String sql = "update usuario set logado = 'Sim' where id = ?";
        //String sql = "update usuario set logado = 'Sim' where usuario = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario_id);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar status usuários. " + e);

        }

    }

    public void usuarioOnline() {
        conexao = ModuloConexao.conector();

        String sql = "select usuario as Usuário from usuario where logado = 'Sim'";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            TelaPrincipal.tblUsuariosOnline.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar usuários online. " + e);
        }
    }
    
        public void alterarStatusOffline(String usuario_id) {
        conexao = ModuloConexao.conector();

        String sql = "update usuario set logado = 'Não' where id = ?";
        //String sql = "update usuario set logado = 'Sim' where usuario = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario_id);
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar status usuários. " + e);

        }

    }
}
