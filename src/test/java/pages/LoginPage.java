package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    @Step("Открытие страницы RegisterPage")
    public RegisterPage openRegisterPage() {
        $x("//a[text()=' Sign up here for free!']").click();
        return new RegisterPage();
    }
}
