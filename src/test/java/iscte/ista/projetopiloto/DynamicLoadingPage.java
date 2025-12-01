package iscte.ista.projetopiloto;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DynamicLoadingPage {
    // We are using Example 1: Element on page that is hidden
    private static final String URL = "https://the-internet.herokuapp.com/dynamic_loading/1";

    // Locators
    private final SelenideElement startButton = $("#start button");
    private final SelenideElement finishText = $("#finish h4");
    private final SelenideElement loadingBar = $("#loading");

    public void openPage() {
        open(URL);
    }

    public void clickStart() {
        startButton.click();
    }

    public SelenideElement getFinishTextElement() {
        return finishText;
    }

    public SelenideElement getLoadingBar() {
        return loadingBar;
    }
}