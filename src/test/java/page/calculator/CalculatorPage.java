package page.calculator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;
import page.calculator.component.engine.Engine;
import page.calculator.component.engine.EngineComponent;
import page.calculator.component.instances.InstancesComponent;
import page.calculator.component.instances.OsType;
import page.calculator.component.instances.VmClass;

public class CalculatorPage extends AbstractPage {


    WebDriverWait wait = new WebDriverWait(driver, 5);
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    EngineComponent engineComponent = new EngineComponent(driver);
    InstancesComponent instancesComponent = new InstancesComponent(driver);

    @FindBy(css = "article#cloud-site iframe")
    WebElement globalFrame;
    @FindBy(id = "myFrame")
    WebElement calculatorFrame;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement numbInst;
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
    @FindBy(xpath = "//md-select[@placeholder='GPU type']//md-select-value")
    WebElement gpuTypeDropbox;
    @FindBy(xpath = "//md-option//div[contains(text(),'NVIDIA Tesla V100')]")
    WebElement nvidiaTeslaV100;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']//md-select-value")
    WebElement numbOfGpuDropbox;
    @FindBy(xpath = "//md-option[contains(@ng-repeat,'computeServer.gpuType')]//div[contains(text(),'1')]")
    WebElement numbOfGpu1;
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']//md-select-value")
    WebElement localSsdDropbox;
    @FindBy(xpath = "//md-option//div[contains(text(),'2x375 GB')]")
    WebElement ssdOption2x375;
    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.location')]//md-select-value")
    WebElement dataCenterDropbox;
    @FindBy(xpath = "//md-option[contains(@ng-repeat,'.computeServer')]//div[contains(text(),'Frankfurt (europe-west3)')]")
    WebElement dataCenterFrankfurtEW3;
    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.cud')]//md-select-value")
    WebElement committedUsage;
    @FindBy(xpath = "(//md-option//div[contains(text(),'1 Year')])[2]")
    WebElement comUsOneYear;
    @FindBy(xpath = "//button[contains(@ng-click,'(ComputeEngineForm)')]")
    WebElement addToEstimate;
    @FindBy(id = "email_quote")
    WebElement emailEstimateBtn;


    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public CalculatorPage openPage() {
        return this;
    }

    public CalculatorPage checkInFrame() {
        driver.switchTo().frame(globalFrame);
        driver.switchTo().frame(calculatorFrame);
        return new CalculatorPage(driver);
    }

    public void checkOut() {
        driver.switchTo().defaultContent();
    }

    private void addGpu() {
        wait.until(ExpectedConditions.visibilityOf(addGpuCheckBox));
        addGpuCheckBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(gpuTypeDropbox));
        jse.executeScript("arguments[0].click();", gpuTypeDropbox);
        nvidiaTeslaV100.click();
        numbOfGpuDropbox.click();
        numbOfGpu1.click();
    }
    public void scrollToElement(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public CalculatorPage fillForm(String NumberInstance, Engine engine, OsType osType, VmClass vmClass) {
        engineComponent.selectEngine(engine);
        scrollToElement(numbInst);
        numbInst.sendKeys(NumberInstance);
        instancesComponent.selectOS(osType);
        instancesComponent.selectVmClass(vmClass);
        scrollToElement(instancesComponent.OSDropbox);
        wait.until(ExpectedConditions.elementToBeClickable(seriesDropbox));
        seriesDropbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(n1));
        n1.click();
        wait.until(ExpectedConditions.elementToBeClickable(machineTypeDropbox));
        machineTypeDropbox.click();
        scrollToElement(seriesDropbox);
        wait.until(ExpectedConditions.elementToBeClickable(n1Standard8));
        n1Standard8.click();
        addGpu();
        scrollToElement(addGpuCheckBox);
        localSsdDropbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(ssdOption2x375));
        ssdOption2x375.click();
        wait.until(ExpectedConditions.elementToBeClickable(dataCenterDropbox));
        dataCenterDropbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(dataCenterFrankfurtEW3));
        dataCenterFrankfurtEW3.click();
        committedUsage.click();
        wait.until(ExpectedConditions.elementToBeClickable(comUsOneYear));
        comUsOneYear.click();
        addBtnCompEng();
        return new CalculatorPage(driver);
    }

    public void addBtnCompEng() {
        wait.until(ExpectedConditions.elementToBeClickable(addToEstimate));
        addToEstimate.click();
    }

    public void emailEstimate() {
        wait.until(ExpectedConditions.elementToBeClickable(emailEstimateBtn));
        emailEstimateBtn.click();
    }


}
