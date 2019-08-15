package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import utility.Constants;
import utility.ExcelUtils;
import utility.Log;

import org.testng.annotations.AfterSuite;

public class Setup {

	public static WebDriver driver;
	public static WebElement employeeName;
	public static int rowNum = 1;
	public static String sUsername;
	public static String sPassword;
    public static String sFirstName; 
    public static String sLastName;
    public static String sLastNameChanged;
    public static String sStartDate;
    public static String sEmail;

	@BeforeSuite
	public void startUp() throws Exception {
		driver = new FirefoxDriver();
		Log.info("New driver instantiated.");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds.");

		driver.get(Constants.URL);
		Log.info("Web application launched.");
	}

	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();
		Log.info("Browser closed.");

		ExcelUtils.setCellData(sLastName, rowNum, 4);
		Log.info("Last name restored to its original value in Excel.");
	}
}
