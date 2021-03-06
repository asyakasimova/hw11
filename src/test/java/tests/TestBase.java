package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.EaptekaAuthorizationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static config.ConfigHelper.isVideoOn;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.configureDriver;

public class TestBase {

    EaptekaAuthorizationPage eaptekaAuthPage = new EaptekaAuthorizationPage();

    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.startMaximized = true;
        configureDriver();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if(isVideoOn()) attachVideo(sessionId);
        closeWebDriver();
    }
}

