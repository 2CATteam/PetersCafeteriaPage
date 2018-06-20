package beans;

import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class DataInterface
{

	public static void insertNewDish(DishInstance toInsert)
	{
		String tableName;
		if (toInsert.isLunch)
		{
			tableName = "lunch_history";
		}
		else
		{
			tableName = "breakfast_history";
		}
		try
		{
			PreparedStatement toExecute = Connector.getConnection()
				.prepareStatement("INSERT INTO " + tableName + " (DATE,DISH) VALUES(?, ?);");
			toExecute.setString(1, toInsert.getDateMadeString());
			toExecute.setString(2, toInsert.dishName);
			toExecute.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println("Unable to insert new Dish! Dish information below:");
			System.out.println(toInsert.toString());
			e.printStackTrace();
		}
	}

	public static void updateDish(DishInstance toUpdate, String toSet, double toAdd)
	{
		String tableName;
		if (toUpdate.isLunch)
		{
			tableName = "lunch_history";
		}
		else
		{
			tableName = "breakfast_history";
		}
		try
		{
			PreparedStatement toExecute = Connector.getConnection()
				.prepareStatement("UPDATE " + tableName + " SET " + toSet + " = ? WHERE DATE = ? AND DISH = ?");
			toExecute.setBigDecimal(1, new BigDecimal(toAdd, new MathContext(4)));
			toExecute.setString(2, toUpdate.getDateMadeString());
			toExecute.setString(3, toUpdate.dishName);
			toExecute.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println("Unable to update Dish! Dish information below:");
			System.out.println(toUpdate.toString());
			e.printStackTrace();
		}
	}

	public static void updateDish(DishInstance toUpdate, String toSet, int toAdd)
	{
		String tableName;
		if (toUpdate.isLunch)
		{
			tableName = "lunch_history";
		}
		else
		{
			tableName = "breakfast_history";
		}
		try
		{
			PreparedStatement toExecute = Connector.getConnection()
				.prepareStatement("UPDATE " + tableName + " SET " + toSet + " = ? WHERE DATE = ? AND DISH = ?");
			toExecute.setInt(1, toAdd);
			toExecute.setString(2, toUpdate.getDateMadeString());
			toExecute.setString(3, toUpdate.dishName);
			toExecute.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println("Unable to update Dish! Dish information below:");
			System.out.println(toUpdate.toString());
			e.printStackTrace();
		}
	}

	public static void deleteDish(DishInstance toDelete)
	{
		String tableName;
		if (toDelete.isLunch)
		{
			tableName = "lunch_history";
		}
		else
		{
			tableName = "breakfast_history";
		}
		try
		{
			PreparedStatement toExecute = Connector.getConnection()
				.prepareStatement("DELETE FROM " + tableName + " WHERE DATE = ? AND DISH = ?");
			toExecute.setString(1, toDelete.getDateMadeString());
			toExecute.setString(2, toDelete.dishName);
			toExecute.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println("Unable to delete Dish! Dish information below:");
			System.out.println(toDelete.toString());
			e.printStackTrace();
		}
	}

	public static ArrayList<DishInstance> queryDishesOn(Date onDate, boolean isLunch)
	{
		String dateString = DishInstance.DATE_FORMATTER.format(onDate);
		return queryDishesOn(dateString, isLunch);
	}

	public static ArrayList<DishInstance> queryDishesOn(String onDate, boolean isLunch)
	{
		String tableName;
		if (isLunch)
		{
			tableName = "lunch_history";
		}
		else
		{
			tableName = "breakfast_history";
		}
		try
		{
			PreparedStatement toExecute = Connector.getConnection()
				.prepareStatement("SELECT * FROM " + tableName + " WHERE DATE = ?");
			toExecute.setString(1, onDate);
			ResultSet rs = toExecute.executeQuery();
			ArrayList<DishInstance> toReturn = new ArrayList<>();
			DishInstance toAdd;
			boolean shouldContinue = rs.isBeforeFirst();
			rs.next();
			while (shouldContinue)
			{
				toAdd = new DishInstance(rs.getString("DISH"), rs.getDate("DATE"), isLunch, false);
				int toSet = rs.getInt("AMOUNT_PREPPED");
				if (!rs.wasNull())
				{
					toAdd.setAmountPrepped(toSet);
				}
				toSet = rs.getInt("AMOUNT_LEFT");
				if (!rs.wasNull())
				{
					toAdd.setAmountLeft(toSet);
				}
				if (rs.getBigDecimal("TEMP_START") != null)
				{
					toAdd.setTempStart(rs.getBigDecimal("TEMP_START").doubleValue());
				}
				if (rs.getBigDecimal("TEMP_END") != null)
				{
					toAdd.setTempEnd(rs.getBigDecimal("TEMP_END").doubleValue());
				}
				toReturn.add(toAdd);
				shouldContinue = rs.next();
			}
			Collections.sort(toReturn);
			return toReturn;

		}
		catch (SQLException e)
		{
			System.out.println("Unable to find Dish due to error! Query information below:");
			System.out.println(onDate + ", isLunch: " + isLunch);
			System.out.println("Returning empty ArrayList");
			e.printStackTrace();
			return new ArrayList<DishInstance>();
		}
	}

	public static ArrayList<DishInstance> queryDishesBefore(Date onDate, boolean isLunch)
	{
		String dateString = DishInstance.DATE_FORMATTER.format(onDate);
		return queryDishesBefore(dateString, isLunch);
	}

	public static ArrayList<DishInstance> queryDishesBefore(String onDate, boolean isLunch)
	{
		String tableName;
		if (isLunch)
		{
			tableName = "lunch_history";
		}
		else
		{
			tableName = "breakfast_history";
		}
		try
		{
			PreparedStatement toExecute = Connector.getConnection()
				.prepareStatement("SELECT * FROM " + tableName + " WHERE DATE < ?");
			toExecute.setString(1, onDate);
			ResultSet rs = toExecute.executeQuery();
			ArrayList<DishInstance> toReturn = new ArrayList<>();
			DishInstance toAdd;
			boolean shouldContinue = rs.isBeforeFirst();
			rs.next();
			while (shouldContinue)
			{
				toAdd = new DishInstance(rs.getString("DISH"), rs.getDate("DATE"), isLunch, false);
				int toSet = rs.getInt("AMOUNT_PREPPED");
				if (!rs.wasNull())
				{
					toAdd.setAmountPrepped(toSet);
				}
				toSet = rs.getInt("AMOUNT_LEFT");
				if (!rs.wasNull())
				{
					toAdd.setAmountLeft(toSet);
				}
				if (rs.getBigDecimal("TEMP_START") != null)
				{
					toAdd.setTempStart(rs.getBigDecimal("TEMP_START").doubleValue());
				}
				if (rs.getBigDecimal("TEMP_END") != null)
				{
					toAdd.setTempEnd(rs.getBigDecimal("TEMP_END").doubleValue());
				}
				toReturn.add(toAdd);
				shouldContinue = rs.next();
			}
			Collections.sort(toReturn);
			return toReturn;

		}
		catch (SQLException e)
		{
			System.out.println("Unable to find Dish due to error! Query information below:");
			System.out.println(onDate + ", isLunch: " + isLunch);
			System.out.println("Returning empty ArrayList");
			e.printStackTrace();
			return new ArrayList<DishInstance>();
		}
	}

	public static DishInstance lastServed(DishInstance toCompare, boolean isLunch)
	{
		ArrayList<DishInstance> beforeList = queryDishesBefore(toCompare.getDateMade(), isLunch);
		for (DishInstance toTest : beforeList)
		{
			if (toTest.dishName.equals(toCompare.dishName))
			{
				return toTest;
			}
		}
		return toCompare;
	}

	public static DishInstance servedWith(DishInstance toCompare, boolean isLunch)
	{
		ArrayList<DishInstance> toReturn = queryDishesOn(toCompare.getDateMade(), isLunch);
		for (int index = 0; index < toReturn.size(); ++index)
		{
			if (toReturn.get(index).isMain() && !toReturn.get(index).dishName.equals(toCompare.dishName))
			{
				return toReturn.get(index);
			}
		}
		return null;
	}
}
