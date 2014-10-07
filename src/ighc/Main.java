package ighc;

import ighc.data.Property;
import ighc.data.Stimulus;
import ighc.data.StimulusCalendar;
import ighc.gui.StimulusCalendarView;

import javax.swing.*;
import java.util.Date;

/**
 * Created by NorbergPC on 07-10-2014.
 */
public class Main {
    public static void main(String[] args) {
        StimulusCalendar cal = new StimulusCalendar();

        // TESTKODE MED TILFÆLDIG DATA!!
        Property temp = new Property(4,5,2,1);
        Property humi = new Property(4,5,2,1);
        Property ligh = new Property(4,5,2,1);
        Property co2 = new Property(4,5,2,1);
        Stimulus sti = new Stimulus(temp,humi,ligh,co2);
        Date date = new Date();
        try {
            cal.put(date, sti);
            Thread.sleep(1);
            cal.put(new Date(), sti);
            Thread.sleep(1);
            cal.put(new Date(), sti);
            Thread.sleep(1);
            cal.put(new Date(), sti);
            Thread.sleep(1);
            cal.put(new Date(), sti);
            Thread.sleep(1);
            cal.put(new Date(), sti);
        } catch (InterruptedException e) {
        }
        // SLUT PÅ TESTKODE!!

        StimulusCalendarView view = new StimulusCalendarView(cal);
        JFrame frame = new JFrame("Stimulus calendar control panel");
        frame.setContentPane(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        //frame.pack();
        frame.setVisible(true);
    }
}
