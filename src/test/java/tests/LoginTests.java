package tests;

import config.ConfigHelper;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Login tests")
public class LoginTests extends TestBase{

    @Test
    @DisplayName("Successful authorisation with e-mail")
    public void authorisationWithEmailTest(){
        step("Open main page", () ->
                open(""));

        step("Select email authentification", () ->
            $("#signin-entry").$("a").click());

        step("Fill credentials", () ->
            eaptekaAuthPage.login(ConfigHelper.getEmailUsername(), ConfigHelper.getEmailPassword()));

        step("Verify login success", () ->
            $(".SignIn-line").shouldHave(text("Выход")));
    }
}
