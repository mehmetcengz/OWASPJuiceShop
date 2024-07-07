package pages;

import data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class RegistrationPage {

    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='emailControl']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='passwordControl']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='repeatPasswordControl']")
    private WebElement repeatPasswordField;

    @FindBy(css = ".mat-select-placeholder")
    private WebElement securityQuestionDropdown;

    @FindBy(xpath = "//*[@id='securityAnswerControl']")
    private WebElement securityAnswerField;

    @FindBy(xpath = "//*[@id='registerButton']")
    private WebElement registerButton;

    @FindBy(css = "simple-snack-bar")
    private WebElement successMessage;


    public void open(){
        Driver.getDriver().get(ConfigReader.getProperty("registrationURL"));
    }

    public void selectSecurityQuestion(String questionText) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        securityQuestionDropdown.click();
        WebElement questionOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'" + questionText + "')]")));
        questionOption.click();
    }

    public void register(UserData userData){
        emailField.sendKeys(userData.getEmail());
        passwordField.sendKeys(userData.getPassword());
        repeatPasswordField.sendKeys(userData.getConfirmPassword());
        selectSecurityQuestion(userData.getSecurityQuestion());
        securityAnswerField.sendKeys(userData.getSecurityAnswer());
        registerButton.click();
    }

    public boolean isRegistrationSuccessful(){
        return successMessage.isDisplayed();
    }
}
