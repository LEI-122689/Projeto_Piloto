package iscte.ista.projetopiloto;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static final String URL = "https://the-internet.herokuapp.com/login";

    // Locators
    private final SelenideElement usernameField = $("#username");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("button[type='submit']"); // or $(".radius")
    private final SelenideElement flashMessage = $("#flash");

    public void openPage() {
        open(URL);
    }

    public void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }

    /**
     * Returns the text of the banner (green or red box) at the top
     */
    public String getFlashMessageText() {
        return flashMessage.getText();
    }
}