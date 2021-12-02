package page.calculator.component.engine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.calculator.component.AbstractComponent;

public class EngineComponent extends AbstractComponent {

    public EngineComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//md-tab-item//div[@title='Compute Engine']")
    WebElement compEngine;
    @FindBy(xpath = "//md-tab-item//div[@title='GKE Standard']")
    WebElement gkeStandard;

    public void selectEngine(Engine engine) {
        switch (engine) {
            case COMPUTE_ENGINE:
                compEngine.click();
                break;
            case GKE_STANDARD:
                gkeStandard.click();
                break;
        }
    }

}
