/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio Cruz
 */
public class ProdSolicita extends javax.swing.JFrame {

    /**
     * Creates new form ProdSolicita
     */
    
    Funciones.Tablas tablas = new Funciones.Tablas();
    Funciones.Productos aProd = new Funciones.Productos();
    DefaultTableModel model;
    int fila;
    
    
    public ProdSolicita() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconos/logo.png")).getImage());
        model = (DefaultTableModel) tablaProdSolicita.getModel();
        tablas.tablaProdSolicita(model);
        tablaProdSolicita.getColumnModel().getColumn(0).setMaxWidth(50);
        tablaProdSolicita.getColumnModel().getColumn(7).setMaxWidth(90); tablaProdSolicita.getColumnModel().getColumn(7).setMinWidth(60);
        tablaProdSolicita.getColumnModel().getColumn(6).setMaxWidth(100);
        tablaProdSolicita.getColumnModel().getColumn(5).setMaxWidth(70);
        tablaProdSolicita.getColumnModel().getColumn(4).setMaxWidth(80);
        tablaProdSolicita.getColumnModel().getColumn(2).setMaxWidth(100);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        btnProdRecibido = new javax.swing.JButton();
        btnCancelSoli = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaProdSolicita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Marca", "Proveedor", "Origen", "Destino", "Precio (U)", "Cantidad", "Total $"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProdSolicita);

        btnProdRecibido.setText("Marcar Recibido");
        btnProdRecibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdRecibidoActionPerformed(evt);
            }
        });

        btnCancelSoli.setText("Cancelar Solicitud");
        btnCancelSoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelSoliActionPerformed(evt);
            }
        });

        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelSoli))
                            .addComponent(btnProdRecibido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProdRecibido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelSoli)
                    .addComponent(jButton3))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelSoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelSoliActionPerformed
         fila = tablaProdSolicita.getSelectedRow();
        if(fila>=0){
            int conf = JOptionPane.showConfirmDialog(this, "¿Esta Seguro de Cancelar esta Solicitud?");
            if (conf == 0){
                DefaultTableModel model = (DefaultTableModel) tablaProdSolicita.getModel();
                int idReg = Integer.parseInt(model.getValueAt(fila, 0).toString());
                aProd.setCodigo(idReg);
                String destino = model.getValueAt(tablaProdSolicita.getSelectedRow(), 5).toString();
               try {
                    aProd.rmovSoliProc(destino, model.getValueAt(fila, 3).toString());
                    model = (DefaultTableModel) tablaProdSolicita.getModel();
                    tablas.tablaProdSolicita(model);
                } catch (SQLException ex) {
                    Logger.getLogger(ProdSolicita.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }else{
            JOptionPane.showConfirmDialog(this, "¡No ha seleccionado Ningun Elemento!");
        }
        
        
    }//GEN-LAST:event_btnCancelSoliActionPerformed
    public static  String mensaje="";
    private void btnProdRecibidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdRecibidoActionPerformed
        fila = tablaProdSolicita.getSelectedRow();
        if(fila>=0){
            int conf = JOptionPane.showConfirmDialog(this, "Al Confirmar esta Acción, \nse sumará la solicitud a las existencias del producto.\n¿Confirmar?");
            mensaje="";
            if (conf == 0){
                
                int idReg = Integer.parseInt(model.getValueAt(fila, 0).toString());
                aProd.setCodigo(idReg);
                
                String destino = model.getValueAt(fila, 5).toString();
                
               try {
                    aProd.selectProd();
                    aProd.confirmPedido(destino, model.getValueAt(fila, 3).toString());
                    tablaProdSolicita.setModel(tablas.tablaProdSolicita(model));
                    if(!mensaje.equals("")){
                        JOptionPane.showMessageDialog(this, mensaje);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                    Logger.getLogger(ProdSolicita.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "¡No ha seleccionado Ningun Elemento");
        }
    }//GEN-LAST:event_btnProdRecibidoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Administracion frame = new Administracion();
            frame.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ProdSolicita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ProdSolicita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdSolicita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdSolicita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdSolicita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ProdSolicita().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ProdSolicita.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelSoli;
    private javax.swing.JButton btnProdRecibido;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JTable tablaProdSolicita = new javax.swing.JTable();
    // End of variables declaration//GEN-END:variables
}
