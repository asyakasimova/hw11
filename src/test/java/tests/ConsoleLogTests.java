package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.AttachmentsHelper.getConsoleLogs;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsNot.not;

@Tag("web")
public class ConsoleLogTests extends TestBase{

    @Test
    @DisplayName("Checks if there is no errors in the console log")
    public void consoleLogNoErrorsTest() {
        open("/personal/cart/");
        $(".sum").click();

        String consoleLog = getConsoleLogs();
        assertThat(consoleLog, not(containsString("SEVERE")));
    }
}
