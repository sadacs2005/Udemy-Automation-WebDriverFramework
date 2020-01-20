package udemypractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Base {
    public WebDriver  driver = null;
    public Properties prop   = new Properties();

    @Test
    public WebDriver initilazingDriver() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\global.properties");

        prop.load(fis);

        if (prop.getProperty("browser").contains("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
            if (prop.getProperty("browser").contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);

        } else if (prop.getProperty("browser").equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }

}
