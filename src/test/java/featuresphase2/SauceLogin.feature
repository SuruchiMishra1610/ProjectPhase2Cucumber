Feature: Login Feature Scenarios for saucelab

  Background: 
    Given I have launched the application

  @sanity
  Scenario: This scenario is to define the saucelab login happy path
    When I enter the correct username and password.
    And I click on Login Button
    Then I should land on the home page

  @regression
  Scenario Outline: This scenario is to define the failure path
    When I enter the username as "<UserName>" and password as "<Password>"
    And I click on Login Button
    Then I should get the error message "Epic sadface: Username and password do not match any user in this service"

    Examples: 
      | UserName            | Password  |
      | Scenario1@gmail.com | Abc@1234  |
      | Scenario2@gmail.com | Abc@12345 |
