package ighc.data;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by NorbergPC on 07-10-2014.
 */
public class StimulusCalendar extends AbstractTableModel {
    LinkedHashMap<Date,Stimulus> calendar;

    public StimulusCalendar() {
        this(new LinkedHashMap<Date, Stimulus>());
    }

    public StimulusCalendar(LinkedHashMap<Date, Stimulus> calendar) {
        this.calendar = calendar;
    }

    public void remove(Object key) {    //TODO: Implement database calls when removing values
        calendar.remove(key);
        fireTableDataChanged();
    }

    public void put(Date key, Stimulus value) {     //TODO: Implement database calls when putting values
        calendar.put(key, value);

        Object[] calArray = calendar.keySet().toArray();
        for(int i = 0; i < calendar.size(); i++) {
            if(calArray[i].equals(key)) {
                fireTableRowsInserted(i,i);
                return;
            }
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {       //TODO: Maybe use an if-then-else instead of switch?
            case 0:     // Is a date
                return Date.class;

            default:    // Otherwise it is a property
                return Property.class;
        }
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
            case 0: // Column is date
                return "Date";

            case 1: // Column is humidity
                 return "Humidity";

            case 2: // Column is temperature
                return "Temperature";

            case 3: // Column is light intensity
                return "Light";

            case 4: // Column is CO2
                return "CO2";

            default: // Error
                throw new IllegalArgumentException("Invalid column selected!");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Map.Entry<Date,Stimulus> entry = ((Map.Entry<Date,Stimulus>)calendar.entrySet().toArray()[rowIndex]);
        switch(columnIndex) {
            case 0: // Column is date
                return entry.getKey();

            case 1: // Column is humidity
                return entry.getValue().getHumidity();

            case 2: // Column is temperature
                return entry.getValue().getTemperature();

            case 3: // Column is light intensity
                return entry.getValue().getLight();

            case 4: // Column is CO2
                return entry.getValue().getCo2();

            default: // Error
                throw new IllegalArgumentException("Invalid column selected!");
        }
    }
}
