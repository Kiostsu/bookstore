package View;

import DAO.LocacaoDAO;
import DAO.ResultSetLocacao;
import Entidades.Locacao;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class IfLocacao extends javax.swing.JInternalFrame {

    /**
     * Creates new form IfLocacao
     */
    boolean addRegistro = false;
    Locacao locacao = new Locacao();
    LocacaoDAO dao = new LocacaoDAO();

    public IfLocacao() {
        initComponents();       
        //desabilitar os campos antes de clicar em novo para não dar erro de query ao salvar
        desabilitaCampos();
        
        try {
            loadRegistros(); // carregar table
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os registros. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setEntidade() {  //Pega as informações da tela e prepara o objeto locacao para inserir no banco
        locacao.setAluno(tfAluno.getText());
        locacao.setCurso(tfCurso.getText());
        locacao.setTurma(tfTurma.getText());
        locacao.setLivro(tfLivro.getText());
        locacao.setData(tfData.getText());
        locacao.setEntrega(tfEntrega.getText());
    }
    

    public void loadRegistros() throws Exception {
        ResultSetLocacao tableModel = new ResultSetLocacao();
        jtLocacao.setModel(tableModel);

        jtLocacao.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                try {
                    if (jtLocacao.getSelectedRow() >= 0) {

                        Object id = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 0); //pegar os objetos selecionados
                        Object aluno = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 1);
                        Object curso = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 2);
                        Object turma = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 3);
                        Object livro = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 4);
                        Object data = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 5);
                        Object entrega = jtLocacao.getValueAt(jtLocacao.getSelectedRow(), 6);

                        //setar os campos de acordo com a linha selecionada
                        tfId.setText(id.toString());
                        tfAluno.setText(aluno.toString());
                        tfAluno.setEnabled(true);
                        
                        tfCurso.setText(curso.toString());
                        tfCurso.setEnabled(true);
                        
                        tfTurma.setText(turma.toString());
                        tfTurma.setEnabled(true);
                        
                        tfLivro.setText(livro.toString());
                        tfLivro.setEnabled(true);
                        
                        tfData.setText(data.toString());
                        tfData.setEnabled(true);
                        
                        tfEntrega.setText(entrega.toString());
                        tfEntrega.setEnabled(true);
                        
                        btSalvar.setText("Atualizar");
                        btSalvar.setEnabled(true);
                        btDelete.setEnabled(true);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível setar os campos. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        lblCodigo1 = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        tfCurso = new javax.swing.JTextField();
        barraDeFerramentas1 = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btSalvar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btDelete = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btFechar = new javax.swing.JButton();
        tfId = new javax.swing.JTextField();
        tfAluno = new javax.swing.JTextField();
        lblAluno = new javax.swing.JLabel();
        tfTurma = new javax.swing.JTextField();
        lblTurma = new javax.swing.JLabel();
        tfLivro = new javax.swing.JTextField();
        lblLivro = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblEntrega = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLocacao = new javax.swing.JTable();
        lblDados = new javax.swing.JLabel();
        tfEntrega = new javax.swing.JFormattedTextField();
        tfData = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("BookStore - Locações");

        painel.setPreferredSize(new java.awt.Dimension(600, 600));

        Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Titulo.setText("BookStore");

        lblCodigo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCodigo1.setText("Código Locação");

        lblCurso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCurso.setText("Curso");

        tfCurso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCursoActionPerformed(evt);
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
        btSalvar.setEnabled(false);
        btSalvar.setFocusable(false);
        btSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalvar.setMaximumSize(new java.awt.Dimension(90, 65));
        btSalvar.setMinimumSize(new java.awt.Dimension(70, 65));
        btSalvar.setPreferredSize(new java.awt.Dimension(90, 65));
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
        btDelete.setEnabled(false);
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
        btFechar.setToolTipText("Fechar");
        btFechar.setFocusable(false);
        btFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        barraDeFerramentas1.add(btFechar);

        tfId.setEditable(false);
        tfId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfId.setEnabled(false);
        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });
        barraDeFerramentas1.add(tfId);

        tfAluno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfAluno.setNextFocusableComponent(tfCurso);
        tfAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAlunoActionPerformed(evt);
            }
        });

        lblAluno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAluno.setText("Aluno");

        tfTurma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTurmaActionPerformed(evt);
            }
        });

        lblTurma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTurma.setText("Turma");

        tfLivro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLivroActionPerformed(evt);
            }
        });

        lblLivro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLivro.setText("Livro");

        lblData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblData.setText("Data");

        lblEntrega.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEntrega.setText("Entrega");

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
        jtLocacao.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jtLocacao);

        lblDados.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDados.setText("Dados");

        try {
            tfEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfEntrega.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        try {
            tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfData.setToolTipText("  /  /");
        tfData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(lblCurso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(barraDeFerramentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCodigo1)
                                .addGroup(painelLayout.createSequentialGroup()
                                    .addComponent(lblAluno)
                                    .addGap(96, 96, 96)
                                    .addComponent(tfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(lblTurma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(lblLivro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout.createSequentialGroup()
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEntrega)
                                    .addComponent(lblData))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(251, 251, 251)))
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDados)
                                .addGap(376, 376, 376))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                        .addComponent(Titulo)
                        .addGap(619, 619, 619))))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addComponent(Titulo)
                .addGap(29, 29, 29)
                .addComponent(barraDeFerramentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo1)
                    .addComponent(lblDados))
                .addGap(39, 39, 39)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAluno))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurso))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTurma))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLivro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblData))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEntrega)
                            .addComponent(tfEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 1356, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 167, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja Excluir esse registro?", "Confirma Exclusão?", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                locacao.setId(Integer.parseInt(tfId.getText())); //A exclusão é feita através do id
                setEntidade();
                dao.delete(locacao);
                loadRegistros();
                tfAluno.setText("Clique em Novo para Inserir");
                desabilitaCampos();
                tfId.setText("");
                btSalvar.setText("Salvar");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível deletar. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        btDelete.setEnabled(false);
        btSalvar.setEnabled(false);
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja Salvar / Atualizar Cadastro?", "Confirmar Inserção / atualização?", JOptionPane.YES_NO_OPTION);
        if(!camposLimpos()){
            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    if (addRegistro == true) { //se for um novo registro irá criar um id novo e inserir o que foi digitado na tf
                        setEntidade(); //
                        dao.insert(locacao);
                        tfId.setText("");
                        tfAluno.setText("Clique em novo para inserir");
                        desabilitaCampos();

                    } else {
                        locacao.setId(Integer.parseInt(tfId.getText())); // se for uma atualização mantém o mesmo id e altera o nome
                        setEntidade();
                        dao.update(locacao);
                        tfId.setText("");
                        tfAluno.setText("Clique em novo para inserir");
                        desabilitaCampos();
                    }
                    addRegistro = false;
                    loadRegistros();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível salvar. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
            }else{
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }  
        btSalvar.setEnabled(false);
        btDelete.setEnabled(false);
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        tfAluno.grabFocus();
        tfAluno.setText("");
        tfId.setText("");
        habilitarCampos();
        limparCampos();
        btSalvar.setEnabled(true);
        btSalvar.setText("Salvar");
        btDelete.setEnabled(false);
        addRegistro = true;
    }//GEN-LAST:event_btNovoActionPerformed

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void tfCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCursoActionPerformed

    private void tfAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAlunoActionPerformed

    private void tfTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTurmaActionPerformed

    private void tfLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLivroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JToolBar barraDeFerramentas1;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JTable jtLocacao;
    private javax.swing.JLabel lblAluno;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDados;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEntrega;
    private javax.swing.JLabel lblLivro;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField tfAluno;
    private javax.swing.JTextField tfCurso;
    private javax.swing.JFormattedTextField tfData;
    private javax.swing.JFormattedTextField tfEntrega;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfLivro;
    private javax.swing.JTextField tfTurma;
    // End of variables declaration//GEN-END:variables

    public void desabilitaCampos(){
        tfAluno.setEnabled(false);
        tfCurso.setEnabled(false); 
        tfTurma.setEnabled(false); 
        tfLivro.setEnabled(false); 
        tfData.setEnabled(false); 
        tfEntrega.setEnabled(false);
        limparCampos();
    }
    
    public void habilitarCampos(){
        
        tfAluno.setEnabled(true);
        tfCurso.setEnabled(true); 
        tfTurma.setEnabled(true); 
        tfLivro.setEnabled(true); 
        tfData.setEnabled(true); 
        tfEntrega.setEnabled(true);
    }
    
    public void limparCampos(){
        
      tfAluno.setText("");  
      tfCurso.setText("");  
      tfTurma.setText("");  
      tfLivro.setText("");  
      tfData.setText("");  
      tfEntrega.setText("");  
    }
    
    public boolean camposLimpos(){
        return !(tfAluno.getText().length() > 0 &&
                tfCurso.getText().length() > 0 &&
                tfTurma.getText().length() > 0 &&
                tfLivro.getText().length() > 0 &&
                tfData.getText().length() > 0 &&
                tfEntrega.getText().length() > 0);
    }
}
