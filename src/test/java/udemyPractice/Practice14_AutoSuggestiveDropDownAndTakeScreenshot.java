package udemyPractice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice14_AutoSuggestiveDropDownAndTakeScreenshot {
    WebDriver driver = null;

    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void autoSuggestive() throws IOException {
        driver.get("https://ksrtc.in/oprs-web/");
        WebElement leavingFrom = driver.findElement(By.cssSelector("input[value='Leaving From:']"));
        leavingFrom.sendKeys("BENG");
        boolean isFound = false;
        int i = 0;
        while (!isFound) {
            i++;
            leavingFrom.sendKeys(Keys.DOWN);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            String script = "return document.getElementById(\"fromPlaceName\").value;";
            if (((String) jse.executeScript(script)).contains("AIRPORT")) {
                isFound = true;
                takeScreenshot();
            }
            if (i >= 10) {
                System.out.println("The Element is not found");
                break;
            }
        }
        leavingFrom.sendKeys(Keys.ENTER);
    }

    private void takeScreenshot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\Screenshot1.png"));
    }
}
