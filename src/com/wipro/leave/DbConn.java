/**
 * 
 */
/**
 * @author NA391766
 *
 */
package com.wipro.leave;

import java.sql.*;

import org.apache.log4j.Logger;

public class DbConn {

	final static Logger log = Logger.getLogger(DbConn.class.getName());

	public static Connection connect() {

		Connection con = null;

		Connection connection = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			try {
				con = DriverManager.getConnection("jdbc:odbc:leaveplanner", "",
						"");
				
			} catch (SQLException exp) {
			
				log.error(exp);
			}

		} catch (ClassNotFoundException exp) {
		
			log.error(exp);
		}

		return con;
	}

	public static Connection getEmpDbConn() {

		Connection connection = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			try {
				connection = DriverManager.getConnection(
						"jdbc:odbc:EMP_DETAILS", "", "");

			} catch (SQLException exp) {
				log.error(exp);
			}

		} catch (ClassNotFoundException exp) {
			log.error(exp);
		}

		return connection;
	}

}