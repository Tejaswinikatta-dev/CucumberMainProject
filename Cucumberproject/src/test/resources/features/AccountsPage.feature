Feature: Accounts Page feature 
Background: 
	Given the user has alreaddy loggedin into application 
		|username|password|
		|katta.tejaswini21@gmail.com|dhonimsd2244|

Scenario: Accounts page title
Given User is on accounts page
When User gets the title of the page
Then title of the page should be "My account - My Store"

Scenario: Accounts Sections counts
Given User is on accounts page
Then user gets the accounts sections
|order history and details|
|my credit slips|
|my addresses|
|my personal information|
|my wishlists|
And sections count should be 5
