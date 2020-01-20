package udemyPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.QAClickAcademyHomePage;

public class AssignedAutoSuggestive {
    WebDriver      driver = null;
    QAClickAcademyHomePage qap    = null;

    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        qap = new QAClickAcademyHomePage(driver);
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void autoSuggestive() throws InterruptedException {
        boolean isFound = false;
        driver.get("http://www.qaclickacademy.com/practice.php");
        qap.autoComplete.sendKeys("Uni");
        int counter = 0;
        while (!isFound) {
            counter++;
            Thread.sleep(1000);
            qap.autoComplete.sendKeys(Keys.DOWN);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //String script= "return document.getElementById(\"autocomplete\").value;";
            String script = "return document.evaluate(\"//input[@id='autocomplete']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.value;";
            String placeName = (String) jse.executeScript(script);
            if (placeName.equalsIgnoreCase("United States")) {
                isFound = true;
                System.out.println("Match Found");
                break;
            }
            if (counter >= 10) {
                System.out.println("Place not found");
                break;
            }
        }
        qap.autoComplete.sendKeys(Keys.ENTER);
    }
}
