package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void addProductToBasket (){
        WebElement addToBasketButton = Driver.getDriver().findElement(By.xpath("//*[text()='Add to Basket']"));
        addToBasketButton.click();
    }
    public boolean isAddToBasketMessageDisplayed(){
        WebElement addToBasketMessage = Driver.getDriver().findElement(By.xpath("//*[@class='mat-simple-snackbar ng-star-inserted']"));
        return addToBasketMessage.isDisplayed();
    }
}
