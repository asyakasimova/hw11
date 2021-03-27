package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class EaptekaAuthorizationPage {

    private final static SelenideElement
            mainDiv = $(".modal-content"),
            emailLink = $(".modal-select.modal-center"),
            emailInput = $("[name='email']"),
            passwordInput = $("[name='password']"),
            submitButton = $(".modal-content form").$("[type='submit']");

    @Step("Authorization with email")
    public void login(String username, String password) {
        emailLink.click();
        sleep(1000);
        emailInput.setValue(username);
        passwordInput.setValue(password);
        submitButton.click();

        mainDiv.should(Condition.disappear);
    }
}
