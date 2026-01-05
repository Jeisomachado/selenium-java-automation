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
