package sparta_console;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.collect.ContiguousSet;

public class Assets
{
	public static void main(String[] args) throws InterruptedException, TimeoutException, NoSuchElementException, IOException, IllegalStateException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa.console.sparta.aero/login");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div[2]/div/div/div[1]/form/div/div/div[1]/div/div/input")).sendKeys("chinmay.agrawal@acumen.aero");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div[2]/div/div/div[1]/form/div/div/div[2]/div/div/input")).sendKeys("Abcde1234$");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div[2]/div/div/div[1]/form/div/div/div[5]/button")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/a")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/div/div[2]/ul/li[1]/div/button")).click();
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		
		Actions a = new Actions(driver);
		for(int i=0;i<5;i++)
		{
			a.sendKeys(Keys.DOWN).perform();
		}
		driver.switchTo().activeElement().click();
		
		File f = new File("C:\\Users\\Chinmay\\Downloads\\Softwares\\eclipse-workspace\\Acumen\\src\\sparta_console\\Components form - XPATHS.xls");
		FileInputStream fis = new FileInputStream(f);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet s = wb.getSheet("Sheet2");
		int rowcount = s.getLastRowNum()-s.getFirstRowNum()+1;
		
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		
		//XPATHS
		WebElement manufacturerbox = driver.findElement(By.xpath("//input[@id='manufacturer']"));
		WebElement componentserialnobox = driver.findElement(By.xpath("//input[@id='serial_number']"));
		WebElement componentnamebox = driver.findElement(By.xpath("//input[@id='component_name']"));
		WebElement dateofmanufacturebox = driver.findElement(By.xpath("//input[@id='date_of_manufacture']"));
		WebElement partnumberbox = driver.findElement(By.xpath("//input[@id='part_number']"));
		WebElement regionofoperationbox = driver.findElement(By.xpath("//input[@id='region']"));
		WebElement locationbox = driver.findElement(By.xpath("//input[@id='location']"));
//		WebElement ownershipbox = driver.findElement(By.xpath("//input[@id='mui-54319']"));
		WebElement leasestatusbox = driver.findElement(By.xpath("//input[@id='status']"));
		WebElement substatusbox =driver.findElement(By.xpath("//input[@id='sub_status']"));
		WebElement tsnbox = driver.findElement(By.xpath("//input[@id='tsn']"));
		WebElement csnbox = driver.findElement(By.xpath("//input[@id='csn']"));
		WebElement avgmonthlyhrsbox = driver.findElement(By.xpath("//input[@id='average_monthly_hours']"));
		WebElement avgmonthlycyclesbox = driver.findElement(By.xpath("//input[@id='average_monthly_cycles']"));
