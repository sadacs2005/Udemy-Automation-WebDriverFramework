package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBook {
    public FaceBook(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//button[text()='✕']")
    public WebElement closeMark;
    
    @FindBy(xpath = "//span[text()='Men']")
    public WebElement menMenu;
    
    @FindBy(css = "[title='Search for products, brands and more']")
    public WebElement search;
}
