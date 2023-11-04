package ya.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ya.practicum.Paths;

public class MainPage extends Page {

    private final By createBurgerHeader = By.xpath("//h1[text() = 'Соберите бургер']");
    private final By profileButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By orderButton = By.xpath("//button[text() = 'Оформить заказ']");
    private final By enterAccountButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    private final By sauceButton = By.xpath("//span[text() = 'Соусы']");
    private final By bunButton = By.xpath("//span[text() = 'Булки']");
    private final By fillingButton = By.xpath("//span[text() = 'Начинки']");

    private final By bunHeader = By.xpath("//h2[text() = 'Булки']");
    private final By sauceHeader = By.xpath("//h2[text() = 'Соусы']");
    private final By fillingHeader = By.xpath("//h2[text() = 'Начинки']");

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForLoad() {
        waitForVisibility(createBurgerHeader);
    }

    public void open() {
        webDriver.get(Paths.BASE_URL);
    }

    public void clickEnterAccountButton() {
        webDriver.findElement(enterAccountButton).click();
    }

    public void clickEnterProfileLink() {
        webDriver.findElement(profileButton).click();
    }

    public boolean isOrderButtonVisible() {
        return webDriver.findElement(orderButton).isDisplayed();
    }

    public boolean isCreateOrderHeaderVisible() {
        return webDriver.findElement(createBurgerHeader).isDisplayed();
    }

    public void clickBunButton() {
        webDriver.findElement(bunButton).click();
    }

    public void clickFillingButton() {
        webDriver.findElement(fillingButton).click();
    }

    public void clickSauceButton() {
        webDriver.findElement(sauceButton).click();
    }

    public boolean isSauceHeaderVisible() {
        return webDriver.findElement(sauceHeader).isDisplayed();
    }

    public boolean isBunHeaderVisible() {
        return webDriver.findElement(bunHeader).isDisplayed();
    }

    public boolean isFillingHeaderVisible() {
        return webDriver.findElement(fillingHeader).isDisplayed();
    }
}
