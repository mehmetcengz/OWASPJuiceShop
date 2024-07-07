package tests;

import data.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddressPage;
import pages.OrderSummeryPage;
import pages.PaymentOptionsPage;
import pages.ShoppingCartPage;

public class CheckoutTest {
    private final AddressPage addressPage = new AddressPage();
    private final PaymentOptionsPage paymentOptionsPage = new PaymentOptionsPage();
    private final OrderSummeryPage orderSummeryPage = new OrderSummeryPage();
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    public static UserData user;

    @BeforeClass
    public void setUp(){
        addressPage.open();
    }

    @Test(groups = "functional", dependsOnMethods = "tests.ShoppingCartTest.addItemsToBasketTest")
    public void selectAnAddressTest (){
        addressPage.addNewAddressButton.click();
        user = UserData.generateUserData();
        addressPage.addNewAddressForm(user);
        addressPage.submitButton.click();

        Assert.assertTrue(addressPage.successMessage());

        addressPage.selectAddressRadioBtn.click();
        addressPage.continueButton.click();

        addressPage.chooseDeliverySpeed("Standard Delivery");
        addressPage.continueButton2.click();
    }

    @Test(groups = "functional", dependsOnMethods = "selectAnAddressTest")
    public void selectPaymentOptionsTest() {
        paymentOptionsPage.choosePaymentOptions("Add new card");
        paymentOptionsPage.addNewCreditCard(user);
        Assert.assertTrue(paymentOptionsPage.successMessage());
        paymentOptionsPage.creditCardRadioBtn.click();
        paymentOptionsPage.continueButton.click();
        paymentOptionsPage.placeOrderPayButton.click();
    }

    @Test(groups = "functional", dependsOnMethods = "selectPaymentOptionsTest")
    public void orderConfirmationTest() throws InterruptedException {
        Assert.assertEquals(orderSummeryPage.thanksMessage.getText(), "Thank you for your purchase!");
        Assert.assertEquals(orderSummeryPage.orderConfirmationMessage.getText()
                ,"Your order has been placed and is being processed. You can check for status updates on our Track Orders page.");
        Thread.sleep(2000);
        Assert.assertTrue(shoppingCartPage.itemsCount.getText().contains("0"));
    }

}
