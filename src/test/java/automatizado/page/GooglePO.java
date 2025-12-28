package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(id = "result-status")
    public WebElement divResultadoPesquisa;

    /**
     * Construtor para criação da pagina do Google
     * @param driver Driver da pagina do Google
     */

    public  GooglePO(WebDriver driver) {
        super(driver);
        
    }
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }


    
}
