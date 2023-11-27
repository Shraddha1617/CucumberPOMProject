Feature: Phone filter feature

  Scenario: Phone filter
    Given user search for "phone"
    When apply the filter as brand realme
    Then filter list should be displayed

  
