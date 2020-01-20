package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpiceJetPage {
    
    public SpiceJetPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
     
    @FindBy(css =  "#ctl00_mainContent_ddl_originStation1_CTXT")
    public WebElement origin;
    
    @FindBy(xpath = "//a[normalize-space(text())='Mangaluru (IXE)']")
    public WebElement originMlr;
    
    @FindBy(xpath = "//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[normalize-space(text())='Bengaluru (BLR)']")
    public WebElement destBlr;
    
    @FindBy(xpath = "//div[contains(text(),'Adult')]")
    public WebElement passengers;
    
    @FindBy(css = "select[name='ctl00$mainContent$ddl_Adult']")
    public WebElement adults;
    
    @FindBy(css = ".ui-state-default.ui-state-highlight.ui-state-active")
    public WebElement currentDate;
    
    @FindBy(xpath = "//label[normalize-space(text())='Depart date']/../following-sibling::button")
    public WebElement departDateCal;
    
    @FindBy(xpath = "//label[normalize-space(text())='Return date']/../..")
    public WebElement returnDateEnabledOrNot;
    
    @FindBy(xpath = "//label[text()='Round Trip']/preceding-sibling::input")
    public WebElement roundTrip;
}
