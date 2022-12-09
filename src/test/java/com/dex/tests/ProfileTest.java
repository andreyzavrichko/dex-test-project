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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @Tag("smoke")
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
    @Tag("smoke")
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
    @Tag("smoke")
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

    // Негативные сценарии

    @Test
    @Tag("smoke")
    @Feature("Профиль")
    @Story("Профиль")
    @DisplayName("Редактирование профиля - удаление имени")
    @Severity(SeverityLevel.BLOCKER)
    void deleteFirstNameProfileTest() {
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
        step("Очищаем поле имя", () ->
                profilePage.clearFirstNameInput());
        step("Нажать кнопку Сохранить", () ->
                profilePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Профиль")
    @Story("Профиль")
    @DisplayName("Редактирование профиля - удаление фамилии")
    @Severity(SeverityLevel.BLOCKER)
    void deleteLastNameProfileTest() {
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
        step("Очищаем поле Фамилия", () ->
                profilePage.clearMiddleNameInput());
        step("Нажать кнопку Сохранить", () ->
                profilePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Профиль")
    @Story("Профиль")
    @DisplayName("Редактирование профиля - удаление отчества")
    @Severity(SeverityLevel.BLOCKER)
    void deleteMiddleNameProfileTest() {
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
        step("Очищаем поле Отчество", () ->
                profilePage.clearLastNameInput());
        step("Нажать кнопку Сохранить", () ->
                profilePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Профиль")
    @Story("Профиль")
    @DisplayName("Редактирование профиля - удаление дня рождения")
    @Severity(SeverityLevel.BLOCKER)
    void deleteBirthdayProfileTest() {
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
        step("Очищаем поле День рождения", () ->
                profilePage.clearBirthDayInput());
        step("Нажать кнопку Сохранить", () ->
                profilePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Профиль")
    @Story("Профиль")
    @DisplayName("Редактирование профиля - установка дня рождения в будущем")
    @Severity(SeverityLevel.BLOCKER)
    void moreBirthdayProfileTest() {
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
        step("Очищаем поле День рождения", () ->
                profilePage.clearBirthDayInput());
        step("Установить дату рождения в будущем", () ->
                profilePage.typeBirthDay("01-01-9999"));
        step("Нажать кнопку Сохранить", () ->
                profilePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Дата рождения должна быть меньше текущей"));
    }

    @Test
    @Tag("smoke")
    @Feature("Профиль")
    @Story("Профиль")
    @DisplayName("Смена пароля в профиле - проверка обязательности пароля")
    @Severity(SeverityLevel.BLOCKER)
    void changePassInProfileRegTest() {
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
        step("Заполнить поле Подтвердить новый пароль", () ->
                profilePage.typeConfirmPassword(newConfirmPassword));
        step("Нажать кнопку Готово", () ->
                profilePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Профиль")
    @Story("Профиль")
    @DisplayName("Смена пароля в профиле - проверка обязательности подтверждения пароля")
    @Severity(SeverityLevel.BLOCKER)
    void changeConfirmPassInProfileRegTest() {
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
        step("Заполнить поле Новый пароль", () ->
                profilePage.typePassword(newPassword));
        step("Нажать кнопку Готово", () ->
                profilePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Профиль")
    @Story("Профиль")
    @DisplayName("Смена пароля в профиле - проверка совпадения паролей")
    @Severity(SeverityLevel.BLOCKER)
    void matchPassInProfileTest() {
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
        step("Заполнить поле Новый пароль", () ->
                profilePage.typePassword(newPassword));
        step("Заполнить поле Подтвердите новый пароль", () ->
                profilePage.typeConfirmPassword("123456789"));
        step("Нажать кнопку Готово", () ->
                profilePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Пароли должны совпадать"));
    }


    @Tag("smoke")
    @Feature("Смена пароля")
    @Story("Профиль")
    @DisplayName("Смена пароля в профиле")
    @Severity(SeverityLevel.BLOCKER)
    @CsvSource(value = {
            "!!!, Длина пароля должна быть больше 8 символов",
            ", Заполните обязательное поле",
            "152, Длина пароля должна быть больше 8 символов",
            ".dsf, Длина пароля должна быть больше 8 символов",
            "@@@, Длина пароля должна быть больше 8 символов",
            "###, Длина пароля должна быть больше 8 символов",
            "$$$, Длина пароля должна быть больше 8 символов",
            "%%%, Длина пароля должна быть больше 8 символов",
            "^^^, Длина пароля должна быть больше 8 символов",
            "&&&, Длина пароля должна быть больше 8 символов",
            "***, Длина пароля должна быть больше 8 символов",
            "(((, Длина пароля должна быть больше 8 символов",
            "))), Длина пароля должна быть больше 8 символов",
            "___, Длина пароля должна быть больше 8 символов",
            "+++, Длина пароля должна быть больше 8 символов",
            "///, Длина пароля должна быть больше 8 символов",
            "****, Длина пароля должна быть больше 8 символов",
            "---, Длина пароля должна быть больше 8 символов",
            "++++, Длина пароля должна быть больше 8 символов",
            "№№№, Длина пароля должна быть больше 8 символов",
            ";;;, Длина пароля должна быть больше 8 символов",
            ":::, Длина пароля должна быть больше 8 символов",
            "???, Длина пароля должна быть больше 8 символов",
            "[[[, Длина пароля должна быть больше 8 символов",
            "}}}, Длина пароля должна быть больше 8 символов",
            "]]], Длина пароля должна быть больше 8 символов",
            "{{{, Длина пароля должна быть больше 8 символов",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "00000000000, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "11111111111, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "22222222222, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "33333333333, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "44444444444, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "55555555555, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "66666666666, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "88888888888, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "99999999999, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "58456454, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "$&%^#$%^, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "vdsdsfdsf, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "vdsdfdsf, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "%$$^%^%$^, Пароль должен содержать заглавную букву, цифру и спецсимвол"})
    @ParameterizedTest(name = "Проверка поля нового пароля с тестовыми данными: {0}")
    void changePassInProfileTest(String testData, String expectedResult) {
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
                profilePage.typePassword(testData));
        step("Заполнить поле Подтвердить пароль", () ->
                profilePage.typeConfirmPassword(newConfirmPassword));
        step("Нажать кнопку Готово", () ->
                profilePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                profilePage.checkInputError(expectedResult));
    }

    @Tag("smoke")
    @Feature("Смена пароля")
    @Story("Профиль")
    @DisplayName("Смена пароля в профиле - подтверждение пароля")
    @Severity(SeverityLevel.BLOCKER)
    @CsvSource(value = {
            "!!!, Длина пароля должна быть больше 8 символов",
            ", Заполните обязательное поле",
            "152, Длина пароля должна быть больше 8 символов",
            ".dsf, Длина пароля должна быть больше 8 символов",
            "@@@, Длина пароля должна быть больше 8 символов",
            "###, Длина пароля должна быть больше 8 символов",
            "$$$, Длина пароля должна быть больше 8 символов",
            "%%%, Длина пароля должна быть больше 8 символов",
            "^^^, Длина пароля должна быть больше 8 символов",
            "&&&, Длина пароля должна быть больше 8 символов",
            "***, Длина пароля должна быть больше 8 символов",
            "(((, Длина пароля должна быть больше 8 символов",
            "))), Длина пароля должна быть больше 8 символов",
            "___, Длина пароля должна быть больше 8 символов",
            "+++, Длина пароля должна быть больше 8 символов",
            "///, Длина пароля должна быть больше 8 символов",
            "****, Длина пароля должна быть больше 8 символов",
            "---, Длина пароля должна быть больше 8 символов",
            "++++, Длина пароля должна быть больше 8 символов",
            "№№№, Длина пароля должна быть больше 8 символов",
            ";;;, Длина пароля должна быть больше 8 символов",
            ":::, Длина пароля должна быть больше 8 символов",
            "???, Длина пароля должна быть больше 8 символов",
            "[[[, Длина пароля должна быть больше 8 символов",
            "}}}, Длина пароля должна быть больше 8 символов",
            "]]], Длина пароля должна быть больше 8 символов",
            "{{{, Длина пароля должна быть больше 8 символов",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "00000000000, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "11111111111, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "22222222222, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "33333333333, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "44444444444, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "55555555555, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "66666666666, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "88888888888, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "99999999999, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "58456454, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "$$%^, Длина пароля должна быть больше 8 символов",
            "$&%^#$%^, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "vdsdsfdsf, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "vdsdfdsf, Пароль должен содержать заглавную букву, цифру и спецсимвол",
            "%$$^%^%$^, Пароль должен содержать заглавную букву, цифру и спецсимвол"})
    @ParameterizedTest(name = "Проверка поля подтверждения нового пароля с тестовыми данными: {0}")
    void changeConfirmPassInProfileTest(String testData, String expectedResult) {
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
                profilePage.typePassword(testData));
        step("Заполнить поле Подтвердить пароль", () ->
                profilePage.typeConfirmPassword(testData));
        step("Нажать кнопку Готово", () ->
                profilePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                profilePage.checkInputError(expectedResult));
    }


}
