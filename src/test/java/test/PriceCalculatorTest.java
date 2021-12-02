package test;

import org.testng.annotations.Test;
import page.MainPage;
import page.calculator.component.engine.Engine;
import page.calculator.component.instances.optionsEnam.CommittedUsage;
import page.calculator.component.instances.optionsEnam.DataCenter;
import page.calculator.component.instances.optionsEnam.MachineType;
import page.calculator.component.instances.optionsEnam.OsType;
import page.calculator.component.instances.optionsEnam.Series;
import page.calculator.component.instances.optionsEnam.Ssd;
import page.calculator.component.instances.optionsEnam.VmClass;

public class PriceCalculatorTest extends CommonCondition {

    String search = "Google cloud pricing calculator";

    @Test
    public void priceCalculatorTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
            .search(search)
            .openCalculatorLink()
            .checkInFrame()
            .fillForm("4", Engine.COMPUTE_ENGINE, OsType.FREE_DEBIAN, VmClass.REGULAR, Series.N1,
                      MachineType.N1_STANDARD_8, Ssd.TWO_X_375, DataCenter.FRANKFURT, CommittedUsage.ONE_YEAR)
            .emailEstimate();
    }

}
