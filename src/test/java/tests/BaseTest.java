package tests;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LoginPage;
import pages.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
@Listeners(TestListener.class)

public class BaseTest {

    LoginPage loginPage;
    RegisterPage registerPage;


    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            Configuration.browser = Browsers.CHROME;
        } else if (browser.equalsIgnoreCase("edge")) {
            Configuration.browser = Browsers.EDGE;
        } else if (browser.equalsIgnoreCase("firefox")) {
            Configuration.browser = Browsers.FIREFOX;
        }
        Configuration.timeout = 10000;
        open("https://log.finalsurge.com/");
        getWebDriver().manage().window().maximize();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }
}
