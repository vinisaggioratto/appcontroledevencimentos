/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.vinicius.appcontrolevencimentos.view;

import br.com.vinicius.appcontrolevencimentos.controller.DocumentoDAO;
import br.com.vinicius.appcontrolevencimentos.search.PesquisarSetarDocumento;
import br.com.vinicius.appcontrolevencimentos.utilities.LimparCampos;
import br.com.vinicius.appcontrolevencimentos.model.Documento;
import java.awt.Dimension;
import java.sql.Connection;

/**
 *
 * @author FROTA01-PC
 */
public class TelaCadastroDocumento extends javax.swing.JInternalFrame {
    PesquisarSetarDocumento pesquisarDocumento = new PesquisarSetarDocumento();
    DocumentoDAO documentoDAO = new DocumentoDAO();
    Documento documento = new Documento();
    

    LimparCampos limpaCampos = new LimparCampos();
    Connection conexao = null;

    /**
     * Creates new form TelaCadUsuario
     */
    public TelaCadastroDocumento() {
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
        txtPesquisarDocumento = new javax.swing.JTextField();
        btnPesquisarDocumento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCadastroDocumento = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtIdDocumento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomeDocumento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboAtivo = new javax.swing.JComboBox<>();
        cboEmissorDocumento = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Cadastrar Documento");
        setToolTipText("Cadastrar Documento");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

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

        txtPesquisarDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarDocumentoKeyReleased(evt);
            }
        });

        btnPesquisarDocumento.setText("Pesquisar");
        btnPesquisarDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisarDocumentoMouseClicked(evt);
            }
        });

        tblCadastroDocumento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Documento", "Emissor", "Ativo"
            }
        ));
        tblCadastroDocumento.setShowGrid(true);
        tblCadastroDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCadastroDocumentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCadastroDocumento);

        jLabel1.setText("Id:");

        txtIdDocumento.setEditable(false);
        txtIdDocumento.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Nome:");

        jLabel3.setText("Emissor:");

        jLabel5.setText("Ativo?");

        cboAtivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        cboEmissorDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmissorDocumentoActionPerformed(evt);
            }
        });

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
                                .addComponent(txtPesquisarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisarDocumento))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomeDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                    .addComponent(txtIdDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboEmissorDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(txtPesquisarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarDocumento))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboEmissorDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        setBounds(0, 0, 627, 519);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisarDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarDocumentoKeyReleased
        // TODO add your handling code here:
        pesquisarDocumento.pesquisarDocumento();
    }//GEN-LAST:event_txtPesquisarDocumentoKeyReleased

    private void tblCadastroDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCadastroDocumentoMouseClicked
        // TODO add your handling code here:
        pesquisarDocumento.setarDocumento();
    }//GEN-LAST:event_tblCadastroDocumentoMouseClicked

    private void lblBotaoCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotaoCancelarMouseClicked
        // TODO add your handling code here:
        limpaCampos.limparCamposDocumento();
    }//GEN-LAST:event_lblBotaoCancelarMouseClicked

    private void btnPesquisarDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarDocumentoMouseClicked
        // TODO add your handling code here:
        pesquisarDocumento.pesquisarDocumento();
    }//GEN-LAST:event_btnPesquisarDocumentoMouseClicked

    private void lblBotaoSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotaoSalvarMouseClicked
        // TODO add your handling code here:
        if(txtIdDocumento.getText().isEmpty()){
            documento.setNome(txtNomeDocumento.getText());
            documento.setEmissor(pesquisarDocumento.retornarIdEmissor());
            documento.setAtivo(cboAtivo.getSelectedItem().toString());
            documentoDAO.cadastrarDocumento(documento);  
        }else{
            documento.setNome(txtNomeDocumento.getText());
            documento.setEmissor(pesquisarDocumento.retornarIdEmissor());
            documento.setAtivo(cboAtivo.getSelectedItem().toString());
            documento.setId(Integer.parseInt(txtIdDocumento.getText()));
            documentoDAO.alterarDocumento(documento); 
        }
        
    }//GEN-LAST:event_lblBotaoSalvarMouseClicked

    private void lblBotaoNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotaoNovoMouseClicked
        // TODO add your handling code here:
        limpaCampos.limparCamposDocumento();
    }//GEN-LAST:event_lblBotaoNovoMouseClicked

    private void lblBotaoExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotaoExcluirMouseClicked
        // TODO add your handling code here:
        documento.setId(Integer.parseInt(txtIdDocumento.getText()));
        documentoDAO.excluirDocumento(documento);
    }//GEN-LAST:event_lblBotaoExcluirMouseClicked

    private void cboEmissorDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmissorDocumentoActionPerformed
        // TODO add your handling code here:
        
        System.out.println("posicao: "+cboEmissorDocumento.getSelectedIndex());
        
    }//GEN-LAST:event_cboEmissorDocumentoActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        cboEmissorDocumento.removeAllItems();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisarDocumento;
    public static javax.swing.JComboBox<String> cboAtivo;
    public static javax.swing.JComboBox<String> cboEmissorDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblBotaoCancelar;
    public static javax.swing.JLabel lblBotaoExcluir;
    public static javax.swing.JLabel lblBotaoNovo;
    public static javax.swing.JLabel lblBotaoSalvar;
    public static javax.swing.JTable tblCadastroDocumento;
    public static javax.swing.JTextField txtIdDocumento;
    public static javax.swing.JTextField txtNomeDocumento;
    public static javax.swing.JTextField txtPesquisarDocumento;
    // End of variables declaration//GEN-END:variables
}
