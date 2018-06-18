package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DishesInterface
{
	public static Connection storedConnection = null;

	public static Connection getConnection() throws SQLException
	{
		if (storedConnection == null)
		{
			String hostName = "localhost";
			String dbName = "peterscafeteria";
			String userName = "root";
			String password = "2theDish!";
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}

			Connection conn = DriverManager.getConnection(connectionURL, userName, password);
			storedConnection = conn;
		}
		return storedConnection;
	}

	public static void createDish(String dishName, boolean isLunch)
	{
		String tableName;
		if (isLunch)
		{
			tableName = "lunch_dishes";
		}
		else
		{
			tableName = "breakfast_dishes";
		}
		try
		{
			String sql = "INSERT INTO " + tableName + " (DISH_NAME) VALUES(?)";
			PreparedStatement toExecute = getConnection().prepareStatement(sql);
			toExecute.setString(1, dishName);
			toExecute.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println(
				"Unable to insert new dish! It's possible that this dish already exists; dish information below:");
			System.out.println(dishName + ", isLunch: " + isLunch);
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getDishNames(boolean isLunch)
	{
		String tableName;
		if (isLunch)
		{
			tableName = "lunch_dishes";
		}
		else
		{
			tableName = "breakfast_dishes";
		}
		try
		{
			PreparedStatement toExecute = getConnection().prepareStatement("SELECT * FROM " + tableName);
			ResultSet rs = toExecute.executeQuery();
			ArrayList<String> toReturn = new ArrayList<String>();
			boolean shouldContinue = rs.isBeforeFirst();
			rs.next();
			while (shouldContinue)
			{
				toReturn.add(rs.getString("DISH_NAME"));
				shouldContinue = rs.next();
			}
			return toReturn;
		}
		catch (SQLException e)
		{
			System.out.println("Unable to get dishes; information below:");
			System.out.println("isLunch: " + isLunch);
			e.printStackTrace();
			System.out.println("Returning empty set");
			return new ArrayList<String>();
		}
	}
}
