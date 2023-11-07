package ya.practicum;

public class Environment {

    public static final String CHROME_DRIVER = System.getProperty("webdriver.chrome.driver");
    public static final String CHROME_BINARY = System.getProperty("webdriver.chrome.binary");
    public static final String YANDEX_DRIVER = System.getProperty("webdriver.yandex.driver");
    public static final String YANDEX_BINARY = System.getProperty("webdriver.yandex.binary");
    public static final String BROWSER = System.getProperty("browser", "chrome");

}
