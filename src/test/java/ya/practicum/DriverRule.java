package ya.practicum;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class DriverRule extends ExternalResource {

    private WebDriver webDriver;

    private static WebDriver getSpecificDriver(String driver, String binary) {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(driver))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary(binary);

        return new ChromeDriver(service, options);
    }

    @Override
    protected void before() {
        String chrome = "chrome";
        String yandex = "yandex";
        String browser = Environment.BROWSER;
        if (chrome.equalsIgnoreCase(browser)) {
            webDriver = getSpecificDriver(Environment.CHROME_DRIVER, Environment.CHROME_BINARY);
        } else if (yandex.equalsIgnoreCase(browser)) {
            webDriver = getSpecificDriver(Environment.YANDEX_DRIVER, Environment.YANDEX_BINARY);
        } else {
            throw new RuntimeException(browser + " is not supported");
        }

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    protected void after() {
        webDriver.quit();
    }
}
