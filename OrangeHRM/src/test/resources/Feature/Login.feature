Feature: Test the login functionality of OrangeHRM

Scenario: Test the valid login

Given user is on login page
When user enters username and password
And click on Login button 
Then user should land on homepage