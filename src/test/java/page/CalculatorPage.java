package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage {


    WebDriverWait wait = new WebDriverWait(driver, 5);
    @FindBy(css = "article#cloud-site iframe")
    WebElement globalFrame;
    @FindBy(id = "myFrame")
    WebElement calculatorFrame;
    @FindBy(xpath = "//md-tab-item//div[@title='Compute Engine']")
    WebElement compEngine;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement numbInst;
    @FindBy(xpath = "//md-select[@placeholder='VM Class']//md-select-value")
    WebElement vmClassDropbox;
    @FindBy(xpath = "(//md-option[@value='regular']//div)[2]")
    WebElement vmRegular;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']//md-select-value")
    WebElement OSDropbox;
    @FindBy(xpath = "//md-option[contains(@value,'free')]//div")
    WebElement OSFree;
    @FindBy(xpath = "//md-select[@placeholder='Series']//md-select-value")
    WebElement seriesDropbox;
    @FindBy(xpath = "//md-option//div[contains(text(),'N1')]")
    WebElement n1;
    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    WebElement machineTypeDropbox;
    @FindBy(xpath = "//md-optgroup[@label='standard']//div[contains(text(),'n1-standard-8')]")
    WebElement n1Standard8;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    WebElement addGpuCheckBox;


    protected CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected AbstractPage openPage() {

        return null;
    }

    public CalculatorPage checkInFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(globalFrame);
        driver.switchTo().frame(calculatorFrame);
        return new CalculatorPage(driver);
    }

    public void checkOut() {
        driver.switchTo().defaultContent();
    }

    public void fillForm(String NumberInstance) throws InterruptedException {
        compEngine.click();
        numbInst.sendKeys(NumberInstance);
        OSDropbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(OSFree));
        OSFree.click();
        vmClassDropbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(vmRegular));
        vmRegular.click();
        seriesDropbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(n1));
        n1.click();
        machineTypeDropbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(n1Standard8));
        n1Standard8.click();
        addGpuCheckBox.click();
    }
}
