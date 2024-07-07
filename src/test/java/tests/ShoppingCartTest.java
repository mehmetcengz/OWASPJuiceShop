package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import utilities.ConfigReader;
import utilities.Driver;

public class ShoppingCartTest {
    private final MainPage mainPage = new MainPage();
    private final ProductPage productPage = new ProductPage();
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("searchURL"));
    }
    @Test (groups = "functional", dependsOnGroups = "smoke")
    public void addItemsToBasketTest() throws InterruptedException {
        mainPage.searchForProduct("Apple Juice");
        productPage.addProductToBasket();
        Assert.assertTrue(productPage.isAddToBasketMessageDisplayed());
        mainPage.searchButtonClose.click();
        Thread.sleep(1000);

        mainPage.searchForProduct("Banana Juice");
        productPage.addProductToBasket();
        Assert.assertTrue(productPage.isAddToBasketMessageDisplayed());
        mainPage.searchButtonClose.click();
        Thread.sleep(1000);

        mainPage.goToBasket();
        Assert.assertTrue(shoppingCartPage.itemsCount.getText().contains("2"));
        shoppingCartPage.checkoutButton.click();
    }
}
