Feature: Vehicle Filtering

  Scenario: User filters vehicles by type
    Given the user is on the homepage
    When the user opens the filter menu
    And the user selects the "Vehicle Type" filter
    And the user chooses "SUV"
    Then the list of available vehicles should display only SUVs

  Scenario: User filters vehicles by price range
    Given the user is on the homepage
    When the user opens the filter menu
    And the user selects the "Price Range" filter
    And the user sets the price range between "50" and "100" dollars per day
    Then the list of available vehicles should display only vehicles within the specified price range

  Scenario: User filters vehicles by transmission type
    Given the user is on the homepage
    When the user opens the filter menu
    And the user selects the "Transmission" filter
    And the user chooses "Automatic"
    Then the list of available vehicles should display only vehicles with automatic transmission

  Scenario: User combines multiple filters to narrow down vehicle choices
    Given the user is on the homepage
    When the user opens the filter menu
    And the user selects the "Vehicle Type" filter and chooses "SUV"
    And the user selects the "Price Range" filter and sets it between "50" and "100" dollars per day
    And the user selects the "Transmission" filter and chooses "Automatic"
    Then the list of available vehicles should display only SUVs with automatic transmission within the specified price range

  Scenario: User clears all filters
    Given the user has applied multiple filters
    When the user clears all filters
    Then the list of available vehicles should display all vehicle options
