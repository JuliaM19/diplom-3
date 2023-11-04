## Тестирирование UI сайта Stellar Burgers
### Стек технологий:
* Java 11
* JUnit 4.13.1
* Allure 2.24.0
* RestAssured 3.2.0
* Selenium 4.15
* maven

### Запуск
#### Окружение:
- webdriver.chrome.driver - путь к chromedriver
- webdriver.chrome.binary - путь к исполняемому файлу Google Chrome
- webdriver.yandex.driver - путь к yandexdriver
- webdriver.yandex.binary - путь к исполняемому файлу Yandex browser
- browser - выбор браузера для запуска (yandex/chrome)

```bash
mvn -Dwebdriver.chrome.driver=/Users/uliamamontova/WebDriver/bin/chromedriver \
"-Dwebdriver.chrome.binary=/Applications/Google Chrome.app/Contents/MacOS/Google Chrome" \
-Dwebdriver.yandex.driver=/Users/uliamamontova/WebDriver/bin/yandexdriver \
-Dwebdriver.yandex.binary=/Applications/Yandex.app/Contents/MacOS/Yandex \
-Dbrowser=chrome \
clean test
```

### Посмотреть отчет
```bash
allure serve target/surefire-reports/
```