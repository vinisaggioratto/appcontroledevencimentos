/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.view;

import br.com.vinicius.appcontrolevencimento.utilities.FecharSistema;
import javax.swing.JFrame;

/**
 *
 * @author FROTA01-PC
 */
public class TelaPrincipal extends javax.swing.JFrame {
    

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        labelTituloStatusDB = new javax.swing.JLabel();
        labelStatusDB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelUsuarioLogado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuCadastroDocumento = new javax.swing.JMenuItem();
        menuCadastroLicenca = new javax.swing.JMenuItem();
        menuCadastroVeiculo = new javax.swing.JMenuItem();
        menuCadastroMotorista = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuCadastroUsuario = new javax.swing.JMenuItem();
        menuDocumentos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuLicencas = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        menuOpcoes = new javax.swing.JMenu();
        menuOpcoesSobre = new javax.swing.JMenuItem();
        menuOpcoesAjuda = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        menuSairSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelTituloStatusDB.setText("Status DB:");

        labelStatusDB.setText("Online");

        jLabel1.setText("Usuário:");

        labelUsuarioLogado.setText("UsuárioLogado");

        menuCadastros.setText("Cadastros");
        menuCadastros.setName(""); // NOI18N

        menuCadastroDocumento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuCadastroDocumento.setText("Documento");
        menuCadastroDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroDocumentoActionPerformed(evt);
            }
        });
        menuCadastros.add(menuCadastroDocumento);

        menuCadastroLicenca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuCadastroLicenca.setText("Licença");
        menuCadastroLicenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroLicencaActionPerformed(evt);
            }
        });
        menuCadastros.add(menuCadastroLicenca);

        menuCadastroVeiculo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuCadastroVeiculo.setText("Veículo");
        menuCadastros.add(menuCadastroVeiculo);

        menuCadastroMotorista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuCadastroMotorista.setText("Motorista");
        menuCadastros.add(menuCadastroMotorista);
        menuCadastros.add(jSeparator2);

        menuCadastroUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuCadastroUsuario.setText("Usuário");
        menuCadastros.add(menuCadastroUsuario);

        jMenuBar1.add(menuCadastros);

        menuDocumentos.setText("Documentos");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem1.setText("Veículos");
        menuDocumentos.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem2.setText("Motoristas");
        menuDocumentos.add(jMenuItem2);

        jMenuBar1.add(menuDocumentos);

        menuLicencas.setText("Licenças");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem3.setText("Veículos");
        menuLicencas.add(jMenuItem3);

        jMenuBar1.add(menuLicencas);

        menuRelatorios.setText("Relatórios");
        jMenuBar1.add(menuRelatorios);

        menuOpcoes.setText("Opções");

        menuOpcoesSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuOpcoesSobre.setText("Sobre");
        menuOpcoes.add(menuOpcoesSobre);

        menuOpcoesAjuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuOpcoesAjuda.setText("Ajuda");
        menuOpcoes.add(menuOpcoesAjuda);

        jMenuBar1.add(menuOpcoes);

        menuSair.setText("Sair");

        menuSairSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuSairSair.setText("Sair");
        menuSairSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairSairActionPerformed(evt);
            }
        });
        menuSair.add(menuSairSair);

        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTituloStatusDB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatusDB)
                .addGap(142, 142, 142)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUsuarioLogado)
                .addContainerGap(433, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(482, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelStatusDB)
                        .addComponent(jLabel1)
                        .addComponent(labelUsuarioLogado))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelTituloStatusDB)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCadastroDocumentoActionPerformed

    private void menuCadastroLicencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroLicencaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCadastroLicencaActionPerformed

    private void menuSairSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairSairActionPerformed
        // TODO add your handling code here:
        FecharSistema fechar = new FecharSistema();
        fechar.closeSystem();
    }//GEN-LAST:event_menuSairSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    public static javax.swing.JLabel labelStatusDB;
    private javax.swing.JLabel labelTituloStatusDB;
    public static javax.swing.JLabel labelUsuarioLogado;
    private javax.swing.JMenuItem menuCadastroDocumento;
    private javax.swing.JMenuItem menuCadastroLicenca;
    private javax.swing.JMenuItem menuCadastroMotorista;
    private javax.swing.JMenuItem menuCadastroUsuario;
    private javax.swing.JMenuItem menuCadastroVeiculo;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuDocumentos;
    private javax.swing.JMenu menuLicencas;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenuItem menuOpcoesAjuda;
    private javax.swing.JMenuItem menuOpcoesSobre;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenuItem menuSairSair;
    // End of variables declaration//GEN-END:variables
}