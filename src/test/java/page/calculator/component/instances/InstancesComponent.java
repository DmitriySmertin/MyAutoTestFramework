package page.calculator.component.instances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.calculator.component.AbstractComponent;

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


    public void selectOS(OsType osType){
        wait.until(ExpectedConditions.elementToBeClickable(OSDropbox));
        OSDropbox.click();
        switch (osType){
            case FREE_DEBIAN:
                wait.until(ExpectedConditions.elementToBeClickable(OSFree));
                OSFree.click();
                break;
            case PAID_SLES:
                break;
            case PAID_UBUNTU:
                break;
        }
//        scrollToElement(OSDropbox);
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
}
