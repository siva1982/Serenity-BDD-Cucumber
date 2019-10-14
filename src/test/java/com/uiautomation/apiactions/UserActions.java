package com.uiautomation.apiactions;

import java.io.IOException;
import java.util.List;

import com.uiautomation.utils.CommonUsageCode;
import com.uiautomation.utils.Constants;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class UserActions {

    Response response;
    RequestSpecification request = SerenityRest.given();


    @Step
    public void initializeGetCall() throws IOException {
        request.header("Content-Type","application/json");
        response = request.when().get(Constants.HOST +"/users");
    }

    @Step
    public void assertStatusCode(int statusCode){
        Assert.assertEquals(response.getStatusCode(),statusCode);
    }

    @Step
    public void checkNumberOfUsersInResponseBody(int sizeOfList){
        List<Integer> ids = response.jsonPath().getList("id");
        Assert.assertEquals(ids.size(),sizeOfList);
    }

    @Step
    public void checkUserNameInTheObtainedResponse (String userNameToAssert){
        List<String> userNames = response.jsonPath().getList("name");
        Assert.assertTrue(userNames.contains(userNameToAssert));
    }

}
