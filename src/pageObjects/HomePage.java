package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class HomePage {

	private static WebElement element = null;
	
	public static WebElement Login(WebDriver driver) {
		element = driver.findElement(By.id("login-form"));
		Log.info("Log In element found.");
		return element;
	} 

	public static WebElement Logout(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-click='logout()']"));
		Log.info("Log Out element found.");
		return element;
	} 
}
