Feature: Home Page scenario for Sauce Lab

  Background: 
    Given I have launched the application

  @regression
  Scenario: This scenario is to define add product in cart successfully
    When I enter the correct username and password.
    And I click on Login Button
    And I click on add to cart on product "Sauce Labs Backpack"
    Then Basket item value is 1
