package com.restAssuredTests.BrokenLinks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


/*TODO Code added by Rutu Shah
*  Date : - 11th September 2020*/
public class BrokenLinks {

    public static void main(String[] args) throws InterruptedException, IOException, UnknownHostException {
        //Initiate driver
        System.setProperty("webdriver.chrome.driver", "E:\\API_REST_ASSURED_TESTING\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //maximize the page
        driver.manage().window().maximize();

        //implicit wait for 10 secs
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //open url of app
        driver.get("https://www.jio.com");

        //wait
        Thread.sleep(5000);

        //capture links from a webpage
        List<WebElement> links =  driver.findElements(By.tagName("a"));

        //number of links
        System.out.println("Link size : " + links.size());


        //read each and every link
        for (int i = 0; i < links.size(); i++){
              //by using href attribute we can get URL of required link

            WebElement element = links.get(i); //capture the element
            String url = element.getAttribute("href");

            if (isUrlValid(url)) {
                URL link = new URL(url);

                //to check whether target page is connected to the link or not without click on target url
                //create a connection using url object link
                HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();


                Thread.sleep(2000);

                httpConn.setConnectTimeout(3000);

                //connect () method used to establish connection
                httpConn.connect();

                //capture response code
                int resCode = httpConn.getResponseCode(); //return response if res code is above 400 : broken link

                if (resCode >= 400) {
                    System.out.println(url + " - " + "is a broken link.");
                } else {
                    System.out.println(url + " - " + "is a valid link.");
                }

            }

        }

        driver.quit();
    }

    public static boolean isUrlValid(String url) throws UnknownHostException {
        try {
            URL obj = new URL(url);
            obj.toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }

}
