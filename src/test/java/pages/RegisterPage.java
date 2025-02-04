package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class RegisterPage {

    SelenideElement firstNameField = $(By.id("create_first"));
    SelenideElement lastNameField = $(By.id("create_last"));
    SelenideElement emailField = $(By.id("create_email"));
    SelenideElement passwordField = $(By.id("password_meter"));
    SelenideElement repeatPasswordField = $(By.id("create_passwordmatch"));
    SelenideElement createNewAccountButton = $(By.xpath("//button[text()='Create New Account']"));
    SelenideElement errorFirstName = $(By.xpath("//*[@id='register-validate']" +
            "/div[1]/table/tbody/tr[1]/td[1]/label[2]"));
    SelenideElement errorLastName = $(By.xpath("//*[@id='register-validate']" +
            "/div[1]/table/tbody/tr[1]/td[1]/label[2]"));
    SelenideElement errorEmail = $(By.xpath("//*[@id='register-validate']" +
            "/div[1]/table/tbody/tr[1]/td[1]/label[2]"));

    @Step("Регистрация аккаунта с именем: {name}, фамилией: {lastName}, " +
            "паролем: {password}, почтой: {email} и подвтерждением пароля: {repeatPassword}")
    public RegisterPage createAccount(String name, String lastName,
                                      String email, String password,
                                      String repeatPassword) {
        firstNameField.sendKeys(name);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        repeatPasswordField.sendKeys(repeatPassword);
        createNewAccountButton.click();
        return this;
    }

    public String errorFirst() {
        return errorFirstName.getText();
    }

    public String errorLast() {
        return errorLastName.getText();
    }

    public String errorEmail() {
        return errorEmail.getText();
    }
}
