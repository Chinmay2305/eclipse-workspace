package automation.PageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import automation.BaseMethods.Controls;

public class PageObject_PartsMaster extends Controls
{
	private Properties pm;
	public PageObject_PartsMaster(WebDriver driver)
	{
		this.driver = driver;
	}

	public void sorting() throws InterruptedException
	{
		driver.get("https://qa.aerfinity.acumenaviation.in/settings/part-master");
		List<WebElement> columns = driver.findElements(By.xpath("//table/thead/tr/th"));
		int columnCount = columns.size();
		Thread.sleep(5000);
		Sort(columnCount, true);
	//	SortOneColumn(2, false);
	}
	
	public void multiplefilter() throws InterruptedException
	{
		driver.get("https://qa.aerfinity.acumenaviation.in/settings/part-master");
		Thread.sleep(5000);
		Controls.clickElement(By.xpath(partsmasterprop.getProperty("filter_btn")));
		
		String[] fields = {"pn","pndesc","appcode","fleettype"};
		for(String field: fields)
		{
			Controls.confirmdata(By.xpath(partsmasterprop.getProperty("filter_"+field+"_title_locator")), partsmasterprop.getProperty("filter_"+field+"_title"), "Filter "+field+" title");
			Controls.confirmplaceholders(By.xpath(partsmasterprop.getProperty("filter_"+field)), partsmasterprop.getProperty("filter_"+field+"_placeholder"), "Filter "+field);
		}
		
		//NOW FILTERING
		String[] attributes = {"pndesc","appcode"};
		String[][] filterdatasets = {
				{"valve"},{"A220","A320 ceo fam","a320 neo fam","a330 ceo fam","a330 neo fam"}
		};
		
		String[] filterInputLocators = new String[attributes.length];
		By[] tableColumnLocators = new By[attributes.length];
		
		for(int i=0;i<attributes.length;i++)
		{
			filterInputLocators[i] = partsmasterprop.getProperty("filter_"+attributes[i]);
			tableColumnLocators[i] = By.xpath(partsmasterprop.getProperty("column_"+attributes[i]));
		}
				
		applyVerifyMultipleFilters(
			    By.xpath(partsmasterprop.getProperty("filter_btn")),
			    filterInputLocators,
			    filterdatasets,
			    new boolean[] {false,false},	//for date fields - false for non-date fields & true for date fields
			    By.xpath(partsmasterprop.getProperty("filter_apply")),
			    tableColumnLocators,
			    attributes
			);
	}
	
	public List<List<String>> getWebTableData(By tablelocator)
	{
		WebElement table = driver.findElement(By.xpath(partsmasterprop.getProperty("tablelocator")));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<List<String>> tableData = new ArrayList<>();
		for(WebElement row:rows)
		{
			List<WebElement> cells = row.findElements(By.tagName("td"));
			List<String> rowData = new ArrayList<>();
			for(WebElement cell:cells)
			{
				rowData.add(cell.getText().trim());
			}
			tableData.add(rowData);
		}
		System.out.println("From the getWebTableData: "+tableData);
		return tableData;
	}
}