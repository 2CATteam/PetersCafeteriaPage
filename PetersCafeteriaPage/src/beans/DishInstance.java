package beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DishInstance implements Comparable<DishInstance>, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3780090849779812589L;
	public final String dishName;
	private final Date dateMade;
	public final boolean isLunch;


	public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyyMMdd");
	private Integer amountPrepped;
	private Integer amountLeft;
	private Double tempStart;
	private Double tempEnd;
	
	private Boolean isMain;
	private String units;
	private DishInstance lastServedWith;
	private DishInstance lastServed;
	
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
		this(dishName, DATE_FORMATTER.parse(dateMade), isLunch, isNew);
	}
	
	public String getUnits()
	{
		if (units == null)
		{
			units = DishesInterface.getUnits(this);
		}
		return units;
	}
	
	public boolean isMain()
	{
		if (isMain == null)
		{
			isMain = DishesInterface.isMain(this);
		}
		return isMain;
	}
	
	public int numDefined()
	{
		int countDefined = 0;
		if (this.getAmountPrepped() != null)
		{
			++countDefined;
		}
		if (this.getAmountLeft() != null)
		{
			++countDefined;
		}
		if (this.getTempStart() != null)
		{
			++countDefined;
		}
		if (this.getTempEnd() != null)
		{
			++countDefined;
		}
		return countDefined;
	}
	
	public DishInstance lastServedWith()
	{
		if (lastServedWith == null)
		{
			lastServedWith = DataInterface.servedWith(this.lastServed(), isLunch);
		}
		return lastServedWith;
	}
	
	public DishInstance lastServed()
	{
		if (lastServed == null)
		{
			lastServed = DataInterface.lastServed(this.lastServed(), isLunch);
		}
		return lastServed;
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
	
	/**
	 * @return the dishName
	 */
	public String getDishName()
	{
		return dishName;
	}

	/**
	 * @return the dateFormatter
	 */
	public static SimpleDateFormat getDateFormatter()
	{
		return DATE_FORMATTER;
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
		if (this.isMain())
		{
			if (toCompare.isMain())
			{
				return toCompare.getDateMade().compareTo(this.getDateMade());
			}
			return -1;
		}
		else
		{
			if (toCompare.isMain())
			{
				return 1;
			}
			return toCompare.getDateMade().compareTo(this.getDateMade());
		}
		
	}
	
}
