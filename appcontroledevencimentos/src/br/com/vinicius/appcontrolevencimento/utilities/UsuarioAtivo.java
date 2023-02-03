/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimento.utilities;

import br.com.vinicius.appcontrolevencimentos.view.TelaLogin;

/**
 *
 * @author FROTA01-PC
 */
public class UsuarioAtivo {

    public String getUsuarioAtivoLogin() {

        TelaLogin login = null;

        String usuario = login.txtUsuario.getText();
        return usuario;
    }

}
