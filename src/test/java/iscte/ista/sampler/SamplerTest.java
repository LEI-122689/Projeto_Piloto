package iscte.ista.sampler;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text; // Import this!

public class SamplerTest {

    SamplerPage page = new SamplerPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        page.openPage();
    }

    @Test
    @Description("Verify that we can access the Grid (Data Presentation) component")
    @Severity(SeverityLevel.NORMAL)
    public void accessDataPresentationComponent() {
        page.navigateToDataPresentation();

        // FIX: Use Selenide's assertion to WAIT for the page load
        // This will retry until the H1 tag contains "Grid"
        page.getHeaderElement().shouldHave(text("Grid"));
    }
}