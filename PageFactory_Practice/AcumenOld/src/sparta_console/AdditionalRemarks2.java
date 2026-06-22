package sparta_console;

import java.util.List;
import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.NoSuchElementException;

public class AdditionalRemarks2
{
	private WebDriver driver;
	
    @BeforeClass
    public void setUp() throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa.console.sparta.aero/login");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div[2]/div/div/div[1]/form/div/div/div[1]/div/div/input")).sendKeys("chinmay.agrawal@acumen.aero");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div[2]/div/div/div[1]/form/div/div/div[2]/div/div/input")).sendKeys("Abcde1234$");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div[2]/div/div/div[1]/form/div/div/div[5]/button")).click();
		Thread.sleep(20000);
		try
		{
			driver.findElement(By.linkText("Assets")).click();
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			WebElement classes = w.until(ExpectedConditions.visibilityOfElementLocated(By.className("MuiButtonBase-root.MuiTab-root.MuiTab-textColorInherit.MuiTab-fullWidth")));
			List<WebElement> buttons = driver.findElements(By.className("MuiButtonBase-root.MuiTab-root.MuiTab-textColorInherit.MuiTab-fullWidth"));
			for(WebElement btn:buttons)
			{
				if(btn.getText().contains("COMPONENT"))
				{
					btn.click();
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[3]/div[1]/table/tbody/tr[1]/td[8]/div/ul/li/a")).click();
    }

    @Test(priority = 1)
    public void CO2T369_AddRemarks() throws InterruptedException, NoSuchElementException
    {
    	driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[1]/div[3]/a")).click();
    	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
    	By addiconlocator = By.xpath("/html/body/div[1]/div/div/section/div/div[2]/div/div[1]/div/div[2]/ul/li[1]/button");
    	WebElement addicon = w.until(ExpectedConditions.visibilityOfElementLocated(addiconlocator));
    	addicon.click();
    	
    	Thread.sleep(3000);
    	driver.switchTo().activeElement();
    	WebElement textarea = driver.findElement(By.name("remarks"));
    	String remark = "Done";
    	WebElement savebtn = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[3]/button[2]"));
    	String user = driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[2]/div/div[2]/span/div[2]/ul/li[1]/h5")).getText().toString();
    	textarea.sendKeys(remark);
    	savebtn.click();
    	LocalDate currentDate = LocalDate.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
    	String currentdate = currentDate.format(formatter);
    	
    	Thread.sleep(3000);
    	String writtenremark = driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")).getText().toString();
    	String writtennameanddate = driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/div/div[2]/table/tbody/tr/td[3]")).getText().toString();
    	String[] lines = writtennameanddate.split("\n");
    	Thread.sleep(3000);
    	String[] expected = {remark,user,currentdate};	//remark - from string remark ; user - from username on top; currentdate - from current date
    	String[] actual = {writtenremark,lines[0],lines[1]};
    	
    	for(int i=0;i<expected.length;i++)
    	{
    		if(expected[i].equals(actual[i]))
    		{
    			System.out.println("Element matches");
    		}
    		else
    		{
    			System.out.println("Element does not match");
    		}
    	}
    	
    }
    	
    @Test(priority = 2)
    public void CO2T370_EditRemarks()
    {
    	
    }

/*    @Test(priority = 3)
    public void testCaseThree() {
        driver.get("https://example.com");
        System.out.println("Running Test Case 3: " + driver.getTitle());
    }
*/
    @AfterClass
    public void tearDown()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }
}