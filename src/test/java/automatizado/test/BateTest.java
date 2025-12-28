package automatizado.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BateTest {
    
    
    protected static WebDriver driver;
    protected static final String URL_BASE = "https://www.google.com";

     @BeforeEach
     protected void iniciar() {
        driver = new ChromeDriver(); // Selenium Manager
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }
    @AfterEach
    protected void finalizar(){
        driver.quit();
    }

}
