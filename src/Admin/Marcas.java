/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Mauricio Cruz
 */
public class Marcas extends javax.swing.JFrame {

    /**
     * Creates new form Marcas
     */
    
    DefaultTableModel model;
    Funciones.Tablas tablas = new Funciones.Tablas();
    Funciones.Productos aProd = new Funciones.Productos();
    TableRowSorter filtro;
    
    public Marcas() throws SQLException {
        initComponents();
        model=(DefaultTableModel) tablaMarcas.getModel();
        tablaMarcas.setModel(tablas.Marcas(model, ""));
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconos/logo.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMarcas = new javax.swing.JTable();
        btnMarCancel = new javax.swing.JButton();
        btnAddMarca = new javax.swing.JButton();
        btnDeleteMarca = new javax.swing.JButton();
        txtFindMarca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaMarcas);

        btnMarCancel.setText("Cerrar");
        btnMarCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarCancelActionPerformed(evt);
            }
        });

        btnAddMarca.setText("Agregar");
        btnAddMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMarcaActionPerformed(evt);
            }
        });

        btnDeleteMarca.setText("Eliminar");
        btnDeleteMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMarcaActionPerformed(evt);
            }
        });

        txtFindMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFindMarcaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindMarcaKeyPressed(evt);
            }
        });

        jLabel2.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFindMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDeleteMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMarCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFindMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteMarca)
                        .addGap(30, 30, 30)
                        .addComponent(btnMarCancel)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMarCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarCancelActionPerformed
        try {
            Admin.Administracion f = new Admin.Administracion();
            f.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMarCancelActionPerformed

    private void btnAddMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMarcaActionPerformed
        String marca = JOptionPane.showInputDialog("Ingrese la Nueva Marca");
        if(!marca.equals("")){
            if(aProd.addMarca(marca)){
                JOptionPane.showMessageDialog(this, "¡Marca Agregada!");
                
                try {
                    tablaMarcas.setModel(tablas.Marcas(model, ""));
                } catch (SQLException ex) {
                    Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(this, "No se Pudo Agregar la Marca");
            }
        }else{
            JOptionPane.showMessageDialog(this, "No se ingresó un Nombre para la Marca");
        }
    }//GEN-LAST:event_btnAddMarcaActionPerformed

    private void btnDeleteMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMarcaActionPerformed
        int fila = tablaMarcas.getSelectedRow();

        if(fila>=0){
            int id= Integer.parseInt(model.getValueAt(fila, 0).toString());
            int ok = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar esta marca?");
            if(ok == 0){
                try {
                    if(aProd.rmMarca(id)){
                        JOptionPane.showMessageDialog(this, "La Marca ha Sido Eliminada");
                        try {
                            tablaMarcas.setModel(tablas.Marcas(model, ""));
                        } catch (SQLException ex) {
                            Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Esta Marca esta Vinculada a uno o mas productos,\n Para Eliminar, desvincule esta marca del producto");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Selecione una Marca de la lista");
        }

    }//GEN-LAST:event_btnDeleteMarcaActionPerformed

    private void txtFindMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindMarcaKeyTyped
        try {
            tablas.Marcas(model, txtFindMarca.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFindMarcaKeyTyped

    private void txtFindMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindMarcaKeyPressed
        
    }//GEN-LAST:event_txtFindMarcaKeyPressed

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
            java.util.logging.Logger.getLogger(Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Marcas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Marcas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMarca;
    private javax.swing.JButton btnDeleteMarca;
    private javax.swing.JButton btnMarCancel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tablaMarcas;
    private javax.swing.JTextField txtFindMarca;
    // End of variables declaration//GEN-END:variables
}
