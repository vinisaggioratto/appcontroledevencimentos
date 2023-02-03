/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.vinicius.appcontrolevencimento.utilities;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author vinicius-dev
 */
public class CriptografarSenha {
    
    public String criptografarSenha(String senha) throws NoSuchAlgorithmException{

        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(senha.getBytes(),0,senha.length());
        BigInteger senha1 = new BigInteger(1, m.digest());
        
        //formatar a senha criptografada para 32 caracteres
        String senhaCriptografada = String.format("%1$032x", senha1);
        //System.out.println("senha criptografada: " + senhaCriptografada);
        return senhaCriptografada;
    }
    
}
