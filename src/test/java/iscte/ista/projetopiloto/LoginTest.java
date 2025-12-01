package iscte.ista.projetopiloto;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.Condition.text;

public class LoginTest {

    LoginPage page = new LoginPage();

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
    public void successfulLogin() {
        // 1. Login with correct credentials
        page.login("tomsmith", "SuperSecretPassword!");

        // 2. Verify success message contains "You logged into a secure area!"
        // Note: The message also contains an "x" for closing, so we check contains string
        assertTrue(page.getFlashMessageText().contains("You logged into a secure area!"));
    }

    @Test
    public void invalidLogin() {
        // 1. Login with wrong credentials
        page.login("wronguser", "wrongpassword");

        // 2. Verify error message
        assertTrue(page.getFlashMessageText().contains("Your username is invalid!"));
    }
}