package proyecto_final;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Rederer extends DefaultTableCellRenderer {

    private Component componente;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row % 2 == 0) {
            componente.setBackground(new java.awt.Color(196, 248, 255));
            componente.setFont(new Font("Tahoma", Font.BOLD, 12));
        } else {
            componente.setBackground(new java.awt.Color(236, 253, 255));
            componente.setFont(new Font("Tahoma", Font.BOLD, 12));
        }
        return componente;
    }
}
