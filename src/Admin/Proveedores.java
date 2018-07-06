/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import static Admin.Administracion.tablaProd;
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
public class Proveedores extends javax.swing.JFrame {

    Funciones.Tablas tablas = new Funciones.Tablas();
    Funciones.Proveedores aProvs = new Funciones.Proveedores();
    DefaultTableModel model;
    TableRowSorter filtro;
    int fila, idProv;
    boolean insertMode;
    /**
     * Creates new form Proveedores
     */
    public Proveedores() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconos/logo.png")).getImage());
        tablaProvs.getColumnModel().getColumn(0).setMaxWidth(60);
        model = (DefaultTableModel) tablaProvs.getModel();
        tablas.tablaProveedor(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        interModInsert = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfEncargado = new javax.swing.JTextField();
        prodVinculados = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProdVinculado = new javax.swing.JTable();
        btnDesvincular = new javax.swing.JButton();
        btnVincuRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        btnAddProv = new javax.swing.JButton();
        btnModProv = new javax.swing.JButton();
        btnRmProv = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        btnViewProds = new javax.swing.JButton();

        interModInsert.setMinimumSize(new java.awt.Dimension(300, 220));
        interModInsert.setSize(new java.awt.Dimension(300, 235));

        jLabel3.setText("Nombre:");

        jLabel4.setText("Telefono:");

        jLabel5.setText("Correo:");

        tfCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCorreoActionPerformed(evt);
            }
        });

        jLabel6.setText("Direccion:");

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Encargado:");

        javax.swing.GroupLayout interModInsertLayout = new javax.swing.GroupLayout(interModInsert.getContentPane());
        interModInsert.getContentPane().setLayout(interModInsertLayout);
        interModInsertLayout.setHorizontalGroup(
            interModInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interModInsertLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(interModInsertLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(tfEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(interModInsertLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(interModInsertLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(interModInsertLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(interModInsertLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnSave)
                .addGap(29, 29, 29)
                .addComponent(btnCancel))
        );
        interModInsertLayout.setVerticalGroup(
            interModInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interModInsertLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(interModInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(interModInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(interModInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(interModInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(interModInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(interModInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)))
        );

        prodVinculados.setUndecorated(true);

        tablaProdVinculado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Marca", "Proveedor", "Precio de Compra", "Precio C/U", "Precio(Paquete)", "# Local", "# Bodega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaProdVinculado);

        btnDesvincular.setText("Desvincular Proveedor");
        btnDesvincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesvincularActionPerformed(evt);
            }
        });

        btnVincuRegresar.setText("Regresar");
        btnVincuRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincuRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout prodVinculadosLayout = new javax.swing.GroupLayout(prodVinculados.getContentPane());
        prodVinculados.getContentPane().setLayout(prodVinculadosLayout);
        prodVinculadosLayout.setHorizontalGroup(
            prodVinculadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prodVinculadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prodVinculadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDesvincular)
                .addGap(79, 79, 79)
                .addComponent(btnVincuRegresar)
                .addGap(309, 309, 309))
        );
        prodVinculadosLayout.setVerticalGroup(
            prodVinculadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prodVinculadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(prodVinculadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVincuRegresar)
                    .addComponent(btnDesvincular))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaProvs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Encargado", "Telefono", "Direccion", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProvs);

        btnAddProv.setText("Añadir Proveedor");
        btnAddProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProvActionPerformed(evt);
            }
        });

        btnModProv.setText("Actualizar Proveedor");
        btnModProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModProvActionPerformed(evt);
            }
        });

        btnRmProv.setText("Remover Proveedor");
        btnRmProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRmProvActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Lista de Proveedores");

        jButton6.setText("Cerrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnViewProds.setText("Ver Productos");
        btnViewProds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProdsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewProds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRmProv)
                            .addComponent(btnAddProv, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProv)
                    .addComponent(jButton6)
                    .addComponent(btnModProv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRmProv)
                    .addComponent(btnViewProds))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRmProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRmProvActionPerformed
        fila = tablaProvs.getSelectedRow();
        model = (DefaultTableModel) tablaProvs.getModel();
        int idProvee =Integer.parseInt(model.getValueAt(fila, 0).toString());
        aProvs.setId(idProvee);
        if (fila >= 0){
            int confirmar = JOptionPane.showConfirmDialog(this, "¿Eliminar al Proveedor \""+model.getValueAt(fila, 1)+"\"?");
            if (confirmar == 0){
                try {
                    if(aProvs.rmProv()){
                        JOptionPane.showMessageDialog(this, "¡Proveedor Eliminado!");
                    }else{
                        JOptionPane.showMessageDialog(this, "Este proveedor esta vinculado a uno o más productos\n Desvincule este Proveedor de estos Productos para remover al Proveedor");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
                }
                model = (DefaultTableModel) tablaProvs.getModel();
                try {
                    tablaProvs.setModel(tablas.tablaProveedor(model));
                } catch (SQLException ex) {
                    Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Aún No ha seleccionado un Proveedor");
        }
        
        
    }//GEN-LAST:event_btnRmProvActionPerformed

    private void tfCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCorreoActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        tfCorreo.setText("");
        tfNombre.setText("");
        tfEncargado.setText("");
        tfTelefono.setText("");
        tfDireccion.setText("");
        interModInsert.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProvActionPerformed
        interModInsert.setSize(320, 360);
        interModInsert.setLocationRelativeTo(null);
        interModInsert.setVisible(true);
        insertMode = true;
    }//GEN-LAST:event_btnAddProvActionPerformed

    private void btnModProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModProvActionPerformed
        //Llenar Campos 
        model = (DefaultTableModel) tablaProvs.getModel();
        fila = tablaProvs.getSelectedRow();
        if(fila >= 0){
            int id = Integer.valueOf(model.getValueAt(fila, 0).toString());
            aProvs.setId(id);
            aProvs.selectProv();
            
            tfNombre.setText(aProvs.getNombre());
            tfDireccion.setText(aProvs.getDirec());
            tfCorreo.setText(aProvs.getCorreo());
            tfTelefono.setText(aProvs.getTel());
            tfEncargado.setText(aProvs.getEncargado());
            interModInsert.setVisible(true);
            interModInsert.setSize(320, 360);
            interModInsert.setLocationRelativeTo(null);
            insertMode = false;
            
        }else{
            JOptionPane.showMessageDialog(interModInsert, "¡Seleccione un Proveedor!");
        }
        
        
    }//GEN-LAST:event_btnModProvActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
        Administracion frame= new Administracion();
        frame.setVisible(true);
        this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        aProvs.setNombre(tfNombre.getText());
        aProvs.setEncargado(tfEncargado.getText());
        aProvs.setTel(tfTelefono.getText());
        aProvs.setDirec(tfDireccion.getText());
        aProvs.setCorreo(tfCorreo.getText());
        try {
            if(insertMode){ //Evaluar si esta vaina va a modificar o intsertar proveedor
                if(aProvs.addProv()){
                    JOptionPane.showMessageDialog(interModInsert, "¡Proveedor Registrado!");
                    interModInsert.setVisible(false);
                    this.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(interModInsert, "¡No se Pudo resgistrar el nuevo Proveedor!");
                }
                        
            }else{
                if(aProvs.modProv()){
                    JOptionPane.showMessageDialog(interModInsert, "¡Cambios Guardados!");
                    interModInsert.setVisible(false);
                    this.setVisible(true);
                    tablaProvs.clearSelection();
                }else{
                    JOptionPane.showMessageDialog(interModInsert, "¡No Pudieron Aplicar los Cambios!");
                }
            }
            tfCorreo.setText("");
            tfNombre.setText("");
            tfEncargado.setText("");
            tfTelefono.setText("");
            tfDireccion.setText("");
            model = (DefaultTableModel) tablaProvs.getModel();
            tablas.tablaProveedor(model);
        } catch (SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnViewProdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProdsActionPerformed
        model = (DefaultTableModel) tablaProvs.getModel();
        fila = tablaProvs.getSelectedRow();
        idProv = Integer.valueOf(model.getValueAt(fila, 0).toString());
        aProvs.setId(idProv);
        if(fila >= 0){
            try {
                model = (DefaultTableModel) tablaProdVinculado.getModel();
                model = tablas.prodVinculados(model, idProv); //Mandamos como parametros el modelo y el id del proveedor
                tablaProdVinculado.setModel(model);
                prodVinculados.setSize(855, 390);
                prodVinculados.setLocationRelativeTo(null);
                prodVinculados.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_btnViewProdsActionPerformed

    private void btnDesvincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesvincularActionPerformed
        fila = tablaProdVinculado.getSelectedRow();
        model = (DefaultTableModel) tablaProdVinculado.getModel();
        if(fila >= 0){
            int id = Integer.valueOf(model.getValueAt(fila, 0).toString());
            try {
                int confir = JOptionPane.showConfirmDialog(prodVinculados, "¿Esta Seguro de Realizar esta Acción?");
                if(confir >= 0){
                    if(aProvs.desvincular(id)){
                    JOptionPane.showMessageDialog(this.prodVinculados, "¡Producto Desvinculado de Este Proveedor!");
                    tablaProdVinculado.setModel(tablas.prodVinculados(model, idProv));
                    tablaProdVinculado.clearSelection();
                }else{
                        JOptionPane.showMessageDialog(prodVinculados, "¡No se ha Podido Desvincular este Producto!");
                    }
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        
    }//GEN-LAST:event_btnDesvincularActionPerformed

    private void btnVincuRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVincuRegresarActionPerformed
        this.prodVinculados.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_btnVincuRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Proveedores().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProv;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDesvincular;
    private javax.swing.JButton btnModProv;
    private javax.swing.JButton btnRmProv;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnViewProds;
    private javax.swing.JButton btnVincuRegresar;
    private javax.swing.JFrame interModInsert;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFrame prodVinculados;
    private javax.swing.JTable tablaProdVinculado;
    public static final javax.swing.JTable tablaProvs = new javax.swing.JTable();
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfEncargado;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
