package appModules;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import utility.ExcelUtils;
import utility.Log;

public class SignInAction {

	public static void ExecuteSignIn(WebDriver driver, int rowNum) throws Exception {
		
		//This is to get the values from Excel sheet, passing parameters (Row num, Col num) to getCellData method
		System.out.println("Dentro do EcecuteSignIn().");
		String sUsername = ExcelUtils.getCellData(rowNum, 1);
		Log.info("User name picked from Excel is: " + sUsername);

		String sPassword = ExcelUtils.getCellData(rowNum, 2);
		Log.info("Password picked from Excel is: " + sPassword);
		
		LoginPage.txtUserName(driver).sendKeys(sUsername);
		Log.info("User name entered in the Username text box.");
		
		LoginPage.txtPassword(driver).sendKeys(sPassword);
		Log.info("Password entered in the Password text box.");

		LoginPage.btnLogin(driver).click();
		Log.info("Click action performed on Submit button.");

	}
}
