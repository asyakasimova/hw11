package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
@Feature("Login tests")
public class LoginTests extends TestBase{

    @Test
    @DisplayName("Successful authorisation with e-mail")
    public void authorisationWithEmailTest(){
        open("");
        $("#signin-entry").$("a").click();
        eaptekaAuthPage.login("yanastasia@mail.ru", "Ulv7eaxbpkT7e");

        $(".SignIn-line").shouldHave(Condition.text("Выход"));
    }
}
