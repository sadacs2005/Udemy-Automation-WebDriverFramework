package udemyPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice13_Tables {
    WebDriver driver = null;

    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void tableTest() {
        int score = 0;
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22746/ind-vs-ban-1st-t20i-bangladesh-tour-of-india-2019");
        WebElement table = driver.findElement(By.xpath("//span[text()='India Innings']/../.."));
        List<WebElement> batsmanScore = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"));
        int numberOfBatsman = batsmanScore.size();
        for (int i = 0; i < numberOfBatsman - 2; i++) {
            score = score + Integer.parseInt(batsmanScore.get(i).getText());
        }
        int extras = Integer.parseInt(table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());
        int total = Integer.parseInt(table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());
        System.out.println("The total score is " + (score + extras));
        System.out.println("The total is " + total);
        Assert.assertTrue(score + extras == total);
    }

}
