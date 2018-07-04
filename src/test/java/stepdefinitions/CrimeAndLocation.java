package stepdefinitions;


import net.serenitybdd.cucumber.CucumberWithSerenity;
import cucumber.api.CucumberOptions;


import org.junit.runner.RunWith;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/features/crime.feature"
)


public class CrimeAndLocation {


}







