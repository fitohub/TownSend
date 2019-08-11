package appModules;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import utility.Log;

public class SignOutAction {
	public static void ExecuteSignOut(WebDriver driver, int rowNum) throws Exception {
		
		HomePage.btnLogout(driver).click();
		Log.info("Click action is performed on main page.");

	}
}
