package framework;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.SignOutAction;
import pageObjects.HomePage;
import utility.Log;

public class LogoutPage extends Setup {
	@BeforeMethod (description="Includes Start method header.")
	public void beforeTestMethod(Method testMethod) {
		Log.startTestCase(testMethod.getName());
	}

	@Test (description="Logoff application.", priority=1)
	public static void SignOut() throws Exception {	
		if (HomePage.IsHomePagePresent(driver)) {
			SignOutAction.ExecuteSignOut(driver, rowNum);
		}
	}

	@AfterMethod (description="Includes End method footer.")
	public void afterTestMethod(Method testMethod){
		Log.endTestCase(testMethod.getName());
	}
}
