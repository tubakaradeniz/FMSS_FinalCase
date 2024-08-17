Feature: User Sign Up
  As a new user, I want to sign up for an account so that I can use the application.

  Scenario: User tries to sign up without filling mandatory fields
    Given the user is on the sign up page
    When the user leaves mandatory fields blank
    And clicks the sign-up button
    Then the system should display an error message
    And the user should remain on the sign-up page

  Scenario: User successfully signs up and verifies account
    Given the user is on the sign up page
    And the user fills in all mandatory fields
    When the user clicks the sign-up button
    Then the system should save the user information in the database
    And the system should generate a verification code
    And the system should prompt the user to choose SMS or email for receiving the verification code
    When the user selects "SMS"
    And enters the correct verification code within 1 minute
    Then the system should confirm the account verification
    And the user should be redirected to the home page

  Scenario: User enters an incorrect or expired verification code
    Given the user is on the verification page
    When the user enters an incorrect verification code or the code has expired
    Then the system should display an error message
    And the system should prompt the user to request a new verification code
