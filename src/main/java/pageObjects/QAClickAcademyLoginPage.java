package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAClickAcademyLoginPage {

    WebDriver driver;

    public QAClickAcademyLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#user_email")
    private WebElement userName;

    @FindBy(css = "#user_password")
    private WebElement password;

    @FindBy(css = "input[value='Log In']")
    private WebElement Login;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogin() {
        return Login;
    }
}
