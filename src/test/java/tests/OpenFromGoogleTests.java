package tests;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class OpenFromGoogleTests {

    @Test
    void testOpenFromGoogle() {
        open("http://google.com");
        $("[name=q]").setValue("Еаптека").pressEnter();
        $(".g").$("h3").click();
        sleep(5000);
    }
}
