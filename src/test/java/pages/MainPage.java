package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']")
    private WebElement cookies;

    @FindBy(xpath = "//*[text()='Me want it!']")
    private WebElement cookies2;

    @FindBy(xpath = "//*[@id='navbarAccount']")
    public WebElement accountButton;

    @FindBy(xpath = "//*[@id='navbarLoginButton']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='navbarLogoutButton']")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[text()=' shopping_cart ']")
    public WebElement yourBasketButton;

    @FindBy(css = ".mat-search_icon-search")
    public WebElement searchButton;

    @FindBy(xpath = "//*[text()=' close ']")
    public WebElement searchButtonClose;

    @FindBy(xpath = "//*[@id='mat-input-0']")
    public WebElement searchField;


    public void cookiesDismiss(){
        cookies.click();
        cookies2.click();
    }

    public void goToBasket(){
        yourBasketButton.click();
    }

    public void searchForProduct(String productName){
        searchButton.click();
        searchField.sendKeys(productName);
        searchField.sendKeys(Keys.ENTER);
    }
}
