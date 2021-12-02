package page.calculator.component.instances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.calculator.component.AbstractComponent;
import page.calculator.component.instances.optionsEnam.CommittedUsage;
import page.calculator.component.instances.optionsEnam.DataCenter;
import page.calculator.component.instances.optionsEnam.MachineType;
import page.calculator.component.instances.optionsEnam.OsType;
import page.calculator.component.instances.optionsEnam.Series;
import page.calculator.component.instances.optionsEnam.Ssd;
import page.calculator.component.instances.optionsEnam.VmClass;

public class InstancesComponent extends AbstractComponent {

    public InstancesComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    //Operating System/Software
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']//md-select-value")
    public WebElement OSDropbox;
    @FindBy(xpath = "//md-option[contains(@value,'free')]//div")
    WebElement OSFree;

    //vmClass
    @FindBy(xpath = "//md-select[@placeholder='VM Class']//md-select-value")
    WebElement vmClassDropbox;
    @FindBy(xpath = "(//md-option[@value='regular']//div)[2]")
    WebElement vmRegular;

    //Series
    @FindBy(xpath = "//md-select[@placeholder='Series']//md-select-value")
    public WebElement seriesDropbox;
    @FindBy(xpath = "//md-option//div[contains(text(),'N1')]")
    WebElement n1;

    //Machine Type
    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    WebElement machineTypeDropbox;
    @FindBy(xpath = "//md-optgroup[@label='standard']//div[contains(text(),'n1-standard-8')]")
    WebElement n1Standard8;

    //SSD
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']//md-select-value")
    WebElement localSsdDropbox;
    @FindBy(xpath = "//md-option//div[contains(text(),'2x375 GB')]")
    WebElement ssdOption2x375;

    //Data Center
    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.location')]//md-select-value")
    WebElement dataCenterDropbox;
    @FindBy(xpath = "//md-option[contains(@ng-repeat,'.computeServer')]//div[contains(text(),'Frankfurt (europe-west3)')]")
    WebElement frankfurtEW3;

    //Committed Usage
    @FindBy(xpath = "//md-select[contains(@ng-model,'computeServer.cud')]//md-select-value")
    WebElement committedUsage;
    @FindBy(xpath = "(//md-option//div[contains(text(),'1 Year')])[2]")
    WebElement comUsOneYear;

    public void selectOS(OsType osType) {
        wait.until(ExpectedConditions.elementToBeClickable(OSDropbox));
        OSDropbox.click();
        switch (osType) {
            case FREE_DEBIAN:
                wait.until(ExpectedConditions.elementToBeClickable(OSFree));
                OSFree.click();
                break;
            case PAID_SLES:
                break;
            case PAID_UBUNTU:
                break;
        }
    }

    public void selectVmClass(VmClass vmClass) {
        wait.until(ExpectedConditions.elementToBeClickable(vmClassDropbox));
        vmClassDropbox.click();
        switch (vmClass) {
            case REGULAR:
                wait.until(ExpectedConditions.elementToBeClickable(vmRegular));
                vmRegular.click();
                break;
            case PREEMPTIBLE:
                break;
        }
    }

    public void selectSeries(Series series) {
        wait.until(ExpectedConditions.elementToBeClickable(seriesDropbox));
        seriesDropbox.click();
        switch (series) {
            case N1:
                wait.until(ExpectedConditions.elementToBeClickable(n1));
                n1.click();
            case N2:
                break;
            case E2:
                break;
        }
    }

    public void selectMachineType(MachineType machineType) {
        wait.until(ExpectedConditions.elementToBeClickable(machineTypeDropbox));
        machineTypeDropbox.click();
        switch (machineType) {
            case N1_STANDARD_1:
                break;
            case N1_STANDARD_8:
                wait.until(ExpectedConditions.elementToBeClickable(n1Standard8));
                n1Standard8.click();
                break;
            case N1_HIGH_MEM_2:
                break;
        }
    }

    public void selectLocalSsd(Ssd ssd) {
        wait.until(ExpectedConditions.elementToBeClickable(localSsdDropbox));
        localSsdDropbox.click();
        switch (ssd) {
            case ZERO:
                break;
            case ONE_X_375:
                break;
            case TWO_X_375:
                wait.until(ExpectedConditions.elementToBeClickable(ssdOption2x375));
                ssdOption2x375.click();
                break;
        }
    }

    public void selectDataCenter(DataCenter dataCenter) {
        wait.until(ExpectedConditions.elementToBeClickable(dataCenterDropbox));
        dataCenterDropbox.click();
        switch (dataCenter) {
            case IOWA:
                break;
            case OREGON:
                break;
            case FRANKFURT:
                wait.until(ExpectedConditions.elementToBeClickable(frankfurtEW3));
                frankfurtEW3.click();
        }
    }

    public void selectCommUsage(CommittedUsage commUsage) {
        wait.until(ExpectedConditions.elementToBeClickable(committedUsage));
        committedUsage.click();
        switch (commUsage) {
            case NONE:
                break;
            case ONE_YEAR:
                wait.until(ExpectedConditions.elementToBeClickable(comUsOneYear));
                comUsOneYear.click();
                break;
        }
    }
}
