package iscte.ista.projetopiloto;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DropdownPage {
    private static final String URL = "https://the-internet.herokuapp.com/dropdown";

    // Locator for the <select> element
    private final SelenideElement dropdown = $("#dropdown");

    public void openPage() {
        open(URL);
    }

    /**
     * Selects an option by its visible text (e.g., "Option 1")
     */
    public void selectOption(String optionText) {
        dropdown.selectOption(optionText);
    }

    /**
     * Returns the text of the currently selected option
     */
    public String getSelectedOptionText() {
        return dropdown.getSelectedOption().getText();
    }
}