package guru99Example;

import org.testng.annotations.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class FetchDifferentPartsOFResponse {

    public static String url = "https://reqres.in/api/users?page=2";

    @Test
    public void fetchHeaders(){
        //This method will fetch the header;

        System.out.println("The Headers in the Reponse." +
                get(url)
                    .then()
                        .extract().headers());

    }

    @Test
    public void fetchTime(){
        System.out.println("The Time taken to fetch the response is : + " +
                get(url)
                    .then()
                        .extract().timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }

    @Test
    public void fetchContentType(){
        System.out.println("The contentType of the response is : + " +
                get(url)
                        .then()
                        .extract().contentType());
    }

    @Test
    public void fetchAllAmounts(){

        ArrayList<String> amounts = when().get(url).then().extract().path("result.statement.AMOUNT");
        int sumOFAll = 0;

        for(String a : amounts){
            System.out.println( " The amount value fetch is : " +a);
            sumOFAll = sumOFAll+Integer.valueOf(a);
        }

        System.out.println("The total amount is : " +sumOFAll);
    }

}
