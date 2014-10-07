package ighc.gui;

import ighc.data.Property;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by NorbergPC on 07-10-2014.
 */
public class PropertyCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JPanel panel = new JPanel();
        Property property = (Property) value;

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(new JLabel(String.format("High: %.1f",property.getHigh())));
        panel.add(new JLabel(String.format("Low: %.1f",property.getLow())));
        panel.add(new JLabel(String.format("Freq: %.0f",property.getFrequency())));
        panel.add(new JLabel(String.format("Duty: %.0f",property.getDutycycle())));

        table.setRowHeight(row,70);
        table.getColumnModel().getColumn(column).setMinWidth(40);
        table.getColumnModel().getColumn(column).setMaxWidth(Integer.MAX_VALUE);
        return panel;
    }
}
