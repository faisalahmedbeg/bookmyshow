package com.bookmyshow.dbconnect;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	private static final String DB_USERNAME = "db.username";
	private static final String DB_PASSWORD = "db.password";
	private static final String DB_URL = "db.url";
	private static final String DB_DRIVER_CLASS = "driver.class.name";

	private static Properties properties = null;
	@SuppressWarnings("unused")
	private static ComboPooledDataSource cpds;

	public static Connection getConnection() throws SQLException, IOException, PropertyVetoException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream resourceStream = loader.getResourceAsStream("database.properties");
		properties = new Properties();
		properties.load(resourceStream);
		// properties.load(new FileInputStream("database.properties"));
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		System.out.println("class - " + properties.getProperty(DB_DRIVER_CLASS));
		cpds.setDriverClass(properties.getProperty(DB_DRIVER_CLASS));
		cpds.setJdbcUrl(properties.getProperty(DB_URL));
		cpds.setUser(properties.getProperty(DB_USERNAME));
		cpds.setPassword(properties.getProperty(DB_PASSWORD));
		System.out.println("password - " + properties.getProperty(DB_PASSWORD));
		System.out.println("cpds - " + cpds.toString());
		Connection con = cpds.getConnection();
		System.out.println("con - " + con.toString());
		return con;
	}
}
