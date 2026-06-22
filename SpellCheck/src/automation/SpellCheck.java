package automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpellCheck
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try
		{
			driver.get("http://qa.aerfinity.acumenaviation.in/");
			Thread.sleep(3000);
			driver.findElement(By.name("email")).sendKeys("support@acumen.aero");
			driver.findElement(By.name("password")).sendKeys("Acumen@123");
			driver.findElement(By.xpath("//button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-containedPrimary') and contains(@class, 'MuiButton-fullWidth')]")).click();
			Thread.sleep(3000);
			driver.get("https://qa.aerfinity.acumenaviation.in/settings/aircraft-family");
			driver.get("https://en.wikipedia.org/wiki/Commonly_misspelled_English_words");
			Thread.sleep(3000);
			List<WebElement> textElements = driver.findElements(By.xpath("//body//*[normalize-space(text())]"));
			List<String> allWords = new ArrayList<String>();
			for(WebElement element:textElements)
			{
				String text = element.getText().trim();
				if(!text.isEmpty())
				{
					String[] words = text.split("\\s+");
					for(String word:words)
					{
						allWords.add(word);
					}
				}
			}
			
			for(String word:allWords)
			{
				if(!isWordSpelledCorrectly(driver, word))
				{
					System.out.println(word);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean isWordSpelledCorrectly(WebDriver driver, String word)
	{
		try
		{
			driver.get("https://www.google.com/search?q="+word);
			List<WebElement> suggestionElements = driver.findElements(By.xpath("//a[contains(text(),'Did you mean')]"));
			return suggestionElements.isEmpty();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}