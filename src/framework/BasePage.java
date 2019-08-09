package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class BasePage {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://cafetownsend-angular-rails.herokuapp.com");
		

		LoginPage.txtUserName(driver).sendKeys("Luke");
		LoginPage.txtPassword(driver).sendKeys("Skywalker");
		LoginPage.btnLogin(driver).click();
		System.out.println("Successfully opened the website cafetownsend-angular-rails.herokuapp.com");

		//Wait for 5 Sec
		Thread.sleep(5000);
		
		HomePage.Logout(driver).click();

		// Close the driver
		driver.quit();
	}

}
