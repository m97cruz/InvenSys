package Vendedor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Admin.Administracion;
import java.awt.MenuComponent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Alumno
 */
public class Vendedor extends javax.swing.JFrame {
    Funciones.Usuarios usuarios = new Funciones.Usuarios();
    Admin.Login login = new Admin.Login();
    Funciones.Tablas tablas = new Funciones.Tablas();
    private TableRowSorter filtro;
    DefaultTableModel  modelo,model;
    
    Funciones.Vendedor_ funVendedor =new Funciones.Vendedor_();
    /**
     * Creates new form Vendedor
     */
    public Vendedor() throws SQLException, ParseException{
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconos/logo.png")).getImage());
        modelo= (DefaultTableModel) Vendedor.tbl_list.getModel(); //Obtiene el Modelo
        this.txf_buscar.requestFocus();
        model=(DefaultTableModel) Vendedor.tablaProds.getModel();
        tablas.tablaProdVend(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_search = new javax.swing.JLabel();
        txf_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbl_lista = new javax.swing.JLabel();
        btn_success = new javax.swing.JButton();
        lbl_total_venta = new javax.swing.JLabel();
        btn_nVenta = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        cb_filtro = new javax.swing.JComboBox<>();
        lbl_total = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        lbl_efectivo = new javax.swing.JLabel();
        jt_efectivo = new javax.swing.JTextField();
        lbl_cam = new javax.swing.JLabel();
        lbl_cambio = new javax.swing.JLabel();
        chbx_mayoreo = new javax.swing.JCheckBox();
        chbx_lugar = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventas");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setResizable(false);

        lbl_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconos/filter.png"))); // NOI18N
        lbl_search.setText("Filtrar por:");

        txf_buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txf_buscar.setNextFocusableComponent(tablaProds);
        txf_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_buscarActionPerformed(evt);
            }
        });
        txf_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txf_buscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txf_buscarKeyTyped(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tablaProds.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tablaProds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Marca", "Precio (U)", "Precio (Paquetes)", "Disp. Local", "Disp.Bodega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProds.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaProdsKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProds);
        if (tablaProds.getColumnModel().getColumnCount() > 0) {
            tablaProds.getColumnModel().getColumn(0).setMinWidth(40);
            tablaProds.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaProds.getColumnModel().getColumn(0).setMaxWidth(60);
            tablaProds.getColumnModel().getColumn(1).setMinWidth(150);
            tablaProds.getColumnModel().getColumn(1).setMaxWidth(350);
        }

        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tbl_list.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Precio Unitario", "Cantidad", "Depachar desde", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_list.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_listKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_list);
        if (tbl_list.getColumnModel().getColumnCount() > 0) {
            tbl_list.getColumnModel().getColumn(0).setMinWidth(40);
            tbl_list.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_list.getColumnModel().getColumn(0).setMaxWidth(60);
            tbl_list.getColumnModel().getColumn(1).setMinWidth(150);
            tbl_list.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_list.getColumnModel().getColumn(1).setMaxWidth(250);
        }

        lbl_lista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconos/icon_list.png"))); // NOI18N
        lbl_lista.setText("Lista de venta:");

        btn_success.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_success.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconos/ok_icon.png"))); // NOI18N
        btn_success.setText("Procesar Venta");
        btn_success.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_successActionPerformed(evt);
            }
        });

        lbl_total_venta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_total_venta.setText("Total de venta:");

        btn_nVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_nVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconos/plus2.png"))); // NOI18N
        btn_nVenta.setText("Nueva venta");
        btn_nVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nVentaActionPerformed(evt);
            }
        });

        btn_remove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconos/send_up.png"))); // NOI18N
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        btn_add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconos/send_down.png"))); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        cb_filtro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Marca" }));
        cb_filtro.setSelectedIndex(1);

        lbl_total.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbl_total.setText("0.00");

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_limpiar.setText("Limpiar lista");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        lbl_efectivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_efectivo.setText("Efectivo:");

        jt_efectivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jt_efectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_efectivoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jt_efectivoKeyTyped(evt);
            }
        });

        lbl_cam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_cam.setText("Cambio:");

        lbl_cambio.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbl_cambio.setText("0.00");

        chbx_mayoreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chbx_mayoreo.setText("Mayoreo");
        chbx_mayoreo.setToolTipText("Aplicar precio por mayoreo a todos los producos");
        chbx_mayoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbx_mayoreoActionPerformed(evt);
            }
        });

        chbx_lugar.setFont(getFont());
        chbx_lugar.setText("Despachar de bodega");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconos/icon_list.png"))); // NOI18N
        jMenu1.setText("Opciones");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconos/logout.png"))); // NOI18N
        jMenuItem1.setText("Cerrar Sesión");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconos/update.png"))); // NOI18N
        jMenuItem2.setText("Actualizar productos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Procesar venta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Limpiar lista");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btn_remove)
                        .addGap(18, 18, 18)
                        .addComponent(btn_add))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_lista)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_limpiar))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_success))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(lbl_search)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_cam)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_cambio))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_total_venta)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_total))
                                .addComponent(btn_nVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_efectivo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jt_efectivo))
                                .addComponent(chbx_mayoreo)
                                .addComponent(chbx_lugar)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_search)
                    .addComponent(txf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_nVenta)
                        .addGap(18, 18, 18)
                        .addComponent(chbx_mayoreo)
                        .addGap(18, 18, 18)
                        .addComponent(chbx_lugar)))
                .addGap(18, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_add)
                    .addComponent(btn_remove))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_lista)
                    .addComponent(btn_limpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_total_venta)
                            .addComponent(lbl_total))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_efectivo)
                            .addComponent(jt_efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cam)
                            .addComponent(lbl_cambio))
                        .addGap(18, 18, 18)
                        .addComponent(btn_success))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_successActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_successActionPerformed
        try {
            procesarVenta();
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_successActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Admin.Login frame = new Admin.Login();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            // TODO add your handling code here:
            this.llenarTbl_List();
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_addActionPerformed

    private void tablaProdsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaProdsKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            try {
                this.llenarTbl_List();
            } catch (SQLException ex) {
                Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tablaProdsKeyPressed

    private void txf_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_buscarKeyTyped
        // TODO add your handling code here:
         txf_buscar.addKeyListener(new KeyAdapter() {
        public void keyReleased(final KeyEvent e){
            txf_buscar.setText(txf_buscar.getText());
            repaint();
            filtro.setRowFilter(RowFilter.regexFilter(txf_buscar.getText().trim(), cb_filtro.getSelectedIndex()));
        }
        });
        filtro = new TableRowSorter(this.tablaProds.getModel());
        this.tablaProds.setRowSorter(filtro);
    }//GEN-LAST:event_txf_buscarKeyTyped

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        // TODO add your handling code here:
        this.removerProd();
    }//GEN-LAST:event_btn_removeActionPerformed

    private void tbl_listKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_listKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_DELETE){
            this.removerProd();
        }
    }//GEN-LAST:event_tbl_listKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            // TODO add your handling code here:
            tablas.tablaProdVend(model);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            // TODO add your handling code here:
            procesarVenta();
        } catch (SQLException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        limpiarLista();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        limpiarLista();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void jt_efectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_efectivoKeyTyped
        // TODO add your handling code here:
        char val=evt.getKeyChar();
        if (Character.isLetter(val)){
            getToolkit().beep(); 
            evt.consume();
        }
    }//GEN-LAST:event_jt_efectivoKeyTyped

    private void jt_efectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_efectivoKeyPressed
         // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                procesarVenta();
            } catch (SQLException ex) {
                Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jt_efectivoKeyPressed

    private void btn_nVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nVentaActionPerformed
//        try {
//            Nuevaventa f = new Nuevaventa();
//            f.setVisible(true);
//        } catch (SQLException ex) {
//            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btn_nVentaActionPerformed

    private void txf_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_buscarKeyPressed
         // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.tablaProds.requestFocus();
        }
    }//GEN-LAST:event_txf_buscarKeyPressed

    private void chbx_mayoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbx_mayoreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbx_mayoreoActionPerformed

    private void txf_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_buscarActionPerformed
    public void llenarTbl_List() throws SQLException{
        int fila=tablaProds.getSelectedRow();
        if(fila<0){
            //Si no hay un producto de la lista seleccionado
            JOptionPane.showMessageDialog(this, "No se ha seleccionado algun producto","Aviso",JOptionPane.INFORMATION_MESSAGE);
        } else{
            //Acciones si hay un producto de la lista seleccionado
            //Variable que almacena la canridad disponible
            int cantDisponible=0;
                cantDisponible= Integer.valueOf(tablaProds.getValueAt(fila,5).toString()); //Cantidad disponilbe segun tabla
            //verificar si la venta se hara desdedesde bodega
            if(chbx_lugar.isSelected()){
                cantDisponible= Integer.valueOf(tablaProds.getValueAt(fila,6).toString()); //Cantidad disponilbe segun tabla
            }
            
            //Preguntar la cantidad de producto que se desea
            int cantidad=Integer.valueOf(JOptionPane.showInputDialog(this,"Cantidad de productos:","Ingrese la cantidad",JOptionPane.QUESTION_MESSAGE).trim());
            //verificar que la cantidad solicitada no exceda la cantidad disponible
            if(cantidad>cantDisponible){
                //si se excede la cantidad disponible
                JOptionPane.showMessageDialog(this, "Se excede la cantidad disponible en el local","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } else{
                //Si la cantidad solicitada es valida
                //verificar si la cantidad solicitada es mayor a cero 
                if(cantidad>0){
                    //si la cantidad solicitada es mayor a cero
                   String codigo = tablaProds.getValueAt(fila,0).toString();//codigo de producto
                   String nombre = tablaProds.getValueAt(fila,1).toString();//nombre de producto
                   String precioUni = tablaProds.getValueAt(fila,3).toString();//precio unitario de producto
                   String lugar="Local";
                   if(chbx_lugar.isSelected()){
                       lugar="Bodega";
                   }
                   float total=0.00f;//total por producto
                   total=tablas.getTotal(codigo, cantidad, this.chbx_mayoreo.isSelected());//obtener el total por producto,con metodo getTotal(,,)
                    //anadir producto a la lista de producto
                    modelo.addRow(new Object[]{
                       codigo,
                       nombre,
                       precioUni,
                       String.valueOf(cantidad),
                       lugar,
                       total
                   });
                    //Setear el total a pagar debido al ingreso de otro producto a la lista
                    setTotal();
                    this.txf_buscar.requestFocus();
                    this.jt_efectivo.setText("");
                    this.txf_buscar.setText("");
               }
            }
        }
    }
    public void removerProd(){
        int fila=tbl_list.getSelectedRow();
        if(fila<0){
            JOptionPane.showMessageDialog(this, "No se ha seleccionado algun producto","Aviso",JOptionPane.INFORMATION_MESSAGE);
        } else{
            try{
                modelo.removeRow(fila);
                setTotal();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Error");
            }
        }
    }
    private void limpiarLista(){
        if(modelo.getRowCount()>0){
            int filas=modelo.getRowCount();
            for(int i=0;i<=filas-1;i++){
                modelo.removeRow(0);
            }
            this.jt_efectivo.setText("");
            this.txf_buscar.setText("");
            this.lbl_cambio.setText("");
            this.txf_buscar.requestFocus();
            setTotal();
        } else{
            JOptionPane.showMessageDialog(this, "Lista de venta vacia","Aviso",JOptionPane.INFORMATION_MESSAGE);       
        }
    }
    private void setTotal() {
        int filas=modelo.getRowCount();
        float total=0.00f;
        float precio=0.00f;
        if(filas>0){
            for(int i=0;i<=filas-1;i++){
                precio=Float.valueOf(Vendedor.this.modelo.getValueAt(i, 5).toString());
                total+=precio;
            }
        }
        this.lbl_total.setText(String.valueOf(total));
    }
    private void procesarVenta() throws SQLException{
        if(modelo.getRowCount()>0){
            if(this.jt_efectivo.getText().isEmpty()){
                this.jt_efectivo.requestFocus();
                JOptionPane.showMessageDialog(this,"Debe completar el campo de efectivo","Aviso",JOptionPane.INFORMATION_MESSAGE);
            } else{
                float efectivo=Float.valueOf(this.jt_efectivo.getText().trim());
                if(efectivo<Float.valueOf(this.lbl_total.getText())){
                    this.jt_efectivo.requestFocus();
                    JOptionPane.showMessageDialog(this,"Efectivo insuficiente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                } else{
                    if(JOptionPane.showConfirmDialog(this,"CONFIRMAR VENTA","CONFIRMACION" ,JOptionPane.OK_CANCEL_OPTION)==0){
                        String lugar="local_cant";
                        for(int i=0;i<modelo.getRowCount();i++){
                            funVendedor.setFecha(LocalDate.now().toString());
                            funVendedor.setCantidad(Integer.valueOf(modelo.getValueAt(i,3).toString()));
                            funVendedor.setTotal(Float.valueOf(modelo.getValueAt(i,5).toString()));
                            funVendedor.setProducto(modelo.getValueAt(i,1).toString());
                            funVendedor.setId(Integer.valueOf(modelo.getValueAt(i,0).toString()));
                            if(modelo.getValueAt(i,4).toString().equals("Bodega")){
                                lugar="bodega_cant";
                            }
                            funVendedor.setLugar(lugar);
                            funVendedor.procesarVenta();
                        }
                        float cambio=efectivo-Float.valueOf(this.lbl_total.getText());
                        this.lbl_cambio.setText(String.valueOf(cambio));
                        JOptionPane.showMessageDialog(this, "Venta procesada\n Cambio $ "+String.valueOf(cambio),"Aviso",JOptionPane.INFORMATION_MESSAGE);  
                        limpiarLista();
                        tablas.tablaProdVend(model);
                    } else{
                        JOptionPane.showMessageDialog(this, "Venta cancelada","Aviso",JOptionPane.INFORMATION_MESSAGE);       
                    }
                }
            }
        } else{
            JOptionPane.showMessageDialog(this, "Lista de venta vacia","Aviso",JOptionPane.INFORMATION_MESSAGE);       
        }
    }
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
            java.util.logging.Logger.getLogger(Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Vendedor().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_nVenta;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_success;
    private javax.swing.JComboBox<String> cb_filtro;
    private javax.swing.JCheckBox chbx_lugar;
    private javax.swing.JCheckBox chbx_mayoreo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jt_efectivo;
    private javax.swing.JLabel lbl_cam;
    private javax.swing.JLabel lbl_cambio;
    private javax.swing.JLabel lbl_efectivo;
    private javax.swing.JLabel lbl_lista;
    private javax.swing.JLabel lbl_search;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_total_venta;
    public static final javax.swing.JTable tablaProds = new javax.swing.JTable();
    public static final javax.swing.JTable tbl_list = new javax.swing.JTable();
    private javax.swing.JTextField txf_buscar;
    // End of variables declaration//GEN-END:variables

  
}
