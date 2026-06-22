package automation;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinks
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.holadata.co.za");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		// Check each link
		for (WebElement link : links)
		{
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty())
			{
				try
				{
					HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
					httpURLConnection.setRequestMethod("HEAD");
					httpURLConnection.setConnectTimeout(3000); // Set timeout as per your need
					httpURLConnection.connect();

					int responseCode = httpURLConnection.getResponseCode();
					if (responseCode >= 400)
					{
						System.out.println("Broken link: " + url + " (Response Code: " + responseCode + ")");
					}
					else
					{
						System.out.println("Valid link: " + url + " (Response Code: " + responseCode + ")");
					}
				}
				catch (IOException e)
				{
					System.out.println("Error checking link: " + url + " (" + e.getMessage() + ")");
				}
			}
		}
	driver.quit();
	}
}