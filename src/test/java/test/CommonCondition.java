package test;

import driver.DriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonCondition {

    protected WebDriver driver;

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeBrowser();
    }

}
