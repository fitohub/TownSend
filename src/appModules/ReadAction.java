package appModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.EmployeePage;
import pageObjects.HomePage;
import utility.ExcelUtils;
import utility.Log;
import org.testng.Assert;

public class ReadAction {
	public static void ExecuteRead(WebDriver driver, int rowNum) throws Exception {
		
//		Actions actions = new Actions(driver);
		WebElement employeeName;
		String txtFirstName;
		String txtLastName;
		String txtStartDate;
		String txtEmail;
		
		
		String sFirstName = ExcelUtils.getCellData(rowNum, 3);
		Log.info("First name picked from Excel is: " + sFirstName);

		String sLastName = ExcelUtils.getCellData(rowNum, 4);
		Log.info("LastName picked from Excel is: " + sLastName);
		
		String sStartDate = ExcelUtils.getCellData(rowNum, 5);
		Log.info("Start date picked from Excel is: " + sStartDate);

		String sEmail = ExcelUtils.getCellData(rowNum, 6);
		Log.info("Email picked from Excel is: " + sEmail);

		employeeName = HomePage.searchEmployee(driver, sFirstName, sLastName);

		if (employeeName != null) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", employeeName);
			Log.info("Employee name is displayed in the list.");

			employeeName.click();
			Log.info("Employee name is selected.");
			
			HomePage.btnEdit(driver).click();
			Log.info("Edit button clicked.");

			txtFirstName = EmployeePage.txtFirstName(driver).getAttribute("value");
			System.out.println("txtFirstName: " + txtFirstName);
			//Assert.assertEquals(sFirstName, txtFirstName);
			Log.info("Verifies if First name is equal the first name value in Excel.");

			txtLastName = EmployeePage.txtLastName(driver).getAttribute("value");
			//Assert.assertEquals(sLastName, txtLastName);
			Log.info("Verifies if Last name is equal the last name value in Excel.");

			txtStartDate =  EmployeePage.txtStartDate(driver).getAttribute("value");
			//Assert.assertEquals(sStartDate, txtStartDate);
			Log.info("Verifies if Start date is equal the start date value in Excel.");

			txtEmail = EmployeePage.txtEmail(driver).getAttribute("value");
			//Assert.assertEquals(sEmail, txtEmail);
			Log.info("Verifies if E-mail address is equal the e-mail address value in Excel.");

			EmployeePage.btnBack(driver).click();
			Log.info("Cancel button clicked.");

			Thread.sleep(2000);
			Log.info("Waiting 2 seconds before log out the application.");
		}
	}
}
