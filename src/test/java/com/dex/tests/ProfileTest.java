package com.dex.tests;

import com.dex.TestBase;
import com.dex.pages.AuthorizationPage;
import com.dex.pages.ProfilePage;
import com.dex.pages.RegistrationPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Профиль")
class ProfileTest extends TestBase {
    ProfilePage profilePage = new ProfilePage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    RegistrationPage registrationPage = new RegistrationPage();
    // Данные для регистрации
    Faker faker = new Faker();
    String phone = "7" + faker.number().digits(10);
    String smsCode = "0000";
    String firstName = faker.name().firstName();
    String middleName = faker.name().lastName();
    String lastName = faker.animal().name();
    String birthDay = "12-02-1990";
    String password = "Passw0rd%";
    String confirmPassword = "Passw0rd%";

    // Данные для редактирования профиля
    String newFirstName = faker.name().firstName();
    String newMiddleName = faker.name().lastName();
    String newLastName = faker.animal().name();
    String newBirthDay = "11-01-1980";
    String newPassword = "Pass5rd%";
    String newConfirmPassword = "Pass5rd%";

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

    @Test
    @Feature("Профиль")
    @Story("Профиль")
    @DisplayName("Редактирование профиля")
    @Severity(SeverityLevel.BLOCKER)
    void editProfileTest() {
        step("Открываем сайт", () ->
                registrationPage.openPage());
        step("Нажать кнопку Вход", () ->
                registrationPage.clickAuthButton());
        step("Нажать ссылку Регистрация", () ->
                registrationPage.clickRegButton());
        step("Заполнить номер телефона", () ->
                registrationPage.typePhone(phone));
        step("Нажать на кнопку Продолжить", () ->
                registrationPage.clickContinueButton());
        step("Ввести код из смс", () ->
                registrationPage.typeSmsCode(smsCode));
        step("Нажать на кнопку Продолжить", () ->
                registrationPage.clickContinueButton());
        step("Заполнить поле имя", () ->
                registrationPage.typeFirstName(firstName));
        step("Заполнить поле фамилия", () ->
                registrationPage.typeMiddleName(middleName));
        step("Заполнить поле отчество", () ->
                registrationPage.typeLastName(lastName));
        step("Заполнить поле Дата рождения", () ->
                registrationPage.typeBirthDay(birthDay));
        step("Заполнить поле Пароль", () ->
                registrationPage.typePassword(password));
        step("Заполнить поле Подтвердить пароль", () ->
                registrationPage.typeConfirmPassword(confirmPassword));
        step("Установить чек-бокс", () ->
                registrationPage.typeConfirmCheckbox());
        step("Нажимаем кнопку Зарегистрироваться", () ->
                registrationPage.clickSubmit());
        step("Нажимаем кнопку Войти в аккаунт", () ->
                registrationPage.clickAuthRegButton());
        step("Заполнить номер телефона", () ->
                registrationPage.typePhone(phone));
        step("Заполнить пароль", () ->
                registrationPage.typePassword(password));
        step("Нажать на кнопку Войти", () ->
                registrationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                registrationPage.checkNewsLink());
        // Основное действие
        step("Нажать кнопку Профиль", () ->
                profilePage.clickProfileButton());
        step("Нажать ссылку Профиль", () ->
                profilePage.clickProfileLink());
        step("Нажать ссылку Редактировать профиль", () ->
                profilePage.clickEditButton());
        step("Заполнить поле имя", () ->
                profilePage.typeFirstName(newFirstName));
        step("Заполнить поле фамилия", () ->
                profilePage.typeMiddleName(newMiddleName));
        step("Заполнить поле отчество", () ->
                profilePage.typeLastName(newLastName));
        step("Заполнить поле Дата рождения", () ->
                profilePage.typeBirthDay(newBirthDay));
        step("Нажать кнопку Сохранить", () ->
                profilePage.clickSubmitButton());
        // Проверяем новые данные
        step("Проверить новое содержимое страницы Профиль", () -> {
            profilePage.checkFirstName(newFirstName);
            profilePage.checkLastName(newMiddleName);
            profilePage.checkMiddleName(newLastName);
        });
    }

    @Test
    @Feature("Профиль")
    @Story("Профиль")
    @DisplayName("Смена пароля в профиле")
    @Severity(SeverityLevel.BLOCKER)
    void changePassInProfileTest() {
        step("Открываем сайт", () ->
                registrationPage.openPage());
        step("Нажать кнопку Вход", () ->
                registrationPage.clickAuthButton());
        step("Нажать ссылку Регистрация", () ->
                registrationPage.clickRegButton());
        step("Заполнить номер телефона", () ->
                registrationPage.typePhone(phone));
        step("Нажать на кнопку Продолжить", () ->
                registrationPage.clickContinueButton());
        step("Ввести код из смс", () ->
                registrationPage.typeSmsCode(smsCode));
        step("Нажать на кнопку Продолжить", () ->
                registrationPage.clickContinueButton());
        step("Заполнить поле имя", () ->
                registrationPage.typeFirstName(firstName));
        step("Заполнить поле фамилия", () ->
                registrationPage.typeMiddleName(middleName));
        step("Заполнить поле отчество", () ->
                registrationPage.typeLastName(lastName));
        step("Заполнить поле Дата рождения", () ->
                registrationPage.typeBirthDay(birthDay));
        step("Заполнить поле Пароль", () ->
                registrationPage.typePassword(password));
        step("Заполнить поле Подтвердить пароль", () ->
                registrationPage.typeConfirmPassword(confirmPassword));
        step("Установить чек-бокс", () ->
                registrationPage.typeConfirmCheckbox());
        step("Нажимаем кнопку Зарегистрироваться", () ->
                registrationPage.clickSubmit());
        step("Нажимаем кнопку Войти в аккаунт", () ->
                registrationPage.clickAuthRegButton());
        step("Заполнить номер телефона", () ->
                registrationPage.typePhone(phone));
        step("Заполнить пароль", () ->
                registrationPage.typePassword(password));
        step("Нажать на кнопку Войти", () ->
                registrationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                registrationPage.checkNewsLink());
        // Основное действие
        step("Нажать кнопку Профиль", () ->
                profilePage.clickProfileButton());
        step("Нажать ссылку Профиль", () ->
                profilePage.clickProfileLink());
        step("Нажать на кнопку Сменить пароль", () ->
                profilePage.clickChangePasswordButton());
        step("Заполнить поле Пароль", () ->
                profilePage.typePassword(newPassword));
        step("Заполнить поле Подтвердить пароль", () ->
                profilePage.typeConfirmPassword(newConfirmPassword));
        step("Нажать кнопку Готово", () ->
                profilePage.clickSubmitButton());
        step("Проверить успешность смены пароля", () ->
                profilePage.checkSuccessChangePassTitle("Вы успешно сменили пароль"));
        step("Нажать кнопку Вернуться к профилю", () ->
                profilePage.clickProfileReturnButton());
        step("Нажать кнопку Профиль", () ->
                profilePage.clickProfileButton());
        step("Нажать ссылку Выход", () ->
                profilePage.clickExitLink());
        // Проверяем вход с новым паролем
        step("Нажать кнопку Вход", () ->
                authorizationPage.clickAuthButton());
        step("Заполнить номер телефона", () ->
                authorizationPage.typePhone(phone));
        step("Заполнить пароль", () ->
                authorizationPage.typePassword(newPassword));
        step("Нажать на кнопку Войти", () ->
                authorizationPage.clickSubmit());
        step("Проверить переход в админ-панель", () ->
                authorizationPage.checkNewsLink());
    }


}
