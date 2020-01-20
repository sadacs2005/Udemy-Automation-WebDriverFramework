package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeMyTripPage {
    
    public MakeMyTripPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//input[@placeholder='From']")
    public WebElement from;
    
    @FindBy(xpath = "//input[@placeholder='To']")
    public WebElement to;
    
    @FindBy(css = "#fromCity")
    public WebElement fromCity;

}
