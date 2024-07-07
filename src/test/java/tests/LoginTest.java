package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void setUp(){
        loginPage.open();
    }

    @Test(groups = "smoke", dependsOnMethods = "tests.RegistrationTest.userRegistrationTest")
    public void loginTest(){
        loginPage.login(RegistrationTest.getRegisteredUser());
    }
}
