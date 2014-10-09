/**
 * File:		DatabaseConnection.java
 * Package:		com.innobox.innotrace.servermodule
 * Project:		ServerModule
 * Created:		12/04/2014 15.52.02
 * Author:		jonathanfrank
 * 
 * Copyright 2014 InnoBox / Jonathan Frank. All rights reserved.
 * For further information, please read LICENSE.md
 */
package ighc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

/**
 * @author jonathanfrank
 * 
 */
public class DatabaseConnection {
	private Connection conn;
	
	public DatabaseConnection(Configuration conf) throws SQLException {
		Properties connProp = new Properties();
		connProp.put("user", conf.getDbUsername());
		connProp.put("password", conf.getDbPassword());
		
		conn = DriverManager.getConnection(conf.getDbURL(), connProp);
		conn.setAutoCommit(false);
	}
	
	public void executeUpdate(String sql, Object... params) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if (params != null) {
				for (int n = 0; n < params.length; n++) {
					pstmt.setObject(n + 1, params[n]);
				}
			}
			
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			throw ex;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	
	public CachedRowSet executeQuery(String sql, Object... params) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet results = null;
		CachedRowSet cachedResults = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if (params != null) {
				for (int n = 0; n < params.length; n++) {
					pstmt.setObject(n + 1, params[n]);
				}
			}
			
			results = pstmt.executeQuery();
			
			cachedResults = new CachedRowSetImpl();
			cachedResults.populate(results);
			
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			throw ex;
		} finally {
			if (results != null) {
				results.close();
			}
			
			if (pstmt != null) {
				pstmt.close();
			}
		}
		
		return cachedResults;
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// NO-OP
		}
	}
}
