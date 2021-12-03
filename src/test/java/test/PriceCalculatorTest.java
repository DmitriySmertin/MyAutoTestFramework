package test;

import static service.TestDataReader.getTestData;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.EmailGeneratorPage;
import page.MainPage;
import page.calculator.CalculatorPage;
import page.calculator.component.engine.Engine;
import page.calculator.component.instances.optionsEnam.CommittedUsage;
import page.calculator.component.instances.optionsEnam.DataCenter;
import page.calculator.component.instances.optionsEnam.MachineType;
import page.calculator.component.instances.optionsEnam.OsType;
import page.calculator.component.instances.optionsEnam.Series;
import page.calculator.component.instances.optionsEnam.Ssd;
import page.calculator.component.instances.optionsEnam.VmClass;

public class PriceCalculatorTest extends CommonCondition {

    String search = getTestData("base_url");

    @Test
    public void priceCalculatorTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        CalculatorPage calculator = mainPage.openPage()
            .search(search)
            .openCalculatorLink()
            .checkInFrame()
            .fillCalculator("4", Engine.COMPUTE_ENGINE, OsType.FREE_DEBIAN, VmClass.REGULAR, Series.N1,
                            MachineType.N1_STANDARD_8, Ssd.TWO_X_375, DataCenter.FRANKFURT, CommittedUsage.ONE_YEAR)
            .emailEstimate()
            .checkOutFrame();
        EmailGeneratorPage emailPage = new EmailGeneratorPage(driver);
        emailPage.createNewTab();
        emailPage.switchTab(2);
        String genEmail = emailPage.openPage().generateEmail();
        emailPage.switchTab(1);
        calculator
            .checkInFrame()
            .fillEstimateForm(genEmail)
            .checkOutFrame();
        emailPage.switchTab(2);
        String actualResult = emailPage.checkEmail();
        Assert.assertEquals(actualResult, "Google Cloud Price Estimate");
    }

}
