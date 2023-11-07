package ya.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends Page {

    private final By forgotPasswordLabel = By.xpath("//h2[text() = 'Восстановление пароля']");
    private final By enterButton = By.xpath("//a[text() = 'Войти']");

    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForLoad() {
        waitForVisibility(forgotPasswordLabel);
    }

    public void clickEnterButton() {
        webDriver.findElement(enterButton).click();
    }
}
