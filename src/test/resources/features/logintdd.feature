Feature: login with TDD

  @TDD
  Scenario Outline: Login with TDD
  Given user is on login page
  When user input <username> and <password>
  And user click login button
  Then user get verify login <result>

    Examples:
      | username | password | result |
      | standard_user | secret_sauce | Passed |
      | invalidUsername | secret_sauce | Failed |
      | standard_user | invalidPassword | Failed |