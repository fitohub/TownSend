package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.Log;

public class HomePage {

	private static WebElement element = null;

	public static WebElement btnLogout(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-click='logout()']"));
		Log.info("Log Out button found.");
		return element;
	} 

	public static WebElement btnCreate(WebDriver driver) {
		element = driver.findElement(By.id("bAdd"));
		Log.info("Create button found.");
		return element;
	} 

	public static WebElement btnDelete(WebDriver driver) {
		element = driver.findElement(By.id("bDelete"));
		Log.info("Delete button found.");
		return element;
	} 

	public static WebElement btnEdit(WebDriver driver) {
		element = driver.findElement(By.id("bEdit"));
		Log.info("Edit button found.");
		return element;
	} 

	public static WebElement searchEmployee(WebDriver driver, String firstName, String lastName) throws Exception {

		try {
			element = driver.findElement(By.xpath("//li[@ng-repeat='employee in employees' and contains(text(), '" + firstName + " " + lastName + "')]"));
			Log.info("Employee name found.");
		} catch (Exception e) {
			Log.info("Employee name not found.");
		}

		return element;		
	}

	public static boolean IsHomePagePresent(WebDriver driver) {
		try 
		{
			driver.findElement(By.id("employee-list"));
			return true;
		} catch (Exception e) {
			Assert.fail("Home page is not present.");
			return false;
		}
	}
}
