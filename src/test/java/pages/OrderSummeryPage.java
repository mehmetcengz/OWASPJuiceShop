package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrderSummeryPage {
    public OrderSummeryPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "h1.confirmation")
    public WebElement thanksMessage;

    @FindBy(css = "div>mat-card:nth-child(1)>div>div")
    public WebElement orderConfirmationMessage;


}
