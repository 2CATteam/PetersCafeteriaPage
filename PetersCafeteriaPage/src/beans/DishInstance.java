package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DishInstance implements Comparable<DishInstance>
{
	public final String dishName;
	private final Date dateMade;
	public final boolean isLunch;
	public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyyMMdd");
	private Integer amountPrepped;
	private Integer amountLeft;
	private Double tempStart;
	private Double tempEnd;
	
	public DishInstance(String dishName, Date dateMade, boolean isLunch, boolean isNew)
	{
		this.dishName = dishName;
		this.dateMade = dateMade;
		this.isLunch = isLunch;
		if (isNew)
		{
			DataInterface.insertNewDish(this);
		}
	}
	
	public DishInstance(String dishName, String dateMade, boolean isLunch, boolean isNew) throws ParseException
	{
		this.dishName = dishName;
		this.dateMade = DATE_FORMATTER.parse(dateMade);
		this.isLunch = isLunch;
		if (isNew)
		{
			DataInterface.insertNewDish(this);
		}
	}

	/**
	 * @return the dateMade
	 */
	public Date getDateMade()
	{
		return dateMade;
	}
	
	public String getDateMadeString()
	{
		return DATE_FORMATTER.format(dateMade);
	}
	
	/**
	 * @return the amountPrepped
	 */
	public Integer getAmountPrepped()
	{
		return amountPrepped;
	}

	/**
	 * @param amountPrepped the amountPrepped to set
	 */
	public void setAmountPrepped(int amountPrepped)
	{
		this.amountPrepped = amountPrepped;
		DataInterface.updateDish(this, "AMOUNT_PREPPED", amountPrepped);
	}

	/**
	 * @return the amountLeft
	 */
	public Integer getAmountLeft()
	{
		return amountLeft;
	}

	/**
	 * @param amountLeft the amountLeft to set
	 */
	public void setAmountLeft(int amountLeft)
	{
		this.amountLeft = amountLeft;
		DataInterface.updateDish(this, "AMOUNT_LEFT", amountLeft);
	}

	/**
	 * @return the tempStart
	 */
	public Double getTempStart()
	{
		return tempStart;
	}

	/**
	 * @param tempStart the tempStart to set
	 */
	public void setTempStart(double tempStart)
	{
		this.tempStart = tempStart;
		DataInterface.updateDish(this, "TEMP_START", tempStart);
	}

	/**
	 * @return the tempEnd
	 */
	public Double getTempEnd()
	{
		return tempEnd;
	}

	/**
	 * @param tempEnd the tempEnd to set
	 */
	public void setTempEnd(double tempEnd)
	{
		this.tempEnd = tempEnd;
		DataInterface.updateDish(this, "TEMP_END", tempEnd);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DishInstance [dishName=" + dishName + ", dateMade=" + dateMade + " (" + this.getDateMadeString() + "), isLunch=" + isLunch
				+ ", amountPrepped=" + amountPrepped + ", amountLeft=" + amountLeft + ", tempStart=" + tempStart
				+ ", tempEnd=" + tempEnd + "]";
	}

	@Override
	public int compareTo(DishInstance toCompare)
	{
		return toCompare.getDateMade().compareTo(this.getDateMade());
	}
	
}
