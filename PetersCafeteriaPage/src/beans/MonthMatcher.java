package beans;

import java.io.Serializable;

public class MonthMatcher implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5946154274989832824L;
	public int number;
	public String name;
	public MonthMatcher(int toMatch)
	{
		this.number = toMatch;
		this.name = matchMonth(toMatch);
	}
	/**
	 * @return the number
	 */
	public int getNumber()
	{
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number)
	{
		this.number = number;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	public String matchMonth(int toMatch)
	{
		switch(toMatch)
		{
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			return "Unknown";
		}
	}
}
