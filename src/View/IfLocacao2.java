/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ResultSetComboBoxAlunos;
import DAO.ResultSetComboBoxLivros;
import DAO.ResultSetLocacao;
import DAO.LocacaoDAO;
import Entidades.Aluno;
import Entidades.Livro;
import Entidades.Locacao;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;


public class IfLocacao2 extends javax.swing.JInternalFrame {

    boolean addRegistro = false;
    Locacao locacao = new Locacao();
    LocacaoDAO dao = new LocacaoDAO();

    public IfLocacao2() {

        initComponents();

        try {
            loadRegistros();
            tfData.setEnabled(false);
            tfEntrega.setEnabled(false);
            cmbLivro.setEnabled(false);
            cmbLivro.setModel(new ResultSetComboBoxLivros());
            cmbAluno.setEnabled(false);
            cmbAluno.setModel(new ResultSetComboBoxAlunos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os registros. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setEntidade() {
        locacao.setLivro(new Livro(cmbLivro.getSelectedItem().toString())); //inserir o que esta na combobox marca
        locacao.setAluno(new Aluno(cmbAluno.getSelectedItem().toString()));
        locacao.setData(tfData.getText());
        locacao.setEntrega(tfEntrega.getText());
    }

    public void loadRegistros() throws Exception {
        ResultSetLocacao tableModel = new ResultSetLocacao();
        jtLocacao.setModel(tableModel);

        jtLocacao.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            try {
                if (jtLocacao.getSelectedRow() >= 0) {
                    Object id = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 0); //pegar os objetos selecionados 
                    Object livro = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 1);
                    Object aluno = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 2);
                    
                    Object data = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 4);
                    Object entrega = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 5);

                    //setar os campos de acordo com a linha selecionada
                    tfIdLocacao.setText(id.toString());
                    cmbLivro.getModel().setSelectedItem(livro.toString());
                    cmbAluno.getModel().setSelectedItem(aluno.toString());
                    tfData.setText(data.toString());
                    tfEntrega.setText(entrega.toString());
                    tfData.setEnabled(true);
                    tfEntrega.setEnabled(true);
                    cmbLivro.setEnabled(true);
                    cmbAluno.setEnabled(true);
                    btSalvar.setText("Atualizar");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível setar os campos. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        lblIdLocacao = new javax.swing.JLabel();
        lblLivro = new javax.swing.JLabel();
        tfIdLocacao = new javax.swing.JTextField();
        barraDeFerramentas1 = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btSalvar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btDelete = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLocacao = new javax.swing.JTable();
        cmbLivro = new javax.swing.JComboBox<>();
        lblAluno = new javax.swing.JLabel();
        lblEntrega = new javax.swing.JLabel();
        tfData = new javax.swing.JFormattedTextField();
        tfEntrega = new javax.swing.JFormattedTextField();
        lblData = new javax.swing.JLabel();
        cmbAluno = new javax.swing.JComboBox<>();

        painel.setPreferredSize(new java.awt.Dimension(600, 600));

        Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Titulo.setText("Locação");

        lblIdLocacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIdLocacao.setText("ID");

        lblLivro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLivro.setText("Livro");

        tfIdLocacao.setEditable(false);
        tfIdLocacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfIdLocacao.setEnabled(false);
        tfIdLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdLocacaoActionPerformed(evt);
            }
        });

        barraDeFerramentas1.setFloatable(false);
        barraDeFerramentas1.setBorderPainted(false);

        btNovo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/icones/32x32/1297713678_document-new (Custom).png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.setFocusable(false);
        btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        barraDeFerramentas1.add(btNovo);

        jSeparator2.setMaximumSize(new java.awt.Dimension(32, 32767));
        barraDeFerramentas1.add(jSeparator2);

        btSalvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/icones/32x32/1297713679_list-add-user (Custom).png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setFocusable(false);
        btSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalvar.setMaximumSize(new java.awt.Dimension(80, 65));
        btSalvar.setMinimumSize(new java.awt.Dimension(70, 65));
        btSalvar.setPreferredSize(new java.awt.Dimension(80, 65));
        btSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        barraDeFerramentas1.add(btSalvar);

        jSeparator4.setMaximumSize(new java.awt.Dimension(32, 32767));
        barraDeFerramentas1.add(jSeparator4);

        btDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/icones/32x32/Trash-Empty-icon (Custom).png"))); // NOI18N
        btDelete.setText("Excluir");
        btDelete.setFocusable(false);
        btDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDelete.setMaximumSize(new java.awt.Dimension(70, 65));
        btDelete.setMinimumSize(new java.awt.Dimension(70, 65));
        btDelete.setPreferredSize(new java.awt.Dimension(70, 65));
        btDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        barraDeFerramentas1.add(btDelete);

        jSeparator5.setMaximumSize(new java.awt.Dimension(32, 32767));
        barraDeFerramentas1.add(jSeparator5);

        btFechar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/icones/32x32/Log-Out-icon (Custom).png"))); // NOI18N
        btFechar.setText("Fechar");
        btFechar.setToolTipText("");
        btFechar.setFocusable(false);
        btFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        barraDeFerramentas1.add(btFechar);

        jtLocacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtLocacao.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtLocacao.setFillsViewportHeight(true);
        jtLocacao.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jtLocacao.setRowHeight(30);
        jScrollPane1.setViewportView(jtLocacao);

        cmbLivro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblAluno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAluno.setText("Aluno");

        lblEntrega.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEntrega.setText("Data Entrega");

        try {
            tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfData.setToolTipText("  /  /");
        tfData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        try {
            tfEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfEntrega.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblData.setText("Data Locação");

        cmbAluno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addGap(223, 223, 223))
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraDeFerramentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAluno)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblIdLocacao)))
                        .addGap(31, 31, 31)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(tfIdLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblLivro)
                                .addGap(18, 18, 18)
                                .addComponent(cmbLivro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cmbAluno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(lblData)
                        .addGap(10, 10, 10)
                        .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEntrega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addGap(18, 18, 18)
                .addComponent(barraDeFerramentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdLocacao)
                    .addComponent(lblLivro)
                    .addComponent(cmbLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAluno)
                    .addComponent(cmbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEntrega)
                    .addComponent(tfEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdLocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdLocacaoActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        cmbLivro.grabFocus();
        cmbAluno.setSelectedIndex(0);
        tfIdLocacao.setText("");
        tfData.setText("");
        tfEntrega.setText("");
        cmbLivro.setSelectedIndex(0);
        tfData.setEnabled(true);
        tfEntrega.setEnabled(true);
        cmbLivro.setEnabled(true);
        cmbAluno.setEnabled(true);
        btSalvar.setText("Salvar");
        addRegistro = true;
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja Salvar / Atualizar Cadastro?", "Confirmar Inserção / atualização?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                if (addRegistro == true) { //se for um novo registro gera um id novo e grava as demais informações
                    setEntidade();
                    dao.insert(locacao);
                    tfIdLocacao.setText("");
                    tfData.setText("");
                    tfEntrega.setText("");
                    cmbLivro.setSelectedIndex(0);
                    cmbAluno.setSelectedIndex(0);
                    tfData.setEnabled(false);
                    tfEntrega.setEnabled(false);
                    cmbLivro.setEnabled(false);
                    cmbAluno.setEnabled(false);
                    
                } else { //se for atualização mantém o mesmo id e altera as demais
                    locacao.setId(Integer.parseInt(tfIdLocacao.getText()));
                    setEntidade();
                    dao.update(locacao);
                    tfIdLocacao.setText("");
                    tfData.setText("");
                    tfEntrega.setText("");
                    cmbLivro.setSelectedIndex(0);
                    cmbAluno.setSelectedIndex(0);
                    tfData.setEnabled(false);
                    tfEntrega.setEnabled(false);
                    cmbLivro.setEnabled(false);
                    cmbAluno.setEnabled(false);
                }
                addRegistro = false;
                loadRegistros();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja Excluir esse registro?", "Confirma Exclusão?", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                locacao.setId(Integer.parseInt(tfIdLocacao.getText()));  //a exclusão é feita pelo id
                setEntidade();
                dao.delete(locacao);
                loadRegistros();
  
                tfIdLocacao.setText("");
                cmbLivro.setSelectedIndex(0);
                cmbAluno.setSelectedIndex(0);
                tfData.setEnabled(false);
                tfEntrega.setEnabled(false);
                cmbAluno.setEnabled(false);
                cmbLivro.setEnabled(false);
                btSalvar.setText("Salvar");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JToolBar barraDeFerramentas1;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cmbAluno;
    private javax.swing.JComboBox<String> cmbLivro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JTable jtLocacao;
    private javax.swing.JLabel lblAluno;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEntrega;
    private javax.swing.JLabel lblIdLocacao;
    private javax.swing.JLabel lblLivro;
    private javax.swing.JPanel painel;
    private javax.swing.JFormattedTextField tfData;
    private javax.swing.JFormattedTextField tfEntrega;
    private javax.swing.JTextField tfIdLocacao;
    // End of variables declaration//GEN-END:variables
}
