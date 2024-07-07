package tests;

import data.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;

public class RegistrationTest {
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final MainPage mainPage = new MainPage();
    public static UserData user;

    @BeforeClass
    public void setUp() {
        registrationPage.open();
        mainPage.cookiesDismiss();
    }

    @Test(groups = "smoke")
    public void userRegistrationTest(){

        user = UserData.generateUserData();
        registrationPage.register(user);

        Assert.assertTrue(registrationPage.isRegistrationSuccessful());
    }
    public static UserData getRegisteredUser(){
        return user;
    }

}
