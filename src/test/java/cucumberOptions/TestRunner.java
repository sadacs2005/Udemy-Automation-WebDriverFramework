package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/Practice4_DropDownSelection.feature", glue = "stepDefinations")

public class TestRunner {

}
