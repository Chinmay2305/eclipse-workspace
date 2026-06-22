package components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.Controls;

public class Sort
{
	private WebDriver driver;
	Properties properties;
	Controls controls;
	
	public Sort(WebDriver driver, Controls controls)
	{
		this.driver=driver;
		this.controls=controls;
	}
	
	public void sort(String tablelocator, int columnindex) throws InterruptedException
	{
		properties=new Properties();
		try
		{
			FileInputStream input = new FileInputStream("resources/locators.properties");
			properties.load(input);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		Thread.sleep(3000);
		controls.setup(properties.getProperty("vendors_url"));
		controls.waitForElement(By.xpath(properties.getProperty("clickable")), 10);
		
		//1. Get the original data of the column 
		List<String> original = controls.getColumnData(tablelocator, columnindex);
		System.out.println(original);
		
		//2. Sort in ascending order and verify
		controls.sortColumn(tablelocator, columnindex);
		Thread.sleep(4000);
		List<String> ascendingdata = controls.getColumnData(tablelocator, columnindex);
		System.out.println(ascendingdata);
		if(controls.isSorted(ascendingdata, true))
		{
			System.out.println("Sorted in ascending order - passed");
		}
		else
		{
			System.out.println("Sorted in ascending order - failed");
		}
		
		//3. Sort in descending order and verify
		controls.sortColumn(tablelocator, columnindex);
		Thread.sleep(4000);
		List<String> descendingdata = controls.getColumnData(tablelocator, columnindex);
		System.out.println(descendingdata);
		if(controls.isSorted(descendingdata, false))
		{
			System.out.println("Sorted in descending order - passed");
		}
		else
		{
			System.out.println("Sorted in descending order - failed");
		}
	}
}