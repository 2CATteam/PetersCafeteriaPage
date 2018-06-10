package dataContainer;

import java.util.Date;

public class Dish implements Comparable<Dish>
{
	/** The name of the dish */
	public final String dishName;

	/** The day the dish was served */
	public final Date dateServed;

	private Double temp = null;

	private Integer amountCooked = null;

	private Integer amountLeft = null;

	/**
	 * @param dishName
	 *            the dish's name
	 * @param dateServed
	 *            the day the dish was served
	 */
	public Dish(String dishName, Date dateServed)
	{
		this.dishName = dishName;
		this.dateServed = dateServed;
	}

	/**
	 * @return the temp
	 */
	public double getTemp()
	{
		return temp;
	}

	/**
	 * @param temp
	 *            the temp to set
	 */
	public void setTemp(double temp)
	{
		this.temp = temp;
	}

	/**
	 * @return the amountCooked
	 */
	public int getAmountCooked()
	{
		return amountCooked;
	}

	/**
	 * @param amountCooked
	 *            the amountCooked to set
	 */
	public void setAmountCooked(int amountCooked)
	{
		this.amountCooked = amountCooked;
	}

	/**
	 * @return the amountLeft
	 */
	public int getAmountLeft()
	{
		return amountLeft;
	}

	/**
	 * @param amountLeft
	 *            the amountLeft to set
	 */
	public void setAmountLeft(int amountLeft)
	{
		this.amountLeft = amountLeft;
	}

	@Override
	public int compareTo(Dish toCompare)
	{
		return dateServed.compareTo(toCompare.dateServed);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Dish: Name=" + dishName + ", dateServed=" + dateServed + ", temp=" + temp + ", amountCooked="
				+ amountCooked + ", amountLeft=" + amountLeft;
	}
}
