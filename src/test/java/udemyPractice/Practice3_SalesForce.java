package udemyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice3_SalesForce {
    
    @Test
    public void SalesForce() {
        
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/?locale=in");
        //CSS selector
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("sadacs2005@gmail.com");
        //CSS selector tagName#id
        driver.findElement(By.cssSelector("input#password")).sendKeys("sada123");
        //CSS selector #id
        driver.findElement(By.cssSelector("#Login")).click();
        //CSS Regular expression
        driver.findElement(By.cssSelector("a[id*='forgot_password']")).click();
        //Other CSS selector tagName.className
        driver.close();
    }

}
