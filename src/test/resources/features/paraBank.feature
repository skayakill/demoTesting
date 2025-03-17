@All
  Feature: Para bank Registration

   @Positive @Regis
   Scenario: Success register
     Given user is on parabank homepage
     When user click register link button
     Then user is in register page
     When user input name
     And user input address detail
     And user fill input username and password
     And user input password confirmation
     When user click register button
     Then user register successfully

    @Negative @Regis
    Scenario: Failed register - Missmatch Password
      Given user is on parabank homepage
      When user click register link button
      Then user is in register page
      When user input name
      And user input address detail
      And user fill input username and password
      And user input invalid password confirmation
      When user click register button
      Then user get error password did not match
