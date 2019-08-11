package appModules;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import utility.Log;

public class SignInAction {

	public static void ExecuteSignIn(WebDriver driver, String sUsername, String sPassword) throws Exception {
		
		LoginPage.txtUserName(driver).sendKeys(sUsername);
		Log.info("User name entered in the Username text box.");
		
		LoginPage.txtPassword(driver).sendKeys(sPassword);
		Log.info("Password entered in the Password text box.");

		LoginPage.btnLogin(driver).click();
		Log.info("Click action performed on Submit button.");

	}
}
