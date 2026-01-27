package automatizado.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import automatizado.page.GooglePO;
import automatizado.test.BaseTest;

public class GoogleTest extends BaseTest {

    private GooglePO googlePage;

    @BeforeEach
    void prepararTestes() {
        googlePage = new GooglePO(driver);
    }

    @Test
    void devePesquisarNoDuckDuckGo() {

        googlePage.pesquisar("Batata frita");

        String textoPagina = googlePage.obterResultadoDaPesquisa();

        assertTrue(textoPagina.contains("Protegido"));
    }
}
