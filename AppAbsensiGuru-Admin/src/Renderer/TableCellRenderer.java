/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;


/**
 *
 * @author User
 */

public class TableCellRenderer extends DefaultTableCellRenderer{
    private static final long serialVersionUID=1L;
    private SimpleDateFormat format;
 
    public TableCellRenderer(){
        format = new SimpleDateFormat("dd-MMM-yyyy");
    }
    
    public Component getTableCellRendererComponent(JTable table, JTableHeader header, Object value, boolean isSelected,
            boolean hasFocus, int row, int column){
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value !=null && value instanceof Date) {
            Date date= (Date) value;
            String text= format.format(date);
            label.setText(text);
            
          /*  JTableHeader header = table.getTableHeader();
            label.setBorder(UIManager.getBorder("Table Header.cellBorder"));
            label.setHorizontalAlignment(JLabel.CENTER);
           Font font = new Font("Times New Roman", Font.BOLD, 12);
         label.setFont(font); 
         label.setBackground(Color.CYAN);*/
            
        }
        return label;
         
    }
    
   
}
