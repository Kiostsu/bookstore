/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ResultSetComboBoxAlunos;
import DAO.ResultSetComboBoxLivros;
import DAO.ResultSetLivro;
import DAO.LivroDAO;
import DAO.ResultSetComboBoxGenero;
import Entidades.Aluno;
import Entidades.Genero;
import Entidades.Livro;
import Entidades.Livro;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;


public class IfLivro extends javax.swing.JInternalFrame {

    boolean addRegistro = false;
    Livro livro = new Livro();
    LivroDAO dao = new LivroDAO();

    public IfLivro() {

        initComponents();

        try {
            loadRegistros();
           habilitarCampos(false);
            cmbGenero.setModel(new ResultSetComboBoxGenero());
          
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os registros. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setEntidade() {
        livro.setAutor(tfAutor.getText()); //inserir o que esta na combobox marca
        livro.setGenero(new Genero(cmbGenero.getSelectedItem().toString()));
        livro.setAno(Integer.valueOf(tfAno.getText()));
        livro.setTitulo(tfTitulo.getText());
        livro.setEditora(tfEditora.getText());
    }

    public void loadRegistros() throws Exception {
        ResultSetLivro tableModel = new ResultSetLivro();
        jtLivro.setModel(tableModel);

        jtLivro.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            try {
                if (jtLivro.getSelectedRow() >= 0) {
                    Object id = jtLivro.getValueAt(jtLivro.getSelectedRow(), 0); //pegar os objetos selecionados 
                    Object genero = jtLivro.getValueAt(jtLivro.getSelectedRow(), 1);
                    Object titulo = jtLivro.getValueAt(jtLivro.getSelectedRow(), 2);
                    Object editora = jtLivro.getValueAt(jtLivro.getSelectedRow(), 3);
                    Object autor = jtLivro.getValueAt(jtLivro.getSelectedRow(), 4);
                    Object ano = jtLivro.getValueAt(jtLivro.getSelectedRow(), 5);

                    //setar os campos de acordo com a linha selecionada
                    tfIdLivro.setText(id.toString());
                    cmbGenero.getModel().setSelectedItem(genero.toString());
                    tfTitulo.setText(titulo.toString());
                    tfEditora.setText(editora.toString());
                    tfAutor.setText(autor.toString());
                    tfAno.setText(ano.toString());
                    habilitarCampos(true);
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
        lblIdLivro = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        tfIdLivro = new javax.swing.JTextField();
        barraDeFerramentas1 = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btSalvar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btDelete = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btFechar = new javax.swing.JButton();
        cmbGenero = new javax.swing.JComboBox<>();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        tfTitulo = new javax.swing.JTextField();
        tfAutor = new javax.swing.JTextField();
        lblAno = new javax.swing.JLabel();
        tfAno = new javax.swing.JTextField();
        lblEditora = new javax.swing.JLabel();
        tfEditora = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLivro = new javax.swing.JTable();

        painel.setPreferredSize(new java.awt.Dimension(600, 600));

        Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Titulo.setText("Livro");

        lblIdLivro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIdLivro.setText("ID");

        lblGenero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblGenero.setText("Gênero");

        tfIdLivro.setEditable(false);
        tfIdLivro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfIdLivro.setEnabled(false);
        tfIdLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdLivroActionPerformed(evt);
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

        cmbGenero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo.setText("Titulo");

        lblAutor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAutor.setText("Autor");

        tfTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfTitulo.setEnabled(false);
        tfTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTituloActionPerformed(evt);
            }
        });

        tfAutor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfAutor.setEnabled(false);
        tfAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAutorActionPerformed(evt);
            }
        });

        lblAno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAno.setText("Ano");

        tfAno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfAno.setEnabled(false);
        tfAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAnoActionPerformed(evt);
            }
        });

        lblEditora.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEditora.setText("Editora");

        tfEditora.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfEditora.setEnabled(false);
        tfEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEditoraActionPerformed(evt);
            }
        });

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
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblIdLivro))
                            .addComponent(lblTitulo))
                        .addGap(31, 31, 31)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTitulo)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(tfIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblGenero)
                                .addGap(18, 18, 18)
                                .addComponent(cmbGenero, 0, 271, Short.MAX_VALUE))))
                    .addComponent(barraDeFerramentas1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout.createSequentialGroup()
                        .addComponent(lblAutor)
                        .addGap(33, 33, 33)
                        .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEditora)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblAno)))
                        .addGap(18, 18, 18)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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
                    .addComponent(tfIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdLivro)
                    .addComponent(lblGenero)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAutor))
                .addGap(21, 21, 21)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEditora))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtLivro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtLivro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtLivro.setFillsViewportHeight(true);
        jtLivro.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jtLivro.setRowHeight(30);
        jScrollPane1.setViewportView(jtLivro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdLivroActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        cmbGenero.grabFocus();
        limparCampos();
        habilitarCampos(true);
     
        btSalvar.setText("Salvar");
        addRegistro = true;
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja Salvar / Atualizar Cadastro?", "Confirmar Inserção / atualização?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                if (addRegistro == true) { //se for um novo registro gera um id novo e grava as demais informações
                    setEntidade();
                    dao.insert(livro);
                   limparCampos();
                   habilitarCampos(false);
                    
                } else { //se for atualização mantém o mesmo id e altera as demais
                    livro.setId(Integer.parseInt(tfIdLivro.getText()));
                    setEntidade();
                    dao.update(livro);
                   
                   limparCampos();
                   habilitarCampos(false);
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
                livro.setId(Integer.parseInt(tfIdLivro.getText()));  //a exclusão é feita pelo id
                setEntidade();
                dao.delete(livro);
                loadRegistros();
                limparCampos();
                habilitarCampos(false);
                btSalvar.setText("Salvar");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void tfTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTituloActionPerformed

    private void tfAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAutorActionPerformed

    private void tfAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAnoActionPerformed

    private void tfEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEditoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEditoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JToolBar barraDeFerramentas1;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JTable jtLivro;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblEditora;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIdLivro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField tfAno;
    private javax.swing.JTextField tfAutor;
    private javax.swing.JTextField tfEditora;
    private javax.swing.JTextField tfIdLivro;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
    private void limparCampos(){
        tfIdLivro.setText("");
                tfAutor.setText("");
                tfEditora.setText("");
                tfAno.setText("");
                tfTitulo.setText("");
                cmbGenero.setSelectedIndex(0);
    }
      private void habilitarCampos(boolean acao){
          
        tfIdLivro.setEnabled(acao);
                tfAutor.setEnabled(acao);
                tfEditora.setEnabled(acao);
                tfAno.setEnabled(acao);
                tfTitulo.setEnabled(acao);
                cmbGenero.setEnabled(acao);
    }
}
