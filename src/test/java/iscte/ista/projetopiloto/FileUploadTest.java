package iscte.ista.projetopiloto;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class FileUploadTest {

    FileUploadPage page = new FileUploadPage();
    File tempFile;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() throws IOException {
        // Create a dummy file just for this test
        tempFile = File.createTempFile("hello-world", ".txt");
        Files.write(tempFile.toPath(), "This is automation content".getBytes());

        page.openPage();
    }

    @Test
    public void uploadFileSuccessfully() {
        // 1. Upload the temp file we created
        page.uploadFile(tempFile);

        // 2. Verify the site says "File Uploaded!"
        assertEquals("File Uploaded!", page.getHeaderText());

        // 3. Verify the filename on screen matches our temp file's name
        assertEquals(tempFile.getName(), page.getUploadedFileName());
    }

    @AfterEach
    public void tearDown() {
        // Clean up the mess (delete the temp file)
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
    }
}