package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private static WebElement element = null;
	
	public static WebElement Login(WebDriver driver) {
		element = driver.findElement(By.id("login-form"));
		return element;
	} 

	public static WebElement Logout(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-click='logout()']"));
		return element;
	} 
}
