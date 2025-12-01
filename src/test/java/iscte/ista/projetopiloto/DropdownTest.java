package iscte.ista.projetopiloto;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DropdownTest {

    DropdownPage page = new DropdownPage();

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
    public void selectOption1() {
        // Action: Select "Option 1"
        page.selectOption("Option 1");

        // Assertion: Check if the selected text matches
        assertEquals("Option 1", page.getSelectedOptionText());
    }

    @Test
    public void selectOption2() {
        // Action: Select "Option 2"
        page.selectOption("Option 2");

        // Assertion
        assertEquals("Option 2", page.getSelectedOptionText());
    }
}