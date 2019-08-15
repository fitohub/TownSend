package framework;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.UpdateAction;
import pageObjects.HomePage;
import utility.Constants;
import utility.ExcelUtils;
import utility.Log;

public class UpdatePage extends Setup {

	@BeforeClass
	public void beforeTestClass() throws Exception {
		DOMConfigurator.configure("log4j.xml");

		ExcelUtils.setExcelFile(Constants.filePath + Constants.fileName, "Sheet1");
		Log.info("Excel sheet opened.");

		sFirstName = ExcelUtils.getCellData(rowNum, 3); 
		Log.info("First name picked up from Excel is: " + sFirstName);

		sLastName = ExcelUtils.getCellData(rowNum, 4);
		Log.info("LastName picked up from Excel is: " + sLastName);

		sLastNameChanged = sLastName + "Changed";
		Log.info("LastName changed is: " + sLastNameChanged);
	}

	@BeforeMethod (description="Includes Start method header.")
	public void beforeTestMethod(Method testMethod){
		Log.startTestCase(testMethod.getName());
	}

	@Test (description="Updates an employee.", priority=1)
	public static void Update() throws Exception {
		if (HomePage.IsHomePagePresent(driver)) {
			if (employeeName != null) {

				UpdateAction.ExecuteUpdate(driver, employeeName, sFirstName, sLastName, sLastNameChanged);

				ExcelUtils.setCellData(sLastNameChanged, rowNum, 4);
				Log.info("Last name updated from " + sLastName + " to " + sLastNameChanged  + ".");

				Assert.assertFalse(sLastName.equals(ExcelUtils.getCellData(rowNum, 4)), "Last name value was not changed.");
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
