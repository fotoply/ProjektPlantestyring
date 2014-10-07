package ighc.gui;

import ighc.data.Property;
import ighc.data.Stimulus;
import ighc.data.StimulusCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by NorbergPC on 07-10-2014.
 */
public class StimulusCalendarView extends JPanel {
    private StimulusCalendar calendar;

    public StimulusCalendarView(final StimulusCalendar calendar) {
        this.calendar = calendar;
        mainTable.setModel(this.calendar);
        mainTable.setDefaultRenderer(Property.class, new PropertyCellRenderer());

        this.setLayout(new BorderLayout());
        this.add(mainJPanel, BorderLayout.CENTER);
        this.revalidate();

        addNewEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Property temp = new Property(4, 5, 2, 1);
                Property humi = new Property(4, 5, 2, 1);
                Property ligh = new Property(4, 5, 2, 1);
                Property co2 = new Property(4, 5, 2, 1);
                Stimulus sti = new Stimulus(temp, humi, ligh, co2);
                sti.setEnabled(false);
                Date date = new Date();
                calendar.put(date, sti);
            }
        });
    }

    private JTable mainTable;
    private JButton addNewEventButton;
    private JPanel mainJPanel;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainJPanel = new JPanel();
        mainJPanel.setLayout(new GridBagLayout());
        final JScrollPane scrollPane1 = new JScrollPane();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainJPanel.add(scrollPane1, gbc);
        mainTable = new JTable();
        mainTable.setBackground(new Color(-1));
        mainTable.setFillsViewportHeight(true);
        scrollPane1.setViewportView(mainTable);
        addNewEventButton = new JButton();
        addNewEventButton.setText("Add new event");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainJPanel.add(addNewEventButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainJPanel;
    }
}
