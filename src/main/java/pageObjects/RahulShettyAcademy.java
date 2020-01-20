package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class RahulShettyAcademy {

    public RahulShettyAcademy(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#name")
    public WebElement       alertEnterName;

    @FindBy(xpath = "//input[@value='Alert']")
    public WebElement       alertButton;

    @FindBys(@FindBy(css = ".product-name"))
    public List<WebElement> productNames;
    
    @FindBys(@FindBy(xpath = "//button[text()='ADD TO CART']"))
    public List<WebElement> addToCart;
    
    @FindBy(css = "img[alt='Cart']")
    public WebElement clickOnCart;
    
    @FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
    public WebElement proceedToCheckOut;
    
    @FindBy(css="input[placeholder='Enter promo code']")
    public WebElement enterPromoCode;
    
    @FindBy(css = ".promoBtn")
    public WebElement applyPromeCodeBtn;
    
    @FindBy(css=".promoInfo")
    public WebElement promoInfoMsg;
    
    @FindBys(@FindBy(xpath = "//tbody/tr/td[2]"))
    public List <WebElement> fruitNames;
    
    @FindBy(css = "tr th:nth-child(2)")
    public WebElement fruitNamesHeader;
    
    public WebElement getAddToCartBtnByProdName(String prodName, WebDriver driver) {
        return driver.findElement(By.xpath("//h4[contains(text(),'"+prodName+"')]/following-sibling::div/button[text()='ADD TO CART']"));
    }

}
