package iscte.ista.projetopiloto;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.not;
import static org.junit.jupiter.api.Assertions.*;

public class CheckboxesTest {

    CheckboxesPage page = new CheckboxesPage();

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
    public void toggleFirstCheckbox() {
        // 1. Verify the first checkbox starts UNCHECKED
        page.getCheckbox(0).shouldNotBe(checked);

        // 2. Click it
        page.toggleCheckbox(0);

        // 3. Verify it is now CHECKED
        page.getCheckbox(0).shouldBe(checked);
    }

    @Test
    public void toggleSecondCheckbox() {
        // 1. Verify the second checkbox starts CHECKED (default behavior of the site)
        page.getCheckbox(1).shouldBe(checked);

        // 2. Click it
        page.toggleCheckbox(1);

        // 3. Verify it is now UNCHECKED
        page.getCheckbox(1).shouldNotBe(checked);
    }
}