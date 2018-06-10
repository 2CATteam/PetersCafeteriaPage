package dataContainer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class DataContainer
{
	private ArrayList<Dish> dishList;

	private File file;

	public final SimpleDateFormat dateFormat;

	public DataContainer(String filename)
	{
		this.dishList = new ArrayList<Dish>();
		dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		file = new File(filename);

		try
		{
			file.createNewFile();
			BufferedReader br = new BufferedReader(new FileReader(file));
			String nextLine = br.readLine();
			while (nextLine != null)
			{
				addByString(nextLine);
				nextLine = br.readLine();
			}
			Collections.sort(dishList);
			br.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The file was not found. Which really sucks, since the code was supposed to create it.");
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			System.out.println("Unable to parse data in text sheet. It's there, it's just ugly.");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("Unable to access file for loading. It may be there, but we can't access it.");
			e.printStackTrace();
		}
	}

	private void addByString(String toParse) throws ParseException
	{
		String[] toSave = toParse.split(",");
		Dish toAdd = new Dish(toSave[0], dateFormat.parse(toSave[1]));
		if (toSave[2] != "null")
		{
			toAdd.setTemp(Double.parseDouble(toSave[3]));
		}
		if (toSave[3] != "null")
		{
			toAdd.setAmountCooked(Integer.parseInt(toSave[3]));
		}
		if (toSave[4] != "null")
		{
			toAdd.setAmountLeft(Integer.parseInt(toSave[4]));
		}
		dishList.add(toAdd);
	}
	
	public void addByDish(Dish toAdd, boolean overwrite)
	{
		if (overwrite)
		{
			
		}
		else 
		{
			dishList.add(toAdd);
		}
		Collections.sort(dishList);
	}

	public void saveToFile(String filename)
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false));
			for (Dish toSave : dishList)
			{
				bw.write(toSave.dishName + "," + dateFormat.format(toSave.dateServed) + "," + toSave.getTemp() + ","
						+ toSave.getAmountCooked() + "," + toSave.getAmountLeft());
			}
			bw.close();
		}
		catch (IOException e)
		{
			System.out.println("Unable to access file for saving. It may be there, but we can't access it.");
			e.printStackTrace();
		}
	}
}