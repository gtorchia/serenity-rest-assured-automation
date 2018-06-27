import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import org.junit.BeforeClass;
import org.junit.Test;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;



public class StreetLevelCrimes {


    @BeforeClass
    public static void setUp() throws IOException {

        HttpURLConnection connection;

        Logger logger = Logger.getLogger(StreetLevelCrimes.class.getName());

        try {

            connection = (HttpURLConnection) new URL("https://data.police.uk/").openConnection();
            connection.setRequestMethod("HEAD");
            if (connection.getResponseCode() != 200) logger.log(Level.INFO, "Server no available");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }



    @Test
    public void streetLevelCrimesTest(){

        RestAssured.when().get("https://data.police.uk/api/crimes-street/all-crime?lat=52.629729&lng=-1.131592&date=2017-01").
                then().assertThat().statusCode(200).
                and().
                body("location_type",hasItems("Force")).
                and().body("category",hasItems("anti-social-behaviour"));
    }

    @Test
    public void streetLevelCrimeWithResponseTest(){

        Response response =RestAssured.when().get("https://data.police.uk/api/crimes-street/all-crime?lat=52.629729&lng=-1.131592&date=2017-01");
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        response.then().body("category",hasItems("anti-social-behaviour"));

    }

    @Test
    public void streetLevelCrimesWithParameterAdded(){


        RestAssured.given().
                param("lat", "52.629729").
                param("lng", "1.131592").
                param("date", "2017-01").
                when().
                get("https://data.police.uk/api/crimes-street/all-crime").
                then().
                assertThat().
                statusCode(200).
                and().
                body("location.latitude",everyItem(hasItems("52.630684")));


    }
}
