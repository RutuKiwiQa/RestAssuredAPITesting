package com.restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_01_GET {

    @Test
    void testCase_01(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Response as String : " + response.asString());
        System.out.println("Response Body : " +response.getBody());
        System.out.println("Response Status Code : " + response.getStatusCode());
        System.out.println("Reponse Status Line : " +response.getStatusLine());
        System.out.println("Response Header Content : " + response.getHeader("content-type"));
        System.out.println("Response Time : " + response.getTime());

        //To use asserts
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
    }
}
