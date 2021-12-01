package page.calculator.component.instances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.calculator.component.AbstractComponent;

public class InstancesComponent extends AbstractComponent {

    @FindBy(xpath = "//md-select[@placeholder='VM Class']//md-select-value")
    WebElement vmClassDropbox;
    @FindBy(xpath = "(//md-option[@value='regular']//div)[2]")
    WebElement vmRegular;

    public InstancesComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void selectVMClass(vmClass vm) {
        wait.until(ExpectedConditions.elementToBeClickable(vmClassDropbox));
        vmClassDropbox.click();
        switch (vm) {
            case REGULAR:
                wait.until(ExpectedConditions.elementToBeClickable(vmRegular));
                vmRegular.click();
                break;
            case PREEMPTIBLE:
                break;
        }
    }
}
