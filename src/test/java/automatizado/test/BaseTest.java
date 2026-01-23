package automatizado.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected WebDriver driver;
    protected static final String URL_BASE = "https://duckduckgo.com/";

    @BeforeEach
    void iniciar() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @AfterEach
    void finalizar() {
        if (driver != null) {
            driver.quit();
        }
    }
}
