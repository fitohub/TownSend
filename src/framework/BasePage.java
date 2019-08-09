package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();

		//Launch the caféTOWNSEND Website
		driver.get("http://cafetownsend-angular-rails.herokuapp.com");

		// Print a Log In message to the screen
		System.out.println("Successfully opened the website cafetownsend-angular-rails.herokuapp.com");

		//Wait for 5 Sec
		Thread.sleep(5000);

		// Close the driver
		driver.quit();
	}

}
