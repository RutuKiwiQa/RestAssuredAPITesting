package com.restAssuredTests.youtubeExamples;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class RestAssuredStaticImportExample {

    @Test
    void testCase_01(){
        Response response = get("https://reqres.in/api/users?page=2"); //as it is static import you can directly use get
        System.out.println("Response as String : " + response.asString());
        System.out.println("Response Body : " +response.getBody());
        System.out.println("Response Status Code : " + response.getStatusCode());
        System.out.println("Reponse Status Line : " +response.getStatusLine());
        System.out.println("Response Header Content : " + response.getHeader("content-type"));
        System.out.println("Response Time : " + response.getTime());

        //To use asserts
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    /* Todo done by using bdd concepts*/
    @Test
    void testCase_02(){

        //This line of code says that check whether the status code is 200 or not for the given url.
      //  given().get("https://reqres.in/api/users?page=2").then().statusCode(201); // it will fail code

                 given()
                    .get("https://reqres.in/api/users?page=2")
                .then()
                         .statusCode(200) // it will pass code
                         .body("data.id[0]", equalTo(7)); //checks that id at first position has 7 as value or not.

        //same code to check fails or not

//                given()
//                    .get("https://reqres.in/api/users?page=2")
//                .then()
//                        .statusCode(200) // it will pass code
//                        .body("data.id[0]", equalTo(9)); //checks that id at first position has 7 as value or not.
    }
}
