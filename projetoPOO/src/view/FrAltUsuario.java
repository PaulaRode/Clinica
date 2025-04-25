package view;

import controller.UsuarioController;
import java.awt.Color;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Usuario;
import utils.Utils;

public class FrAltUsuario extends javax.swing.JDialog {

    //código do usuário que irá alterar
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public FrAltUsuario(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();

        //centraliza a janela na tela
        this.setLocationRelativeTo(null);

        setId(id);

        //carregar os dados deste usuário
        carregarUsuario();
    }

    public void carregarUsuario() {
        //vamos buscar no banco de dados o restante
        //dos campos do usuario, atualmente só
        //tem o pk
        UsuarioController controller = new UsuarioController();
        Usuario usuario = controller.buscarPorId(id);

        String codigo = String.valueOf(usuario.getId());
        edtCodigo.setText(codigo);
        edtNome.setText(usuario.getNome());
        edtEmail.setText(usuario.getEmail());
        edtDataNasc.setText(Utils.converterDateToString(usuario.getDataNasc()));
        chkAtivo.setSelected(usuario.isAtivo());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        edtCodigo = new javax.swing.JTextField();
        edtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblConfirmaSenha = new javax.swing.JLabel();
        lblDataNasc = new javax.swing.JLabel();
        edtConfirmaSenha = new javax.swing.JPasswordField();
        edtSenha = new javax.swing.JPasswordField();
        edtDataNasc = new javax.swing.JFormattedTextField();
        chkAtivo = new javax.swing.JCheckBox();
        btnAlterarSenha = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ateração de Usuário");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("Alteração de Usuário");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCodigo.setText("Código");
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        edtCodigo.setEditable(false);
        edtCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        edtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(edtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, -1));

        edtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(edtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 380, -1));

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmail.setText("Email");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        lblSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSenha.setText("Senha");
        jPanel1.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        lblConfirmaSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblConfirmaSenha.setText("Confirma senha");
        jPanel1.add(lblConfirmaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        lblDataNasc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDataNasc.setText("Data de Nascimento");
        jPanel1.add(lblDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, -1));

        edtConfirmaSenha.setEditable(false);
        edtConfirmaSenha.setBackground(java.awt.Color.gray);
        edtConfirmaSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(edtConfirmaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 260, -1));

        edtSenha.setEditable(false);
        edtSenha.setBackground(java.awt.Color.gray);
        edtSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(edtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 260, -1));

        edtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        edtDataNasc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        edtDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtDataNascActionPerformed(evt);
            }
        });
        jPanel1.add(edtDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 160, -1));

        chkAtivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chkAtivo.setText("Ativo");
        chkAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAtivoActionPerformed(evt);
            }
        });
        jPanel1.add(chkAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, -1, -1));

        btnAlterarSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAlterarSenha.setText("Alterar senha");
        btnAlterarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarSenhaMouseClicked(evt);
            }
        });
        jPanel1.add(btnAlterarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 140, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNome.setText("Nome");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        edtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 380, -1));

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 570, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void btnAlterarSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarSenhaMouseClicked
      if (edtSenha.isEditable() == false) {
          edtSenha.setEditable(true);
          edtConfirmaSenha.setEditable(true);
          edtSenha.setBackground(Color.white);
          edtConfirmaSenha.setBackground(Color.white);
          btnAlterarSenha.setText("Cancelar alteração");

          edtSenha.setText("");
          edtConfirmaSenha.setText("");
      } else {
          edtSenha.setEditable(false);
          edtConfirmaSenha.setEditable(false);
          edtSenha.setBackground(Color.gray);
          edtConfirmaSenha.setBackground(Color.gray);
          btnAlterarSenha.setText("Alterar Senha");

          edtSenha.setText("");
          edtConfirmaSenha.setText("");
      }
  }//GEN-LAST:event_btnAlterarSenhaMouseClicked

  private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
      this.dispose();
  }//GEN-LAST:event_btnCancelarMouseClicked

  private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
      if (verificarCampos()) {
          gravar();
      }
  }//GEN-LAST:event_btnSalvarMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void chkAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAtivoActionPerformed

    private void edtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCodigoActionPerformed

    private void edtDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDataNascActionPerformed

    public boolean verificarCampos() {
        if (edtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "O campo 'Nome' em branco");
            return false;
        }

        if (!edtNome.getText().matches("^[\\p{L} ]+$")) {
            JOptionPane.showMessageDialog(null,
                    "O campo 'Nome' possui caracteres inválidos");
            return false;
        }

        if (edtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "O campo 'Email' em branco");
            return false;
        }
        if (!edtEmail.getText().matches(
                "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null,
                    "O campo 'Email' possui formato inválido");
            return false;
        }

        if (!edtDataNasc.getText().matches(
                "^[0-9]{2}/[0-9]{2}/[0-9]{4}$")) {
            JOptionPane.showMessageDialog(null,
                    "O campo 'Data Nascimento' possui formato inválido."
                    + " Ex: 01/01/2010");
            return false;
        }

        if (edtSenha.isEditable()) {
            String senha = new String(edtSenha.getPassword());

            if (senha.length() < 5) {
                JOptionPane.showMessageDialog(null,
                        "O campo 'Senha' deve ser maior que 4 caracteres");
                return false;
            }

            if (!senha.equals(new String(edtConfirmaSenha.getPassword()))) {
                JOptionPane.showMessageDialog(null,
                        "As senhas não são iguais");
                return false;
            }

        }

        return true;
    }

    public void gravar() {
        //cria o objeto usuário
        Usuario usuario = new Usuario();

        //preenche os dados do usuário
        //id é o atributo da classe que veio do menu
        usuario.setId(id);
        usuario.setNome(edtNome.getText());
        usuario.setEmail(edtEmail.getText());

        if (edtSenha.isEditable()) {
            String senha = new String(edtSenha.getPassword());
            String senhaHash = Utils.calcularHash(senha);
            usuario.setSenha(senhaHash);
        }

        Date data = Utils.converterStringToDate(edtDataNasc.getText());
        usuario.setDataNasc(data);

        usuario.setAtivo(chkAtivo.isSelected());

        //Passar o objeto usu para o controller
        //enviar para o banco de dados
        UsuarioController controller = new UsuarioController();

        if (controller.alterarUsuario(usuario)) {
            JOptionPane.showMessageDialog(null,
                    "Usuário: " + usuario.getNome()
                    + " alterado com sucesso!");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Erro ao alterar usuário!");
        }
    }

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
            java.util.logging.Logger.getLogger(FrAltUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrAltUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrAltUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrAltUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrAltUsuario dialog = new FrAltUsuario(new javax.swing.JFrame(), true, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarSenha;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JTextField edtCodigo;
    private javax.swing.JPasswordField edtConfirmaSenha;
    private javax.swing.JFormattedTextField edtDataNasc;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtNome;
    private javax.swing.JPasswordField edtSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConfirmaSenha;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
