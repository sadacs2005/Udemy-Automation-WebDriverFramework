package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features/Practice4_DropDownSelection.feature", glue = "stepDefinations")

public class TestRunnerWithTestNG extends AbstractTestNGCucumberTests {

}
