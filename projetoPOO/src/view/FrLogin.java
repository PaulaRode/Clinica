package view;

import controller.UsuarioController;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utils.Utils;

public class FrLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrLogin
     */
    public FrLogin() {
        initComponents();
        //centraliza a janela na tela
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAutenticacao = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        edtSenha = new javax.swing.JPasswordField();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        btnLogar = new javax.swing.JButton();
        lblImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autenticação");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAutenticacao.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblAutenticacao.setText("Autenticação");
        jPanel1.add(lblAutenticacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        edtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(edtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 273, -1));

        edtSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        edtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtSenhaActionPerformed(evt);
            }
        });
        edtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtSenhaKeyPressed(evt);
            }
        });
        jPanel1.add(edtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 273, -1));

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmail.setText("Email");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        lblSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSenha.setText("Senha");
        jPanel1.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

        btnLogar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogar.setText("Logar");
        btnLogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogarMouseClicked(evt);
            }
        });
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 121, -1));

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Menu.png"))); // NOI18N
        jPanel1.add(lblImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 100, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  private void btnLogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogarMouseClicked
      realizarLogin();
  }//GEN-LAST:event_btnLogarMouseClicked

  private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      URL caminhoImagem = getClass().getResource("/images/24heart_icon.png");

      ImageIcon icon = new ImageIcon(caminhoImagem);

      // Define o ícone da janela
      this.setIconImage(icon.getImage());
  }//GEN-LAST:event_formWindowOpened

  private void edtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtSenhaKeyPressed
      //verifico se foi pressionado ENTER
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          //Se foi teclado ENTER tenta fazer login
          realizarLogin();
      }
  }//GEN-LAST:event_edtSenhaKeyPressed

    private void edtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtSenhaActionPerformed

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogarActionPerformed

    private void realizarLogin() {
        String email = edtEmail.getText();
        String senha = new String(edtSenha.getPassword());

        if (email.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Campo 'Email' em branco!");
            return;
        }

        if (senha.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Campo 'Senha' em branco!");
            return;
        }

        //Calcular o hash da senha
        senha = Utils.calcularHash(senha);

        UsuarioController controller = new UsuarioController();

        boolean autenticado = controller.autenticar(email, senha);

        if (autenticado) {
            //Se está autenticado cria a tela de menu
            FrMenu telaMenu = new FrMenu();
            telaMenu.setVisible(true);
            this.dispose();  // Fecha a janela
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
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
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JPasswordField edtSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAutenticacao;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblSenha;
    // End of variables declaration//GEN-END:variables
}
