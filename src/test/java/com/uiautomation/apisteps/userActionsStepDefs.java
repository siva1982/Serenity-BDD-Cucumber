package com.uiautomation.apisteps;

import com.uiautomation.apiactions.PostUserActions;
import com.uiautomation.apiactions.UserActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class userActionsStepDefs {

    @Steps
    UserActions userActions;

    @Steps
    PostUserActions postUserActions;

    @Given("^As a new user$")
    public void as_a_new_user() throws Exception {

    }

    @When("^I trigger GET call on typicode users list$")
    public void i_trigger_GET_call_on_typicode_users_list() throws Exception {
        userActions.initializeGetCall();
    }

    @When("^I see the status code as (\\d+)$")
    public void i_see_the_status_code_as(int statusCode) throws Exception {
        userActions.assertStatusCode(statusCode);
    }

    @Then("^I should see the list of users in typicode website as (\\d+)$")
    public void i_should_see_the_list_of_users_in_typicode_website_as(int usersList) throws Exception {
        userActions.checkNumberOfUsersInResponseBody(usersList);
    }

    @Then("^I should see the userName in list as \"([^\"]*)\"$")
    public void i_should_see_the_userName_in_list_as(String userNameInList) throws Exception {
        userActions.checkUserNameInTheObtainedResponse(userNameInList);
    }

    @When("^I trigger POST call to add the user to the users list$")
    public void i_trigger_POST_call_to_add_the_user_to_the_users_list() throws Exception {
        postUserActions.initializePostCall();
    }

    @Then("^I should see the valid response body with valid status code$")
    public void i_should_see_the_valid_response_body() throws Exception {
        postUserActions.checkValidResponseWithValidStatusCode();
    }

    @Then("^I should the userName in response body as \"([^\"]*)\"$")
    public void i_should_the_userName_in_response_body_as(String userToVerifyInResponse) throws Exception {
        postUserActions.checkUserInResponseBody(userToVerifyInResponse);
    }




}
