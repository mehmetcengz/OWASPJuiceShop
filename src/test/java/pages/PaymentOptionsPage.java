package pages;

import data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PaymentOptionsPage {
    public PaymentOptionsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id='mat-expansion-panel-header-0']")
    private WebElement addNewCard;

    @FindBy(css = "div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(1) input")
    private WebElement nameField;

    @FindBy(css = "div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(2) input")
    private WebElement cardNumberField;

    @FindBy(css = "div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(3) select")
    private WebElement expiryMonth;

    @FindBy(css = "div.mat-expansion-panel-body > div > mat-form-field.mat-form-field:nth-child(4) select")
    private WebElement expiryYear;

    public void addNewCreditCard(UserData userData){

        nameField.sendKeys(userData.getName());
        cardNumberField.sendKeys(userData.getCreditCardNumber());
        expiryMonth.sendKeys(userData.getExpiryMonth());
        expiryYear.sendKeys(userData.getExpiryYear());
        submitButton.click();
    }
    public boolean successMessage() {
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//*[@class='mat-simple-snackbar ng-star-inserted']"));
        return successMessage.isDisplayed();
    }

    @FindBy(id = "submitButton")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id='mat-radio-46']")
    public WebElement creditCardRadioBtn;

    @FindBy(css = "div.custom-card.ng-star-inserted > div > div:nth-child(3) > button")
    public WebElement walletBalancePayButton;

    @FindBy(xpath = "//*[@id='mat-expansion-panel-header-1']")
    private WebElement addACoupon;

    @FindBy(xpath = "//*[@placeholder='Please enter your coupon code']")
    public WebElement couponField;

    @FindBy(xpath = "//*[@id='applyCouponButton']")
    public WebElement couponRedeemButton;

    @FindBy(xpath = "//*[@id='mat-expansion-panel-header-2']")
    private WebElement otherPaymentOptions;

    @FindBy(xpath = "//*[@aria-label='Proceed to review']")
    public WebElement continueButton;

    public void choosePaymentOptions(String paymentOptions){
        switch (paymentOptions){
            case "Add new card" -> addNewCard.click();
            case "Pay using wallet" -> walletBalancePayButton.click();
            case "Add a coupon" -> addACoupon.click();
            case "Other payment options" -> otherPaymentOptions.click();
        }
    }

    @FindBy(xpath = "//*[@aria-label='Complete your purchase']")
    public WebElement placeOrderPayButton;


}
