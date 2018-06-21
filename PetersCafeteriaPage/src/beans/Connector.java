package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector
{
	public static Connection storedConnection;

	public static Connection getConnection() throws SQLException
	// mysql://b7b7124cc8043b:1f0108f2@us-cdbr-iron-east-04.cleardb.net/heroku_aca051f453e3673?reconnect=true
	{
		if (storedConnection == null)
		{
			String hostName = "us-cdbr-iron-east-04.cleardb.net";
			String dbName = "heroku_aca051f453e3673";
			String userName = "b7b7124cc8043b";
			String password = "1f0108f2";
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?autoReconnect=true";

			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(connectionURL, userName, password);
				storedConnection = conn;
			}
			catch (SQLException e)
			{
				System.out.println("Unable to get connection... That kinda sucks, huh?");
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				System.out.println("Unable to get connection... Class not found.");
				e.printStackTrace();
			}
		}
		if (storedConnection == null)
		{
			System.out.println("Still no connection");
		}
		return storedConnection;
	}
}
