package tests;

import com.codeborne.selenide.Condition;
import config.ConfigHelper;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

@Tag("web")
@Feature("Login tests")
public class LoginTests extends TestBase{

    @Test
    @DisplayName("Successful authorisation with e-mail")
    public void authorisationWithEmailTest(){
        open("");
        $("#signin-entry").$("a").click();
        sleep(1000);
        eaptekaAuthPage.login(ConfigHelper.getEmailUsername(), ConfigHelper.getEmailPassword());

        $(".SignIn-line").shouldHave(Condition.text("Выход"));
    }
}
