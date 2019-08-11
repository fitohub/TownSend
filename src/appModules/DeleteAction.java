package appModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import utility.ExcelUtils;
import utility.Log;
//import org.testng.Assert;

public class DeleteAction {
	
	public static void ExecuteDelete(WebDriver driver, int rowNum) throws Exception {
		
//		Actions actions = new Actions(driver);
		WebElement employeeName;

		String sFirstName = ExcelUtils.getCellData(rowNum, 3);
		Log.info("First name picked from Excel is: " + sFirstName);

		String sLastName = ExcelUtils.getCellData(rowNum, 4);
		Log.info("LastName picked from Excel is: " + sLastName);

		//driver.navigate().refresh();
		
		Thread.sleep(2000);
		Log.info("Waiting 2 seconds before log out the application.");
		
		employeeName = HomePage.searchEmployee(driver, sFirstName, sLastName);

		if (employeeName != null) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", employeeName);
			Log.info("Employee name is displayed in the list.");

			employeeName.click();
			Log.info("Employee name is selected.");

			Thread.sleep(2000);
			Log.info("Waiting 2 seconds before log out the application.");

			HomePage.btnDelete(driver).click();
			Log.info("Confirmation pop-up clicked.");
			
			driver.switchTo().alert().accept();
			Log.info("Employee was removed from list.");
			
		}
		
	}
}
