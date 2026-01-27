## 📌 Passo a passo para criação de testes automatizados

### 1️⃣ Estruturar o Page Object de Login
- Criar um arquivo chamado `LoginPO.java` dentro da pasta `page`
- Fazer herança do arquivo `BasePO.java`
- Realizar o mapeamento de todos os elementos da tela de login
  - Criar os elementos utilizando `PageFactory`

### 2️⃣ Estruturar o arquivo de teste de Login
- Criar um arquivo chamado `LoginTest.java` dentro da pasta `test`
- Fazer herança do arquivo `BaseTest.java`
- Criar um método inicial responsável por instanciar o Page Object de Login
- Criar os testes baseados na planilha de cenários
  - Não deve logar com usuário e senha em branco




1️⃣ O que é um PO (Page Object)?

PO = Page Object

É uma classe que representa uma página (ou parte dela) da aplicação.

👉 A regra de ouro é:

Page Object NÃO testa
Page Object APENAS encapsula elementos e ações da página

Exemplo: LoginPO.java

Ele representa a tela de login.

Normalmente contém:

Locators (By)

Métodos que simulam ações do usuário

Exemplo conceitual:

public class LoginPO {

    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherUsuario(String usuario) { ... }

    public void preencherSenha(String senha) { ... }

    public void clicarEntrar() { ... }

    public String obterMensagemErro() { ... }
}


📌 Nenhum @Test aqui
📌 Nenhuma asserção (assert)
📌 Apenas ações da página

2️⃣ O que é BaseTest.java?

O BaseTest é uma classe base para TODOS os testes.

Ela existe para evitar repetição de código.

O que você colocou nela (corretamente):
@BeforeEach
protected void iniciar() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(URL_BASE);
}

@AfterEach
protected void finalizar() {
    // driver.quit();
}


Isso significa que:

✔ Todo teste que herdar BaseTest
✔ Vai abrir o navegador automaticamente
✔ Vai fechar no final (quando ativar o quit)

📌 BaseTest não tem testes
📌 Ela só prepara e finaliza o ambiente

3️⃣ Por que separar BaseTest.java e LoginTest.java?

Sim — são responsabilidades diferentes, não exatamente “testes distintos”, mas níveis diferentes.

🔹 BaseTest.java

Responsabilidade:

Setup (@BeforeEach)

Teardown (@AfterEach)

WebDriver

URL base

Configurações comuns

👉 Infraestrutura do teste

🔹 LoginTest.java

Responsabilidade:

Cenários de teste

Asserções

Regras de negócio

Exemplo típico:

public class LoginTest extends BaseTest {

    @Test
    void deveLogarComUsuarioValido() {
        LoginPO login = new LoginPO(driver);

        login.preencherUsuario("admin");
        login.preencherSenha("123");
        login.clicarEntrar();

        assertTrue(login.usuarioLogado());
    }
}


📌 Aqui sim temos:

@Test

assert

Validação de comportamento

4️⃣ Por que isso é considerado boa prática?
❌ Sem BaseTest

Você teria isso em todo teste:

WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("...");


🔁 Código duplicado
🐛 Difícil de manter

✅ Com BaseTest

Mudou navegador? → muda em 1 lugar

Mudou URL? → muda em 1 lugar

Adicionou logs, waits, screenshots? → automático para todos

5️⃣ Estrutura mental correta (bem importante)

Pense assim:

TESTE (LoginTest)
 └── usa → PAGE OBJECT (LoginPO)
      └── usa → WebDriver (do BaseTest)

Resumo em uma frase:

BaseTest → prepara o terreno

Page Object (PO) → sabe usar a página

Test → valida o comportamento

6️⃣ Respondendo sua pergunta diretamente

“Seriam testes distintos?”

👉 Não
Eles são camadas diferentes do mesmo teste automatizado:

BaseTest → infraestrutura

LoginPO → representação da página

LoginTest → cenários de teste

Essa separação é exatamente o que empresas esperam ver em automação com Selenium + Java.

Se quiser, no próximo passo posso:

Revisar sua estrutura de pastas

Refatorar um teste seu para o padrão “ideal”

Explicar quando criar mais de um PO para a mesma página

É só me dizer 👍