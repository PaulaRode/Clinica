package view;

import controller.ClienteController;
import controller.ConsultaController;
import controller.MedicoController;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Consulta;
import model.Medico;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FrAgendaConsulta extends javax.swing.JDialog {

    // guarda o cliente selecionado na pesquisa
    private Cliente clienteSelecionado = null;
    private final ClienteController clienteController = new ClienteController();
    private final MedicoController medicoController = new MedicoController();
    private final ConsultaController consultaController = new ConsultaController();

    // nova tabela + scroll para pesquisa de clientes
    private javax.swing.JScrollPane jScrollPane2;

    //Construtor
    public FrAgendaConsulta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarClientes();
        carregarMedicos();
        carregarConsultas();
        //centraliza a janela na tela
        this.setLocationRelativeTo(null);

    }

    // Método para carregar clientes
    private void carregarClientes() {

        List<Cliente> lista = clienteController.listarClientes();

        for (Cliente c : lista) {

        }
    }

    private void carregarMedicos() {

        List<Medico> lista = medicoController.listarMedicos();
        cbMedico.removeAllItems();
        for (Medico m : lista) {
            cbMedico.addItem(m);
        }
    }

    private void carregarConsultas() {
        DefaultTableModel model = (DefaultTableModel) tblConsulta.getModel();
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        ConsultaController controller = new ConsultaController();
        for (Consulta c : consultaController.listarConsultasComNomes()) {
            model.addRow(new Object[]{
                c.getId(),
                c.getCliente().getNome(),
                c.getMedico().getNome(),
                sdf.format(c.getData()),
                c.getHora().toString().substring(0, 5)
            });
        }
    }

    private void carregarTabela() {
        //Pega o modelo da grade com suas colunas
        DefaultTableModel modeloTabela = (DefaultTableModel) tblConsulta.getModel();

        //Cria um ConsultaController para poder acessar os dados de tbconsulta
        ConsultaController controller = new ConsultaController();

        //consulta as consultas e guarda a lista de consulta que encontrou
        List<Consulta> listaConsulta = controller.listarConsultasComNomes();

        //Preencher a grade
        //percorre todos as consultas presentes na lista
        for (Consulta c : listaConsulta) {
            modeloTabela.addRow(new Object[]{
                c.getId(),
                c.getCliente().getNome(),
                c.getMedico().getNome(),
                c.getData(),
                c.getHora()
            });
        }
    }

    private void salvarConsulta() {

        // Captura os dados dos campos
        String nomeCliente = txtPesquisa.getText().trim(); // Obtém o nome do cliente do JTextField
        //List <Cliente> listaCliente = controller.buscarClientePorNome(nomeCliente); // Recupera o cliente usando o nome
        String dataStr = txtData.getText();
        String horaStr = txtHora.getText();
        Medico medicoSelecionado = (Medico) cbMedico.getSelectedItem();

        // validando cliente vindo da pesquisa
        if (clienteSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente na tabela de pesquisa!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validação dos campos obrigatórios
        if (clienteSelecionado == null || medicoSelecionado == null || dataStr.isEmpty() || horaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {

            // Conversão de String para LocalDate e LocalTime
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            LocalDate localDate = LocalDate.parse(dataStr, dateFormatter);
            LocalTime localTime = LocalTime.parse(horaStr, timeFormatter);

            // Conversão para java.sql.Date e java.sql.Time
            Date data = Date.valueOf(localDate);
            Time hora = Time.valueOf(localTime);

            // Criação e preenchimento do objeto Consulta
            Consulta c = new Consulta();
            c.setData(data);
            c.setHora(hora);
            c.setCliente(clienteSelecionado);
            c.setMedico(medicoSelecionado);

            // Salvando via controller
            consultaController.inserirConsulta(c);// Chama o método para salvar no banco de dados
            JOptionPane.showMessageDialog(this, "Consulta salva com sucesso!");

            limparCampos();
            carregarConsultas();
            clienteSelecionado = null;
            txtNomeCliente.setText("");
            txtPesquisa.setText("");
            jScrollPane2.setVisible(false);

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de data ou hora inválido! Use dd/MM/yyyy para a data e HH:mm para a hora.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar consulta: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void alterarConsulta() {
        int linha = tblConsulta.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para alterar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtém o ID da consulta da linha selecionada
        int id = Integer.parseInt(tblConsulta.getValueAt(linha, 0).toString());

        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(txtCodCliente.getText()));

        Medico medico = (Medico) cbMedico.getSelectedItem();

        String data = txtData.getText().trim();
        String hora = txtHora.getText().trim();

        if (clienteSelecionado == null || medico == null || data.isEmpty() || hora.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {

            Consulta c = new Consulta();
            c.setId(id);
            c.setCliente(cliente);
            c.setMedico(medico);

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dataConvertida = formato.parse(data);

            c.setData(dataConvertida);
            c.setHora(Time.valueOf(hora + ":00"));
            //consultaController.alterarConsulta(c);

            if (consultaController.alterarConsulta(c)) {

                JOptionPane.showMessageDialog(null, "Consulta alterada com sucesso!");
                limparCampos();
                carregarConsultas();

            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido! Use yyyy-MM-dd", "Erro", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirConsulta() {
        int linha = tblConsulta.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para excluir!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idConsulta = Integer.parseInt(tblConsulta.getValueAt(linha, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            consultaController.excluirConsulta(idConsulta);

            JOptionPane.showMessageDialog(null, "Consulta excluída com sucesso!");
            limparCampos();
            carregarConsultas();
        }
    }

    private void limparCampos() {
        clienteSelecionado = null;
        //cbCliente.setSelectedIndex(-1);
        cbMedico.setSelectedIndex(-1);
        txtData.setText("");
        txtHora.setText("");
        tblConsulta.clearSelection();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbMedico = new javax.swing.JComboBox<>();
        txtData = new javax.swing.JFormattedTextField();
        txtHora = new javax.swing.JFormattedTextField();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesquisaCliente = new javax.swing.JTable();
        txtNomeCliente = new javax.swing.JTextField();
        txtCodCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Consultas");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Agenda de Consultas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 33, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Cliente");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 430, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Médico");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 470, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Data");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 512, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Hora");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 512, -1, -1));

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 563, 99, -1));

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 563, 101, -1));

        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 563, 106, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 563, -1, -1));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cbMedico, org.jdesktop.beansbinding.ObjectProperty.create(), cbMedico, org.jdesktop.beansbinding.BeanProperty.create("elements"));
        bindingGroup.addBinding(binding);

        jPanel1.add(cbMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 472, 583, -1));

        txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jPanel1.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 514, 195, -1));

        txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 514, 188, -1));

        txtPesquisa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        jPanel1.add(txtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 162, 241, 46));

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Consulta", "Cliente", "Médico", "Data", "Hora"
            }
        ));
        tblConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblConsulta);
        if (tblConsulta.getColumnModel().getColumnCount() > 0) {
            tblConsulta.getColumnModel().getColumn(2).setHeaderValue("Médico");
            tblConsulta.getColumnModel().getColumn(3).setHeaderValue("Data");
            tblConsulta.getColumnModel().getColumn(4).setHeaderValue("Hora");
        }

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 260, 690, 142));

        tblPesquisaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ));
        tblPesquisaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesquisaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesquisaCliente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 132, 410, 101));
        jPanel1.add(txtNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 432, 510, -1));
        jPanel1.add(txtCodCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Agenda de Consulta");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * quando clica no cliente encontrado, seleciona e habilita os campos
     */

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Validação dos campos obrigatórios
        String data = txtData.getText();
        String hora = txtHora.getText();
        String clienteSelecionado = txtCodCliente.getText();
        Medico medicoSelecionado = (Medico) cbMedico.getSelectedItem();

        if (clienteSelecionado.equals("") || medicoSelecionado == null || data.isEmpty() || hora.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Senão salva
        salvarConsulta();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirConsulta();

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterarConsulta();

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased

        //dispara a cada tecla digitada no txtPesquisa
        String pesquisa = txtPesquisa.getText().trim();
        if (!pesquisa.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) tblPesquisaCliente.getModel();
            model.setRowCount(0); // limpa a tabela

            ClienteController controller = new ClienteController();

            List<Cliente> clientes = controller.buscarClientePorNome(pesquisa);
            for (Cliente cliente : clientes) {
                model.addRow(new Object[]{cliente.getId(), cliente.getNome()});
            }

            jScrollPane2.setVisible(true);
            tblPesquisaCliente.setVisible(true);
            jPanel1.revalidate();
            jPanel1.repaint();
        } else {
            jScrollPane2.setVisible(false); //esconde a tabela se não houver pesquisa
        }
        //consultar os clientes passando nome do que já esta digitado no filtro

        //fazer select no cliente controller com a clausula where nome like '%' + texto do filtro + '%'
        //com resultado consulta cliente, ira preencher a tabela de clientes
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // adicione esse scroll logo abaixo do txtPesquisa (ajuste conforme seu layout)
        //jPanel1.add(jScrollPane2);
        // === FIM: pesquisa de cliente ===
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void tblConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblConsultaMouseClicked

    private void tblPesquisaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesquisaClienteMouseClicked
        int linha = tblPesquisaCliente.getSelectedRow();
        if (linha == -1) {
            return;
        }

        int id = (int) tblPesquisaCliente.getValueAt(linha, 0);
        String nm = (String) tblPesquisaCliente.getValueAt(linha, 1);

        clienteSelecionado = new Cliente();
        clienteSelecionado.setId(id);
        clienteSelecionado.setNome(nm);

        // habilita os campos do agendamento
        cbMedico.setEnabled(true);
        txtData.setEnabled(true);
        txtHora.setEnabled(true);

        // limpa pesquisa
        txtPesquisa.setText("");
        jScrollPane2.setVisible(false);
    }//GEN-LAST:event_tblPesquisaClienteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrAgendaConsulta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrAgendaConsulta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrAgendaConsulta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrAgendaConsulta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrAgendaConsulta dialog = new FrAgendaConsulta(new JFrame(), true);
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
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Medico> cbMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JTable tblPesquisaCliente;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtPesquisa;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
