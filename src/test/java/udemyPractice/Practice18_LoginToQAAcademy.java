package udemyPractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.QAClickAcademyHomePage;
import pageObjects.QAClickAcademyLoginPage;
import udemypractice.Base;

public class Practice18_LoginToQAAcademy extends Base {

    WebDriver               driver = null;
    QAClickAcademyHomePage  qah    = null;
    QAClickAcademyLoginPage qal    = null;

    @BeforeMethod
    public void launch() throws IOException {
        driver = initilazingDriver();
        qah = new QAClickAcademyHomePage(driver);
        qal = new QAClickAcademyLoginPage(driver);
        driver.get(prop.getProperty("QAClickAcademyURL"));

    }

    @Test
    public void login() throws InterruptedException {
        if (qah.dynamicPopUP.size() > 0) {
            qah.noThanks.click();
        }
        qah.Login.click();
        String username = prop.getProperty("QAClickAcademyLoginUsername");
        String password = prop.getProperty("QAClickAcademyLoginPwd");

        qal.getUserName().sendKeys(username);
        qal.getPassword().sendKeys(password);
        qal.getLogin().click();
        driver.close();
    }

    //@Test(dataProvider = "getData")
    public void MultipeloginCheck(String username, String pwd) {
        if (qah.dynamicPopUP.size() > 0) {
            qah.noThanks.click();
        }
        qah.Login.click();
        qal.getUserName().sendKeys(username);
        qal.getPassword().sendKeys(pwd);
        qal.getLogin().click();

        driver.close();
    }

    @DataProvider
    public Object[][] getData() {
        Object data[][] = new Object[3][2];
        data[0][0] = "abc@gmail.com";
        data[0][1] = "abc123";
        data[1][0] = "def@gmail.com";
        data[1][1] = "def123";
        data[2][0] = "ghi@gmail.com";
        data[2][1] = "ghi123";
        return data;
    }
}
