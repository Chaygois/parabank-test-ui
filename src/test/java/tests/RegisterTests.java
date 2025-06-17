package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;

import java.time.Duration;

public class RegisterTests extends BaseTest {

    @Test
    public void registrarNovoUsuarioComSucesso() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        RegisterPage registerPage = new RegisterPage(driver);
        String username = "user" + System.currentTimeMillis();
        String password = "senha123";

        registerPage.register(
                "Maria", "Silva", "Rua Teste 123", "São Paulo", "SP",
                "01234567", "11999999999", "123-45-6789", username, password
        );

        Assertions.assertTrue(
                registerPage.isRegistrationSuccessful(),
                "Mensagem de sucesso não encontrada após o registro."
        );
    }

    @Test
    public void registrarComUsernameJaExistente() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        RegisterPage registerPage = new RegisterPage(driver);
        String username = "john"; // Este username já existe no parabank
        String password = "senha123";

        registerPage.register(
                "João", "Souza", "Rua A", "SP", "SP",
                "01020304", "11999999999", "123-45-6789", username, password
        );

        // Espera pela mensagem de erro
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='error']"))
        );

        String erroEsperado = "This username already exists.";
        Assertions.assertTrue(
                errorMessage.getText().contains(erroEsperado),
                "Deveria exibir erro de username já existente. Mensagem encontrada: " + errorMessage.getText()
        );
    }

    @Test
    public void registrarComCamposObrigatoriosVazios() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.register("", "", "", "", "", "", "", "", "", "");

        // Espera por erro (exemplo: campo obrigatório)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='error']"))
        );

        Assertions.assertTrue(
                errorMessage.isDisplayed(),
                "Deveria exibir erro de campos obrigatórios vazios."
        );
    }

    @Test
    public void registrarComSenhasDiferentes() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.fillFirstName("Ana");
        registerPage.fillLastName("Teste");
        registerPage.fillAddress("Rua X");
        registerPage.fillCity("São Paulo");
        registerPage.fillState("SP");
        registerPage.fillZipCode("01000-000");
        registerPage.fillPhone("11999999999");
        registerPage.fillSsn("123-45-6789");
        registerPage.fillUsername("testeSenha" + System.currentTimeMillis());
        registerPage.fillPassword("senha123");
        registerPage.fillConfirmPassword("senhaDiferente");
        registerPage.clickRegister();

        // Espera pela mensagem de erro
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='error']"))
        );

        Assertions.assertTrue(
                errorMessage.getText().toLowerCase().contains("password"),
                "Deveria exibir erro de senhas diferentes. Mensagem encontrada: " + errorMessage.getText()
        );
    }
}
