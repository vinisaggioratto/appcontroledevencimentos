/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.controller;

import br.com.vinicius.appcontrolevencimentos.connection.ModuloConexao;
import br.com.vinicius.appcontrolevencimentos.model.Perfil;
import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import br.com.vinicius.appcontrolevencimentos.view.TelaCadastroPerfil;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FROTA01-PC
 */
public class PerfilDAO {
    TelaCadastroPerfil telaPerfil = null;
    Perfil perfil = new Perfil();
    LimparCampos limparCampos = new LimparCampos();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void cadastrarPerfil(Perfil perfil){
        conexao = ModuloConexao.conector();
        
        String sql = "insert into perfil(nome, descricao) values (?, ?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, perfil.getNome());
            pst.setString(2, perfil.getDescricao());
            
            if((perfil.getNome().isEmpty())
                    || (perfil.getDescricao().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            }else{
                int adicionado = pst.executeUpdate();
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Novo usuário cadastrado com sucesso.");
                }
                limparCampos.limparCamposPerfil();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o "
                    + " novo perfil." + e);
        }
        
    }
    
    public void editarPerfil(Perfil perfil){
        conexao = ModuloConexao.conector();
        String sql = "update perfil set nome = ?, descricao = ? where id = ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, perfil.getNome());
            pst.setString(2, perfil.getDescricao());
            pst.setInt(3, perfil.getId());
            
            if((perfil.getNome().isEmpty())
                    || (perfil.getDescricao().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            }else{
                int adicionado = pst.executeUpdate();
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
                }
                limparCampos.limparCamposPerfil();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar os dados "
                    + "do perfil." + e);
        }
        
    }
    
    public void excluirPerfil(Perfil perfil){
        conexao = ModuloConexao.conector();
        
        int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja "
                + "excluir o perfil?","Atenção!",JOptionPane.YES_NO_CANCEL_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION){
            String sql = "delete from perfil where id = ?";
            
            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, perfil.getId());
                int apagado = pst.executeUpdate();
                
                if(apagado > 0){
                    JOptionPane.showMessageDialog(null, "Perfil excluído com sucesso.");
                }
                limparCampos.limparCamposPerfil();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao excluir o perfil." + e);
            }
        }
        
        
    }
    
}
