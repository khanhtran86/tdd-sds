Feature: Login to application with user's credentials
  As a registered user
  I want to be able to log in to the system
  So that I can access my account

  Scenario: Successful Login
    Given I am on the login page
    When I attempt to login with valid credentials
    Then I should be Logged in Successfully

  Scenario: Unsuccessful Login
    Given I am on the login page
    When I attempt to login with invalid credentials
    Then I should see an error message
