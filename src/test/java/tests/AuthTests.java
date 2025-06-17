package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class AuthTests extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(AuthTests.class);

    @Test
    void loginComCredenciaisValidas() {
        logger.info("Iniciando teste: login com credenciais válidas");

        LoginPage login = new LoginPage(driver);
        login.login("john", "demo");

        boolean logado = login.isLoggedIn();
        logger.info("Login bem-sucedido: {}", logado);

        assertTrue(logado, "Usuário deveria estar logado.");

        logger.info("Teste finalizado com sucesso");
    }

    @Test
    void loginComCredenciaisInvalidas() {
        logger.info("Iniciando teste: login com credenciais inválidas");

        LoginPage login = new LoginPage(driver);
        login.login("usuarioInvalido", "senhaErrada");

        boolean erroExibido = login.isErrorDisplayed();
        logger.info("Mensagem de erro exibida: {}", erroExibido);

        assertTrue(erroExibido, "Mensagem de erro esperada não foi exibida.");

        logger.info("Teste finalizado com sucesso");
    }
}
