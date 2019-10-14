@useractions @regression
Feature: To test the API actions for typicode users

  Scenario: As a user I want to see the list of typicode users

    Given As a user
    When I trigger GET call on typicode users list
    Then I see the status code as 200
    And I should see the list of users in typicode website as 10
    And I should see the userName in list as "Clementina DuBuque"

  Scenario: As a user I want to test the POST operation on users
    Given As a user
    When I trigger POST call to add the user to the users list
    Then I see the status code as 201
    And the response body should match "usersSchema.json" file with valid status code
    And I should see the "id" in response body as "11"

  Scenario: As a user I want to test the POST operation on Comments
    Given As a user
    When I trigger POST call to add the comment
    Then I see the status code as 201
    And the response body should match "commentsResponse.json" file with valid status code
    And I should see the "id" in response body as "501"

   Scenario: As a user I want to see the comments where the postid is 1
     Given As a user
     When I trigger GET call for the comments with the postid is 1
     Then I see the status code as 200
     And the response body should match "commentsWithPostIdAs1.json" file with valid status code
     And I should the list of comments that associated with postid as 1 in response body

  Scenario: As a user I want to test the POST operation on posts
    Given As a user
    When I trigger POST call to add the posts
    Then I see the status code as 201
    And the response body should match "postsSchema.json" file with valid status code
    And I should see the "id" in response body as "101"

   Scenario: As a user I want to test the GET operation on the posts
     Given As a user
     When I trigger GET call on the post endpoint
     Then I see the status code as 200
     And I should see the "id" in response body as "1"
     And I should see the "userId" in response body as "1"

   Scenario: As a user I want to test the DELETE operation on the posts
     Given As a user
     When I trigger DELETE call on the post endpoint
     Then I see the status code as 200