Feature: User Logout
  As a user, I want to securely log out of the application so that my session is closed.

  Scenario: User cancels logout
    Given the user is logged in
    When the user clicks the logout button
    And the system displays "Are you sure you want to log out?"
    When the user selects "No"
    Then the user should remain on the main menu

  Scenario: User confirms logout
    Given the user is logged in
    When the user clicks the logout button
    And the system displays "Are you sure you want to log out?"
    When the user selects "Yes"
    Then the user should be securely logged out
    And the user should be redirected to the login page
