package iscte.ista.sampler;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class SamplerPage {
    private static final String URL = "https://vaadin.com/docs/latest/components";

    // Locator for the link (Using the href is safer than text)
    private final SelenideElement gridLink = $("a[href*='components/grid']");

    // The Header on the destination page
    private final SelenideElement pageHeader = $("h1");

    public void openPage() {
        open(URL);
    }

    public void navigateToDataPresentation() {
        // 1. Check if the link exists on the page
        if (gridLink.exists()) {
            // 2. Scroll to it
            gridLink.scrollTo();

            // 3. THE FIX: Use JavaScript Click
            // This ignores the cookie banner completely.
            // If ClickOptions isn't recognized, ensure you imported com.codeborne.selenide.ClickOptions
            gridLink.click(ClickOptions.usingJavaScript());
        } else {
            // Fallback: If the menu is collapsed or hidden, go directly to the URL
            open("https://vaadin.com/docs/latest/components/grid");
        }
    }

    public String getHeaderText() {
        return pageHeader.getText();
    }
}