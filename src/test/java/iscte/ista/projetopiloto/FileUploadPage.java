package iscte.ista.projetopiloto;

import com.codeborne.selenide.SelenideElement;
import java.io.File;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FileUploadPage {
    private static final String URL = "https://the-internet.herokuapp.com/upload";

    // Locators
    // The input element is often hidden or styled, but Selenide needs the <input type="file">
    private final SelenideElement fileInput = $("#file-upload");
    private final SelenideElement submitButton = $("#file-submit");
    private final SelenideElement uploadedFilesList = $("#uploaded-files");
    private final SelenideElement header = $("h3");

    public void openPage() {
        open(URL);
    }

    /**
     * Uploads a specific file object
     */
    public void uploadFile(File file) {
        // This bypasses the OS "Open File" dialog
        fileInput.uploadFile(file);
        submitButton.click();
    }

    public String getUploadedFileName() {
        return uploadedFilesList.getText().trim();
    }

    public String getHeaderText() {
        return header.getText();
    }
}