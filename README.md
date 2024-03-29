# Test Approach
The aim of this framework is to cover the 4 main functionalities: Create, Read, Update and Delete as well as Login and Logout. I choose this approach because from these 4 functionalities it is possible create more scripts for positive and negative tests. The baseline is ready.

I created this framework with Java, Selenium and TestNG, and structured in a way that no data is left in the application. So, feel free to change the data and execute as much as you want. Also, for debug purposes (that was very helpful during the creation of this framework), I included a log feature for each step. The test results are automatically generated by TestNG and can be found at "test-output" folder in HTML format. You can see the results on both "index.html" and "emailable-report.html".

Kick-off the test by Run "testng.xml" As "TestNG Suite". Also, for better maintenability and reusability, I organized the features in modules at "appModules" package and the pages definitions in an repository named "pageObjects". 

The data (at testData package) is recorded in an Excel spreadsheet. At last, I grouped some support files in the "utility" package.

# Test Cases
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

# Copy TownSend repository into your local machine with git clone
1. You can get TownSend repository with: 
	$ git clone https://github.com/fitohub/TownSend.git
2. That creates a directory named TownSend, initializes a .git directory inside it, pulls down all the data for that repository, and checks out a working copy of the latest version. If you go into the new TownSend directory that was just created, you will see the project files in there, ready to be worked on or used;
3. If you want to clone the repository into a directory named something other than TownSend, you can specify the new directory name as an additional argument: 
	$ git clone https://github.com/fitohub/TownSend.git cafeTownSend
That command does the same thing as the previous one, but the target directory is called “cafeTownSend”.

# Software Requirements
1. MacOS 10.14.4 (Mojave);
2. Firefox 68.0.1; 
3. Java 1.8;
4. Eclipse 4.9.0 (Photon Release);
5. git;
6. Maven 3.4.5;
7. Selenium 3.141.59; 
8. TestNG 6.14.3;
9. POI 4.0.0.

See "TownSend - Installation  and Configuration Manual for MacOS.pdf" for your IDE Setup.

# Test Data
No changes needed. Unless if you want to try a different name, date and/or e-mail address. 

# How to run (estimated time: 10 sec)
1. Open the project TownSend in Eclipse;
2. From Project Explorer, navigate through TownSend and run the file "testng.xml" as TestNG Suite;
3. The test will perform a CRUD with 6 test cases: SignIn, Create, Read, Update, Delete and SignOut against Café Townsend website. This is a zero-footprint execution.

# Log File
In the root directory, you will find the log file (logfile.log) with details about the test execution.
