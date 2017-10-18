package com.webregistrationapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class MySQLAccess {

	private Connection connect = null;
	private Statement statement = null;
	private static final String SQL_INSERT = "INSERT INTO sys.registered_users"
		    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private ResultSet resultSet = null;
	final private String host = "24.192.171.42";
	final private String user = "Oudin";
	final private String passwd = "password123";

	public List<UserInfo> readDataBase() throws Exception {

		List<UserInfo> allUserInfo = new Vector<UserInfo>();
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			String connectionString = "jdbc:mysql://" + host + ":3306/?autoReconnect=true&useSSL=false";
			connect = DriverManager
					.getConnection(connectionString, user,  passwd);

			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from sys.registered_users");
			allUserInfo = writeResultSet(resultSet);

		} catch (Exception e) {
			e.printStackTrace();;
		} finally {
			close();
		}
		return allUserInfo;
	}

	private List<UserInfo> writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		List<UserInfo> allUserInfo = new Vector<UserInfo>();
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			UserInfo userInfo = new UserInfo(resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getString("address1"),
					resultSet.getString("address2"), resultSet.getString("city"), resultSet.getString("state"), resultSet.getString("zip"), 
					resultSet.getString("country"), resultSet.getString("date"));
			allUserInfo.add(userInfo);
		}
		return allUserInfo;
	}

	// You need to close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void submitUserInfo(UserInfo userInfo) {
		//Submits the users registration info to the database.
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			String connectionString = "jdbc:mysql://" + host + ":3306/?autoReconnect=true&useSSL=false";
			connect = DriverManager
					.getConnection(connectionString, user,  passwd);

			PreparedStatement prepStatement = connect.prepareStatement(SQL_INSERT);
			prepStatement.setInt(1, 0);
			prepStatement.setString(2, userInfo.firstName);
			prepStatement.setString(3, userInfo.lastName);
			prepStatement.setString(4, userInfo.address1);
			prepStatement.setString(5, userInfo.address2);
			prepStatement.setString(6, userInfo.city);
			prepStatement.setString(7, userInfo.state);
			prepStatement.setString(8, userInfo.zip);
			prepStatement.setString(9, userInfo.country);
			prepStatement.setString(10, userInfo.date);

			prepStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

}
