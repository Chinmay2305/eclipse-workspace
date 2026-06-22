package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage
{
	private WebDriver driver;
	private By firstResult = By.cssSelector("h3");
	public ResultsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String getFirstResultTitle()
	{
		return driver.findElement(firstResult).getText();
	}
}