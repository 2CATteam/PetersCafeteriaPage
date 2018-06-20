package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;

public class Connector
{
	public static Connection storedConnection;

	public static Connection getConnection() throws SQLException
	// mysql://b7b7124cc8043b:1f0108f2@us-cdbr-iron-east-04.cleardb.net/heroku_aca051f453e3673?reconnect=true
	{
		Boolean haveConnection = false;
		try
		{
			Statement testStatement = storedConnection.createStatement();
			testStatement.executeQuery("SELECT * FROM lunch_dishes");
			haveConnection = true;
		}
		catch (SQLNonTransientConnectionException e)
		{
			haveConnection = false;
		}
		catch (NullPointerException e)
		{
			haveConnection = false;
		}
		if (haveConnection)
		{
			String hostName = "us-cdbr-iron-east-04.cleardb.net";
			String dbName = "heroku_aca051f453e3673";
			String userName = "b7b7124cc8043b";
			String password = "1f0108f2";
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

			try
			{
				Connection conn = DriverManager.getConnection(connectionURL, userName, password);
				storedConnection = conn;
				return storedConnection;
			}
			catch (SQLException e)
			{
				System.out.println("Unable to get connection... That kinda sucks, huh?");
				e.printStackTrace();
				return null;
			}
		}
		return storedConnection;
	}
}
