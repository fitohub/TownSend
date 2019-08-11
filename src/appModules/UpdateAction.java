package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.EmployeePage;
import pageObjects.HomePage;
import utility.ExcelUtils;
import utility.Log;
import org.openqa.selenium.JavascriptExecutor;

public class UpdateAction {

	public static void ExecuteUpdate(WebDriver driver, int rowNum) throws Exception {
		//Actions actions = new Actions(driver);
		WebElement employeeName;

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

			EmployeePage.txtFirstName(driver).clear();
			EmployeePage.txtFirstName(driver).sendKeys(sFirstName);
			Log.info("First name entered in the First Name text box.");

			EmployeePage.txtLastName(driver).clear();
			EmployeePage.txtLastName(driver).sendKeys(sLastName + "Changed");
			Log.info("Last name entered in the Last Name text box.");
			
			EmployeePage.txtStartDate(driver).clear();
			EmployeePage.txtStartDate(driver).sendKeys(sStartDate);
			Log.info("Start date entered in the Start Date text box.");

			EmployeePage.txtEmail(driver).clear();
			EmployeePage.txtEmail(driver).sendKeys(sEmail);
			Log.info("E-mail name entered in the Email text box.");

			EmployeePage.btnUpdate(driver).click();
			Log.info("Update button clicked.");

			Thread.sleep(2000);
			Log.info("Waiting 2 seconds before log out the application.");
			
			ExcelUtils.setCellData(sLastName + "Changed", 1, 4);

		} else {
			System.out.println("Employee not found: " + sFirstName + " " + sLastName);
		}
			


		//Assert.assertTrue(HomePage.isAlphabetic(sFirstName), "First name is not Alphabetic.");
		//Assert.assertTrue(HomePage.isAlphabetic(sLastName), "Last name is not Alphabetic.");

	}
}
