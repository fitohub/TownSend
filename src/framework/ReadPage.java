package framework;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.ReadAction;
import pageObjects.HomePage;
import utility.Constants;
import utility.ExcelUtils;
import utility.Log;

public class ReadPage extends Setup {

	@BeforeClass
	public void beforeTestClass() throws Exception {
		DOMConfigurator.configure("log4j.xml");

		ExcelUtils.setExcelFile(Constants.filePath + Constants.fileName, "Sheet1");
		Log.info("Excel sheet opened.");

		sFirstName = ExcelUtils.getCellData(rowNum, 3); 
		Log.info("First name picked up from Excel is: " + sFirstName);

		sLastName = ExcelUtils.getCellData(rowNum, 4);
		Log.info("LastName picked up from Excel is: " + sLastName);

		sStartDate = ExcelUtils.getCellData(rowNum, 5);
		Log.info("Start date picked up from Excel is: " + sStartDate);

		sEmail = ExcelUtils.getCellData(rowNum, 6);
		Log.info("Email address picked up from Excel is: " + sEmail);
	}

	@BeforeMethod (description="Includes Start method header.")
	public void beforeTestMethod(Method testMethod){
		Log.startTestCase(testMethod.getName());
	}

	@Test (description="Read an employee information.", priority=1)
	public static void Read() throws Exception {
		if (HomePage.IsHomePagePresent(driver)) {
			if (employeeName != null) {
				ReadAction.ExecuteRead(driver, employeeName, sFirstName, sLastName, sStartDate, sEmail);
			} else {
				Assert.fail("Employee name not found.");		
			}
		}		
	}

	@AfterMethod (description="Includes End method footer.")
	public void afterTestMethod(Method testMethod){
		Log.endTestCase(testMethod.getName());
	}

}
