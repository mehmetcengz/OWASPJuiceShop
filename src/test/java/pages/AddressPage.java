package pages;

import data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class AddressPage {
    public AddressPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public void open (){
        Driver.getDriver().get(ConfigReader.getProperty("addressSelectURL"));
    }

    @FindBy(xpath = "//*[@aria-label='Add a new address']")
    public WebElement addNewAddressButton;

    @FindBy(xpath = "//*[@data-placeholder='Please provide a country.']")
    public WebElement countryField;

    @FindBy(xpath = "//*[@data-placeholder='Please provide a name.']")
    public WebElement nameField;

    @FindBy(xpath = "//*[@data-placeholder='Please provide a mobile number.']")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//*[@data-placeholder='Please provide a ZIP code.']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//*[@data-placeholder='Please provide an address.']")
    private WebElement addressField;

    @FindBy(xpath = "//*[@data-placeholder='Please provide a city.']")
    private WebElement cityField;

    @FindBy(xpath = "//*[@data-placeholder='Please provide a state.']")
    private WebElement stateField;

    @FindBy(xpath = "//*[@id='submitButton']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id='mat-radio-42']")
    public WebElement selectAddressRadioBtn;

    @FindBy(xpath = "//*[@aria-label='Proceed to payment selection']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id='mat-radio-43']")
    public WebElement oneDayDeliveryRadioBtn;

    @FindBy(xpath = "//*[@id='mat-radio-44']")
    private WebElement fastDeliveryRadioBtn;

    @FindBy(xpath = "//*[@id='mat-radio-45']")
    private WebElement standardDeliveryRadioBtn;

    @FindBy(xpath = "//*[@aria-label='Proceed to delivery method selection']")
    public WebElement continueButton2;



    public void addNewAddressForm (UserData userData){
        countryField.sendKeys(userData.getCountry());
        nameField.sendKeys(userData.getName());
        mobileNumberField.sendKeys(userData.getMobileNumber());
        zipCodeField.sendKeys(userData.getZipCode());
        addressField.sendKeys(userData.getAddress());
        cityField.sendKeys(userData.getCity());
        stateField.sendKeys(userData.getState());
    }

    public boolean successMessage() {
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//*[@class='mat-simple-snackbar ng-star-inserted']"));
        return successMessage.isDisplayed();
    }

    public void chooseDeliverySpeed(String deliveryType){
        switch (deliveryType) {
            case "One Day Delivery" -> oneDayDeliveryRadioBtn.click();
            case "Fast Delivery" -> fastDeliveryRadioBtn.click();
            case "Standard Delivery" -> standardDeliveryRadioBtn.click();
        }
    }
}
