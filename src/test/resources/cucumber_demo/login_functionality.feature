Feature: Login functionality
  
  Scenario: Logging in with an inexistent email
    Given I've chosen to login
    When I use any password
    And I try to login using an email of an inexistent user
    Then I should get a text saying "Email doesn't exist"
    
  Scenario: Logging in with an incorrect password
    Given I've chosen to login
    When I enter a valid email and an incorrect password
    Then I should get a text saying "Incorrect password used"
    
  Scenario: Logging in successfully
    Given I've chosen to login
    When I enter the correct email and password
    Then I should get a text saying "Welcome <user>!" with <user> being the account owner's first name
