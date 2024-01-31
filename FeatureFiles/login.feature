Feature: User login
	Scenario: Successful login
		Given user opens beCognizant portal
		When user entered valid username and password
		Then check if the home page of beCognizant is opening or not
		And user should see user account details