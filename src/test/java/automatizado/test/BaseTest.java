package automatizado.test;

import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    protected void iniciar() {

        URL url = getClass()
                .getClassLoader()
                .getResource("login.html");

        if (url == null) {
            throw new RuntimeException("login.html não encontrado em src/test/resources");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.get(url.toString());
    }

    @AfterEach
    protected void finalizar() {
        if (driver != null) {
            driver.quit();
        }
    }
}
