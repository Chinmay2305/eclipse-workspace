package automation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CMS_Customer_add
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://devadmin.holadata.co.za");
		driver.findElement(By.xpath("/html/body/section/div/div[2]/div/form/div[1]/input")).sendKeys("abhishek@gmail.com");
		driver.findElement(By.xpath("/html/body/section/div/div[2]/div/form/div[3]/input")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/section/div/div[2]/div/form/button")).click();
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String accounttype = "Home";
		String title = "Mr";
		String fn = "Chinmay";
		String ln = "Agrawal";
		String contact = "8238997664";
		String email = "chinmay@avdevs.com";
		String idtype = "Company Number";
		String idnumber = "2468";
		String location = "Dublin, South Africa";
		
		try
		{
//			WebElement customers = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[2]/a")));
//			customers.click();	
		}
		
		catch(Exception e)
		{
			System.out.println("Not found");
		}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[1]/button")).click();
		Thread.sleep(3000);
		if(accounttype.equals("Home"))
		{
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/section/div/div[2]/div/form/div[1]/div/input[1]")).click();
		}
		else
		{
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/section/div/div[2]/div/form/div[1]/div/input[2]")).click();
		}
		Select titledd = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/section/div/div[2]/div/form/div[2]/div[1]/select")));
		titledd.selectByVisibleText(title);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/section/div/div[2]/div/form/div[2]/div[2]/div[1]/input")).sendKeys(fn);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/section/div/div[2]/div/form/div[2]/div[2]/div[2]/input")).sendKeys(ln);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/section/div/div[2]/div/form/div[2]/div[3]/input")).sendKeys(contact);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/section/div/div[2]/div/form/div[2]/div[4]/input")).sendKeys(email);
		
		Select idtypedd = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/section/div/div[2]/div/form/div[2]/div[5]/select")));
		idtypedd.selectByVisibleText(idtype);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/section/div/div[2]/div/form/div[2]/div[6]/input")).sendKeys(idnumber);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/section/div/div[2]/div/form/button")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/section/div/div[2]/div/div/div/div/div/form/div[1]/div/div/input")).sendKeys(location);
		Thread.sleep(3000);
		List<WebElement> suggestions = driver.findElements(By.cssSelector("body > div.flex > div.w-full.md\\:w-\\[80\\%\\].bg-gray-bg.h-screen.overflow-y-auto > div.px-4.md\\:px-8.pt-0.pb-0.overflow-y-auto.h-\\[calc\\(100\\%-160px\\)\\] > section > div > div:nth-child(2) > div > div > div > div > div > form > div:nth-child(2) > div > div > div"));
		
		if(suggestions.size()>0)
		{
			Random r = new Random();
			WebElement randomsuggestion = suggestions.get(r.nextInt(suggestions.size()));
			randomsuggestion.click();
			System.out.println(randomsuggestion.getText());
		}
	}
}