package ya.practicum;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import ya.practicum.api.StellarBurgersApi;
import ya.practicum.model.AuthorizationRequest;
import ya.practicum.model.UserRequest;
import ya.practicum.pageobject.LoginPage;
import ya.practicum.pageobject.MainPage;
import ya.practicum.pageobject.RegisterPage;


public class RegistrationTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    private StellarBurgersApi api;
    private UserRequest userRequest;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Before
    public void setUp() {
        WebDriver webDriver = driverRule.getWebDriver();

        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);

        api = new StellarBurgersApi();
        userRequest = Utils.createRandomUser();
    }

    @Test
    public void testSuccessfulRegistration() {
        mainPage.open();
        mainPage.waitForLoad();
        mainPage.clickEnterAccountButton();

        loginPage.clickRegisterLink();
        registerPage.waitForLoad();
        registerPage.enterNewAccountData(
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getPassword()
        );
        registerPage.clickRegisterButton();
        loginPage.waitForLoad();
        loginPage.enterLoginData(userRequest.getEmail(), userRequest.getPassword());
        loginPage.clickEnterButton();
        mainPage.waitForLoad();

        Assert.assertTrue("Successful registration failed", mainPage.isOrderButtonVisible());
    }

    @Test
    public void testRegistrationWithInvalidPassword() {
        mainPage.open();
        mainPage.waitForLoad();
        mainPage.clickEnterAccountButton();

        loginPage.clickRegisterLink();
        registerPage.waitForLoad();
        int maxInvalidPasswordLength = 5;
        registerPage.enterNewAccountData(
                userRequest.getName(),
                userRequest.getEmail(),
                Utils.randomPassword(maxInvalidPasswordLength)
        );
        registerPage.clickRegisterButton();
        Assert.assertTrue("There is no invalid password error",
                registerPage.isIncorrectPasswordLabelVisible());
    }

    @After
    public void tearDown() {
        AuthorizationRequest authorizationRequest = Utils.createAuthorizationRequest(userRequest);
        String accessToken = api.loginUser(authorizationRequest);
        api.deleteUser(accessToken);
    }
}
