package com.dex.tests;

import com.dex.TestBase;
import com.dex.pages.AuthorizationPage;
import com.dex.pages.NewsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

@DisplayName("Новости")
class NewsTest extends TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    NewsPage newsPage = new NewsPage();
    String phone = "77777777777";
    String pass = "Passw0rd%";

    @Test
    @Tag("smoke")
    @Feature("Новости")
    @Story("Новости")
    @DisplayName("Открытие новостей")
    @Severity(SeverityLevel.BLOCKER)
    void newsTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Заполнить номер телефона", () ->
                authorizationPage.typePhone(phone));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword(pass));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                authorizationPage.checkNewsLink());
        step("Нажать на пункт меню Новости", () ->
                newsPage.clickNewsLink());
        step("Проверить заголовок", () ->
                newsPage.checkNewsTitle("Новости"));
        step("Проверить количество новостей", () ->
                newsPage.checkNewItem());
    }

    @Test
    @Tag("smoke")
    @Feature("Новости")
    @Story("Новости")
    @DisplayName("Открытие отдельной новости")
    @Severity(SeverityLevel.BLOCKER)
    void newsItemTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Заполнить номер телефона", () ->
                authorizationPage.typePhone(phone));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword(pass));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                authorizationPage.checkNewsLink());
        step("Нажать на пункт меню Новости", () ->
                newsPage.clickNewsLink());
        step("Открыть первую новость", () ->
                newsPage.clickNewsItemTitle());
        step("Проверить заголовок первой новости", () ->
                newsPage.checkNewsItemTitle("Хакеры взломали тайваньскую учётную запись Nvidia в Twitter ради мошеннической рекламы Dogecoin"));
    }

    @Test
    @Tag("smoke")
    @Feature("Новости")
    @Story("Новости")
    @DisplayName("Подгрузка новостей")
    @Severity(SeverityLevel.BLOCKER)
    void newsMoreItemTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Заполнить номер телефона", () ->
                authorizationPage.typePhone(phone));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword(pass));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                authorizationPage.checkNewsLink());
        step("Нажать на пункт меню Новости", () ->
                newsPage.clickNewsLink());
        // Костыль, т.к. кнопка не успевает стать активной, sleep - это плохо
        step("Нажать на кнопку Показать ещё", () -> {
            sleep(500);
            newsPage.clickMoreButton();
        });
        step("Проверить подгрузку новостей", () ->
                newsPage.checkMoreNewsItem());
    }

    @Test
    @Tag("smoke")
    @Feature("Новости")
    @Story("Новости")
    @DisplayName("Проверка скрытия новостей")
    @Severity(SeverityLevel.BLOCKER)
    void newsHideItemTest() {
        step("Открываем сайт", () ->
                authorizationPage.openPage());
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Заполнить номер телефона", () ->
                authorizationPage.typePhone(phone));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword(pass));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                authorizationPage.checkNewsLink());
        step("Нажать на пункт меню Новости", () ->
                newsPage.clickNewsLink());
        // Костыль, т.к. кнопка не успевает стать активной, sleep - это плохо
        step("Нажать на кнопку Показать ещё", () -> {
            sleep(500);
            newsPage.clickMoreButton();
        });
        step("Проверить подгрузку новостей", () ->
                newsPage.checkMoreNewsItem());
        step("Нажать на кнопку Скрыть все новости", () ->
                newsPage.clickHideButton());
        step("Проверить скрытие ранее загруженных новостей", () ->
                newsPage.checkNewItem());

    }


}
