/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.connection;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Método responsável pela conexao com o banco
 *
 * @author FROTA01-PC
 */
public class ModuloConexao {

    //inicia com uma url do servidor padrão, que pode ser alterada usando o método
    //conectorDados, que recebe um novo servidor e porta.
    public static String url = "jdbc:mysql://localhost:3306/app_controle_vencimentos?characterEncoding=utf-8";
    ;
    String localServidor = "localhost";
    String portaLocal = "3306";

    public void conectorDados(String local, String porta) {
        localServidor = local;
        portaLocal = porta;
        url = "jdbc:mysql://" + localServidor + ":" + portaLocal + "/app_controle_vencimentos?characterEncoding=utf-8";
        //copia de segurança: String url = "jdbc:mysql://localhost:3306/app_controle_vencimentos?characterEncoding=utf-8";

    }

    public static Connection conector() {
        Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";

//        //copia de segurança: String url = "jdbc:mysql://localhost:3306/app_controle_vencimentos?characterEncoding=utf-8";
        String user = "Vinicius";
        String password = "Vini1812";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("Url" + url);

            return conexao;
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco." + e);
            return null;
        }
    }
    
    public void fecharConexao(Connection conexao){
        
        try {
            if(conexao != null && !conexao.isClosed()){
                conexao.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao fechar conexão.\n" + e 
                    + JOptionPane.ERROR_MESSAGE);
        }
    }

}
