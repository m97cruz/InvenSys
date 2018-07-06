/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Rudyz Meza
 */
public class Render extends DefaultTableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
      super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
       setBackground(Color.white);
       setForeground(Color.black);
       int cantLocal = 0;
       int repo =0;
       cantLocal = Integer.valueOf(table.getValueAt(row, 7).toString());
       repo = Integer.valueOf(table.getValueAt(row, 9).toString());
      if ( cantLocal<=repo)
      {
         this.setOpaque(true);
         this.setBackground(Color.RED);
         this.setForeground(Color.YELLOW);
      } else {

      }
      return this;
   }
}
