package udemyPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Practice11_DriverScopeAndWindowsHandler {
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
    public void getLinksCount() {
        driver.get("http://www.qaclickacademy.com/practice.php");
        System.out.println("The total number of links is: "+driver.findElements(By.tagName("a")).size());
        //Scope of the driver to footer and find all the links
        WebElement footDriver=driver.findElement(By.xpath("//div[@id=\"gf-BIG\"]"));
        System.out.println(footDriver.findElements(By.tagName("a")).size());
        //Scope of driver is first column in footer and find the links
        WebElement firstColumnFooter=footDriver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
        System.out.println(firstColumnFooter.findElements(By.tagName("a")).size());
        
        //Click on all the links on the footer first column and check if the tabs are opened
        for(int i=1;i<firstColumnFooter.findElements(By.tagName("a")).size();i++) {
            String openLinksOnTab= Keys.chord(Keys.CONTROL,Keys.ENTER);    
            firstColumnFooter.findElements(By.tagName("a")).get(i).sendKeys(openLinksOnTab);
        }
        Set<String> tabs=driver.getWindowHandles();
        Iterator<String> it=tabs.iterator();
        while(it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
        driver.switchTo().defaultContent();
    }


}
