package ighc.data;

import java.sql.SQLException;

import ighc.util.ConnectionPool;
import ighc.util.DatabaseConnection;

public class StimulusCalendarDAO {
//Delete
	public void deleteCalendar(int calenderId) throws SQLException {
		DatabaseConnection connection = ConnectionPool.getDatabaseConnection();
		connection.executeUpdate("DELETE FROM stimuluscalendar WHERE id = ?", calenderId);
	}
//Save
	public void saveCalendar (StimulusCalendar calendar) throws SQLException {      //TODO: Actually save the calendar instead of doing nothing
        DatabaseConnection connection = ConnectionPool.getDatabaseConnection();
	}

//Load
    public StimulusCalendar loadCalendar (int calenderId) throws SQLException {     //TODO: Return results instead of null
        DatabaseConnection connection = ConnectionPool.getDatabaseConnection();
        connection.executeQuery("SELECT FROM stimuluscalendar WHERE id = ?", calenderId);
        return null;
    }

//Modify
    public void updateCalendar (int calendarId, StimulusCalendar calendar) throws  SQLException {
        DatabaseConnection connection = ConnectionPool.getDatabaseConnection();

    }

}
