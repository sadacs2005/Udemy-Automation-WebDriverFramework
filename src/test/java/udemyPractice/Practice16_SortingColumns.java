package udemyPractice;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.RahulShettyAcademy;
import udemypractice.Base;

public class Practice16_SortingColumns extends Base {
    RahulShettyAcademy rsp = null;

    @BeforeMethod
    public void Launch() throws IOException {
       initilazingDriver();
        rsp = new RahulShettyAcademy(driver);
        driver.get(prop.getProperty("SeleniumPracticeURL"));
    }

    @Test
    public void checkSortingOnColumns() {
        List<String> productNames = new ArrayList<String>();
        List<String> productNamesCopy = new ArrayList<String>();
        WebDriverWait w = new WebDriverWait(driver, 2);
        w.until(ExpectedConditions.visibilityOf(rsp.fruitNamesHeader));
        rsp.fruitNamesHeader.click();
        //Add the text of the webElement to arraylist
        System.out.println("The contents of the original list is");
        for (int i = 0; i < rsp.fruitNames.size(); i++) {
            productNames.add(rsp.fruitNames.get(i).getText());
            System.out.println(productNames.get(i));
        }
        //Copy the content of array list to another array list
        for (int i = 0; i < productNames.size(); i++) {
            productNamesCopy.add(productNames.get(i));
            ;
        }
        System.out.println("The contents of the sorted list is");
        Collections.sort(productNamesCopy);
        Collections.reverse(productNamesCopy);
        for (String s : productNamesCopy) {
            System.out.println(s);
        }
        assertTrue(productNames.equals(productNamesCopy));
        driver.close();
    }

}
