package stepdefinitions;

import cucumber.api.DataTable;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



import userdefinedobject.Location;

import java.util.List;



import static org.hamcrest.Matchers.hasItems;


public class CrimeStepDefinitions {

    RequestSpecification specification ;

    Location locationCrime;

    Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }




    public RequestSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(RequestSpecification specification) {
        this.specification = specification;
    }




    @Given("^a request with the details$")
    public void aRequestWithTheDetails(DataTable requestWithDetailDataTable)  {

        List<Location> dataListLocation= requestWithDetailDataTable.asList(Location.class);

        locationCrime = new Location(dataListLocation.get(0).getLocation(),dataListLocation.get(0).getDate());

            setSpecification(RestAssured.
                given().
                param("location",dataListLocation.get(0).getLocation()).
                param("date",dataListLocation.get(0).getDate()));



    }


    @When("^the client receive the status (\\d+)$")
    public void theClientReceiveTheStatusOK(int  httpStatusValue)  {

        response =RestAssured.given().
                param("date", locationCrime.getDate()).
                param("location_id", locationCrime.getLocation()).
                when().
                get("https://data.police.uk/api/crimes-at-location");

        response.
                then().
                assertThat().
                statusCode(httpStatusValue);

         setResponse(response);

    }






    @Then("^the client result  is \"([^\"]*)\"$")
    public void theClientResultIs(String resultFromEnquiryApi)  {
        getResponse().
                then().
                body("category",hasItems(resultFromEnquiryApi));

    }
}
