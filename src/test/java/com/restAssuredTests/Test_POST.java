package com.restAssuredTests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Test_POST {

    /*POST :-
        In post example we also need to pass the body(json body).
        So for that you can either use and map and convert into json or directly use some json libraries
        Some json libraries are gson,jackson,json,simple json
        I will be added json simple library from central maven and add it into my pom.xml to convert map into json.
*/

    @Test
    public void post_testCase_01(){

        //In testcase 01 we converted map into json object

        //creating a map to create the body
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","Rutu");
        map.put("job","Tester");
        System.out.println( "MAP FORMAT : " + map);

        //to convert map into json object just say jsonobject
        JSONObject request = new JSONObject(map); //passing map in jsonobject parameter

        System.out.println("JSON FORMAT : " + request); //printing json request
        System.out.println(request.toJSONString());

    }

    @Test
    public void post_testCase_02(){

        //in this testcase we will directly add keyvalues into json request object

        JSONObject request = new JSONObject();

        request.put("name","Rutu");
        request.put("job","Tester");

        System.out.println("JSON FORMAT : " + request); //printing json request
        System.out.println("JSON FORMAT using toJsonString : " + request.toJSONString());

                given().
                        header("Content-Type","application/json").
                        contentType(ContentType.JSON).accept(ContentType.JSON). // it should accept contenttype of json
                        body(request.toJSONString())
                   .when().
                         post("https://reqres.in/api/users").
                         then().
                        statusCode(201);
                            // statusCode(200);//this will purposly fail bcz in post for creating request we have status code 201
    }

    @Test
    public void put_testCase_01(){

        //put is used to update the request
        JSONObject request = new JSONObject();

        request.put("name","Rutu");
        request.put("job","Tester");

        System.out.println("JSON FORMAT : " + request); //printing json request
        System.out.println("JSON FORMAT using toJsonString : " + request.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON). // it should accept contenttype of json
                body(request.toJSONString())
                .when().
                put("https://reqres.in/api/users/2"). //for put we only need to change post to put

                then().
                statusCode(200) // to check status code is 200
                .log().all(); //it will print all the logs into console.;

    }


    @Test
    public void patch_testCase_01(){

        //patch is used to update the request
        JSONObject request = new JSONObject();

        request.put("name","Rutu");
        request.put("job","Tester");

        System.out.println("JSON FORMAT : " + request); //printing json request
        System.out.println("JSON FORMAT using toJsonString : " + request.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON). // it should accept contenttype of json
                body(request.toJSONString())
                .when().
                patch("https://reqres.in/api/users/2"). //for patch we only need to change put to patch and change end point(url)

                then().
                statusCode(200) // to check status code is 200
                .log().all(); //it will print all the logs into console.;

    }

    @Test
    public void delete_testCase_01(){
        //for delete body is not required.

                when().
                delete("https://reqres.in/api/users/2").

                then().
                statusCode(204) // to check status code is 204 for deleting api
                //statusCode(200) //this should fail
                .log().all(); //it will print all the logs into console.;

    }
}

