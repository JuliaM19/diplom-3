package ya.practicum;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import ya.practicum.api.StellarBurgersApi;
import ya.practicum.model.AuthorizationRequest;
import ya.practicum.model.UserRequest;
import ya.practicum.pageobject.ForgotPasswordPage;
import ya.practicum.pageobject.LoginPage;
import ya.practicum.pageobject.MainPage;
import ya.practicum.pageobject.RegisterPage;

public class LoginTest {

    @Rule
    public DriverRule driverRule = new DriverRule();
    private StellarBurgersApi api;
    private UserRequest userRequest;
    private LoginPage loginPage;
    private MainPage mainPage;
    private RegisterPage registerPage;
    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUp() {
        WebDriver webDriver = driverRule.getWebDriver();
        api = new StellarBurgersApi();
        userRequest = Utils.createRandomUser();
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        registerPage = new RegisterPage(webDriver);
        forgotPasswordPage = new ForgotPasswordPage(webDriver);
    }

    @Test
    public void testLoginByEnterAccountButton() {
        api.createUser(userRequest);

        mainPage.open();
        mainPage.waitForLoad();
        mainPage.clickEnterAccountButton();
        loginPage.waitForLoad();
        loginPage.enterLoginData(userRequest.getEmail(), userRequest.getPassword());
        loginPage.clickEnterButton();
        mainPage.waitForLoad();

        Assert.assertTrue("Login by account button failed", mainPage.isOrderButtonVisible());
    }

    @Test
    public void testLoginByProfileLink() {
        api.createUser(userRequest);

        mainPage.open();
        mainPage.waitForLoad();
        mainPage.clickEnterProfileLink();
        loginPage.waitForLoad();
        loginPage.enterLoginData(userRequest.getEmail(), userRequest.getPassword());
        loginPage.clickEnterButton();
        mainPage.waitForLoad();

        Assert.assertTrue("Login by profile button failed", mainPage.isOrderButtonVisible());
    }

    @Test
    public void testLoginOnRegistrationPage() {
        api.createUser(userRequest);

        mainPage.open();
        mainPage.waitForLoad();
        mainPage.clickEnterAccountButton();
        loginPage.waitForLoad();
        loginPage.clickRegisterLink();
        registerPage.waitForLoad();
        registerPage.clickLoginLink();
        loginPage.waitForLoad();
        loginPage.enterLoginData(userRequest.getEmail(), userRequest.getPassword());
        loginPage.clickEnterButton();
        mainPage.waitForLoad();

        Assert.assertTrue("Login throw register form failed", mainPage.isOrderButtonVisible());
    }

    @Test
    public void testLoginOnPasswordRecoveryPage() {
        api.createUser(userRequest);

        mainPage.open();
        mainPage.waitForLoad();
        mainPage.clickEnterAccountButton();
        loginPage.waitForLoad();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.waitForLoad();
        forgotPasswordPage.clickEnterButton();
        loginPage.waitForLoad();
        loginPage.enterLoginData(userRequest.getEmail(), userRequest.getPassword());
        loginPage.clickEnterButton();
        mainPage.waitForLoad();

        Assert.assertTrue("Login throw forgot password page failed", mainPage.isOrderButtonVisible());
    }

    @After
    public void tearDown() {
        AuthorizationRequest authorizationRequest = Utils.createAuthorizationRequest(userRequest);
        String accessToken = api.loginUser(authorizationRequest);
        api.deleteUser(accessToken);
    }
}
