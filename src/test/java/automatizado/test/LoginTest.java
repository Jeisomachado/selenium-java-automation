package automatizado.test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import automatizado.page.LoginPO;

public class LoginTest extends BaseTest{

     private static LoginPO LoginPage;

    @BeforeEach
    public void prepararTeste() {
        LoginPage = new LoginPO(driver);
    }

@Test
public void TC001_naoDevLogarNoSistemaComEmailESenhaVazios() {
    LoginPage.inputEmail.sendKeys("");
    LoginPage.inputSenha.sendKeys("");

    LoginPage.clicarEntrar();

    String mensagem = LoginPage.obterMensagem();
    assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
}

}
