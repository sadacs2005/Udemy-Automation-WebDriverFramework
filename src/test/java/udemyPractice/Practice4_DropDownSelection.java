package udemyPractice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.MakeMyTripPage;
import pageObjects.SpiceJetPage;

public class Practice4_DropDownSelection {
    WebDriver      driver = null;
    MakeMyTripPage mmt    = null;
    SpiceJetPage   sjp    = null;

    @BeforeClass
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        mmt = new MakeMyTripPage(driver);
        sjp = new SpiceJetPage(driver);

        driver.manage().window().maximize();

    }

    @Test
    public void Test01_staticDropDown() {

        driver.get("https://www.spicejet.com/");
        sjp.passengers.click();
        Select s = new Select(sjp.adults);
        s.selectByValue("5");
        s.selectByIndex(7);
    }

    @Test
    public void Test02_dynamicDropDown() throws InterruptedException {
        driver.get("https://www.spicejet.com/");
        sjp.origin.click();
        sjp.originMlr.click();
        Thread.sleep(2000);
        sjp.destBlr.click();
    }

    @Test
    public void Test03_autoSuggestiveDropDown() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");
        //Select Source
        mmt.fromCity.click();
        mmt.from.sendKeys("Sydn");
        Thread.sleep(2000);
        mmt.from.sendKeys(Keys.ARROW_DOWN);
        mmt.from.sendKeys(Keys.ENTER);
        //Select Destination
        mmt.to.sendKeys("Van");
        Thread.sleep(2000);
        int i = 0;
        while (i < 2) {
            mmt.to.sendKeys(Keys.ARROW_DOWN);
            i++;
        }
        mmt.to.sendKeys(Keys.ENTER);
    }
}
