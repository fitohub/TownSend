package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.EmployeePage;
import pageObjects.HomePage;
import utility.Log;
import org.openqa.selenium.JavascriptExecutor;

public class UpdateAction {

	public static void ExecuteUpdate(WebDriver driver, String sFirstName, String sLastName, String sLastNameChanged) throws Exception {
		
		WebElement employeeName;
		employeeName = HomePage.searchEmployee(driver, sFirstName, sLastName);

		if (employeeName != null) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", employeeName);
			Log.info("Employee name is displayed in the list.");

			employeeName.click();
			Log.info("Employee name is selected.");
			
			HomePage.btnEdit(driver).click();
			Log.info("Edit button clicked.");

			EmployeePage.txtLastName(driver).clear();
			Log.info("LastName text box cleared.");
			
			System.out.println("sLastNameChanged: " + sLastNameChanged);
			EmployeePage.txtLastName(driver).sendKeys(sLastNameChanged);
			Log.info("LastName updated in the Last Name text box.");
			
			EmployeePage.btnUpdate(driver).click();
			Log.info("Update button clicked.");

		} else {
			Log.warn("Employee not found: " + sFirstName + " " + sLastName);
		}
	}
}
