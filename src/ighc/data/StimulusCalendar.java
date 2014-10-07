package ighc.data;

import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by NorbergPC on 07-10-2014.
 */
public class StimulusCalendar extends AbstractTableModel {
    LinkedHashMap<Date,Stimulus> calendar;

    public void remove(Object key) {
        calendar.remove(key);
        fireTableDataChanged();
    }

    public void put(Date key, Stimulus value) {
        calendar.put(key, value);
        fireTableDataChanged();
    }

    public StimulusCalendar() {
        this(new LinkedHashMap<Date, Stimulus>());
    }

    public StimulusCalendar(LinkedHashMap<Date, Stimulus> calendar) {
        this.calendar = calendar;
    }

    @Override
    public int getRowCount() {
        return calendar.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: // Er ved dato
                return "Date";

            case 1: // Er ved jordfugtighed
                 return "Humidity";

            case 2: // Er ved temperatur
                return "Temperature";

            case 3: // Er ved lyststyrke
                return "Light";

            case 4: // Er ved CO2
                return "CO2";

            default: // Fejl
                throw new IllegalArgumentException("Invalid column selected!");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Map.Entry<Date,Stimulus> entry = ((Map.Entry<Date,Stimulus>)calendar.entrySet().toArray()[rowIndex]);
        switch(columnIndex) {
            case 0: // Er ved dato
                return entry.getKey();

            case 1: // Er ved jordfugtighed
                return entry.getValue().getHumidity();

            case 2: // Er ved temperatur
                return entry.getValue().getTemperature();

            case 3: // Er ved lysstyrke
                return entry.getValue().getLight();

            case 4: // Er ved CO2
                return entry.getValue().getCo2();

            default: // Fejl
                throw new IllegalArgumentException("Invalid column selected!");
        }
    }
}
