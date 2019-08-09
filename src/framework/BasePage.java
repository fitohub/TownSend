package framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.*;
import appModules.SignInAction;

import utility.Constants;
import utility.ExcelUtils;

public class BasePage {

	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {
		
		String Path = Constants.filePath + Constants.fileName;
		System.out.println("Path: " + Path);
		
		ExcelUtils.setExcelFile(Path, "Sheet1");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.URL);
				
		SignInAction.Execute(driver);
		System.out.println("Successfully opened the website cafetownsend-angular-rails.herokuapp.com");

		Thread.sleep(5000);
		
		HomePage.Logout(driver).click();

		driver.quit();
		
		// This is to send the PASS value to the Excel sheet in the result column.
		ExcelUtils.setCellData("Pass", 1, 3);
	}

}
