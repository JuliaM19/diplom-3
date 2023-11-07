package ya.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ya.practicum.Paths;

public class MainPage extends Page {

    private final By createBurgerHeader = By.xpath("//h1[text() = 'Соберите бургер']");
    private final By profileButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By orderButton = By.xpath("//button[text() = 'Оформить заказ']");
    private final By enterAccountButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    private final By sauceButton = By.xpath("//span[text() = 'Соусы']");
    private final By bunButton = By.xpath("//span[text() = 'Булки']");
    private final By fillingButton = By.xpath("//span[text() = 'Начинки']");
    private final By currentSection = By.className("tab_tab_type_current__2BEPc");
    private final By childSpanNode = By.tagName("span");

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

    public boolean isSauceSectionSelected() {
        return isCorrectSectionSelected(sauceButton);
    }

    public boolean isBunSectionSelected() {
        return isCorrectSectionSelected(bunButton);
    }

    public boolean isFillingSectionSelected() {
        return isCorrectSectionSelected(fillingButton);
    }

    private boolean isCorrectSectionSelected(By currentButtonLocator) {
        //Ищем текущий выбранный раздел (по наличию tab_tab_type_current__2BEPc в className)
        WebElement currentSectionElement = webDriver.findElement(this.currentSection);
        // Ищем нужную кнопку (которую нажали)
        WebElement currentButton = webDriver.findElement(currentButtonLocator);
        //Берем потомка раздела по имени тега (<span>text</span>) и сравниваем текст искомой кнопки с этим потомком
        return currentButton.getText().equals(currentSectionElement.findElement(childSpanNode).getText());
    }
}
