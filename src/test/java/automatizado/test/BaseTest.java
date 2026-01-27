package automatizado.test;

<<<<<<< HEAD
=======
import java.net.URL;

>>>>>>> 054e2a1b531ab946682dec5b848e660f5e6a15cc
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
=======
import org.openqa.selenium.chrome.ChromeOptions;
>>>>>>> 054e2a1b531ab946682dec5b848e660f5e6a15cc

public abstract class BaseTest {

    protected WebDriver driver;
<<<<<<< HEAD
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
=======

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
>>>>>>> 054e2a1b531ab946682dec5b848e660f5e6a15cc
        if (driver != null) {
            driver.quit();
        }
    }
}
