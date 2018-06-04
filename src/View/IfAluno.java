package View;

import DAO.AlunoDAO;
import DAO.ResultSetAluno;
import Entidades.Aluno;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class IfAluno extends javax.swing.JInternalFrame {

    /**
     * Creates new form IfAluno
     */
    boolean addRegistro = false;
    Aluno aluno = new Aluno();
    AlunoDAO dao = new AlunoDAO();

    public IfAluno() {
        initComponents();
        habilitarCampos(false);
        try {
            loadRegistros(); // carregar table
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os registros. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setEntidade() {
        aluno.setNome(tfNome.getText());
        aluno.setCurso(tfCurso.getText());
        aluno.setNumeroMatricula(Integer.valueOf(tfNroMatricula.getText()));
        aluno.setTurma(tfTurma.getText());
    }

    public void loadRegistros() throws Exception {
        ResultSetAluno tableModel = new ResultSetAluno();
        jtAluno.setModel(tableModel);

        jtAluno.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                try {
                    if (jtAluno.getSelectedRow() >= 0) {

                        Object id = jtAluno.getValueAt(jtAluno.getSelectedRow(), 0); //pegar os objetos selecionados
                        Object curso = jtAluno.getValueAt(jtAluno.getSelectedRow(), 1);
                        Object turma = jtAluno.getValueAt(jtAluno.getSelectedRow(), 2);
                        Object nome = jtAluno.getValueAt(jtAluno.getSelectedRow(), 3);
                        Object numeroMatricula = jtAluno.getValueAt(jtAluno.getSelectedRow(), 4);

                        //setar os campos de acordo com a linha selecionada
                        tfId.setText(id.toString());
                        tfNome.setText(nome.toString());
                        tfTurma.setText(turma.toString());
                        tfNroMatricula.setText(numeroMatricula.toString());
                        tfCurso.setText(curso.toString());
                        habilitarCampos(true);
                        btSalvar.setText("Atualizar");
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
        lblCodigo = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        tfCurso = new javax.swing.JTextField();
        tfId = new javax.swing.JTextField();
        barraDeFerramentas1 = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btSalvar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btDelete = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btFechar = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        tfTurma = new javax.swing.JTextField();
        lblTurma = new javax.swing.JLabel();
        tfNroMatricula = new javax.swing.JTextField();
        lblNroMatricula = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAluno = new javax.swing.JTable();

        painel.setPreferredSize(new java.awt.Dimension(600, 600));

        Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Titulo.setText("Aluno");

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCodigo.setText("ID");

        lblCurso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCurso.setText("Curso");

        tfCurso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfCurso.setText("Clique em Novo Para Inserir");
        tfCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCursoActionPerformed(evt);
            }
        });

        tfId.setEditable(false);
        tfId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfId.setEnabled(false);
        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
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

        tfNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfNome.setText("Clique em Novo Para Inserir");
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNome.setText("Nome");

        tfTurma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfTurma.setText("Clique em Novo Para Inserir");
        tfTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTurmaActionPerformed(evt);
            }
        });

        lblTurma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTurma.setText("Turma");

        tfNroMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfNroMatricula.setText("Clique em Novo Para Inserir");
        tfNroMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNroMatriculaActionPerformed(evt);
            }
        });

        lblNroMatricula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNroMatricula.setText("Nro. Matricula");

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barraDeFerramentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(painelLayout.createSequentialGroup()
                                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCodigo)
                                            .addComponent(lblNome))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                                        .addComponent(lblCurso)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelLayout.createSequentialGroup()
                                        .addComponent(lblTurma)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                                        .addComponent(lblNroMatricula)
                                        .addGap(51, 51, 51)
                                        .addComponent(tfNroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(Titulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addGap(18, 18, 18)
                .addComponent(barraDeFerramentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo))
                .addGap(16, 16, 16)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurso)))
                    .addComponent(lblNome))
                .addGap(20, 20, 20)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(tfTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNroMatricula)))
                    .addComponent(lblTurma))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtAluno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtAluno.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtAluno.setFillsViewportHeight(true);
        jtAluno.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jtAluno.setRowHeight(30);
        jScrollPane1.setViewportView(jtAluno);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja Salvar / Atualizar Cadastro?", "Confirmar Inserção / atualização?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                if (addRegistro == true) { //se for um novo registro irá criar um id novo e inserir o que foi digitado na tf
                    setEntidade(); //
                    dao.insert(aluno);

                    tfId.setText("");
                    habilitarCampos(false);
                } else {
                    aluno.setId(Integer.parseInt(tfId.getText())); // se for uma atualização mantém o mesmo id e altera o nome
                    setEntidade();
                    dao.update(aluno);
                    tfId.setText("");
                    tfCurso.setText("Clique em novo para inserir");
                    habilitarCampos(false);
                }
                addRegistro = false;
                loadRegistros();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        tfNome.grabFocus();        
        limparCampos();
        habilitarCampos(true);        
        btSalvar.setText("Salvar");
        addRegistro = true;
    }//GEN-LAST:event_btNovoActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja Excluir esse registro?", "Confirma Exclusão?", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                aluno.setId(Integer.parseInt(tfId.getText())); //A exclusão é feita através do id
                setEntidade();
                dao.delete(aluno);
                loadRegistros();                
                habilitarCampos(false);
                tfId.setText("");
                btSalvar.setText("Salvar");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível deletar. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void tfCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCursoActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void tfTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTurmaActionPerformed

    private void tfNroMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNroMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNroMatriculaActionPerformed


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
    private javax.swing.JTable jtAluno;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNroMatricula;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField tfCurso;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNroMatricula;
    private javax.swing.JTextField tfTurma;
    // End of variables declaration//GEN-END:variables
    private void limparCampos(){
        tfNome.setText("");
        tfCurso.setText("");
        tfTurma.setText("");
        tfNroMatricula.setText("");
        tfId.setText("");
    }

    private void habilitarCampos(boolean action) {
        tfNome.setEnabled(action);
        tfCurso.setEnabled(action);
        tfTurma.setEnabled(action);
        tfNroMatricula.setEnabled(action);
    }
}
