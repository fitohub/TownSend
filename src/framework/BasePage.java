package framework;

import org.apache.log4j.xml.DOMConfigurator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import appModules.SignInAction;
import appModules.CreateAction;
import appModules.DeleteAction;
import appModules.UpdateAction;
import pageObjects.EmployeePage;
import pageObjects.HomePage;
import appModules.ReadAction;
import appModules.SignOutAction;
import utility.Constants;
import utility.ExcelUtils;
import utility.Log;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import java.lang.reflect.Method;

public class BasePage {

	private static WebDriver driver = null;
	private static WebElement employeeName;
	private static int rowNum = 1;
	private static String sUsername;
	private static String sPassword;
    private static String sFirstName; 
    private static String sLastName;
    private static String sLastNameChanged;
    private static String sStartDate;
    private static String sEmail;
    private static Boolean rc = false; 

	@BeforeClass
	public void beforeTestClass() throws Exception {

		// Provide Log4j configuration settings
		DOMConfigurator.configure("log4j.xml");

		// This is to open the Excel file. Excel path, file name and sheet name are parameters to this method
		ExcelUtils.setExcelFile(Constants.filePath + Constants.fileName, "Sheet1");
		Log.info("Excel sheet opened.");

		sUsername = ExcelUtils.getCellData(rowNum, 1);
		Log.info("User name picked from Excel is: " + sUsername);
		
		sPassword = ExcelUtils.getCellData(rowNum, 2);
		Log.info("Password picked from Excel is: " + sPassword);
		
	    sFirstName = ExcelUtils.getCellData(rowNum, 3); 
		Log.info("First name picked up from Excel is: " + sFirstName);

	    sLastName = ExcelUtils.getCellData(rowNum, 4);
	    Log.info("LastName picked up from Excel is: " + sLastName);
	    
	    sLastNameChanged = ExcelUtils.getCellData(rowNum, 4) + "Changed";
	    Log.info("LastName changed is: " + sLastNameChanged);
	    
	    sStartDate = ExcelUtils.getCellData(rowNum, 5);
	    Log.info("Start date picked up from Excel is: " + sStartDate);
	    
	    sEmail = ExcelUtils.getCellData(rowNum, 6);
	    Log.info("Email address picked up from Excel is: " + sEmail);

		driver = new FirefoxDriver();
		Log.info("New driver instantiated.");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds.");

		driver.get(Constants.URL);
		Log.info("Web application launched.");
		
	}
	
	@BeforeMethod (description="Includes Start method header.")
	 public void beforeTestMethod(Method testMethod){
	    Log.startTestCase(testMethod.getName());
	 }

	@Test (description="Access application with a valid credential.", priority=0)
	public static void SignIn() throws Exception {
		SignInAction.ExecuteSignIn(driver, sUsername, sPassword);
	}
	
	@Test (description="Creates a new employee.", priority=1)
	public static void Create() throws Exception {
		CreateAction.ExecuteCreate(driver, sFirstName, sLastName, sStartDate, sEmail);
		
		employeeName = HomePage.searchEmployee(driver, sFirstName, sLastName);		
		Assert.assertTrue(employeeName != null, "Employee name not found.");
	}	

	@Test (description="Read an employee information.", priority=2)
	public static void Read() throws Exception {
		rc = ReadAction.ExecuteRead(driver, sFirstName, sLastName, sStartDate, sEmail);
		
		Assert.assertTrue(rc, "Employee name not found.");
	}	

	@Test (description="Updates an employee.", priority=3)
	public static void Update() throws Exception {
		UpdateAction.ExecuteUpdate(driver, sFirstName, sLastName, sLastNameChanged);
		
		ExcelUtils.setCellData(sLastNameChanged, rowNum, 4);
		Log.info("Last name updated from " + sLastName + " to " + sLastNameChanged  + ".");
		
		Assert.assertFalse(sLastName.equals(ExcelUtils.getCellData(rowNum, 4)), "Last name value was not changed.");
	}	

	@Test (description="Removes an employee.", priority=4)
	public static void Delete() throws Exception {
		rc = DeleteAction.ExecuteDelete(driver, sFirstName, sLastNameChanged);
		
		Assert.assertTrue(rc, "Employee is still in the list.");
	}	

	@Test (description="Logoff application.", priority=5)
	public static void SignOut() throws Exception {	
		SignOutAction.ExecuteSignOut(driver, rowNum);
	}
	
	@AfterMethod (description="Includes End method footer.")
	 public void afterTestMethod(Method testMethod){
	    Log.endTestCase(testMethod.getName());
	 }

	@AfterClass (description = "Closedown execution.")
	public void afterTestClass() throws Exception {
		driver.quit();
		Log.info("Browser closed.");

		ExcelUtils.setCellData(sLastName, rowNum, 4);
		Log.info("Last name restored to its original value in Excel.");
	}
}
