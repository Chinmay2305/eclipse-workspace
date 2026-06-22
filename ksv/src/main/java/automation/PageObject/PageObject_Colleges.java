package automation.PageObject;

import java.io.IOException;
import java.nio.file.attribute.AclFileAttributeView;
import java.time.Duration;
import java.util.Random;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import automation.BaseMethods.Controls;

public class PageObject_Colleges extends Controls
{
    private String createdCollegeId;
    private String createdCollegeName;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public PageObject_Colleges(WebDriver driver)
    {
        this.driver = driver;
    }

    public void openColleges() throws IOException, InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement academic_menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuprop.getProperty("academicstructure"))));
        academic_menu.click();
        WebElement collegeslink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuprop.getProperty("academic_college"))));
        collegeslink.click();
    }

    public void addColleges() throws InterruptedException
    {
        // Generate unique data
    	Random random = new Random();
    	int number = 1000 + random.nextInt(9000);
    	createdCollegeId = "C-" + number;
    	createdCollegeName = "Test College " + number;
    	System.out.println("Generated College ID   : " + createdCollegeId);
    	System.out.println("Generated College Name : " + createdCollegeName);

        // Fill form
        Controls.waitforvisibility(driver,By.xpath(collegesprop.getProperty("add_button")),30);
        Controls.type(By.xpath(collegesprop.getProperty("add_college_id")),createdCollegeId);
        Controls.type(By.xpath(collegesprop.getProperty("add_college_name")),createdCollegeName);
        Controls.type(By.xpath(collegesprop.getProperty("add_establish_year")),collegesprop.getProperty("establish_year_dataadd"));
        Controls.selectKendoDropdown(By.xpath(collegesprop.getProperty("add_campus")),collegesprop.getProperty("campus_dataadd"));
        Controls.clickElement(By.xpath(collegesprop.getProperty("save_button")));

        // Wait until grid is visible again
        Controls.waitforvisibility(driver,By.xpath(collegesprop.getProperty("search_bar")),30);

        // Search for newly added college
        WebElement searchBar = driver.findElement(By.xpath(collegesprop.getProperty("search_bar")));
        searchBar.clear();
        searchBar.sendKeys(createdCollegeId);

        // Wait for grid refresh
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(collegesprop.getProperty("collegeid_row1")),createdCollegeId));

        // Verify ID
        String actualCollegeId = driver.findElement(By.xpath(collegesprop.getProperty("collegeid_row1"))).getText().trim();
        System.out.println("Expected College ID : " + createdCollegeId);
        System.out.println("Actual College ID   : " + actualCollegeId);

        Assert.assertEquals(actualCollegeId,createdCollegeId,"College ID mismatch after save");

        // Verify Name
        String actualCollegeID = driver.findElement(By.xpath(collegesprop.getProperty("collegeid_row1"))).getText().trim();
        String actualCollegeName = driver.findElement(By.xpath(collegesprop.getProperty("collegename_row1"))).getText().trim();
        String actualCampusName = driver.findElement(By.xpath(collegesprop.getProperty("campusname_row1"))).getText().trim();
        
        Assert.assertEquals(actualCollegeID,createdCollegeId,"College ID mismatch after save");
        Assert.assertEquals(actualCollegeName,createdCollegeName,"College Name mismatch after save");
        Assert.assertEquals(actualCampusName, collegesprop.getProperty("campus_dataadd"),"Campus Name mismatch after save");
        
        System.out.println("College created and verified successfully.");
    }
    
    public void viewCollege() throws InterruptedException
    {
    	Controls.waitforvisibility(driver,By.xpath(collegesprop.getProperty("view_button")),30);
    	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(collegesprop.getProperty("view_college_id")),createdCollegeId));
    	WebElement collegeId = driver.findElement(By.xpath(collegesprop.getProperty("view_college_id")));
    	
    	Controls.confirmdata(By.xpath(collegesprop.getProperty("view_college_id")), createdCollegeId, "College ID");
    	Controls.confirmdata(By.xpath(collegesprop.getProperty("view_college_name")), createdCollegeName, "College Name");
    	Controls.confirmdata(By.xpath(collegesprop.getProperty("view_establish_year")), collegesprop.getProperty("establish_year_dataadd"), "Establish Year");
    	Controls.confirmdata(By.xpath(collegesprop.getProperty("view_campus")), collegesprop.getProperty("campus_dataadd"), "Campus");
    }
    
    public void editCollege() throws InterruptedException
    {
    	Controls.waitforvisibility(driver,By.xpath(collegesprop.getProperty("search_bar")),30);
    	WebElement searchBar = driver.findElement(By.xpath(collegesprop.getProperty("search_bar")));
        searchBar.clear();
        searchBar.sendKeys(createdCollegeId);
        // Wait for grid refresh
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(collegesprop.getProperty("collegeid_row1")),createdCollegeId));
    }
}