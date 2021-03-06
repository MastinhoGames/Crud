/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import modelo.Jogos;
import DAOs.*;
import gerarrelatorio.Relatorio;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author bruno
 */
public class ListaTudo extends javax.swing.JDialog {

    /**
     * Creates new form ListaTudo
     */
    private List<Jogos> jgo = new ArrayList<Jogos>();
    private JogoDAO jg;
    public ListaTudo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jg= new JogoDAO();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnListaTudo = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPanel = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnListaTudo.setText("Listar Tudo");
        btnListaTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaTudoActionPerformed(evt);
            }
        });

        btnRelatorio.setText("Relatório");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        txtPanel.setColumns(20);
        txtPanel.setRows(5);
        jScrollPane1.setViewportView(txtPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnListaTudo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(btnRelatorio)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListaTudo)
                    .addComponent(btnRelatorio))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaTudoActionPerformed
        // TODO add your handling code here:
        try {
            jgo = jg.Listar();
        } catch (SQLException ex) {
            Logger.getLogger(ListaTudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i < jgo.size(); i++)
        {
            txtPanel.append(" Id do jogo: "+jgo.get(i).getId()+
                    "\n Nome do Jogo: "+jgo.get(i).getNome()+
                    "\n Classificação Indicativa: "+jgo.get(i).getIndicacao()+
                    "\n Preço do jogo é: "+jgo.get(i).getPreco()+
                    "\n Quantidade em estoque: "+jgo.get(i).getQuantidade()+ "\n\n");
            
        }
    }//GEN-LAST:event_btnListaTudoActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        // TODO add your handling code here:
        
        Relatorio rel= new Relatorio();
        try {
            rel.GerarRelatorio(jgo);
        } catch (JRException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ListaTudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(ListaTudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaTudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaTudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaTudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListaTudo dialog = new ListaTudo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnListaTudo;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtPanel;
    // End of variables declaration//GEN-END:variables
}
