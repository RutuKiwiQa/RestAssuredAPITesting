package com.restAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class CreateAndTestRequests {

    @Test
    public void TestCase_01(){
                given()
                    .get("https://reqres.in/api/users?page=2")
                .then()
                    .statusCode(200) // it will pass code
                        //checking values of id in array.
                        .body("data.id[0]",equalTo(7))
                        .body("data.id[1]",equalTo(8))
                        .body("data.id[2]",equalTo(9))
                        .body("data.id[3]",equalTo(10))
                        .body("data.id[4]",equalTo(11))
                        .body("data.id[5]",equalTo(12))
                        //to check values of email,firstname ,lastname,avatar in array
                        .body("data.email[0]",equalTo("michael.lawson@reqres.in"))
                        .body("data.first_name[0]",equalTo("Michael"))
                        .body("data.last_name[0]",equalTo("Lawson"))
                        .body("data.avatar[0]",equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg"))
                   //To check firstnames of all
                        .body("data.first_name",hasItems("Michael","Lindsay","Tobias","Byron","George","Rachel"))
                     //   .body()

                    .log().all(); //it will print all the logs into console.
    }
}
