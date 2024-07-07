package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShoppingCartPage {
    public ShoppingCartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@aria-label='Show the shopping cart']")
    public WebElement itemsCount;

    @FindBy(xpath = "(//*[@class='mat-button-wrapper'])[13]")
    public WebElement checkoutButton;

}

