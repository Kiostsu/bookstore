/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        barraDeMenu = new javax.swing.JMenuBar();
        mnCadastros = new javax.swing.JMenu();
        miAluno = new javax.swing.JMenuItem();
        miGenero = new javax.swing.JMenuItem();
        miLivros = new javax.swing.JMenuItem();
        miLocacao = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();
        miInfo = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        miSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bookstore ");
        setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/icones/ground.jpg"))); // NOI18N

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 83, Short.MAX_VALUE))
        );

        barraDeMenu.setBackground(new java.awt.Color(0, 0, 0));
        barraDeMenu.setBorder(null);

        mnCadastros.setText("Cadastros");
        mnCadastros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        miAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        miAluno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        miAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/icones/menores/user_add.png"))); // NOI18N
        miAluno.setText("Alunos");
        miAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAlunoActionPerformed(evt);
            }
        });
        mnCadastros.add(miAluno);

        miGenero.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        miGenero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        miGenero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/icones/menores/add.png"))); // NOI18N
        miGenero.setText("Generos");
        miGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGeneroActionPerformed(evt);
            }
        });
        mnCadastros.add(miGenero);

        miLivros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        miLivros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        miLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/icones/menores/book_addresses_add.png"))); // NOI18N
        miLivros.setText("Livros");
        miLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLivrosActionPerformed(evt);
            }
        });
        mnCadastros.add(miLivros);

        miLocacao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        miLocacao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        miLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/icones/menores/vcard.png"))); // NOI18N
        miLocacao.setText("Locações");
        miLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLocacaoActionPerformed(evt);
            }
        });
        mnCadastros.add(miLocacao);

        barraDeMenu.add(mnCadastros);

        menuSobre.setText("Sobre  ");
        menuSobre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        miInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        miInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/icones/menores/information.png"))); // NOI18N
        miInfo.setText("Informações");
        miInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInfoActionPerformed(evt);
            }
        });
        menuSobre.add(miInfo);

        barraDeMenu.add(menuSobre);

        menuSair.setText("Sair");
        menuSair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        miSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        miSair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        miSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/icones/menores/door_out.png"))); // NOI18N
        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        menuSair.add(miSair);

        barraDeMenu.add(menuSair);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jDesktopPane1.getAccessibleContext().setAccessibleParent(jDesktopPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void miInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInfoActionPerformed
        new Sobre(this, true).setVisible(true); //chamar a janela das informações do programa
    }//GEN-LAST:event_miInfoActionPerformed

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSairActionPerformed

    private void miAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAlunoActionPerformed
        IfAluno frm = new IfAluno(); //instancio a classe FrmLocacao para poder adicionar ao JDesktopPane
        jDesktopPane1.add(frm);
        //centralizar(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_miAlunoActionPerformed

    private void miGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGeneroActionPerformed
        IfGenero frm = new IfGenero(); //instancio a classe FrmLocacao para poder adicionar ao JDesktopPane
        jDesktopPane1.add(frm);
        //centralizar(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_miGeneroActionPerformed

    private void miLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLivrosActionPerformed
        IfLivro frm = new IfLivro(); //instancio a classe FrmLocacao para poder adicionar ao JDesktopPane
        jDesktopPane1.add(frm);
        //centralizar(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_miLivrosActionPerformed

    private void miLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLocacaoActionPerformed
        IfLocacao2 frm = new IfLocacao2(); //instancio a classe FrmLocacao para poder adicionar ao JDesktopPane
        jDesktopPane1.add(frm);
        //centralizar(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_miLocacaoActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JMenuItem miAluno;
    private javax.swing.JMenuItem miGenero;
    private javax.swing.JMenuItem miInfo;
    private javax.swing.JMenuItem miLivros;
    private javax.swing.JMenuItem miLocacao;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenu mnCadastros;
    // End of variables declaration//GEN-END:variables
    public void centralizar(JInternalFrame fr) {
        Dimension d = fr.getDesktopPane().getSize();
        fr.setLocation((d.width - fr.getSize().width) / 2, (d.height - fr.getSize().height) / 2);
    }
}
