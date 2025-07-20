# 🏦 Parabank UI Automation Tests

Este projeto contém uma suíte de testes de automação para a aplicação web [Parabank](https://parabank.parasoft.com/parabank/index.htm), utilizando **Selenium WebDriver** com **Java**, e implementando o padrão **Page Object Model (POM)**. Os testes são projetados para validar as principais funcionalidades da interface do usuário do sistema bancário.

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Selenium WebDriver**
* **Maven** (Gerenciador de Dependências e Build)
* **JUnit 5** (Framework de Testes)
* **Cucumber** (Para BDD - Desenvolvimento Orientado por Comportamento)
* **Logback** (Framework de Logging)


## ✅ Testes Atuais

Atualmente, o projeto cobre as seguintes funcionalidades:

* **Autenticação (Login):**
    * Cenários de login bem-sucedido.
    * Cenários de login com credenciais inválidas.
* **Registro de Usuário:**
    * Cenários de registro de novo usuário.
    * Validações de campos do formulário de registro.

## 🚧 Próximos Passos (Testes a Serem Implementados)

Estamos em processo de expansão da cobertura de testes. As próximas funcionalidades a serem automatizadas incluem:

* **Gerenciamento de Contas:**
    * Criação de novas contas.
    * Visualização de detalhes e saldos das contas.
    * Atualização de informações pessoais do perfil.
* **Transações Financeiras:**
    * Transferência de fundos entre contas.
    * Realização de depósitos.
    * Realização de saques.
    * Pagamento de contas (Bill Pay).
* **Histórico de Transações:**
    * Visualização detalhada do extrato e histórico de transações.
    * Filtragem e busca por transações específicas.
* **Validações e Tratamento de Erros:**
    * Validação robusta de entradas em todos os formulários.
    * Verificação de mensagens de erro claras e apropriadas.
* **Fluxos de Usuário Pós-Login:**
    * Testes de navegação e funcionalidade após o login bem-sucedido.
    * Verificação do comportamento de Logoff.

## ⚙️ Como Configurar e Executar

### Pré-requisitos

Certifique-se de ter os seguintes softwares instalados:

* **Git**
* **Java Development Kit (JDK) 17 ou superior**
* **Maven 3.x**

### Passos para Execução

1.  **Clone o Repositório:**
    ```bash
    git clone [https://github.com/SeuUsuario/parabank-test-ui.git](https://github.com/SeuUsuario/parabank-test-ui.git)
    cd parabank-test-ui
    ```

2.  **Configurar o Driver do Navegador:**
    * O Selenium WebDriver exige um executável de driver para o navegador que você deseja testar (ex: `chromedriver` para Chrome, `geckodriver` para Firefox).
    * **Recomendação:** Utilize o `WebDriverManager` (já configurado no `pom.xml`, se não, adicione) para gerenciar os drivers automaticamente. Se preferir fazer manualmente, baixe o driver compatível com a sua versão do navegador e configure a propriedade do sistema `webdriver.chrome.driver` (ou similar para outro navegador) com o caminho para o executável do driver.
        *Exemplo (se usar o driver manualmente e for Windows):*
        ```java
        System.setProperty("webdriver.chrome.driver", "caminho/para/seu/chromedriver.exe");
        ```
        *Para uso com WebDriverManager (recomendado):*
        No seu `BaseTest.java` (ou onde o driver é inicializado):
        ```java
        import io.github.bonigarcia.wdm.WebDriverManager;
        // ...
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ```

3.  **Compilar e Executar os Testes com Maven:**
    * Para executar todos os testes (JUnit e Cucumber):
        ```bash
        mvn clean install
        ```
    * Para executar apenas testes JUnit (se configurado no `pom.xml` via Surefire Plugin):
        ```bash
        mvn test
        ```
    * Para executar testes Cucumber específicos (se configurado no `pom.xml`):
        ```bash
        # Exemplo: executar todos os cenários de um feature específico
        mvn test -Dcucumber.options="classpath:features/autenticacao.feature"
        ```
        *A forma exata de executar features do Cucumber via Maven pode depender da sua configuração específica no `pom.xml`.*

### Executando via IDE (IntelliJ IDEA)

1.  **Abrir o Projeto:** Abra a pasta `parabank-test-ui` como um projeto Maven no IntelliJ IDEA.
2.  **Sincronizar Dependências:** O IntelliJ deve detectar o `pom.xml` e baixar automaticamente as dependências do Maven. Se não, clique com o botão direito no `pom.xml` e selecione "Maven" -> "Reload Project".
3.  **Executar Testes:**
    * Você pode clicar no ícone de "play" verde ao lado das classes de teste ou métodos específicos para executá-los.
    * Para executar via Cucumber, você pode ter uma classe Runner configurada, ou executar diretamente o arquivo `.feature` se o plugin do Cucumber estiver instalado e configurado na IDE.

## 🤝 Contribuição

Contribuições são bem-vindas! Se você tiver sugestões, melhorias ou encontrar problemas, sinta-se à vontade para abrir uma *issue* ou enviar um *pull request*.

---
