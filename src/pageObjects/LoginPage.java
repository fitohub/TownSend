package pageObjects;

import org.openqa.selenium.*;
 
public class LoginPage {

	private static WebElement element = null;
	
	public static WebElement txtUserName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-model='user.name']"));
		return element;
	}
	
	public static WebElement txtPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-model='user.password']"));
		return element;
	}

	public static WebElement btnLogin(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@type='submit']"));
		return element;
	}
	
}
