package stepDefinations;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.SpiceJetPage;

@RunWith(Cucumber.class)
public class SpiceJetSD {
    WebDriver    driver = null;
    SpiceJetPage sjp    = null;

    @Given("^User launches the URL \"([^\"]*)\"$")
    public void user_launches_the_URL(String URL) throws Throwable {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        sjp = new SpiceJetPage(driver);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @When("^User clicks on Passengers dropdown$")
    public void user_clicks_on_Passengers_dropdown() throws Throwable {
        sjp.passengers.click();

    }

    @Then("^Verify that static dropdown is working$")
    public void verify_that_static_dropdown_is_working() throws Throwable {
        Select s = new Select(sjp.adults);
        s.selectByValue("5");
        s.selectByIndex(7);
        driver.close();
    }

}
