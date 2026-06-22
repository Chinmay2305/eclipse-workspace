package automation.PageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.UserPromptClosed;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

import automation.BaseMethods.Controls;

public class PageObject_LLPValues extends Controls
{
	private WebDriver driver;
	private Properties pv;
	public PageObject_LLPValues(WebDriver driver)
	{
		this.driver = driver;
	}

	public void addllpvalue() throws InterruptedException, IOException
	{
		driver.get("https://qa.aerfinity.acumenaviation.in/settings/llp-values");
		Thread.sleep(2000);
		Controls.clickElement(By.xpath(llpvaluesprop.getProperty("addllpvaluesbutton")));
		driver.switchTo().activeElement();
		Controls.editText(By.xpath(llpvaluesprop.getProperty("enginefamily")), llpvaluesprop.getProperty("family"));
		Controls.editText(By.xpath(llpvaluesprop.getProperty("enginetype")), llpvaluesprop.getProperty("type"));
		Controls.type(By.xpath(llpvaluesprop.getProperty("llpname")), "value");
		Controls.editText(By.xpath(llpvaluesprop.getProperty("module")), "hpc");
		Controls.type(By.xpath(llpvaluesprop.getProperty("order")), "10");
		
/*		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Downloads\\Acumen\\IMP XLS Files\\Willis  - ESN 575194 - 5B MODEL 25-26 v1.8 - Rev 0.xlsx");
		HSSFWorkbook w = new HSSFWorkbook(fis);
		HSSFSheet s = w.getSheet("SUMMARY");*/
	}
}