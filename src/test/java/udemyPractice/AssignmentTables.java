package udemyPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.QAClickAcademyHomePage;

public class AssignmentTables {
    WebDriver      driver = null;
    QAClickAcademyHomePage qap    = null;

    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        qap = new QAClickAcademyHomePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void tableTest() {
        driver.get("http://www.qaclickacademy.com/practice.php");
        List<WebElement> rows = qap.productTable.findElements(By.tagName("tr"));
        List<WebElement> col = qap.productTable.findElements(By.tagName("th"));
        System.out.println("Total number of rows is " + rows.size());
        System.out.println("Total number of columns is " + col.size());
        System.out.println("The contents in the 2nd row is \n"+rows.get(2).getText());
    }
}
