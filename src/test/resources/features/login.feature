@All
Feature: Login

  @Test1
  Scenario: Login
    Given user is on login page
    When user fill username and password
    And user click login button
    Then user verify login result

  @Test2
  Scenario: Login Invalid username and password
    Given user is on login page
    When user fill invalid username and password
    And user click login button
    Then user get message error
