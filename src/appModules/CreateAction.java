package appModules;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import pageObjects.EmployeePage;
import pageObjects.HomePage;
import utility.ExcelUtils;
import utility.Log;

public class CreateAction {
	
	public static void ExecuteCreate(WebDriver driver, int rowNum) throws Exception {
		
//		Actions actions = new Actions(driver);
//		WebElement employeeName;
		
		String sFirstName = ExcelUtils.getCellData(rowNum, 3);
		Log.info("First name picked from Excel is: " + sFirstName);

		String sLastName = ExcelUtils.getCellData(rowNum, 4);
		Log.info("LastName picked from Excel is: " + sLastName);
		
		String sStartDate = ExcelUtils.getCellData(rowNum, 5);
		Log.info("Start date picked from Excel is: " + sStartDate);

		String sEmail = ExcelUtils.getCellData(rowNum, 6);
		Log.info("Email picked from Excel is: " + sEmail);
		
		HomePage.btnCreate(driver).click();
		Log.info("Create button clicked.");
		
		EmployeePage.txtFirstName(driver).sendKeys(sFirstName);
		Log.info("First name entered in the First Name text box.");

		EmployeePage.txtLastName(driver).sendKeys(sLastName);
		Log.info("Last name entered in the Last Name text box.");

		EmployeePage.txtStartDate(driver).sendKeys(sStartDate);
		Log.info("Start date entered in the Start Date text box.");

		EmployeePage.txtEmail(driver).sendKeys(sEmail);
		Log.info("E-mail name entered in the Email text box.");

		EmployeePage.btnAdd(driver).click();
		Log.info("Add button clicked.");

		Thread.sleep(2000);
		Log.info("Waiting 2 seconds before log out the application.");
		
//		employeeName = HomePage.searchEmployee(driver, sFirstName, sLastName);

//		if (employeeName != null) {
//			actions.doubleClick(employeeName).perform();
//			Log.info("Employee name is listed.");
//		}
		
//		Assert.assertTrue(HomePage.isAlphabetic(sFirstName), "First name is not Alphabetic.");
		//Assert.assertTrue(HomePage.isAlphabetic(sLastName), "Last name is not Alphabetic.");		
	}
}
