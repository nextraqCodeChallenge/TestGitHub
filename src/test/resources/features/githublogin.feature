Feature: GitHub Login
  As a user of the GitHub website
  I want to be able to log in with my account
  So that I can access my account-related features and Generate Tokens

  Background:
    Given I am on the GitHub Login Page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the sign-in button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with inccorrect username or password
    Given I have entered invalid "<username>" and "<password>"
    When I click on the sign-in button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username         | password        | error_message                   |
      | invalid@mail.com | invalidPassword | Incorrect username or password. |
