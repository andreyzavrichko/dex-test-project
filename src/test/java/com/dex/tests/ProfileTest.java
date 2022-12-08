package com.dex.tests;

import com.dex.TestBase;
import com.dex.pages.AuthorizationPage;
import com.dex.pages.ProfilePage;
import com.dex.pages.RegistrationPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

class ProfileTest extends TestBase {
    ProfilePage profilePage = new ProfilePage();
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    @Feature("Профиль")
    @Story("Профиль")
    @DisplayName("Проверка экрана Профиль")
    @Severity(SeverityLevel.BLOCKER)
    void profilePositiveTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Заполнить номер телефона", () ->
                authorizationPage.typePhone("72355555524"));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword("Passw0rd%"));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                authorizationPage.checkNewsLink());

        step("Нажать кнопку Профиль", () ->
                profilePage.clickProfileButton());
        step("Нажать ссылку Профиль", () ->
                profilePage.clickProfileLink());
        step("Проверить содержимое страницы Профиль", () -> {
            profilePage.checkProfileTitle("Профиль пользователя");
            profilePage.checkFirstName("имя");
            profilePage.checkLastName("фамилия");
            profilePage.checkMiddleName("отчество");
            profilePage.checkBirthday("08.12.2022");
            profilePage.checkPhone("723******24");
            profilePage.checkProfileNameTitle("Имя");
            profilePage.checkProfileLastNameTitle("Отчество");
            profilePage.checkProfileMiddleNameTitle("Фамилия");
            profilePage.checkProfileBirthdayTitle("Дата рождения");
            profilePage.checkProfilePhoneTitle("Телефон");
        });


    }
}