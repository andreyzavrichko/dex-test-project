package com.dex.tests;

import com.dex.TestBase;
import com.dex.pages.AuthorizationPage;
import com.dex.pages.NewsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class NewsTest extends TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    NewsPage newsPage = new NewsPage();

    @Test
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
                authorizationPage.typePhone("723555555241"));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword("Passw0rd%"));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                authorizationPage.checkNewsLink());
        step("Нажать на пункт меню Новости", () ->
                newsPage.clickNewsLink());
        step("Проверить заголовок", () ->
                newsPage.checkNewsTitle("Новости -"));
        step("Проверить количество новостей", () ->
                newsPage.checkNewItemTitle());

    }




}
