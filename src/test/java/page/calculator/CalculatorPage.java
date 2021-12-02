package page.calculator;

import static page.calculator.component.instances.InstancesComponent.OSDropbox;
import static page.calculator.component.instances.InstancesComponent.selectCommUsage;
import static page.calculator.component.instances.InstancesComponent.selectDataCenter;
import static page.calculator.component.instances.InstancesComponent.selectLocalSsd;
import static page.calculator.component.instances.InstancesComponent.selectMachineType;
import static page.calculator.component.instances.InstancesComponent.selectOS;
import static page.calculator.component.instances.InstancesComponent.selectSeries;
import static page.calculator.component.instances.InstancesComponent.selectVmClass;
import static page.calculator.component.instances.InstancesComponent.seriesDropbox;

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
import page.calculator.component.instances.optionsEnam.CommittedUsage;
import page.calculator.component.instances.optionsEnam.DataCenter;
import page.calculator.component.instances.optionsEnam.MachineType;
import page.calculator.component.instances.optionsEnam.OsType;
import page.calculator.component.instances.optionsEnam.Ssd;
import page.calculator.component.instances.optionsEnam.Series;
import page.calculator.component.instances.optionsEnam.VmClass;

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
    @FindBy(xpath = "//button[contains(@ng-click,'(ComputeEngineForm)')]")
    WebElement addToEstimateBtn;
    @FindBy(id = "email_quote")
    WebElement emailEstimateBtn;
    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    WebElement estimateFormEmailInput;
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement sendEmailBtn;

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

    public CalculatorPage checkOut() {
        driver.switchTo().defaultContent();
        return new CalculatorPage(driver);
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

    public CalculatorPage fillForm(String NumberInstance,
                                   Engine engine,
                                   OsType osType,
                                   VmClass vmClass,
                                   Series series,
                                   MachineType machineType,
                                   Ssd ssd,
                                   DataCenter dataCenter,
                                   CommittedUsage commUsage) {
        engineComponent.selectEngine(engine);
        scrollToElement(numbInst);
        numbInst.sendKeys(NumberInstance);
        selectOS(osType);
        selectVmClass(vmClass);
        scrollToElement(OSDropbox);
        selectSeries(series);
        selectMachineType(machineType);
        scrollToElement(seriesDropbox);
        addGpu();
        scrollToElement(addGpuCheckBox);
        selectLocalSsd(ssd);
        selectDataCenter(dataCenter);
        selectCommUsage(commUsage);
        addBtnCompEng();
        return new CalculatorPage(driver);
    }

    public void addBtnCompEng() {
        wait.until(ExpectedConditions.elementToBeClickable(addToEstimateBtn));
        addToEstimateBtn.click();
    }

    public CalculatorPage emailEstimate() {
        wait.until(ExpectedConditions.elementToBeClickable(emailEstimateBtn));
        emailEstimateBtn.click();
        return new CalculatorPage(driver);
    }

    public CalculatorPage fillEstimateForm(String email) {
        estimateFormEmailInput.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(sendEmailBtn));
        sendEmailBtn.click();
        return new CalculatorPage(driver);
    }


}
