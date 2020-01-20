package stepDefinations;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class WikipediaLaunchSD {
    WebDriver driver =null;

    @Given("^User navigates to wikipedia$")
    public void user_navigates_to_wikipedia() throws Throwable {
        System.out.println("The current directory is "+System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String text) throws Throwable {
        System.out.println("The title of the page is " + driver.getTitle());
        driver.findElement(By.id("searchInput")).sendKeys(text);
        driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @Then("^Verify \"([^\"]*)\" is displayed$")
    public void verify_is_displayed(String arg1) throws Throwable {
        driver.findElement(By.linkText("Create account"));
        driver.close();
    }

}
