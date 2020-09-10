package com.restAssuredTests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataProviderDifferentClass extends TestDatas{

    @Test(dataProvider = "DataForPost")
    public void post_testCase_01(String firstName,String lastName, int subjectId){

        JSONObject request = new JSONObject();

        request.put("firstName",firstName);
        request.put("lastName",lastName);
        request.put("subjectId", subjectId);


        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .   log().all();
    }

    @Test(dataProvider = "DeleteData")
    public void delete_testCase_01(int userId){
        baseURI = "http://localhost:3000/";

        when()
                .delete("/users/" + userId)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Parameters({"userId"}) // here the value for userID will be coming from testng.xml
    @Test()
    public void delete_testCase_02(int userId){
        System.out.println("Value for user id to be deleted is : " +userId);
        baseURI = "http://localhost:3000/";

        when()
                .delete("/users/" + userId)
                .then()
                .statusCode(200)
                .log().all();
    }
}
