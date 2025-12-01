package iscte.ista.projetopiloto;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class CheckboxesPage {
    // The specific URL for this page
    private static final String URL = "https://the-internet.herokuapp.com/checkboxes";

    // Locators
    // This finds all <input> elements inside the form with id="checkboxes"
    private final ElementsCollection checkboxes = $$("#checkboxes input");

    public void openPage() {
        open(URL);
    }

    /**
     * Toggles the checkbox at the specific index (0 for the first, 1 for the second)
     */
    public void toggleCheckbox(int index) {
        checkboxes.get(index).click();
    }

    /**
     * Checks if the checkbox at the specific index is currently selected
     */
    public boolean isCheckboxSelected(int index) {
        return checkboxes.get(index).isSelected();
    }

    /**
     * Returns the checkbox element itself if we need to do assertions on it directly
     */
    public SelenideElement getCheckbox(int index) {
        return checkboxes.get(index);
    }
}