package pageObjects;

import org.openqa.selenium.*;
import utility.Log;

public class EmployeePage {
	
	private static WebElement element = null;
	
	public static WebElement txtFirstName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-model='selectedEmployee.firstName']"));
		Log.info("FirstName text field found.");
		return element;
	} 

	public static WebElement txtLastName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-model='selectedEmployee.lastName']"));
		Log.info("LastName text field found.");
		return element;
	} 

	public static WebElement txtStartDate(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-model='selectedEmployee.startDate']"));
		Log.info("Start date text field found.");
		return element;
	} 

	public static WebElement txtEmail(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@ng-model='selectedEmployee.email']"));
		Log.info("E-mail text field found.");
		return element;
	} 
	public static WebElement btnCancel(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@class='subButton bCancel']"));
		Log.info("Cancel button found.");
		return element;
	} 

	public static WebElement btnBack(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@class='subButton bBack']"));
		Log.info("Back button found.");
		return element;
	} 

	public static WebElement btnAdd(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='main-button' and contains(text(), 'Add')]"));
		Log.info("Add button found.");
		return element;
	} 

	public static WebElement btnUpdate(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='main-button' and contains(text(), 'Update')]"));
		Log.info("Update button found.");
		return element;
	} 

	public static WebElement btnDelete(WebDriver driver) {
		element = driver.findElement(By.xpath("//p[@class='main-button' and contains(text(), 'Delete')]"));
		Log.info("Delete button found.");
		return element;
	} 

}
