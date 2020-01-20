package udemyPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.SpiceJetPage;
import udemypractice.Base;

public class Practice5_Checkbox extends Base {
    WebDriver    driver = null;
    SpiceJetPage sjp    = null;

    @BeforeMethod
    public void Launch() throws IOException {
        driver = initilazingDriver();
        sjp = new SpiceJetPage(driver);
        driver.manage().window().maximize();

    }

    @Test
    public void Test01_checkBoxVerify() throws InterruptedException {
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.xpath("//*[@name='checkBoxOption1']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@name='checkBoxOption1']")).isSelected());
        driver.findElement(By.xpath("//*[@name='checkBoxOption1']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//*[@name='checkBoxOption1']")).isSelected());
        driver.close();
    }

    @Test
    public void Test02_verifyNumberofCheckBox() throws InterruptedException {
        driver.get("http://qaclickacademy.com/practice.php");
        int size = driver.findElements(By.xpath("//*[@type='checkbox']")).size();
        System.out.println("The number of check boxes in the page are: " + size);
        driver.close();
    }

    @Test
    public void Test03_verifyEnabledOrDisabled() {
        driver.get("https://www.spicejet.com/");
        Assert.assertFalse(sjp.returnDateEnabledOrNot.getAttribute("style").contains("opacity: 1"));
        sjp.roundTrip.click();
        Assert.assertTrue(sjp.returnDateEnabledOrNot.getAttribute("style").contains("opacity: 1"));

    }

}
