package com.dex.tests;

import com.dex.TestBase;
import com.dex.pages.AuthorizationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Авторизация")
class AuthorizationTest extends TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с валидными данными")
    @Severity(SeverityLevel.BLOCKER)
    void authorizationPositiveTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Заполнить номер телефона", () ->
                authorizationPage.typePhone("723555555241"));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword("Passw0rd%"));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                authorizationPage.checkNewsLink());
    }


}
