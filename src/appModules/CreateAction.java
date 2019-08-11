package appModules;

import org.openqa.selenium.WebDriver;
import pageObjects.EmployeePage;
import pageObjects.HomePage;
import utility.Log;

public class CreateAction {
	
	public static void ExecuteCreate(WebDriver driver, String sFirstName, String sLastName, String sStartDate, String sEmail) throws Exception {
		
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

	}
}