//		WebElement lesseebox = driver.findElement(By.xpath("//input[@id='lessee']"));
//		WebElement operatorsameaslessebox = driver.findElement(By.xpath("//input[@id='mui-73310']"));
		WebElement operatorbox = driver.findElement(By.xpath("//input[@id='operator']"));
		WebElement dateofsalebox = driver.findElement(By.xpath("//input[@id='sold_out_date']"));
		
		for(int i=1;i<=rowcount;i++)
		{
			for(Row r:s)
			{
				for(Cell c:r)
				{
					switch(c.getCellType())
					{
					case STRING:
						manufacturerbox.sendKeys(s.getRow(i).getCell(0).getStringCellValue());
						componentserialnobox.sendKeys(s.getRow(i).getCell(1).getStringCellValue());
						componentnamebox.sendKeys(s.getRow(i).getCell(2).getStringCellValue());
						dateofmanufacturebox.sendKeys(s.getRow(i).getCell(3).getStringCellValue());
						partnumberbox.sendKeys(s.getRow(i).getCell(4).getStringCellValue());
						regionofoperationbox.sendKeys(s.getRow(i).getCell(5).getStringCellValue());
						locationbox.sendKeys(s.getRow(i).getCell(6).getStringCellValue());
//						ownershipbox.sendKeys(s.getRow(i).getCell(7).getStringCellValue());
						leasestatusbox.sendKeys(s.getRow(i).getCell(8).getStringCellValue());
						dateofsalebox.sendKeys(s.getRow(i).getCell(9).getStringCellValue());
						substatusbox.sendKeys(s.getRow(i).getCell(10).getStringCellValue());
						tsnbox.sendKeys(s.getRow(i).getCell(11).getStringCellValue());
						csnbox.sendKeys(s.getRow(i).getCell(12).getStringCellValue());
						avgmonthlyhrsbox.sendKeys(s.getRow(i).getCell(13).getStringCellValue());
						avgmonthlycyclesbox.sendKeys(s.getRow(i).getCell(14).getStringCellValue());
//						lesseebox.sendKeys(s.getRow(i).getCell(15).getStringCellValue());
						
						//String lesseesameornot = s.getRow(i).getCell(16).getStringCellValue();
						//String operator = s.getRow(i).getCell(17).getStringCellValue();
						break;
					case NUMERIC:
						manufacturerbox.sendKeys(String.valueOf(s.getRow(i).getCell(0).getNumericCellValue()));
						componentserialnobox.sendKeys(String.valueOf(s.getRow(i).getCell(1).getNumericCellValue()));
						componentnamebox.sendKeys(String.valueOf(s.getRow(i).getCell(2).getNumericCellValue()));
						dateofmanufacturebox.sendKeys(String.valueOf(s.getRow(i).getCell(3).getNumericCellValue()));
						partnumberbox.sendKeys(String.valueOf(s.getRow(i).getCell(4).getNumericCellValue()));
						regionofoperationbox.sendKeys(String.valueOf(s.getRow(i).getCell(5).getNumericCellValue()));
						locationbox.sendKeys(String.valueOf(s.getRow(i).getCell(6).getNumericCellValue()));
	//					ownershipbox.sendKeys(String.valueOf(s.getRow(i).getCell(7).getNumericCellValue()));
						leasestatusbox.sendKeys(String.valueOf(s.getRow(i).getCell(8).getNumericCellValue()));
						dateofsalebox.sendKeys(String.valueOf(s.getRow(i).getCell(9).getNumericCellValue()));
						substatusbox.sendKeys(String.valueOf(s.getRow(i).getCell(10).getNumericCellValue()));
						tsnbox.sendKeys(String.valueOf(s.getRow(i).getCell(11).getNumericCellValue()));
						csnbox.sendKeys(String.valueOf(s.getRow(i).getCell(12).getNumericCellValue()));
						avgmonthlyhrsbox.sendKeys(String.valueOf(s.getRow(i).getCell(13).getNumericCellValue()));
						avgmonthlycyclesbox.sendKeys(String.valueOf(s.getRow(i).getCell(14).getNumericCellValue()));
//						lesseebox.sendKeys(String.valueOf(s.getRow(i).getCell(15).getNumericCellValue()));
						
					}
				}
			}
			
			
			
			/*
			
			componentserialnobox.sendKeys(componentserialno);
			componentnamebox.sendKeys(componentname);
			dateofmanufacturebox.sendKeys(dateofmanufacture);
			partnumberbox.sendKeys(partnumber);
			regionofoperationbox.sendKeys(regionofoperation, Keys.DOWN, Keys.ENTER);
			locationbox.sendKeys(location);
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
			w.until(ExpectedConditions.visibilityOfElementLocated(By.className("suggestion-item")));
				
			List<WebElement> suggestions = driver.findElements(By.className("suggestion-item"));
			for(WebElement suggestion:suggestions)
			{
				if(suggestion.getText().contains(location))
				{
					suggestion.click();
					break;
				}
			}
			
			Thread.sleep(2000);
			ownershipbox.sendKeys(ownership, Keys.DOWN, Keys.ENTER);
			leasestatusbox.sendKeys(leasestatus, Keys.DOWN, Keys.ENTER);
			if(leasestatus.equalsIgnoreCase("sold"))
			{
				dateofsalebox.sendKeys(dateofsale);
				substatusbox.sendKeys(substatus, Keys.DOWN, Keys.ENTER);
				tsnbox.sendKeys(tsn);
				csnbox.sendKeys(csn);
				avgmonthlyhrsbox.sendKeys(avgmonthlyhours);
				avgmonthlycyclesbox.sendKeys(avgmonthlycycles);				
			}
			else if(leasestatus.equalsIgnoreCase("on lease"))
			{
				substatusbox.sendKeys(substatus, Keys.DOWN, Keys.ENTER);
				tsnbox.sendKeys(tsn);
				csnbox.sendKeys(csn);
				avgmonthlyhrsbox.sendKeys(avgmonthlyhours);
				avgmonthlycyclesbox.sendKeys(avgmonthlycycles);
				lesseebox.sendKeys(lessee);
				operatorsameaslessebox.sendKeys(lesseesameornot);
				if(lesseesameornot.equalsIgnoreCase("No"))
				{
					operatorbox.sendKeys(operator);
				}
				else
				{
					continue;
				}
			}
			
			
		
		*/
//		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/button[2]")).click();
		}
	}
}