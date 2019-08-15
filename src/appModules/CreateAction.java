package appModules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.EmployeePage;
import pageObjects.HomePage;
import utility.Log;

public class CreateAction {

	public static void ExecuteCreate(WebDriver driver, String sFirstName, String sLastName, String sStartDate, String sEmail) throws Exception {

		HomePage.btnCreate(driver).click();
		Log.info("Create button clicked.");

		if(!sFirstName.isEmpty()) {
			EmployeePage.txtFirstName(driver).sendKeys(sFirstName);
			Log.info("First name entered in the First Name text box.");
		} else {
			Assert.fail("First name is blank.");
		}

		if(!sLastName.isEmpty()) {
			EmployeePage.txtLastName(driver).sendKeys(sLastName);
			Log.info("Last name entered in the Last Name text box.");
		} else {
			Assert.fail("Last name is blank.");
		}

		if(!sStartDate.isEmpty()) {
			EmployeePage.txtStartDate(driver).sendKeys(sStartDate);
			Log.info("Start date entered in the Start Date text box.");
		} else {
			Assert.fail("Start Date is blank.");
		}

		if(!sEmail.isEmpty()) {
			EmployeePage.txtEmail(driver).sendKeys(sEmail);
			Log.info("E-mail name entered in the Email text box.");
		} else {
			Assert.fail("E-mail is blank.");
		}

		EmployeePage.btnAdd(driver).click();
		Log.info("Add button clicked.");

	}
}
