package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EaptekaAгthorisationPage {

    private final static SelenideElement
            mainDiv = $(".modal-content"),
            emailLink = $("signin-popup--enter-by").$(By.linkText("Войти по почте")),
            emailInput = $("[name='email']"),
            passwordInput = $("[name='password']"),
            submitButton = $("[type='submit']");

    @Step("Authorization with email")
    public void login(String username, String password) {
        emailLink.click();
        emailInput.setValue(username);
        passwordInput.setValue(password);
        submitButton.click();

        mainDiv.should(Condition.disappear);
    }
}
