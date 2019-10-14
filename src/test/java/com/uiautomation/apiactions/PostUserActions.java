package com.uiautomation.apiactions;

import java.io.IOException;

import com.uiautomation.utils.CommonUsageCode;
import com.uiautomation.utils.Constants;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class PostUserActions {

    Response response;
    RequestSpecification request = SerenityRest.given();


    @Steps
    CommonUsageCode commonUsageCode;

    @Step
    public void initializePostCall() throws IOException {
        String jsonBody = commonUsageCode.generateStringFromResource(System.getProperty("user.dir")+"\\testdata\\NewUser.json");
        request.header("Content-Type","application/json");
        response = request.when().post(Constants.HOST +"/users");
    }

    @Step
    public void checkValidResponseWithValidStatusCode() {
       int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
    }

    @Step
    public void checkUserInResponseBody(String userNameInObtainedResponse){
        String userName = response.jsonPath().getString(userNameInObtainedResponse);
        Assert.assertEquals(userName,userNameInObtainedResponse);
    }
}
