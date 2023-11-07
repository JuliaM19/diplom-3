package ya.practicum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ya.practicum.pageobject.MainPage;

public class MainPageTest {

    @Rule
    public DriverRule driverRule = new DriverRule();
    private MainPage mainPage;

    @Before
    public void setUp() {
        WebDriver webDriver = driverRule.getWebDriver();
        mainPage = new MainPage(webDriver);
    }

    @Test
    public void testSauceSectionButton() {
        mainPage.open();
        mainPage.waitForLoad();

        mainPage.clickSauceButton();
        Assert.assertTrue("Sauce selection button is not working", mainPage.isSauceSectionSelected());
    }

    @Test
    public void testBunSectionButton() {
        mainPage.open();
        mainPage.waitForLoad();

        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        Assert.assertTrue("Bun selection button is not working", mainPage.isBunSectionSelected());
    }

    @Test
    public void testFillingSectionButton() {
        mainPage.open();
        mainPage.waitForLoad();

        mainPage.clickFillingButton();
        Assert.assertTrue("Filling selection button is not working", mainPage.isFillingSectionSelected());
    }
}
