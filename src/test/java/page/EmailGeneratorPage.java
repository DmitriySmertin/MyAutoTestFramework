package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.TestDataReader;

import java.util.ArrayList;

public class EmailGeneratorPage extends AbstractPage {

    private final String TEMP_EMAIL_URL = TestDataReader.getTestData("email_url");
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 6);
    ArrayList listAllTabs = new ArrayList();

    @FindBy(xpath = "//div[@id]//a[@href='email-generator']")
    WebElement emailGenerateLink;
    @FindBy(id = "egen")
    WebElement email;
    @FindBy(xpath = "//button[@onclick='egengo();']")
    WebElement checkEmailBtn;
    @FindBy(id = "refresh")
    WebElement refreshBtn;
    @FindBy(className = "lms")
    WebElement textHeaderMail;
    @FindBy(id = "message")
    WebElement emptyMail;
    @FindBy(id = "ifinbox")
    WebElement mailFrame;

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

    public String checkEmail() {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.elementToBeClickable(checkEmailBtn));
        checkEmailBtn.click();
        wait.until(ExpectedConditions.visibilityOf(emptyMail));
        while (emptyMail.isDisplayed()) {
            refreshBtn.click();
        }
        wait.until(ExpectedConditions.visibilityOf(mailFrame));
        driver.switchTo().frame(mailFrame);
        return textHeaderMail.getText();
    }
}
