package udemyPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import udemypractice.Base;

public class Practice1_LaunchChromeBrowser  extends Base {

    @Test
    public void launchChromeDriver() throws InterruptedException, IOException {
        driver = initilazingDriver();
        driver.get("https://www.wikipedia.org/");
        System.out.println("The title of the page is " + driver.getTitle());
        driver.findElement(By.id("searchInput")).sendKeys("Selenium");
        driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.linkText("Create account"));
        driver.close(); //Closes the current browser
        //driver.quit(); //Closes all the opened browser by the script
    }

}
