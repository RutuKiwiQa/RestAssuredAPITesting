package guru99Example;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class TC_01GetResponse {

    @Test
    public void getResponseBody(){
        //Note here we will perform get request in order to get the response body.

//        baseURI = "http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

        given().
                when().
                    get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").
                then().
                    statusCode(200). //checks status code
                    log().all(); //prints the reponse of the API
    }
}
