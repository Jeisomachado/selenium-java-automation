package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(tagName = "body")
    public WebElement divResultadoPesquisa;

    /**
     * Construtor responsável por criar a página do Google.
     *
     * @param driver Driver utilizado para controlar o navegador
     */
    public GooglePO(WebDriver driver) {
        super(driver);
    }

    /**
     * Método responsável por realizar uma pesquisa no Google
     * com base no texto informado, finalizando a ação com a tecla ENTER.
     *
     * @param texto Texto que será pesquisado
     */
    public void pesquisar(String texto) {
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /**
     * Método responsável por obter o texto retornado
     * após a realização da pesquisa.
     *
     * @return Texto presente na página de resultados
     */
    public String obterResultadoDaPesquisa() {
        return divResultadoPesquisa.getText();
    }
}
