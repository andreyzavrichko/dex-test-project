package com.dex.tests;

import com.dex.TestBase;
import com.dex.pages.AuthorizationPage;
import com.dex.pages.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Главная")
class MainTest extends TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();

    @Test
    @Tag("smoke")
    @Feature("Главная")
    @Story("Главная")
    @DisplayName("Проверка главной страницы")
    @Severity(SeverityLevel.BLOCKER)
    void mainTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Проверяем наличие всех элементов на странице", () -> {
            mainPage.checkHeader();
            mainPage.checkHeaderLogo();
            mainPage.checkMain();
            mainPage.checkMainLogo();
        });

    }


}
