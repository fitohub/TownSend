package framework;

import org.apache.log4j.xml.DOMConfigurator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import appModules.SignInAction;
import appModules.CreateAction;
import appModules.DeleteAction;
import appModules.UpdateAction;
import appModules.ReadAction;
import pageObjects.HomePage;
import utility.Constants;
import utility.ExcelUtils;
import utility.Log;
import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import java.lang.reflect.Method;

public class BasePage {

	private static WebDriver driver = null;
	private static int rowNum = 1;
	private static String TestCaseName;

	@BeforeClass
	public void Launch() throws Exception {

		// Provide Log4j configuration settings
		DOMConfigurator.configure("log4j.xml");

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


	@Test (description="Access application with a valid credential.", priority=0)
	public static void SignIn() throws Exception {	
		
		//TestCaseName = ExcelUtils.getCellData(rowNum, 0);
		Log.startTestCase("SignIn");

		SignInAction.ExecuteSignIn(driver, rowNum);
		System.out.println("Successfully opened the website " + Constants.URL);

		Thread.sleep(2000);
		Log.info("Waiting 2 seconds before log out the application.");

		Log.endTestCase(TestCaseName);
	}
	
	@Test (description="Creates a new employee.", priority=1)
	public static void Create() throws Exception {
//		TestCaseName = ExcelUtils.getCellData(rowNum, 0);

//		Log.startTestCase(method.getName());
//		Log.startTestCase(TestCaseName);
		Log.startTestCase("Create");
		
		CreateAction.ExecuteCreate(driver, rowNum);

		Thread.sleep(2000);
		Log.info("Waiting 2 seconds before log out the application.");

		Log.endTestCase(TestCaseName);
	}	

	@Test (description="Read an employee information.", priority=2)
	public static void Read() throws Exception {
//		TestCaseName = ExcelUtils.getCellData(rowNum, 0);

//		Log.startTestCase(method.getName());
//		Log.startTestCase(TestCaseName);
		Log.startTestCase("Read");
		
		ReadAction.ExecuteRead(driver, rowNum);

		Thread.sleep(2000);
		Log.info("Waiting 2 seconds before log out the application.");

		Log.endTestCase(TestCaseName);
	}	

	@Test (description="Updates an employee.", priority=3)
	public static void Update() throws Exception {
//		TestCaseName = ExcelUtils.getCellData(rowNum, 0);

//		Log.startTestCase(method.getName());
//		Log.startTestCase(TestCaseName);
		Log.startTestCase("Update");
		
		//driver.navigate().refresh();
		
		UpdateAction.ExecuteUpdate(driver, rowNum);

		Thread.sleep(2000);
		Log.info("Waiting 2 seconds before log out the application.");

		Log.endTestCase(TestCaseName);
	}	

	@Test (description="Removes an employee.", priority=4)
	public static void Delete() throws Exception {
//		TestCaseName = ExcelUtils.getCellData(rowNum, 0);

//		Log.startTestCase(method.getName());
//		Log.startTestCase(TestCaseName);
		
		//driver.navigate().refresh();
		Log.startTestCase("Delete");
		
		DeleteAction.ExecuteDelete(driver, rowNum);

		Thread.sleep(2000);
		Log.info("Waiting 2 seconds before log out the application.");

		Log.endTestCase(TestCaseName);
	}	

//	@Test (description="Logout application.")
	public void Logout() throws Exception {
		Log.startTestCase("Logout");
		
		HomePage.btnLogout(driver).click();
		Log.info("Click action is performed on main page.");

		driver.quit();
		Log.info("Browser closed.");


		// This is to send the PASS value to the Excel sheet in the result column.
		//ExcelUtils.setCellData("Pass", 1, 3);

		Log.endTestCase("Logout");
	}

	@AfterClass (description = "Logout")
	public void afterClass() throws Exception {
		Log.startTestCase("Logout");
		
		HomePage.btnLogout(driver).click();
		Log.info("Click action is performed on main page.");

		driver.quit();
		Log.info("Browser closed.");


		// This is to send the PASS value to the Excel sheet in the result column.
		//ExcelUtils.setCellData("Pass", 1, 3);

		Log.endTestCase("Logout");
	}

}
