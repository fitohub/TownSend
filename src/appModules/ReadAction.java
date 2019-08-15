package appModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.EmployeePage;
import pageObjects.HomePage;
import utility.Log;
import org.testng.Assert;

public class ReadAction {
	public static void ExecuteRead(WebDriver driver, WebElement employeeName, String sFirstName, String sLastName, String sStartDate, String sEmail) throws Exception {
		
		if (employeeName != null) {
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", employeeName);
			Log.info("Employee name is displayed in the list.");

			employeeName.click();
			Log.info("Employee name is selected.");
			
			HomePage.btnEdit(driver).click();
			Log.info("Edit button clicked.");

			Assert.assertEquals(sFirstName, EmployeePage.txtFirstName(driver).getAttribute("value"));
			Log.info("Verify if First name equals to first name data in Excel.");

			Assert.assertEquals(sLastName, EmployeePage.txtLastName(driver).getAttribute("value"));
			Log.info("Verify if Last name equals to last name data in Excel.");

			Assert.assertEquals(sStartDate, EmployeePage.txtStartDate(driver).getAttribute("value"));
			Log.info("Verify if Start date equals to start date data in Excel.");

			Assert.assertEquals(sEmail, EmployeePage.txtEmail(driver).getAttribute("value"));
			Log.info("Verify if E-mail address equals to e-mail address data in Excel.");

			EmployeePage.btnBack(driver).click();
			Log.info("Back button clicked.");

		}
	}
}
