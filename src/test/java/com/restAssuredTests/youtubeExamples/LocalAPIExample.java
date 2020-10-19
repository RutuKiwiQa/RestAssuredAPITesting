package com.restAssuredTests.youtubeExamples;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class LocalAPIExample {

    @Test
    public void get_testCase_01(){
        baseURI = "http://localhost:3000/";

        given()
                .get("/users")
                .then()
                    .statusCode(200)
                .log().all();
    }

    @Test
    public void get_testCase_02(){
        baseURI = "http://localhost:3000/";

        given()
                //adding parameters for subjects
                .param("name","Rest Assured API Testing")
                //this passing parameters is actually http://localhost:3000/subjects?name=Rest Assured API Testing in url
                .get("/subjects")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void post_testCase_01(){

        JSONObject request = new JSONObject();

        request.put("firstName", "Detu");
        request.put("lastName","Shah");
        request.put("subjectId", 2);
        request.put("id",4);

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
                        .log().all();
    }

    @Test
    public void patch_testCase_01(){

        JSONObject request = new JSONObject();


        request.put("lastName","Patel");

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .patch("/users/4") //updating user with id 4
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void put_testCase_01(){

        JSONObject request = new JSONObject();


        request.put("firstName", "James");
        request.put("lastName","Bond");
        request.put("subjectId", 1);

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .put("/users/4") //updating user with id 4
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void delete_testCase_01(){
        baseURI = "http://localhost:3000/";

        when()
                .delete("/users/4")
                    .then()
                .statusCode(200)
                .log().all();
    }
}
