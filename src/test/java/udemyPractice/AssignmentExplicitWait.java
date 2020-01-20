package udemyPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentExplicitWait {
    WebDriver     driver = null;
    WebDriverWait w      = null;

    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void explicitWaitAssignment() {
        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")).click();
        w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div#results"))));
        System.out.println("The text displayed is\n" + driver.findElement(By.cssSelector("div#results")).getText());
    }

}
