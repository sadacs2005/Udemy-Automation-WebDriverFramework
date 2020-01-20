package udemyPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.RahulShettyAcademy;

public class Practice7_Alerts {

    WebDriver          driver = null;
    RahulShettyAcademy rsp    = null;

    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        rsp = new RahulShettyAcademy(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void alerts() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        rsp.alertEnterName.sendKeys("SADA");
        rsp.alertButton.click();
        Assert.assertTrue(driver.switchTo().alert().getText().contains("SADA"));
        driver.switchTo().alert().accept();
    }

}
