package test;

import org.testng.annotations.Test;
import page.MainPage;
import page.calculator.component.engine.Engine;
import page.calculator.component.instances.vmClass;

public class PriceCalculatorTest extends CommonCondition {

    String search = "Google cloud pricing calculator";

    @Test
    public void priceCalculatorTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
            .search(search)
            .openCalculatorLink()
            .checkInFrame()
            .fillForm("4", Engine.COMPUTE_ENGINE, vmClass.REGULAR)
            .emailEstimate();
    }

}
