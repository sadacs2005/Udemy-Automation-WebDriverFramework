package udemyPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice12_Calendar {

    WebDriver driver = null;

    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void selectCalendar() throws InterruptedException {
        boolean findYear = false;
        String day = "26";
        String month = "Sep";
        String year = "2021";
        driver.get("https://www.path2usa.com/travel-companions");
        driver.findElement(By.xpath("//input[@name='travel_date']")).click();
        driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).click();
        driver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='datepicker-switch']")).click();

        //Click on the correct year
        while (!findYear) {
            List<WebElement> years = driver.findElements(By.xpath("//span[contains(@class,'year')]"));
            for (int i = 0; i < years.size(); i++) {
                if (years.get(i).getText().equals(year)) {
                    years.get(i).click();
                    findYear = true;
                    break;
                }
            }
            if (!findYear) {
                driver.findElement(By.xpath("//div[@class='datepicker-years']//th[@class='next']")).click();
            }
        }
        Thread.sleep(2000);

        //Click on the correct month
        List<WebElement> months = driver.findElements(By.xpath("//div[@class='datepicker-months']//span[@class='month']"));
        for (int i = 1; i < months.size(); i++) {
            if (months.get(i).getText().equalsIgnoreCase(month)) {
                months.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
        List<WebElement> days = driver.findElements(By.className("day"));

        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).getText().equals(day)) {
                days.get(i).click();
                break;
            }
        }
    }
}
