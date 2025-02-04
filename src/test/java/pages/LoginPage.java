package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    SelenideElement registerButton = $x("//a[text()=' Sign up here for free!']");

    @Step("Открытие страницы RegisterPage")
    public RegisterPage openRegisterPage() {
        registerButton.click();
        return new RegisterPage();
    }
}
