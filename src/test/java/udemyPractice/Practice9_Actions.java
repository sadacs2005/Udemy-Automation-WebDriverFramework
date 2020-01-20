package udemyPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.FaceBook;


public class Practice9_Actions {
    WebDriver driver=null;
    FaceBook fbp=null;
    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        fbp=new FaceBook(driver);
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    
    @Test
    public void actions() {
        driver.get("https://www.flipkart.com/");
        fbp.closeMark.click();
        Actions act=new Actions(driver);
        act.moveToElement(fbp.menMenu).build().perform();
        //Move to an element, double click on element and then right click
        act.moveToElement(fbp.search).click().keyDown(Keys.SHIFT).sendKeys("television").doubleClick().contextClick().build().perform();
        
    }

}
