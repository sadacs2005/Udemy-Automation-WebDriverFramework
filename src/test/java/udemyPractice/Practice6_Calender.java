package udemyPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.SpiceJetPage;

public class Practice6_Calender {
    WebDriver    driver = null;
    SpiceJetPage sjp    = null;

    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        sjp = new SpiceJetPage(driver);
        driver.manage().window().maximize();

    }

    @Test
    public void Test01_checkBoxVerify() throws InterruptedException {
        driver.get("https://www.spicejet.com/");
        sjp.departDateCal.click();
        sjp.currentDate.click();
        driver.close();
    }
}
