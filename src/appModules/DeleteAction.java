package appModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import utility.Log;

public class DeleteAction {
	
	public static void ExecuteDelete(WebDriver driver, String sFirstName, String sLastNameChanged) throws Exception {
		
		WebElement employeeName;
		employeeName = HomePage.searchEmployee(driver, sFirstName, sLastNameChanged);

		if (employeeName != null) {

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", employeeName);
			Log.info("Employee name is displayed in the list.");

			employeeName.click();
			Log.info("Employee name is selected.");

			HomePage.btnDelete(driver).click();
			Log.info("Confirmation pop-up clicked.");
			
			driver.switchTo().alert().accept();
			Log.info("Employee was removed from list.");
			
		}	
	}
}
