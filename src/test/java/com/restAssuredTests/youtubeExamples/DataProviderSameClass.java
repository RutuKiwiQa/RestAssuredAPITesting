package com.restAssuredTests.youtubeExamples;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/*TODO
*  Note that in this as name suggest we have added data providers and test methods in same class
* .i.e calling the dataproviders in testcase which are created in the same class */

public class DataProviderSameClass {

    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost(){

        //creating object as object can take any datatype
//        Object[][] data = new Object[2][3]; //2 represents the number of rows and 3 represents the number of columns.
//
//        data[0][0] = "Albert";
//        data[0][1] = "Patel";
//        data[0][2] = "2";
//
//        data[1][0] = "Albert";
//        data[1][1] = "Patel";
//        data[1][2] = "1";
//
//        return data;

//data provider function in the same class
        return new Object[][]{
                {"Graham","Bell",1},
                {"Henry","ford",2}
        };
    }

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

    @DataProvider(name = "DeleteData")
    public Object[] dataForDelete(){
        return new Object[]{
            4,5
        };
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
}
