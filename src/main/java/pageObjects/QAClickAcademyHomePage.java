package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class QAClickAcademyHomePage {
    public QAClickAcademyHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css = "#checkBoxOption2")
    public WebElement checkBox;
    
    @FindBy(xpath = "//input[@id='checkBoxOption2']/..")
    public WebElement checkBoxLabel;
    
    @FindBy(css = "select#dropdown-class-example")
    public WebElement dropDownBox;
    
    @FindBy(css = "#name")
    public WebElement alertInputBox;
    
    @FindBy(css = "#alertbtn")
    public WebElement alertBtn;
    
    @FindBy(css= "table[id='product']")
    public WebElement productTable;
    
    @FindBy(css = "input[id='autocomplete']")
    public WebElement autoComplete;
    
    @FindBy(xpath = "//span[text()='Login']")
    public WebElement Login;
    
    /*@FindBy(css = ".listbuilder-popup-scale")
    public WebElement dynamicPopUP;*/
    
    @FindBys(@FindBy(css=".listbuilder-popup-scale"))
    public List<WebElement> dynamicPopUP;
    
    @FindBy(xpath = "//button[text()='NO THANKS']")
    public WebElement noThanks;
}

