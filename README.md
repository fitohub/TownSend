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
