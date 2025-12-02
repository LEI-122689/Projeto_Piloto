package iscte.ista.sampler;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SamplerTest {

    SamplerPage page = new SamplerPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000; // Give it time to load
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

        // The header should contain "Grid"
        assertTrue(page.getHeaderText().contains("Grid"));
    }
}