package framework;

import org.apache.log4j.xml.DOMConfigurator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.HomePage;
import appModules.SignInAction;
import utility.Constants;
import utility.ExcelUtils;
import utility.Log;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BasePage {

	private static WebDriver driver = null;

	@BeforeMethod
	public void beforeMethod() throws Exception {

		// Provide Log4j configuration settings
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Selenium_Test_001.");

		// This is to open the Excel file. Excel path, file name and sheet name are parameters to this method
		ExcelUtils.setExcelFile(Constants.filePath + Constants.fileName, "Sheet1");
		Log.info("Excel sheet opened.");

		driver = new FirefoxDriver();
		Log.info("New driver instantiated.");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds.");

		driver.get(Constants.URL);
		Log.info("Web application launched.");

	}

	@Test
	public static void main() throws Exception {		

		SignInAction.Execute(driver);
		System.out.println("Successfully opened the website cafetownsend-angular-rails.herokuapp.com");

		Thread.sleep(5000);
		Log.info("Waiting 5 seconds before log out the application.");

		HomePage.Logout(driver).click();
		Log.info("Click action is performed on main page.");

	}

	@AfterMethod
	public void afterMethod() throws Exception {
		driver.quit();
		Log.info("Browser closed.");


		// This is to send the PASS value to the Excel sheet in the result column.
		ExcelUtils.setCellData("Pass", 1, 3);

		Log.endTestCase("Selenium_Test_001.");
	}

}
