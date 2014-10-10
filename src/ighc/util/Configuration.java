package ighc.util;

/**
 * @author jonathanfrank
 * 
 */
public class Configuration {
	private String dbURL = "jdbc:mysql://localhost/ighc_data";
	private String dbUsername = "root";
	private String dbPassword = "key4u2use";
	
	/**
	 * 
	 */
	public Configuration() {
		
	}
	
	/**
	 * @param dbURL
	 * @param dbUsername
	 * @param dbPassword
	 */
	public Configuration(String dbURL, String dbUsername, String dbPassword) {
		this.dbURL = dbURL;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	
	/**
	 * @return the dbURL
	 */
	public String getDbURL() {
		return dbURL;
	}
	
	/**
	 * @param dbURL
	 *            the dbURL to set
	 */
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	
	/**
	 * @return the dbUsername
	 */
	public String getDbUsername() {
		return dbUsername;
	}
	
	/**
	 * @param dbUsername
	 *            the dbUsername to set
	 */
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}
	
	/**
	 * @return the dbPassword
	 */
	public String getDbPassword() {
		return dbPassword;
	}
	
	/**
	 * @param dbPassword
	 *            the dbPassword to set
	 */
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	
}
