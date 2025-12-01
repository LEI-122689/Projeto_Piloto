package iscte.ista.projetopiloto;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import java.time.Duration; // <--- Important import for custom waits

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;

public class DynamicLoadingTest {

    DynamicLoadingPage page = new DynamicLoadingPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        page.openPage();
    }

    @Test
    public void waitForHiddenElement() {
        // 1. Click Start
        page.clickStart();

        // 2. (Optional) Verify loading bar appears
        page.getLoadingBar().shouldBe(visible);

        // 3. THE KEY STEP: Wait for "Hello World!"
        // The site takes ~5 seconds to load. Selenide default timeout is 4 seconds.
        // We explicitly tell it: "Wait up to 10 seconds for this specific element"
        page.getFinishTextElement().shouldBe(visible, Duration.ofSeconds(10));

        // 4. Verify the text is correct
        page.getFinishTextElement().shouldHave(text("Hello World!"));
    }
}