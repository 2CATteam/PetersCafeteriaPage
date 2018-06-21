package beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.exceptions.CJCommunicationsException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class DishesInterface
{

	public static void createDish(String dishName, String units, boolean isMain, boolean isLunch)
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
			String sql = "INSERT INTO " + tableName + " (DISH_NAME, IS_MAIN, UNITS) VALUES(?, ?, ?)";
			PreparedStatement toExecute = Connector.getConnection().prepareStatement(sql);
			toExecute.setString(1, dishName);
			toExecute.setBoolean(2, isMain);
			toExecute.setString(3, units);
			toExecute.executeUpdate();
		}
		catch (CommunicationsException | CJCommunicationsException e)
		{
			createDish(dishName, units, isMain, isLunch);
		}
		catch (SQLException e)
		{
			System.out.println(
				"Unable to insert new dish! It's possible that this dish already exists; dish information below:");
			System.out.println(dishName + ", " + units + ", isMain: " + isMain + ", isLunch: " + isLunch);
			e.printStackTrace();
		}
	}

	public static void removeDish(String dishName, boolean isLunch)
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
			String sql = "DELETE FROM " + tableName + " WHERE DISH_NAME = ?";
			PreparedStatement toExecute = Connector.getConnection().prepareStatement(sql);
			toExecute.setString(1, dishName);
			toExecute.executeUpdate();
		}
		catch (CommunicationsException | CJCommunicationsException e)
		{
			removeDish(dishName, isLunch);
		}
		catch (SQLException e)
		{
			System.out.println("Unable to delete dish! Dish information below:");
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
			PreparedStatement toExecute = Connector.getConnection().prepareStatement("SELECT * FROM " + tableName);
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
		catch (CommunicationsException | CJCommunicationsException e)
		{
			return getDishNames(isLunch);
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

	public static boolean isMain(String dishName, boolean isLunch)
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
			String sql = "SELECT * FROM " + tableName + " WHERE DISH_NAME = ?";
			PreparedStatement toExecute = Connector.getConnection().prepareStatement(sql);
			toExecute.setString(1, dishName);
			ResultSet rs = toExecute.executeQuery();
			if (rs.next())
			{
				return rs.getBoolean("IS_MAIN");
			}
			else
			{
				throw new SQLException("Could not find value in DB");
			}
		}
		catch (CommunicationsException | CJCommunicationsException e)
		{
			return isMain(dishName, isLunch);
		}
		catch (SQLException e)
		{
			System.out.println("Unable to identify dish in DB. Query information below:");
			System.out.println(dishName + ", isLunch: " + isLunch);
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isMain(DishInstance toTest)
	{
		return isMain(toTest.dishName, toTest.isLunch);
	}

	public static String getUnits(String dishName, boolean isLunch)
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
			String sql = "SELECT * FROM " + tableName + " WHERE DISH_NAME = ?";
			PreparedStatement toExecute = Connector.getConnection().prepareStatement(sql);
			toExecute.setString(1, dishName);
			ResultSet rs = toExecute.executeQuery();
			if (rs.next())
			{
				return rs.getString("UNITS");
			}
			else
			{
				throw new SQLException("Could not find value in DB");
			}
		}
		catch (CommunicationsException | CJCommunicationsException e)
		{
			return getUnits(dishName, isLunch);
		}
		catch (SQLException e)
		{
			System.out.println("Unable to identify dish in DB. Query information below:");
			System.out.println(dishName + ", isLunch: " + isLunch);
			e.printStackTrace();
			return "units";
		}
	}

	public static String getUnits(DishInstance toTest)
	{
		return getUnits(toTest.dishName, toTest.isLunch);
	}
}
