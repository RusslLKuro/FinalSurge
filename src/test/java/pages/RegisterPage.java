package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class RegisterPage {

    @Step("Регистрация аккаунта с именем: {name}, фамилией: {lastName}, " +
            "паролем: {password}, почтой: {email} и подвтерждением пароля: {repeatPassword}")
    public void createAccount(String name, String lastName, String email, String password, String repeatPassword) {
        $(By.id("create_first")).sendKeys(name);
        $(By.id("create_last")).sendKeys(lastName);
        $(By.id("create_email")).sendKeys(email);
        $(By.id("password_meter")).sendKeys(password);
        $(By.id("create_passwordmatch")).sendKeys(repeatPassword);
        $(By.xpath("//button[text()='Create New Account']")).click();
    }

    public String errorFirst() {
        return $(By.xpath("//*[@id='register-validate']/div[1]/table/tbody/tr[1]/td[1]/label[2]")).
                getText();
    }

    public String errorLast() {
        return $(By.xpath("//*[@id='register-validate']/div[1]/table/tbody/tr[1]/td[2]/label[2]")).
                getText();
    }

    public String errorEmail() {
        return $(By.xpath("//*[@id='register-validate']/div[1]/table/tbody/tr[2]/td/label[2]")).
                getText();
    }
}
