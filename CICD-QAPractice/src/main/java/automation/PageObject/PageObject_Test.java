package automation.PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.By;
import automation.BaseMethods.Controls;

public class PageObject_Test extends Controls
{
	private Properties pl;
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public PageObject_Test(WebDriver driver, Properties pl)
	{
		this.pl = pl;
	}
	
	public void test() throws IOException, InterruptedException
	{
		System.out.println("FIRST JENKINS TEST");
		
	    String e1text = "Employee Name";
	    String e2text = "Timesheet Period";
	    String e3text = "Actions";

	    WebElement texttest = w.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath(homeprop.getProperty("text1"))
	        )
	    );

	    Reporter.log("Actual Text: " + texttest.getText(), true);
	    Reporter.log("Expected Text: " + e1text, true);

	    Assert.assertEquals(
	            texttest.getText().trim(),
	            e1text,
	            "TEXT MISMATCH DETECTED!"
	    );
	}
	
	public void tabletest()
	{
		int rowtocheck = 2;
		int percent = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr["+rowtocheck+"]/td[3]")).getText().toString());
		String name = driver.findElement(By.xpath("//table/tbody/tr["+rowtocheck+"]/td[2]")).getText().toString();
		String result = driver.findElement(By.xpath("//table/tbody/tr["+rowtocheck+"]/td[4]")).getText().toString();
		boolean expectedFail = percent < 80;

		assert (expectedFail && result.equalsIgnoreCase("FAIL")) ||
		       (!expectedFail && result.equalsIgnoreCase("PASS")) : "IT IS WRONG.";

		System.out.println("IT IS CORRECT.");
	}
}