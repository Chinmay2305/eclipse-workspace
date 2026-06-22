#Author: Chinmay Agrawal
#Date: 3/6/2025
#Description: First cucumber test to test login in AerFin

@SmokeScenario
Feature: feature to test login functionality

	@SmokeTest
  Scenario: Check login is successful with valid credentials
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page

  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username | password |
      | user1    | pass1    |
      | user2    | pass2    |
      |support@acumen.aero|Acumen@123|