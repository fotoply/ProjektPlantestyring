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
	public void saveCalendar (StimulusCalendar calendar) throws SQLException {
		
	}
}
