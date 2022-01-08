/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderer;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;


/**
 *
 * @author User
 */
 class HeaderRender extends TableCellRenderer implements javax.swing.plaf.UIResource {
    private final TableCellRenderer defRenderer;
    HeaderRender (TableCellRenderer defRenderer){
        this.defRenderer = defRenderer;
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column)
    {
        Component c = defRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (c instanceof JLabel){
            JLabel label = (JLabel)c;
             label.setBorder(UIManager.getBorder("Table Header.cellBorder"));
            label.setHorizontalAlignment(JLabel.CENTER);
         label.setFont(UIManager.getFont("TableHeader.font")); 
         label.setBackground(UIManager.getColor("TableHeader.focusCellBackground").CYAN);
         label.setText(value.toString());
    }
     return c;   
    }

}
