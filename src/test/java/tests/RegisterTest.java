package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test(priority = 1, enabled = true, invocationCount = 1, threadPoolSize = 2,
            description = "регистрация с пустым полем First Name", testName = "Проверка негативной регистрации",
            retryAnalyzer = Retry.class)
    public void negativeFirstNameFieldIsEmpty() {
        loginPage.openRegisterPage();
        registerPage.createAccount("",
                "lastName",
                "email@mail.ru",
                "PasswordGoodRpQ5r",
                "PasswordGoodRpQ5r");
        Assert.assertEquals(registerPage.errorFirst(),
                "This field is required.",
                "отсутствует ошибка о пустующем поле");
    }

    @Test(priority = 2, enabled = true, invocationCount = 1, threadPoolSize = 2,
            description = "регистрация с пустым полем Last Name", testName = "Проверка негативной регистрации",
            retryAnalyzer = Retry.class)
    public void negativeLastNameFieldIsEmpty() {
        loginPage.openRegisterPage();
        registerPage.createAccount("name",
                "",
                "email@mail.ru",
                "PasswordGoodRpQ5r",
                "PasswordGoodRpQ5r");
        Assert.assertEquals(registerPage.errorLast(),
                "This field is required.",
                "отсутствует ошибка о пустующем поле");
    }

    @Test(priority = 3, enabled = true, invocationCount = 1, threadPoolSize = 2,
            description = "регистрация с пустым полем Email", testName = "Проверка негативной регистрации",
            retryAnalyzer = Retry.class)
    public void negativeEmailFieldIsEmpty() {
        loginPage.openRegisterPage();
        registerPage.createAccount("name",
                "lastName",
                "",
                "PasswordGoodRpQ5r",
                "PasswordGoodRpQ5r");
        Assert.assertEquals(registerPage.errorEmail(),
                "This field is required.",
                "отсутствует ошибка о пустующем поле");
    }
}
