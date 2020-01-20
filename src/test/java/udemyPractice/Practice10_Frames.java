package udemyPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.FaceBook;

public class Practice10_Frames {

    WebDriver driver = null;
    FaceBook  fbp    = null;

    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void handlingWindows() {
        driver.get("https://jqueryui.com/droppable/");
        System.out.println("The number of frames is " + driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        WebElement source = driver.findElement(By.xpath("//p[text()='Drag me to my target']/.."));
        WebElement target = driver.findElement(By.xpath("//p[text()='Drop here']/.."));
        Actions act = new Actions(driver);
        act.dragAndDrop(source, target).build().perform();
        driver.switchTo().defaultContent();
    }

}
