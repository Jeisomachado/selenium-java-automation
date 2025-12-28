package automatizado.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import automatizado.page.GooglePO;

public class GoogleTest extends BateTest {

    private GooglePO googlePage;

    @BeforeEach
    public void prepararTeste() {
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_devePesquisarNoGoogleOTxtoBatataFrita() {

        googlePage.pesquisar("Batata frita");

        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(
            resultado.contains("Aproximadamente"),
            "Resultado esperado não encontrado. Texto atual: " + resultado
        );
    }
}
