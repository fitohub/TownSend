# TEST CASES
Test Case 1: Access application with a valid customer
	1. Enter Username;
	2. Enter Password;
	3. Click on "Login" button.

Test Case 2: Create a new Employee (with a date newer than current date)
	1. Click on "Create" button;
	2. Enter "First name" value;
	3. Enter "Last name" without any alpha letter;
	4. Enter "Start date" in YYYY-MM-DD date format;
	5. Enter "Email";
	6. Click "Add" button.

Test Case 3: Read employee information
	1. Click on "Edit" button;
	2. Verify if the information displayed is equal to the ones in Excel spreadsheet.
	3. Click on "Back" button.

Test Case 4: Update Employee
	1. Select the added employee from list;
	2. Click on "Edit" button;
	3. Update "Last name" by adding "Changed" suffix in the original last name;
	4. Click on "Update" button;
	5. Check if "Last name" is changed in the employee's list.
	
Test Case 5: Delete Employee
	1. Select the added employee from list;
	2. Click on "Delete" button;
	3. Check if the name is not listed in employee's list.
	
Test Case 6: Log out from application
	1. Click on "Logout" button;
	2. Check if you back to Login page;
	3. Close the browser.

# IDE SETUP
Eclipse 4.9.0 (Photon Release)
Maven 3.4.5 
Selenium 3.141.59
Java 1.8
POI 4.0.0
TestNG 6.14.3
Firefox 68.0.1

# Download from git
1. Open terminal or Windows prompt;
2. Download the code into eclipse-workspace;
3. git remote add origin "https://github.com/fitohub/TownSend.git"
4. git pull origin master

# File Structure
TownSend
   |
   |-- src
   |    |
   |	|-- appModules
   |	|       |
   |	|	|--- CreateAction.java
   |	|	|--- DeleteAction.java
   |	|       |--- ReadAction.java
   |	|	|--- SignInAction.java
   |	|	|--- SignOutAction.java
   |	|	 --- UpdateAction.java
   |	|
   |    |--- framework
   |	|       |
   |	|        --- BasePage.java
   |	|
   |	|--- pageObjects
   |	|       |
   |	|       |--- EmployeePage.java
   |	|       |--- HomePage.java
   |	|        --- LoginPage.java
   |	|
   |	|--- testData
   |	|	|
   |	|	 --- testData.xlsx
   |	|
   |	|--- testData
   |		|
   |		|--- Constants.java
   |		|--- ExcelUtils.java		
   |		|--- Log.java
   |		 --- testng.xml
   |			
   |--- log4j.xml
   |--- logfile.log
   |--- pom.xml
    --- README.md
		
# How to run
1. Open the project TownSend in Eclipse;
2. From Project Explorer, navigate through TownSend -> src -> framework and run the file "BasePage.java" as TestNG Test;
3. The test will perform a CRUD with 6 test cases: SignIn, Create, Read, Update, Delete and SignOut against Café Townsend website. No records will be left after execution.

# Log file
In the root directory, you will find the log file (logfile.log) with details about the test execution.
