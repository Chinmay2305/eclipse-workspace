package sparta_console;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AcquisitionAndOtherDetails
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
		Thread.sleep(10000);
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/a")).click();
		driver.findElement(By.linkText("Assets")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[3]/div[1]/table/tbody/tr[1]/td[8]/div/ul/li/a")).click();
    }

    @Test(priority = 1)
    public void CO2T391_EditVerify() throws InterruptedException, NoSuchElementException
    {
    	driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/div/div/div/div[1]/div/div/div/button[2]/span[1]")).click();
    	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
    	By editiconlocator = By.xpath("/html/body/div[1]/div/div/section/div/div[2]/div/div/div/div[2]/div/p/span");
    	WebElement editicon = w.until(ExpectedConditions.visibilityOfElementLocated(editiconlocator));
    	editicon.click();
    	
    	Thread.sleep(3000);
    	WebElement acquisitiondate = driver.findElement(By.name("acquisition_date"));
    	WebElement tsnatacquisition = driver.findElement(By.name("tsn_at_acquisition"));
    	WebElement csnatacquisition = driver.findElement(By.name("csn_at_acquisition"));
    	WebElement acquiredfrom = driver.findElement(By.name("acquired_from"));
    	WebElement tslsv = driver.findElement(By.name("tslsv_at_acquisition"));
    	WebElement cslsv = driver.findElement(By.name("cslsv_at_acquisition"));
    	WebElement ctadate = driver.findElement(By.name("cta_exp_date"));
    	WebElement deliverydate = driver.findElement(By.name("delivery_date_to_current_operator"));
    	WebElement nextdeliverydate = driver.findElement(By.name("next_delivery_date"));
    	WebElement nextuse = driver.findElement(By.name("next_use"));
    	
    	String acqdate = "01-10-2024";
    	String tsn = "3";
    	String csn = "6";
    	String acquiredfromtext = "testing final";
    	String tslsvtext = "9";
    	String cslsvtext = "12";
    	String ctadatetext = "05-10-2024";
    	String deliverydatetext = "06-10-2024";
    	String nextdeliverydatetext = "25-10-2024";
    	String nextusetext = "Final test";
    	
    	acquisitiondate.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
    	acquisitiondate.sendKeys(acqdate);
    	tsnatacquisition.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
    	tsnatacquisition.sendKeys(tsn);
    	csnatacquisition.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
    	csnatacquisition.sendKeys(csn);
    	acquiredfrom.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
    	acquiredfrom.sendKeys(acquiredfromtext);
    	tslsv.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
    	tslsv.sendKeys(tslsvtext);
    	cslsv.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
    	cslsv.sendKeys(cslsvtext);
    	ctadate.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
    	ctadate.sendKeys(ctadatetext);
    	deliverydate.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
    	deliverydate.sendKeys(deliverydatetext);
    	nextdeliverydate.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
    	nextdeliverydate.sendKeys(nextdeliverydatetext);
    	nextuse.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
    	nextuse.sendKeys(nextusetext);
    	
    	driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/div/div/div/div[2]/div[2]/ul/li[2]/button")).click();
    	driver.findElement(By.cssSelector("body")).sendKeys(Keys.F5);
    	driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/div/div/div/div[1]/div/div/div/button[2]/span[1]")).click();
    	
    	String[] expected = {acqdate,tsn,csn,acquiredfromtext,tslsvtext,cslsvtext,ctadatetext,deliverydatetext,nextdeliverydatetext,nextusetext};
    	String[] actual = {acquisitiondate.getAttribute("value"),tsnatacquisition.getAttribute("value"),csnatacquisition.getAttribute("value"),acquiredfrom.getAttribute("value"),tslsv.getAttribute("value"),cslsv.getAttribute("value"),ctadate.getAttribute("value"),deliverydate.getAttribute("value"),nextdeliverydate.getAttribute("value"),nextuse.getAttribute("value")};
    	
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
    	
/*    @Test(priority = 2)
    public void testCaseTwo() {
        driver.get("https://example.com");
        System.out.println("Running Test Case 2: " + driver.getTitle());
    }

    @Test(priority = 3)
    public void testCaseThree() {
        driver.get("https://example.com");
        System.out.println("Running Test Case 3: " + driver.getTitle());
    }

/*    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}