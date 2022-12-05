package com.dex;

import com.codeborne.selenide.Configuration;
import com.dex.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;



import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1600x780";
        Configuration.baseUrl = "https://demo1.k3s.dex-it.ru";

        // Конфигурация для скачивания файлов
        Configuration.downloadsFolder = "src/test/resources/files";

       // Configuration.proxyEnabled = true;
       // Configuration.fileDownload = PROXY;

        // Конфигурация для удаленного запуска
//        Configuration.remote = "http://149.154.70.38:4444/wd/hub";
//        Configuration.remote = System.getProperty("url");
//        Configuration.browser = System.getProperty("browser");
//        Configuration.browserVersion = System.getProperty("version");

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        closeWebDriver();
    }

}
