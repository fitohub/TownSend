package pageObjects;

import org.openqa.selenium.*;
import utility.Log;
 
public class LoginPage {

	private static WebElement element = null;
	
	public static WebElement Login(WebDriver driver) {
		element = driver.findElement(By.id("login-form"));
		Log.info("Log In page found.");
		return element;
	} 

	public static WebElement txtUserName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-model='user.name']"));
		Log.info("User name text field found.");
		return element;
	}
	
	public static WebElement txtPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-model='user.password']"));
		Log.info("Password text field found.");
		return element;
	}

	public static WebElement btnLogin(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@type='submit']"));
		Log.info("Login button found.");
		return element;
	}
	
}
