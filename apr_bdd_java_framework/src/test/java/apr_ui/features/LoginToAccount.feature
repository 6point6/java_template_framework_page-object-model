Feature: Login To Account

  Background: User is navigated to the DIO APR login page
    Given I have navigated to the DIO APR "login" page

  Scenario: Successful login without clicking the show button
    And I enter "6p6test@6point6.co.uk" in the username field
    And I enter "6password6!" on the password field
    When I click on the "Signin" button
    Then I am successfully login

  Scenario: Successful login with clicking the show button
    And I enter "6p6test@6point6.co.uk" in the username field
    And I enter "6password6!" on the password field
    And I click on the "Show" button
    When I click on the "Signin" button
    Then I am successfully login

  Scenario Outline: Unsuccessful login using invalid username and password credentials
    And I enter <username> in the username field and <password> in the password field
    When I click on the "Signin" button
    Then I can see error message "There is a problem with your sign in"
    Examples:
      | username              | password    |
      | invalid               | 6password6! |
      | 6p6test@6point6.co.uk | invalid!    |

  Scenario: Unsuccessful login attempt with blank username and password
    And I enter "" in the username field
    And I enter "" on the password field
    When I click on the "Signin" button
    Then I can see error message "Enter your username"
    And I can see error message "Enter your password"