package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class EmailGeneratorPage extends AbstractPage {

    private final String TEMP_EMAIL_URL = "https://yopmail.com/ru/";
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 6);
    ArrayList listAllTabs = new ArrayList();

    @FindBy(xpath = "//div[@id]//a[@href='email-generator']")
    WebElement emailGenerateLink;
    @FindBy(id = "egen")
    WebElement email;

    public EmailGeneratorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public EmailGeneratorPage openPage() {
        driver.navigate().to(TEMP_EMAIL_URL);
        return new EmailGeneratorPage(driver);
    }

    public ArrayList createNewTab() {
        jse.executeScript("window.open()");
        return listAllTabs = new ArrayList<>(driver.getWindowHandles());
    }

    public void switchTab(int numberTab) {
        driver.switchTo().window((String) listAllTabs.get(numberTab - 1));
    }

    public String generateEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(emailGenerateLink));
        emailGenerateLink.click();
        wait.until(ExpectedConditions.visibilityOf(email));
        return email.getText();
    }


}
