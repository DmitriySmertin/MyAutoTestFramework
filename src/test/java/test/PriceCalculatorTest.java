package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import page.MainPage;

public class PriceCalculatorTest extends CommonCondition {

    String search = "Google cloud pricing calculator";


    @Test
    public void priceCalculatorTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
            .search(search)
            .openCalculatorLink()
            .checkInFrame()
            .fillForm("4");
        Thread.sleep(5000);
    }

}
