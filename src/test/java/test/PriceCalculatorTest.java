package test;

import org.testng.annotations.Test;
import page.MainPage;

public class PriceCalculatorTest extends CommonCondition {

    @Test
    public void priceCalculatorTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
    }

}
