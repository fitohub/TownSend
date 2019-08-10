package pageObjects;

import org.openqa.selenium.*;
import utility.Log;
 
public class LoginPage {

	private static WebElement element = null;
	
	public static WebElement txtUserName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-model='user.name']"));
		Log.info("User name text box found.");
		return element;
	}
	
	public static WebElement txtPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-model='user.password']"));
		Log.info("Password text box found.");
		return element;
	}

	public static WebElement btnLogin(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@type='submit']"));
		Log.info("Submit button found.");
		return element;
	}
	
}
