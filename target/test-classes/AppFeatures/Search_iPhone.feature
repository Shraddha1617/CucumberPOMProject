Feature: Seacrh iPhone feature

  Scenario: Search for iPhone and Capture the price
    Given Search for "iPhone"
    When click on the first iphone link
    And Go to the Product details and add to cart
    Then Product should be added to cart
