package udemyPractice;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice19_ReadingProperties {

    @Test
    @Parameters({
            "Juice"
    })
    public void getPropertyValuesFromTestng(@Optional String Juice) {
        System.out.println("The type of juice is " + Juice);
    }

    @Test
    public void getpropertyValueFromMaven() {
        System.out.println("The type of juice is " + System.getProperty("Juice"));
        System.out.println("The type of fruit is " + System.getProperty("Fruit"));
    }

}
