package tests;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.assertj.core.internal.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class MainPageTests extends TestBase{
    @Test
    @DisplayName("Page should have text \"СБЕР ЕАПТЕКА – интернет-аптека Москвы\"")
    public void mainPageTest(){
        open("");

        $(".main--txt-title h1").shouldHave(text("СБЕР ЕАПТЕКА – интернет-аптека Москвы"));
    }

    @Test
    @DisplayName("A dialog should appear for user to choose his region")
    public void geographicalPositioningTest() {
        open("");
        $(".header__tower").$(byText("Да, я тут")).click();

        $(".select_in").shouldNotBe(Condition.empty);
    }

    @Test
    @DisplayName("User should can to choose his region manually")
    public void choosePositioningManuallyTest(){
        open("");
        $(".header__tower-panel").$(byText("Нет, другой")).click();
        $(".header__tower-input").sendKeys("Бабаюрт");
        $(".header__tower-form .header__tower-result").shouldHave(text("Бабаюрт")).click();
        $(".header__tower-form").$(byText("Да, я тут")).click();

        $(".select_in").shouldHave(text("Бабаюрт"));
    }

    @Test
    @DisplayName("Base blocks are present")
    public void baseBlocksPresentTest(){
        open("");
        $$(".categories--title").shouldHave(CollectionCondition.textsInAnyOrder("Здоровье", "Красота", "Для детей", "Зоотовары"));
    }

}
