package automation;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenImages
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try
		{
			driver.get("https://dev.holadata.co.za");
			List<WebElement> images = driver.findElements(By.tagName("img"));

			for (WebElement image : images)
			{
				String src = image.getAttribute("src");
				if (src != null && !src.isEmpty())
				{
					if (isImageBroken(src))
					{
						System.out.println("Broken image found: " + src);
					}
					else
					{
						System.out.println("Valid image found: " + src);
					}
				}
			}
		}
		finally
		{
			driver.quit();
		}
	}

	private static boolean isImageBroken(String imageUrl)
	{
		try
		{
			URL url = new URL(imageUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000); // Set timeout for connection
			connection.setReadTimeout(5000); // Set timeout for reading response
			int responseCode = connection.getResponseCode();
			return responseCode != HttpURLConnection.HTTP_OK;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return true;
		}
	}
}