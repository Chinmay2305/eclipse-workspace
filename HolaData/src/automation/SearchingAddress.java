package automation;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchingAddress
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.holadata.co.za");
		driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div/div/div/div/input")).sendKeys("Cape Town");
		Thread.sleep(3000);
		List<WebElement> suggestions = driver.findElements(By.cssSelector("body > div:nth-child(17) > section.overflow-hidden > div > div.absolute.z-\\[9999\\].top-\\[30\\%\\].md\\:top-\\[35\\%\\].md\\:left-\\[10\\%\\].p-6.md\\:p-0.transform.-translate-y-1\\/2.aos-init.aos-animate > div > div > div > div > div"));
		
		if(suggestions.size()>0)
		{
			Random r = new Random();
			WebElement randomsuggestion = suggestions.get(r.nextInt(suggestions.size()));
			randomsuggestion.click();
			System.out.println(randomsuggestion.getText());
			driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div/button")).click();
		}

		
		
/*		driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div/div/div/div/input")).sendKeys(Keys.DOWN, Keys.ENTER);
		Thread.sleep(3000);
		String searchedtext = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div/div/div/div/input")).getText().toString();
		driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div/button")).click();
		System.out.println(searchedtext);
*/
	}
}