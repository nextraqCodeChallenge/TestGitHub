Feature: Token Generation
Scenario: Generate token with default settings
Given I am logged into my GitHub account
When I navigate to my GitHub user settings page
And I open developer settings from the left navigation menu
And I open Personal access tokens from the left menu
And I click on token classic
And I click Generate new token
And I fill in the token details for the qa Automation Token
And I click Generate token
Then I should see a new token generated for the qa automation token

Scenario: Generate token with custom expiration date and scopes
Given I am logged into my GitHub account
When I navigate to my GitHub user settings page
And I open developer settings from the left navigation menu
And I open Personal access tokens from the left menu
And I click on token classic
And I click Generate new token
And I fill in the token details for the custom automation token
And I click Generate token
Then I should see a new token generated for the custom automation token