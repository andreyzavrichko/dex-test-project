package com.dex.tests;

import com.dex.TestBase;
import com.dex.pages.AuthorizationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Selenide.actions;
import static io.qameta.allure.Allure.step;

@DisplayName("Авторизация")
public class AuthorizationTest extends TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с валидными данными")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38424")
    void authorizationPositiveTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Заполнить email", () ->
                authorizationPage.typeEmail("test@gmail.com"));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword("005"));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                authorizationPage.checkVisible());
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с пустыми данными")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38425")
    void authorizationNegativeEmptyTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить сообщение об ошибке", () ->
                authorizationPage.checkErrorMessage("Необходимые данные не заполнены."));
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с пустым паролем")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38427")
    void authorizationNegativeEmptyPasswordTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Заполнить email", () ->
                authorizationPage.typeEmail("unrealtest@gmail.com"));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить сообщение об ошибке", () ->
                authorizationPage.checkErrorMessage("Необходимые данные не заполнены."));
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с пустым email")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38426")
    void authorizationNegativeEmptyEmailTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Заполнить пароль", () ->
                authorizationPage.typePassword("stronghold"));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить сообщение об ошибке", () ->
                authorizationPage.checkErrorMessage("Необходимые данные не заполнены."));
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с неправильным паролем")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38432")
    void authorizationNegativeBadPasswordTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Заполнить email", () ->
                authorizationPage.typeEmail("unrealtest@gmail.com"));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword("stronghold"));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить сообщение об ошибке", () ->
                authorizationPage.checkErrorMessage("Нам не удалось найти аккаунт, соответствующий введенным Вами имени пользователя и паролю. Пожалуйста, проверьте Ваши имя пользователя и пароль и попробуйте еще раз."));
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с неправильной раскладкой клавиатуры email")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38431")
    void authorizationNegativeKeyboardLayoutEmailTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Заполнить email", () ->
                authorizationPage.typeEmail("еуыееуыевуч\"пьфшдюсщь"));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword("stronghold"));
        step("Нажать кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить сообщение об ошибке", () ->
                authorizationPage.checkErrorMessage("Неверный формат электронной почты"));
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с неправильной раскладкой клавиатуры email")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38432")
    void authorizationNegativeKeyboardLayoutPasswordTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Заполнить email", () ->
                authorizationPage.typeEmail("testtestdex@gmail.com"));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword("ыекщтпрщдв"));
        step("Нажать кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить сообщение об ошибке", () ->
                authorizationPage.checkErrorMessage("Нам не удалось найти аккаунт, соответствующий введенным Вами имени пользователя и паролю. Пожалуйста, проверьте Ваши имя пользователя и пароль и попробуйте еще раз."));
    }


    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка кнопки Показать пароль")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38428")
    void authorizationShowPasswordTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Заполнить пароль", () ->
                authorizationPage.typePassword("005"));
        step("Нажать на кнопку Показать пароль", () ->
                authorizationPage.clickShowPassword());
        step("Проверить видимость пароля", () ->
                authorizationPage.checkShowPassword("005"));
        step("Нажать на кнопку Скрыть пароль", () ->
                authorizationPage.clickShowPassword());
        step("Проверить невидимость пароля", () ->
                authorizationPage.checkShowPassword(""));
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка табуляции")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38429")
    void authorizationTabTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Заполнить email", () -> {
            authorizationPage.typeEmail("test@gmail.com");
            actions().sendKeys(Keys.chord(Keys.TAB)).perform();
        });
        step("Заполнить пароль", () -> {
            authorizationPage.typePassword("005");
            actions().sendKeys(Keys.chord(Keys.TAB)).perform();
            actions().sendKeys(Keys.chord(Keys.TAB)).perform();
        });
        step("Нажать на кнопку Войти пробелом", () -> {
            actions().sendKeys(Keys.chord(Keys.TAB)).perform();
            actions().sendKeys(Keys.chord(Keys.SPACE)).perform();
        });
        step("Проверить переход в админ-панель", () ->
                authorizationPage.checkVisible());
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка выхода из аккаунта")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38438")
    void authorizationExitTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Авторизоваться", () ->
                authorizationPage.Authorization());
        step("Нажать на кнопку Выход", () ->
                authorizationPage.clickExit());
        step("Нажать кнопку Подтвердить", () ->
                authorizationPage.clickConfirm());
        step("Проверить переход на страницу авторизации", () ->
                authorizationPage.checkVisibleTitle());
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка закрытие окна выхода из аккаунта кнопкой ESC")
    @Severity(SeverityLevel.MINOR)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38436")
    void authorizationExitEscTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Авторизоваться", () ->
                authorizationPage.Authorization());
        step("Нажать на кнопку Выход", () ->
                authorizationPage.clickExit());
        step("Нажать кнопку ESC", () ->
                actions().sendKeys(Keys.chord(Keys.ESCAPE)).perform());
        step("Проверить закрытия окна", () ->
                authorizationPage.checkVisible());
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка закрытие окна выхода из аккаунта кнопкой Отмена")
    @Severity(SeverityLevel.MINOR)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38436")
    void authorizationExitCancelTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Авторизоваться", () ->
                authorizationPage.Authorization());
        step("Нажать на кнопку Выход", () ->
                authorizationPage.clickExit());
        step("Нажать кнопку Отмена", () ->
                authorizationPage.clickCancel());
        step("Проверить закрытия окна", () ->
                authorizationPage.checkVisible());
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка закрытие окна выхода с кликом в любом месте")
    @Severity(SeverityLevel.MINOR)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38437")
    void authorizationExitClickMouseTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Авторизоваться", () ->
                authorizationPage.Authorization());
        step("Нажать на кнопку Выход", () ->
                authorizationPage.clickExit());
        step("Нажать в любом месте экрана", () ->
                authorizationPage.clickOnMouse());
        step("Проверить закрытия окна", () ->
                authorizationPage.checkVisible());
    }

    @Test
    @Owner("azavrichko")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Проверка кнопки Выход")
    @Severity(SeverityLevel.MINOR)
    @Link("https://tr.dextechnology.com/testrail//index.php?/cases/view/38434")
    void authorizationExitClickExitButtonTest() {
        step("Открыть страницу", () ->
                authorizationPage.openPage());
        step("Авторизоваться", () ->
                authorizationPage.Authorization());
        step("Нажать на кнопку Выход", () ->
                authorizationPage.clickExit());
        step("Проверить открытие модального окна выхода", () ->
                authorizationPage.checkModalConfirmMessage());
    }


}
