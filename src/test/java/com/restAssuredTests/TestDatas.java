package com.restAssuredTests;

import org.testng.annotations.DataProvider;

/*TODO
*  Note : Here in this class i have added only data providers and whose reference i will add in other classes for
* performing data provider functionalities or parameterization.*/

public class TestDatas {

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


    @DataProvider(name = "DeleteData")
    public Object[] dataForDelete(){
        return new Object[]{
                4,5
        };
    }
}
