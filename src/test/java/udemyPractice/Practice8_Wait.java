package udemyPractice;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.RahulShettyAcademy;

public class Practice8_Wait {
    WebDriver          driver = null;
    WebDriverWait      w      = null;
    RahulShettyAcademy rsp    = null;

    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        rsp = new RahulShettyAcademy(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void addElementToCart() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        String[] products = {
                "Cucumber", "Mushroom", "Apple", "Cashews "
        };
        addItemsToCart(products);
        rsp.clickOnCart.click();
        rsp.proceedToCheckOut.click();
        rsp.enterPromoCode.sendKeys("rahulshettyacademy");
        rsp.applyPromeCodeBtn.click();
        //Explicit wait
        w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.visibilityOf(rsp.promoInfoMsg));
        Assert.assertTrue(rsp.promoInfoMsg.getText().equals("Promo code applied successfully!"));

    }

    @Test
    public void fluentWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id='start'] button")).click();
        //Fluent wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        WebElement elem = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.xpath("//button[text()='Start']")).isDisplayed()) {
                    return driver.findElement(By.xpath("//button[text()='Start']"));
                } else {
                    return null;
                }
            }
        });
        System.out.println(driver.findElement(By.xpath("//button[text()='Start']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//button[text()='Start']")).getText());
    }

    private void addItemsToCart(String[] products) {
        int totalItems = products.length;
        for (int i = 0; i < totalItems; i++) {
            rsp.getAddToCartBtnByProdName(products[i], driver).click();
        }
    }

}
