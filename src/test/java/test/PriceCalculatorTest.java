package test;

import org.testng.annotations.Test;
import page.MainPage;

public class PriceCalculatorTest extends CommonCondition {

    String search = "Google cloud pricing calculator";


    @Test
    public void priceCalculatorTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
            .search(search)
            .openCalculatorLink();
        Thread.sleep(2000);
    }

}
