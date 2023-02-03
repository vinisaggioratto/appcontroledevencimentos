/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.connection;

import java.sql.*;

/**
 * Método responsável pela conexao com o banco
 * @author FROTA01-PC
 */
public class ModuloConexao {
    
    public static Connection conector(){
        Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/app_controle_vencimentos?characterEncoding=utf-8";
        String user = "Vinicius";
        String password = "Vini1812";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco." + e);
            return null;
        }
    }
    
    
}
