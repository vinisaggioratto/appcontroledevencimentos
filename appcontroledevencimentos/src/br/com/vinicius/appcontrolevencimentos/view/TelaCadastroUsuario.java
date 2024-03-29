/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.view;

import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import br.com.vinicius.appcontrolevencimentos.controller.UsuarioDAO;
import br.com.vinicius.appcontrolevencimentos.search.PesquisarSetarUsuario;
import br.com.vinicius.appcontrolevencimentos.model.Usuario;
import java.awt.Dimension;
import java.sql.Connection;

/**
 *
 * @author FROTA01-PC
 */
public class TelaCadastroUsuario extends javax.swing.JInternalFrame {
    
    PesquisarSetarUsuario pesquisarUsuario = new PesquisarSetarUsuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuario = new Usuario();
    LimparCampos limpaCampos = new LimparCampos();
    Connection conexao = null;

    /**
     * Creates new form TelaCadUsuario
     */
    public TelaCadastroUsuario() {
        initComponents();
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBotaoNovo = new javax.swing.JLabel();
        lblBotaoSalvar = new javax.swing.JLabel();
        lblBotaoCancelar = new javax.swing.JLabel();
        lblBotaoExcluir = new javax.swing.JLabel();
        txtPesquisarUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCadastroUsuario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboAtivo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cboPerfil = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Cadastrar Usuário");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblBotaoNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vinicius/appcontrolevencimentos/icons/adicionar-ficheiro.png"))); // NOI18N
        lblBotaoNovo.setToolTipText("Novo");
        lblBotaoNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBotaoNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotaoNovoMouseClicked(evt);
            }
        });

        lblBotaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vinicius/appcontrolevencimentos/icons/salve-.png"))); // NOI18N
        lblBotaoSalvar.setToolTipText("Salvar");
        lblBotaoSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBotaoSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotaoSalvarMouseClicked(evt);
            }
        });

        lblBotaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vinicius/appcontrolevencimentos/icons/cancelar.png"))); // NOI18N
        lblBotaoCancelar.setToolTipText("Cancelar");
        lblBotaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBotaoCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotaoCancelarMouseClicked(evt);
            }
        });

        lblBotaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/vinicius/appcontrolevencimentos/icons/bin.png"))); // NOI18N
        lblBotaoExcluir.setToolTipText("Excluir");
        lblBotaoExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBotaoExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotaoExcluirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBotaoNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBotaoSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBotaoCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBotaoExcluir)
                .addContainerGap(447, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBotaoNovo)
                    .addComponent(lblBotaoSalvar)
                    .addComponent(lblBotaoCancelar)
                    .addComponent(lblBotaoExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPesquisarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarUsuarioKeyReleased(evt);
            }
        });

        jButton1.setText("Pesquisar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        tblCadastroUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Usuário", "Senha", "Perfil", "Ativo"
            }
        ));
        tblCadastroUsuario.setShowGrid(true);
        tblCadastroUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCadastroUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCadastroUsuario);

        jLabel1.setText("Id:");

        txtIdUsuario.setEditable(false);
        txtIdUsuario.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Usuário:");

        jLabel3.setText("Senha:");

        jLabel4.setText("Ativo?");

        cboAtivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        jLabel5.setText("Perfil:");

        cboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gestor", "Operacional I", "Operacional II" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                    .addComponent(txtSenha)
                                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        setBounds(0, 0, 627, 519);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarUsuarioKeyReleased
        // TODO add your handling code here:
        pesquisarUsuario.pesquisarUsuario();
    }//GEN-LAST:event_txtPesquisarUsuarioKeyReleased

    private void tblCadastroUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCadastroUsuarioMouseClicked
        // TODO add your handling code here:
        pesquisarUsuario.setarCampos();
    }//GEN-LAST:event_tblCadastroUsuarioMouseClicked

    private void lblBotaoCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotaoCancelarMouseClicked
        // TODO add your handling code here:
        limpaCampos.limparCamposUsuario();
    }//GEN-LAST:event_lblBotaoCancelarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        pesquisarUsuario.pesquisarUsuario();
    }//GEN-LAST:event_jButton1MouseClicked

    private void lblBotaoSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotaoSalvarMouseClicked
        // TODO add your handling code here:
        if (txtIdUsuario.getText().isEmpty()) {
            usuario.setNome(txtUsuario.getText());
            usuario.setSenha(txtSenha.getText());
            usuario.setPerfil(pesquisarUsuario.retornarIdEmissor());
            usuario.setAtivo(cboAtivo.getSelectedItem().toString());
            usuarioDAO.cadastrarUsuario(usuario);            
        } else {
            usuario.setNome(txtUsuario.getText());
            usuario.setSenha(txtSenha.getText());
            usuario.setPerfil(pesquisarUsuario.retornarIdEmissor());
            usuario.setAtivo(cboAtivo.getSelectedItem().toString());
            usuario.setId(Integer.parseInt(txtIdUsuario.getText()));
            usuarioDAO.editarUsuario(usuario);
        }
        
    }//GEN-LAST:event_lblBotaoSalvarMouseClicked

    private void lblBotaoNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotaoNovoMouseClicked
        // TODO add your handling code here:
        limpaCampos.limparCamposUsuario();
    }//GEN-LAST:event_lblBotaoNovoMouseClicked

    private void lblBotaoExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotaoExcluirMouseClicked
        // TODO add your handling code here:
        usuario.setId(Integer.parseInt(txtIdUsuario.getText()));
        usuarioDAO.excluirUsuario(usuario);
    }//GEN-LAST:event_lblBotaoExcluirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> cboAtivo;
    public static javax.swing.JComboBox<String> cboPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblBotaoCancelar;
    public static javax.swing.JLabel lblBotaoExcluir;
    public static javax.swing.JLabel lblBotaoNovo;
    public static javax.swing.JLabel lblBotaoSalvar;
    public static javax.swing.JTable tblCadastroUsuario;
    public static javax.swing.JTextField txtIdUsuario;
    public static javax.swing.JTextField txtPesquisarUsuario;
    public static javax.swing.JTextField txtSenha;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
