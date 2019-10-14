package com.uiautomation.apisteps;

import com.uiautomation.apioperations.APIOperations;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class userActionsStepDefs {

   @Steps
    APIOperations apiOperations;

    @Given("^As a user$")
    public void as_a_new_user() throws Exception {

    }

    @When("^I trigger GET call on typicode users list$")
    public void i_trigger_GET_call_on_typicode_users_list() throws Exception {
        apiOperations.initialiseGETCall("/users");
    }

    @When("^I see the status code as (\\d+)$")
    public void i_see_the_status_code_as(int statusCode) throws Exception {
        apiOperations.assertStatusCode(statusCode);
    }

    @Then("^I should see the list of users in typicode website as (\\d+)$")
    public void i_should_see_the_list_of_users_in_typicode_website_as(int usersList) throws Exception {
        apiOperations.checkNumberOfUsersInResponseBody(usersList);
    }

    @Then("^I should see the userName in list as \"([^\"]*)\"$")
    public void i_should_see_the_userName_in_list_as(String userNameInList) throws Exception {
        apiOperations.checkUserNameInTheObtainedResponse(userNameInList);
    }

    @When("^I trigger POST call to add the user to the users list$")
    public void i_trigger_POST_call_to_add_the_user_to_the_users_list() throws Exception {
        apiOperations.initialisePOSTCall("/users", "\\testdata\\NewUserPayLoad.json");
    }

    @Then("^the response body should match \"([^\"]*)\" file with valid status code$")
    public void the_response_body_should_match_file_with_valid_status_code(String jsonSchemaFileName) throws Exception {
        apiOperations.checkValidResponseWithValidStatusCode(jsonSchemaFileName);
    }

    @Then("^I should see the \"([^\"]*)\" in response body as \"([^\"]*)\"$")
    public void i_should_see_the_in_response_body_as(String key, String Value) throws Exception {
        apiOperations.checkKeyValuesInResponseBody(key,Value);
    }

    @When("^I trigger POST call to add the comment$")
    public void i_trigger_POST_call_to_add_the_comment() throws Exception {
        apiOperations.initialisePOSTCall("/comments","\\testdata\\NewCommentPayLoad.json");
    }

    @When("^I trigger POST call to add the posts$")
    public void i_trigger_POST_call_to_add_the_posts() throws Exception {
       apiOperations.initialisePOSTCall("/posts","\\testdata\\NewPostPayLoad.json");
    }

    @When("^I trigger GET call on the post endpoint$")
    public void i_trigger_GET_call_on_the_post_endpoint() throws Exception {
       apiOperations.initialiseGETCall("/posts/1");
    }

    @When("^I trigger GET call for the comments with the postid is (\\d+)$")
    public void i_trigger_GET_call_for_the_comments_with_the_postid_is(int arg1) throws Exception {
       apiOperations.initialiseGETCall("/comments?postId=1");
    }

    @Then("^I should the list of comments that associated with postid as (\\d+) in response body$")
    public void i_should_the_list_of_comments_that_associated_with_postid_as_in_response_body(int arg1) throws Exception {
       apiOperations.checkNumberOfUsersInResponseBody(5);
    }

    @When("^I trigger DELETE call on the post endpoint$")
    public void i_trigger_DELETE_call_on_the_post_endpoint() throws Exception {
       apiOperations.initialiseDELETECall("/posts/1","\\testdata\\NewPostPayLoad.json");
    }





}
