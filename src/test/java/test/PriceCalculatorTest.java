package test;

import org.testng.annotations.Test;
import page.MainPage;
import page.calculator.component.engine.Engine;

public class PriceCalculatorTest extends CommonCondition {

    String search = "Google cloud pricing calculator";


    @Test
    public void priceCalculatorTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
            .search(search)
            .openCalculatorLink()
            .checkInFrame()
            .fillForm("4", Engine.COMPUTE_ENGINE);
        Thread.sleep(5000);
    }

}
