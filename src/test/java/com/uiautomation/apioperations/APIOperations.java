package com.uiautomation.apioperations;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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

/**
 * Reusable class for API Operations
 */

public class APIOperations {

    Response response;
    RequestSpecification request = SerenityRest.given();

    @Steps
    CommonUsageCode commonUsageCode;

    @Step
    public void initialiseGETCall(String endpoint){
        request.header("Content-Type","application/json");
        response = request.when().get(Constants.HOST +endpoint);
    }

    @Step
    public void initialisePOSTCall(String endpoint, String jsonPayLoad) throws IOException {
        String jsonBody = commonUsageCode.generateStringFromResource(System.getProperty("user.dir")+jsonPayLoad);
        request.header("Content-Type","application/json");
        request.body(jsonBody);
        response = request.when().post(Constants.HOST +endpoint);
    }

    @Step
    public void initialiseDELETECall(String endpoint, String jsonPayLoad) throws IOException {
        String jsonBody = commonUsageCode.generateStringFromResource(System.getProperty("user.dir")+jsonPayLoad);
        request.header("Content-Type","application/json");
        request.body(jsonBody);
        response = request.when().delete(Constants.HOST +endpoint);
    }

    @Step
    public void checkValidResponseWithValidStatusCode(String jsonSchemaFileName) {
        response.then().assertThat().body(matchesJsonSchemaInClasspath(jsonSchemaFileName));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
    }

    @Step
    public void checkKeyValuesInResponseBody(String responseBodyKey, String responseBodyValue){
        String responseKey = response.jsonPath().getString(responseBodyKey);
        Assert.assertEquals(responseKey,responseBodyValue);
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
