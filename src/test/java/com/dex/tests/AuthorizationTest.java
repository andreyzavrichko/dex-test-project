package com.dex.tests;

import com.dex.TestBase;
import com.dex.pages.AuthorizationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.actions;
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

    @Test
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка отображения модального окна")
    @Severity(SeverityLevel.BLOCKER)
    void modalTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Кликнуть в любом месте экрана", () ->
                actions().moveByOffset(400, 400).click().perform());
        step("Проверить отображение модального окна", () ->
                authorizationPage.checkModalTitle("Вы действительно хотите закрыть окно?"));
    }

    @Test
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка закрытия модального окна")
    @Severity(SeverityLevel.BLOCKER)
    void modalCloseTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Кликнуть в любом месте экрана", () ->
                actions().moveByOffset(400, 400).click().perform());
        step("Нажать кнопку Подтвердить", () ->
                authorizationPage.clickModalSubmitButton());
        step("Проверить закрытие модального окна", () ->
                authorizationPage.checkUnvisibleModal());
    }

    @Test
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка кнопки отмена модального окна")
    @Severity(SeverityLevel.BLOCKER)
    void modalCancelTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Кликнуть в любом месте экрана", () ->
                actions().moveByOffset(400, 400).click().perform());
        step("Нажать кнопку Отмена", () ->
                authorizationPage.clickModalCancelButton());
        step("Проверка отображения формы авторизации", () ->
                authorizationPage.checkAuthForm());


    }


}
