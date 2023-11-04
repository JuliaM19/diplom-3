package ya.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends Page {

    private final By logoutButton = By.xpath("//button[text() = 'Выход']");

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void waitForLoad() {
        waitForVisibility(logoutButton);
    }

    public void clickLogoutButton() {
        webDriver.findElement(logoutButton).click();
    }

}
