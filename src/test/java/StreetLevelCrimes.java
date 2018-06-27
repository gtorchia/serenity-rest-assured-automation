import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;



public class StreetLevelCrimes {

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
