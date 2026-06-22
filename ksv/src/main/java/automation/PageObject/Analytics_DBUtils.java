package automation.PageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.UserPromptClosed;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

import automation.BaseMethods.Controls;

public class Analytics_DBUtils
{
    private static Connection con;

    public static Connection connect() throws Exception {
    	System.setProperty("java.library.path", "C:\\Windows\\System32");
    	
        String url = "jdbc:sqlserver://119.226.82.140;databaseName=AerfinDevDWLiveQA;integratedSecurity=true;";
        String user = "db_user";
        String pass = "db_pass";

        con = DriverManager.getConnection(url);
        
        System.out.println("Connected Successfully using Windows Authentication!");

        return con;
    }

    public static int getTierCount(int tier) throws Exception {
        String query =
                "SELECT count(i.TIER) as count_qty " +
                "FROM ods.[view_Stock] i " +
                "JOIN ods.[view_PartsMaster] p ON i.PNM_AUTO_KEY = p.PNM_AUTO_KEY " +
                "WHERE i.WHS_CODE NOT LIKE 'CONS' " +
                "AND p.PART_CLASS_DESCRIPTION NOT IN ('Whole Aircraft', 'Whole Airframe', 'Whole Engine') " +
                "AND i.QTY_AVAILABLE > 0 " +
                "AND i.CNC_DESCRIPTION NOT LIKE '%pool%' " +
                "AND i.TIER = " + tier;

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        rs.next();
        return rs.getInt(1);
    }
}