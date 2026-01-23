package automatizado.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import automatizado.test.BaseTest;

public class GoogleTest extends BaseTest {

    @Test
    public void devePesquisarNoDuckDuckGo() {

        WebElement inputPesquisa = driver.findElement(By.name("q"));
        inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);

        String textoPagina = driver.findElement(By.tagName("body")).getText();

        assertTrue(textoPagina.contains("Protegido"));
    }
}
