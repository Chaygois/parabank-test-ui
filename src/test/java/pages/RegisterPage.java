package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Método principal de registro
    public void register(String firstName, String lastName, String address, String city,
                         String state, String zipCode, String phone, String ssn,
                         String username, String password) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillAddress(address);
        fillCity(city);
        fillState(state);
        fillZipCode(zipCode);
        fillPhone(phone);
        fillSsn(ssn);
        fillUsername(username);
        fillPassword(password);
        fillConfirmPassword(password);
        clickRegister();
    }

    // Métodos de preenchimento de campo
    public void fillFirstName(String value) { driver.findElement(By.id("customer.firstName")).sendKeys(value); }
    public void fillLastName(String value) { driver.findElement(By.id("customer.lastName")).sendKeys(value); }
    public void fillAddress(String value) { driver.findElement(By.id("customer.address.street")).sendKeys(value); }
    public void fillCity(String value) { driver.findElement(By.id("customer.address.city")).sendKeys(value); }
    public void fillState(String value) { driver.findElement(By.id("customer.address.state")).sendKeys(value); }
    public void fillZipCode(String value) { driver.findElement(By.id("customer.address.zipCode")).sendKeys(value); }
    public void fillPhone(String value) { driver.findElement(By.id("customer.phoneNumber")).sendKeys(value); }
    public void fillSsn(String value) { driver.findElement(By.id("customer.ssn")).sendKeys(value); }
    public void fillUsername(String value) { driver.findElement(By.id("customer.username")).sendKeys(value); }
    public void fillPassword(String value) { driver.findElement(By.id("customer.password")).sendKeys(value); }
    public void fillConfirmPassword(String value) { driver.findElement(By.id("repeatedPassword")).sendKeys(value); }

    public void clickRegister() {
        driver.findElement(By.xpath("//input[@value='Register']")).click();
    }

    // Verificação de sucesso
    public boolean isRegistrationSuccessful() {
        return driver.getPageSource().contains("Your account was created successfully.");
    }

    // Verificação de erro por usuário já existente
    public boolean isUsernameAlreadyExistsErrorShown() {
        return driver.getPageSource().contains("This username already exists");
    }

    public boolean isDuplicateUserErrorShown() {
        return false;
    }

    public boolean isPasswordMismatchErrorShown() {
        return false;
    }
}
