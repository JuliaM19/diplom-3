package ya.practicum;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import ya.practicum.api.StellarBurgersApi;
import ya.practicum.model.UserRequest;
import ya.practicum.pageobject.LoginPage;
import ya.practicum.pageobject.MainPage;
import ya.practicum.pageobject.ProfilePage;

public class ProfilePageTest {

    @Rule
    public DriverRule driverRule = new DriverRule();
    private LoginPage loginPage;
    private MainPage mainPage;
    private ProfilePage profilePage;
    private StellarBurgersApi api;
    private UserRequest userRequest;
    private String accessToken;

    @Before
    public void setUp() {
        WebDriver webDriver = driverRule.getWebDriver();
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        api = new StellarBurgersApi();
        userRequest = Utils.createRandomUser();
        accessToken = api.createUser(userRequest);
    }

    @Test
    public void testProfileButton() {
        mainPage.open();
        mainPage.waitForLoad();
        mainPage.clickEnterProfileLink();
        loginPage.waitForLoad();

        Assert.assertTrue("Profile link is not working", loginPage.isEnterHeaderVisible());
    }

    @Test
    public void testLogoButton() {
        mainPage.open();
        mainPage.waitForLoad();
        mainPage.clickEnterProfileLink();
        loginPage.waitForLoad();

        loginPage.clickLogoButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Logo button is not working", mainPage.isCreateOrderHeaderVisible());
    }

    @Test
    public void testConstructorButton() {
        mainPage.open();
        mainPage.waitForLoad();
        mainPage.clickEnterProfileLink();
        loginPage.waitForLoad();

        loginPage.clickConstructorButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Constructor button is not working", mainPage.isCreateOrderHeaderVisible());
    }

    @Test
    public void testLogoutButton() {
        mainPage.open();
        mainPage.waitForLoad();
        mainPage.clickEnterAccountButton();
        loginPage.waitForLoad();
        loginPage.enterLoginData(userRequest.getEmail(), userRequest.getPassword());
        loginPage.clickEnterButton();
        mainPage.waitForLoad();
        mainPage.isCreateOrderHeaderVisible();
        mainPage.clickEnterProfileLink();
        profilePage.waitForLoad();
        profilePage.clickLogoutButton();

        loginPage.waitForLoad();
        Assert.assertTrue("Logout button is not working", loginPage.isEnterHeaderVisible());
    }

    @After
    public void tearDown() {
        api.deleteUser(accessToken);
    }
}
