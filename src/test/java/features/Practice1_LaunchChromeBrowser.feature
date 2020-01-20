Feature: Login to Wikipedia

Scenario: Login and search for a string

Given User navigates to wikipedia 
When User searches for "Selenium"
Then Verify "createAccount" is displayed