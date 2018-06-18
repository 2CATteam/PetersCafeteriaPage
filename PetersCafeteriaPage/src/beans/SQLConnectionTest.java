package beans;

import java.text.ParseException;

public class SQLConnectionTest
{
	public static void main(String[] args)
	{
		DishesInterface.createDish("Corn Dog", true);
		DishesInterface.createDish("Taquito", true);
		DishesInterface.createDish("Burger", true);
		DishesInterface.createDish("BBQ", true);
		DishesInterface.createDish("Burrito", true);
		DishesInterface.createDish("Burrito", false);
		
		System.out.println(DishesInterface.getDishNames(true));
		System.out.println(DishesInterface.getDishNames(false));
		
		try
		{
			DishInstance toTest1 = new DishInstance("Corn Dog", DishInstance.DATE_FORMATTER.parse("20010101"),true,true);
			DishInstance toTest2 = new DishInstance("Corn Dog", DishInstance.DATE_FORMATTER.parse("20010102"),true,true);
			DishInstance toTest3 = new DishInstance("Hamburger", DishInstance.DATE_FORMATTER.parse("20010101"),true,true);
			DishInstance toTest4 = new DishInstance("Burrito", DishInstance.DATE_FORMATTER.parse("20010101"),true,true);
			
			toTest1.setAmountPrepped(86);
			toTest1.setAmountLeft(1);
			toTest1.setTempStart(98.6);
			toTest1.setTempEnd(200.1);
			
			toTest2.setAmountPrepped(4);
			toTest2.setAmountLeft(5);
			toTest2.setTempStart(6);
			toTest2.setTempEnd(7);
			
			toTest3.setAmountPrepped(0);
			toTest3.setAmountLeft(0);
			toTest3.setTempStart(0);
			toTest3.setTempEnd(0);
			
			System.out.println(toTest1.dishName);
			System.out.println(toTest1.getDateMadeString());
			System.out.println(toTest1.getAmountPrepped());
			System.out.println(toTest1.getAmountLeft());
			System.out.println(toTest1.getTempStart());
			System.out.println(toTest1.getTempEnd());
			
			System.out.println(toTest4.dishName);
			
			//DataInterface.updateDish(toTest1, "AMOUNT_LEFT", 2);
			
			System.out.println(DataInterface.queryDishesOn("20010102", true));
			System.out.println(DataInterface.queryDishesBefore("20010102", true));
			System.out.println(DataInterface.servedWith(toTest1, true));
			System.out.println(DataInterface.lastServed(toTest2, true));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
}
