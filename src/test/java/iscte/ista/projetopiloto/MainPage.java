package iscte.ista.projetopiloto;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class MainPage {
    // 1. Cookie Banner Button (From your HTML snippet)
    public SelenideElement acceptCookiesButton = $(".ch2-allow-all-btn");

    // 2. The specific "Developer Tools" button inside the menu item
    public SelenideElement toolsMenu = $("[data-test='main-menu-item'][data-test-marker='Developer Tools'] button");

    // 3. Search and Navigation buttons
    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
    public SelenideElement seeDeveloperToolsButton = $("[data-test='suggestion-action']");
    public SelenideElement findYourToolsButton = $("[data-test='suggestion-link']");
}
