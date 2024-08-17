Feature: Vehicle Reservation

  Scenario: User views recommended vehicles on the homepage
    Given the user is on the homepage
    When the user views recommended vehicles
    Then the user should see a list of recommended vehicles

  Scenario: User selects a vehicle and chooses rental dates
    Given the user has selected a vehicle
    When the user chooses rental dates
    Then the system checks if the vehicle is available on the selected dates
    And if the vehicle is not available, the user is prompted to select a different vehicle or dates
    And if the vehicle is available, the rental dates are confirmed

  Scenario: User provides or validates driver information
    Given the user has confirmed rental dates
    When the system checks for existing driver information
    Then if no driver information exists, the user is prompted to enter driver information
    And if driver information exists, the user is directed to the rental agreement screen

  Scenario: User accepts the rental agreement
    Given the user is on the rental agreement screen
    When the user reviews the rental agreement
    Then the user must accept the agreement to proceed to the payment screen

  Scenario: User completes payment and receives a receipt
    Given the user is on the payment screen
    When the user completes the payment
    Then if the payment is successful, the user receives a receipt via email or SMS
    And if the payment fails, the user is notified and cannot proceed

  Scenario: User changes reservation dates
    Given the user is on the vehicle selection page
    When the user selects a vehicle
    And the user selects rental dates from "2024-08-20" to "2024-08-25"
    And the user realizes the dates need to be changed
    And the user selects new rental dates from "2024-08-21" to "2024-08-26"
    Then the system updates the reservation with the new dates
    And the user sees the updated rental dates in the confirmation



