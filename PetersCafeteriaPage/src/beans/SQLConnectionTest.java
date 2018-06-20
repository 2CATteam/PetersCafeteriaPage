package beans;

import java.text.ParseException;

public class SQLConnectionTest
{
	public static void main(String[] args)
	{
		DishesInterface.createDish("Corn Dog", "items", true, true);
		DishesInterface.createDish("Taquito", "items", true, true);
		DishesInterface.createDish("Burger", "items",true, true);
		DishesInterface.createDish("BBQ", "lbs.", true, true);
		DishesInterface.createDish("Burrito", "items", true, true);
		DishesInterface.createDish("Burrito", "items", true, false);
		
		System.out.println(DishesInterface.getDishNames(true));
		System.out.println(DishesInterface.getDishNames(false));
		
		try
		{
			DishInstance toTest1 = new DishInstance("Corn Dog", DishInstance.DATE_FORMATTER.parse("20180618"),true,true);
			DishInstance toTest2 = new DishInstance("Corn Dog", DishInstance.DATE_FORMATTER.parse("20180618"),true,true);
			DishInstance toTest3 = new DishInstance("Burger", DishInstance.DATE_FORMATTER.parse("20180618"),true,true);
			DishInstance toTest4 = new DishInstance("Burrito", DishInstance.DATE_FORMATTER.parse("20180618"),true,true);
			DishInstance toTest5 = new DishInstance("Corn Dog", DishInstance.DATE_FORMATTER.parse("20180617"),true,true);
			DishInstance toTest6 = new DishInstance("Corn Dog", DishInstance.DATE_FORMATTER.parse("20180617"),true,true);
			DishInstance toTest7 = new DishInstance("Burger", DishInstance.DATE_FORMATTER.parse("20180617"),true,true);
			DishInstance toTest8 = new DishInstance("Burrito", DishInstance.DATE_FORMATTER.parse("20180617"),true,true);
			
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
			
			toTest5.setAmountPrepped(86);
			toTest5.setAmountLeft(1);
			toTest5.setTempStart(98.6);
			toTest5.setTempEnd(200.1);
			
			toTest6.setAmountPrepped(4);
			toTest6.setAmountLeft(5);
			toTest6.setTempStart(6);
			toTest6.setTempEnd(7);
			
			toTest7.setAmountPrepped(0);
			toTest7.setAmountLeft(0);
			toTest7.setTempStart(0);
			toTest7.setTempEnd(0);
			
			System.out.println(toTest1.dishName);
			System.out.println(toTest1.getDateMadeString());
			System.out.println(toTest1.getAmountPrepped());
			System.out.println(toTest1.getAmountLeft());
			System.out.println(toTest1.getTempStart());
			System.out.println(toTest1.getTempEnd());
			
			System.out.println(toTest4.dishName);
			System.out.println(toTest5.dishName);
			System.out.println(toTest6.dishName);
			System.out.println(toTest7.dishName);
			System.out.println(toTest8.dishName);
			
			//DataInterface.updateDish(toTest1, "AMOUNT_LEFT", 2);
			
			System.out.println(DataInterface.queryDishesOn("20180617", true));
			System.out.println(DataInterface.queryDishesBefore("20180618", true));
			System.out.println(DataInterface.servedWith(toTest1, true));
			System.out.println(DataInterface.lastServed(toTest2, true));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
}
