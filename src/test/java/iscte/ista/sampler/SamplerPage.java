package iscte.ista.sampler;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class SamplerPage {
    private static final String URL = "https://vaadin.com/docs/latest/components";

    // Locator for the link
    private final SelenideElement gridLink = $("a[href*='components/grid']");

    // The Header on the destination page
    private final SelenideElement pageHeader = $("h1");

    public void openPage() {
        open(URL);
        // Remove banner if it exists to avoid click interception
        executeJavaScript("var banner = document.getElementById('haas-cookie-dialog'); if(banner) banner.remove();");
    }

    public void navigateToDataPresentation() {
        if (gridLink.exists()) {
            gridLink.scrollTo();
            gridLink.click(ClickOptions.usingJavaScript());
        } else {
            open("https://vaadin.com/docs/latest/components/grid");
        }
    }

    // UPDATE: Return the element, not just the string.
    // This allows the test to say "Wait for this element to have text"
    public SelenideElement getHeaderElement() {
        return pageHeader;
    }
}