package framework;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import appModules.SignInAction;
import utility.Constants;
import utility.ExcelUtils;
import utility.Log;

public class LoginPage extends Setup {
	@BeforeClass
	public void beforeTestClass() throws Exception {
		DOMConfigurator.configure("log4j.xml");

		ExcelUtils.setExcelFile(Constants.filePath + Constants.fileName, "Sheet1");
		Log.info("Excel sheet opened.");

		sUsername = ExcelUtils.getCellData(rowNum, 1);
		Log.info("User name picked from Excel is: " + sUsername);
		System.out.println("User name picked from Excel is: " + sUsername);
		
		sPassword = ExcelUtils.getCellData(rowNum, 2);
		Log.info("Password picked from Excel is: " + sPassword);
		System.out.println("Password picked from Excel is: " + sPassword);
	}

	@BeforeMethod (description="Includes Start method header.")
	public void beforeTestMethod(Method testMethod) {
		Log.startTestCase(testMethod.getName());
	}

	@Test (description="Access application with a valid credential.", priority=1)
	public static void SignIn() throws Exception {
		SignInAction.ExecuteSignIn(driver, sUsername, sPassword);
	}	

	@AfterMethod (description="Includes End method footer.")
	public void afterTestMethod(Method testMethod){
		Log.endTestCase(testMethod.getName());
	}
}
