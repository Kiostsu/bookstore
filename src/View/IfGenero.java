package View;

import DAO.GeneroDAO;
import DAO.ResultSetGenero;
import Entidades.Genero;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author MatheusEduardo
 */
public class IfGenero extends javax.swing.JInternalFrame {

    /**
     * Creates new form IfGenero
     */
    boolean addRegistro = false;
    Genero genero = new Genero();
    GeneroDAO dao = new GeneroDAO();

    public IfGenero() {
        initComponents();
        tfDescricaoGenero.setEnabled(false); //desabilitar tf do nome
        try {
            loadRegistros(); // carregar table
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os registros. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setEntidade() {
        genero.setDescricao(tfDescricaoGenero.getText());
    }

    public void loadRegistros() throws Exception {
        ResultSetGenero tableModel = new ResultSetGenero();
        jtGenero.setModel(tableModel);

        jtGenero.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                try {
                    if (jtGenero.getSelectedRow() >= 0) {

                        Object id = jtGenero.getValueAt(jtGenero.getSelectedRow(), 0); //pegar os objetos selecionados
                        Object genero = jtGenero.getValueAt(jtGenero.getSelectedRow(), 1);

                        //setar os campos de acordo com a linha selecionada
                        tfId.setText(id.toString());
                        tfDescricaoGenero.setText(genero.toString());
                        tfDescricaoGenero.setEnabled(true);
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
        lblCodigo1 = new javax.swing.JLabel();
        lblDescricao1 = new javax.swing.JLabel();
        tfDescricaoGenero = new javax.swing.JTextField();
        tfId = new javax.swing.JTextField();
        barraDeFerramentas1 = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btSalvar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btDelete = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtGenero = new javax.swing.JTable();

        painel.setPreferredSize(new java.awt.Dimension(600, 600));

        Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Titulo.setText("Gênero");

        lblCodigo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCodigo1.setText("ID");

        lblDescricao1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDescricao1.setText("Nome");

        tfDescricaoGenero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfDescricaoGenero.setText("Clique em Novo Para Inserir");
        tfDescricaoGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescricaoGeneroActionPerformed(evt);
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

        jtGenero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtGenero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtGenero.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtGenero.setFillsViewportHeight(true);
        jtGenero.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jtGenero.setRowHeight(30);
        jScrollPane1.setViewportView(jtGenero);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barraDeFerramentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescricao1)
                                    .addGroup(painelLayout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(lblCodigo1)))
                                .addGap(51, 51, 51)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDescricaoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(Titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(lblCodigo1)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao1)
                    .addComponent(tfDescricaoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja Salvar / Atualizar Cadastro?", "Confirmar Inserção / atualização?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                if (addRegistro == true) { //se for um novo registro irá criar um id novo e inserir o que foi digitado na tf
                    setEntidade(); //
                    dao.insert(genero);

                    tfId.setText("");
                    tfDescricaoGenero.setText("Clique em novo para inserir");
                    tfDescricaoGenero.setEnabled(false);
                } else {
                    genero.setId(Integer.parseInt(tfId.getText())); // se for uma atualização mantém o mesmo id e altera o nome
                    setEntidade();
                    dao.update(genero);
                    tfId.setText("");
                    tfDescricaoGenero.setText("Clique em novo para inserir");
                    tfDescricaoGenero.setEnabled(false);
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
        tfDescricaoGenero.grabFocus();
        tfDescricaoGenero.setText("");
        tfId.setText("");
        tfDescricaoGenero.setEnabled(true);
        btSalvar.setText("Salvar");
        addRegistro = true;
    }//GEN-LAST:event_btNovoActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja Excluir esse registro?", "Confirma Exclusão?", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                genero.setId(Integer.parseInt(tfId.getText())); //A exclusão é feita através do id
                setEntidade();
                dao.delete(genero);
                loadRegistros();
                tfDescricaoGenero.setText("Clique em Novo para Inserir");
                tfDescricaoGenero.setEnabled(false);
                tfId.setText("");
                btSalvar.setText("Salvar");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível deletar. Erro: " + ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void tfDescricaoGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescricaoGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescricaoGeneroActionPerformed


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
    private javax.swing.JTable jtGenero;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField tfDescricaoGenero;
    private javax.swing.JTextField tfId;
    // End of variables declaration//GEN-END:variables

}
