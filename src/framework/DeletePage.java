package framework;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.DeleteAction;
import pageObjects.HomePage;
import utility.Constants;
import utility.ExcelUtils;
import utility.Log;

public class DeletePage extends Setup {
	@BeforeClass
	public void beforeTestClass() throws Exception {
		DOMConfigurator.configure("log4j.xml");

		ExcelUtils.setExcelFile(Constants.filePath + Constants.fileName, "Sheet1");
		Log.info("Excel sheet opened.");

		sFirstName = ExcelUtils.getCellData(rowNum, 3); 
		Log.info("First name picked up from Excel is: " + sFirstName);

		sLastNameChanged = ExcelUtils.getCellData(rowNum, 4);
		Log.info("LastName picked up from Excel is: " + sLastNameChanged);	    
	}

	@BeforeMethod (description="Includes Start method header.")
	public void beforeTestMethod(Method testMethod){
		Log.startTestCase(testMethod.getName());
	}	

	@Test (description="Removes an employee.", priority=1)
	public static void Delete() throws Exception {
		if (HomePage.IsHomePagePresent(driver)) {
			rc = DeleteAction.ExecuteDelete(driver, sFirstName, sLastNameChanged);

			Assert.assertTrue(rc, "Employee is still in the list.");
		}
	}	

	@AfterMethod (description="Includes End method footer.")
	public void afterTestMethod(Method testMethod){
		Log.endTestCase(testMethod.getName());
	}
}
