Feature: Login Page Feature

Scenario: Login page title
Given user is on login page
When User gets the title of the page
Then title of the page should be "Login - My Store"
@skip_scenario
Scenario: Forgot passwrod link
Given user is on login page
Then Forgot password link should be displayed
@smoke
Scenario: Login with valid Credentials
Given user is on login page
When user Enters Username "katta.tejaswini21@gmail.com"
And user Enters password "dhonimsd2244"
And user clicks on Login button
Then User gets the title of the page
And title of the page should be "My account - My Store"