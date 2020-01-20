package udemyPractice;

import java.io.IOException;

import org.testng.annotations.Test;

import udemypractice.Base;

public class Practice2_LaunchFirefoxBrowser extends Base {

    @Test
    public void launchChromeDriver() throws IOException {
        driver = initilazingDriver();
        driver.get("https://www.wikipedia.org/");
        System.out.println("The title of the page is " + driver.getTitle());
    }
}
