package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
public class CartContentsTests extends TestBase{

    @Test
    @DisplayName("Test checks that the cart is empty initially")
    public void checkCartIsEmptyTest(){
        open("");
        $(".sum").click();

        $("#cart").$("h1").shouldHave(text("Моя корзина"));
        $("#cart").shouldHave(text("Ваша корзина пуста"));
    }
}
