Feature: Test facebook login
	Scenario: Test FB Login with valid credentials
	Given open Firefox and go to fb application
	When I enter valid username and password
	Then user should be able to login 