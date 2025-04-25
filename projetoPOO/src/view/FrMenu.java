package view;

import java.net.URL;
import javax.swing.ImageIcon;
import view.FrAgendaConsulta;

public class FrMenu extends javax.swing.JFrame {

    public FrMenu() {
        initComponents();
        //Abre a tela centralizada
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblImagem = new javax.swing.JLabel();
        barMenu = new javax.swing.JMenuBar();
        meCadastro = new javax.swing.JMenu();
        miCadUsuario = new javax.swing.JMenuItem();
        miCadCliente = new javax.swing.JMenuItem();
        miCadMed = new javax.swing.JMenuItem();
        meConsulta = new javax.swing.JMenu();
        miConUsuario = new javax.swing.JMenuItem();
        miConCliente = new javax.swing.JMenuItem();
        miConMedico = new javax.swing.JMenuItem();
        meAgenda = new javax.swing.JMenu();
        miAgendaCons = new javax.swing.JMenuItem();
        miAgendaExame = new javax.swing.JMenuItem();
        meSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuG.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        barMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        meCadastro.setText("Cadastro");
        meCadastro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        miCadUsuario.setText("Usuário");
        miCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadUsuarioActionPerformed(evt);
            }
        });
        meCadastro.add(miCadUsuario);

        miCadCliente.setText("Cliente");
        miCadCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miCadClienteMouseClicked(evt);
            }
        });
        miCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadClienteActionPerformed(evt);
            }
        });
        meCadastro.add(miCadCliente);

        miCadMed.setText("Médicos");
        miCadMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadMedActionPerformed(evt);
            }
        });
        meCadastro.add(miCadMed);

        barMenu.add(meCadastro);

        meConsulta.setText("Consulta");
        meConsulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        miConUsuario.setText("Usuário");
        miConUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConUsuarioActionPerformed(evt);
            }
        });
        meConsulta.add(miConUsuario);

        miConCliente.setText("Cliente");
        miConCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConClienteActionPerformed(evt);
            }
        });
        meConsulta.add(miConCliente);

        miConMedico.setText("Médico");
        miConMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConMedicoActionPerformed(evt);
            }
        });
        meConsulta.add(miConMedico);

        barMenu.add(meConsulta);

        meAgenda.setText("Agenda");
        meAgenda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        miAgendaCons.setText("Consulta");
        miAgendaCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAgendaConsActionPerformed(evt);
            }
        });
        meAgenda.add(miAgendaCons);

        miAgendaExame.setText("Exames");
        meAgenda.add(miAgendaExame);

        barMenu.add(meAgenda);

        meSobre.setText("Sobre");
        meSobre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        meSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                meSobreMouseClicked(evt);
            }
        });
        barMenu.add(meSobre);

        setJMenuBar(barMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void miConUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConUsuarioActionPerformed
      //crio uma tela de cadastro de usuário
      FrConUsuario telaConsulta = new FrConUsuario(this, rootPaneCheckingEnabled);
      //Torno a tela visível
      telaConsulta.setVisible(true);
  }//GEN-LAST:event_miConUsuarioActionPerformed

  private void miConClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConClienteActionPerformed
      //crio uma tela de cadastro de usuário
      FrConCliente telaConsulta = new FrConCliente(this, rootPaneCheckingEnabled);
      //Torno a tela visível
      telaConsulta.setVisible(true);
  }//GEN-LAST:event_miConClienteActionPerformed

  private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

  }//GEN-LAST:event_formWindowOpened

  private void miCadMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadMedActionPerformed
      //crio uma tela de cadastro de usuário
      FrCadMedicos telaCadMed = new FrCadMedicos(this, rootPaneCheckingEnabled);
      //Torno a tela visível
      telaCadMed.setVisible(true);
  }//GEN-LAST:event_miCadMedActionPerformed

  private void miCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadUsuarioActionPerformed
      //crio uma tela de cadastro de usuário
      FrCadUsuario telaCadastro = new FrCadUsuario(this, rootPaneCheckingEnabled);
      //Torno a tela visível
      telaCadastro.setVisible(true);
  }//GEN-LAST:event_miCadUsuarioActionPerformed

  private void meSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meSobreMouseClicked
      FrSobre telaSobre = new FrSobre(this, rootPaneCheckingEnabled);
      telaSobre.setVisible(true);
  }//GEN-LAST:event_meSobreMouseClicked

    private void miCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadClienteActionPerformed
        //crio uma tela de cadastro de cliente
        FrCadCliente telaCadCli = new FrCadCliente(this, rootPaneCheckingEnabled);
        //Torno a tela visível
        telaCadCli.setVisible(true);
    }//GEN-LAST:event_miCadClienteActionPerformed

    private void miCadClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miCadClienteMouseClicked
    }//GEN-LAST:event_miCadClienteMouseClicked

    private void miConMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConMedicoActionPerformed
        //crio uma tela de cadastro de medico
        FRConMedicos telaConsulta = new FRConMedicos(this, rootPaneCheckingEnabled);
        //Torno a tela visível
        telaConsulta.setVisible(true);
    }//GEN-LAST:event_miConMedicoActionPerformed

    private void miAgendaConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAgendaConsActionPerformed

        try {

            FrAgendaConsulta telaAgenda = new FrAgendaConsulta(this, rootPaneCheckingEnabled);
            telaAgenda.setVisible(true);
        } catch (Exception e) {
            //Mostra o erro no console
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao abrir tela de agenda: " + e.getMessage());
        }
    }//GEN-LAST:event_miAgendaConsActionPerformed

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
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JMenu meAgenda;
    private javax.swing.JMenu meCadastro;
    private javax.swing.JMenu meConsulta;
    private javax.swing.JMenu meSobre;
    private javax.swing.JMenuItem miAgendaCons;
    private javax.swing.JMenuItem miAgendaExame;
    private javax.swing.JMenuItem miCadCliente;
    private javax.swing.JMenuItem miCadMed;
    private javax.swing.JMenuItem miCadUsuario;
    private javax.swing.JMenuItem miConCliente;
    private javax.swing.JMenuItem miConMedico;
    private javax.swing.JMenuItem miConUsuario;
    // End of variables declaration//GEN-END:variables
}
