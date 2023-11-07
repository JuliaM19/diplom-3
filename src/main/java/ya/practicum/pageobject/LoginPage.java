package ya.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

    private final By registerLink = By.linkText("Зарегистрироваться");
    private final By emailInput = By.xpath("//label[text()='Email']/../input");
    private final By passwordInput = By.xpath("//label[text()='Пароль']/../input");
    private final By enterButton = By.xpath("//button[text() = 'Войти']");
    private final By forgotPasswordLink = By.xpath("//a[text() = 'Восстановить пароль']");
    private final By enterHeader = By.xpath("//h2[text() = 'Вход']");
    private final By constructorButton = By.xpath("//p[text() = 'Конструктор']");
    private final By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForLoad() {
        waitForVisibility(registerLink);
    }

    public void clickRegisterLink() {
        webDriver.findElement(registerLink).click();
    }

    public void clickEnterButton() {
        webDriver.findElement(enterButton).click();
    }

    public void clickForgotPasswordLink() {
        webDriver.findElement(forgotPasswordLink).click();
    }

    public void enterLoginData(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    public void enterPassword(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }

    public void enterEmail(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

    public boolean isEnterHeaderVisible() {
        return webDriver.findElement(enterHeader).isDisplayed();
    }

    public void clickConstructorButton() {
        webDriver.findElement(constructorButton).click();
    }

    public void clickLogoButton() {
        webDriver.findElement(logoButton).click();
    }
}
