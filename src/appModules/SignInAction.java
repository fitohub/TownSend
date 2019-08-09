package appModules;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import utility.ExcelUtils;

public class SignInAction {

	public static void Execute(WebDriver driver) throws Exception {
		
		//This is to get the values from Excel sheet, passing parameters (Row num, Col num) to getCellData method
		String sUsername = ExcelUtils.getCellData(1, 1);
		String sPassword = ExcelUtils.getCellData(1, 2);
		
		LoginPage.txtUserName(driver).sendKeys(sUsername);
		LoginPage.txtPassword(driver).sendKeys(sPassword);
		LoginPage.btnLogin(driver).click();
	}
}
