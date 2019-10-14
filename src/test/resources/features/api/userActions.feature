@useractions @regression
Feature: To test the API actions for typicode users

  Scenario: As a user I want to see the list of typicode users

    Given As a new user
    When I trigger GET call on typicode users list
    Then I see the status code as 200
    Then I should see the list of users in typicode website as 10
    Then I should see the userName in list as "Clementina DuBuque"


  Scenario: As a user I want to test the POST operation
    Given As a new user
    When I trigger POST call to add the user to the users list
    Then I see the status code as 201
    Then I should see the valid response body
    And I should the userName in response body as "Siva Kumar"