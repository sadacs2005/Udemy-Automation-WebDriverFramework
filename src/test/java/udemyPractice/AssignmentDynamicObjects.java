package udemyPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.QAClickAcademyHomePage;

public class AssignmentDynamicObjects {
    WebDriver      driver = null;
    QAClickAcademyHomePage cap    = null;

    @BeforeMethod
    public void Launch() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        cap = new QAClickAcademyHomePage(driver);
    }

    @Test
    public void dynamicObject() {
        driver.get("http://www.qaclickacademy.com/practice.php");
        //Select Checkbox and grab the name
        cap.checkBox.click();
        String checkBoxText = cap.checkBoxLabel.getText();
        //Select the option from drop down
        Select s = new Select(cap.dropDownBox);
        s.selectByVisibleText(checkBoxText);
        //Enter the text in alert box
        cap.alertInputBox.sendKeys(checkBoxText);
        cap.alertBtn.click();
        Assert.assertTrue(driver.switchTo().alert().getText().contains(checkBoxText));
        driver.switchTo().alert().accept();
        driver.close();
    }

}
