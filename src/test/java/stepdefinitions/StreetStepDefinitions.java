package stepdefinitions;



import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import userdefinedobject.SinglePoint;


import java.util.List;

import static org.hamcrest.Matchers.hasItems;

public class StreetStepDefinitions {

    private SinglePoint singlePointGiven;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    private Response response;


    public SinglePoint getSinglePointGiven() {
        return singlePointGiven;
    }

    public void setSinglePointGiven(SinglePoint singlePointGiven) {
        this.singlePointGiven = singlePointGiven;
    }

    public RequestSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(RequestSpecification specification) {
        this.specification = specification;
    }

    RequestSpecification specification ;

    @Given("^a request with the values$")
    public void aRequestWithTheValues(DataTable singlePoints) {

        List<SinglePoint> dataListSinglePoint= singlePoints.asList(SinglePoint.class);

        singlePointGiven = new SinglePoint(dataListSinglePoint.get(0).getLatitude(),dataListSinglePoint.get(0).getLongitude(),dataListSinglePoint.get(0).getDate());



        setSpecification(RestAssured.
                given().
                param("lat",dataListSinglePoint.get(0).getLatitude()).
                param("lng",dataListSinglePoint.get(0).getLongitude()).
                param("date",dataListSinglePoint.get(0).getDate()));

        setSinglePointGiven(singlePointGiven);

    }

    @When("^the response status is (\\d+)$")
    public void theResponseStatusIs(int httpStatus)  {

        response = RestAssured.given(getSpecification()).
                when().
                get("https://data.police.uk/api/crimes-street/all-crime");
        response.
                then().
                assertThat().
                statusCode(httpStatus);
        setResponse(response);
    }

    @Then("^the category has value \"([^\"]*)\"$")
    public void theCategoryHasValue(String category)  {

        getResponse().
                then().
                body("category",hasItems(category));

    }


    @Given("^requests with the following  <latitude> <longitude> <date>$")
    public void requestsWithTheFollowingLatitudeLongitudeDate() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^http status is (\\d+)$")
    public void httpStatusIs(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the possible value are <result>$")
    public void thePossibleValueAreResult() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
