Feature: User Login
  As a user, I want to log in to the application so that I can access my account.

  Scenario: User tries to log in with a non-existent account
    Given the user is on the login page
    When the user enters "nonexistent@driveflex.com" and "password123"
    And clicks the login button
    Then the system should display "Account does not exist" and prompt the user to sign up

  Scenario: User successfully logs in
    Given the user is on the login page
    And the user has an account with email "user@driveflex.com" and password "password123"
    When the user enters "user@driveflex.com" and "password123"
    And clicks the login button
    Then the user should be redirected to the dashboard page

  Scenario: User enters incorrect password
    Given the user is on the login page
    And the user has an account with email "user@example.com" and password "password123"
    When the user enters "user@driveflex.com" and "wrong-password"
    And clicks the login button
    Then the system should display "Incorrect email or password"

  Scenario: User tries to log in without an account
    Given the user is on the login page
    When the user clicks on the "Sign Up" link
    Then the system should redirect to the registration page
