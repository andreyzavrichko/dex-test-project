package com.dex.tests;

import com.dex.TestBase;
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

@DisplayName("Регистрация")
class RegistrationTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String phone = "7" + faker.number().digits(10);
    String smsCode = "0000";
    String firstName = faker.name().firstName();
    String middleName = faker.name().lastName();
    String lastName = faker.animal().name();
    String birthDay = "12-02-1990";
    String password = "Passw0rd%";
    String confirmPassword = "Passw0rd%";


    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация на новый номер - проверка перехода на экран смс кода")
    @Severity(SeverityLevel.BLOCKER)
    void registrationFirstTest() {
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
        step("Проверить переход к экрану смс кода", () ->
                registrationPage.checkSmsFormTitle("подтвердите номер телефона"));
    }

    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация на новый номер - проверка перехода на экран создания профиля")
    @Severity(SeverityLevel.BLOCKER)
    void registrationSmsCodeTest() {
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
        step("Проверить переход к экрану создания профиля", () ->
                registrationPage.checkProfileTitle("укажите ваши данные"));
    }

    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация на новый номер - проверка успешного создания")
    @Severity(SeverityLevel.BLOCKER)
    void registrationProfileTest() {
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
        step("Проверить переход к экрану создания профиля", () ->
                registrationPage.checkSuccessTitle("Вы успешно зарегистрировались"));
    }

    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Авторизация после регистрации")
    @Severity(SeverityLevel.BLOCKER)
    void authAfterRegTest() {
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
    }

    // Негативные сценарии

    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация - проверка номера телефона")
    @Severity(SeverityLevel.BLOCKER)
    @CsvSource(value = {
            "!!!, Длина номера должна быть 11 символов",
            ", Заполните обязательное поле",
            "152, Длина номера должна быть 11 символов",
            ".dsf, Длина номера должна быть 11 символов",
            "@@@, Длина номера должна быть 11 символов",
            "###, Длина номера должна быть 11 символов",
            "$$$, Длина номера должна быть 11 символов",
            "%%%, Длина номера должна быть 11 символов",
            "^^^, Длина номера должна быть 11 символов",
            "&&&, Длина номера должна быть 11 символов",
            "***, Длина номера должна быть 11 символов",
            "(((, Длина номера должна быть 11 символов",
            "))), Длина номера должна быть 11 символов",
            "___, Длина номера должна быть 11 символов",
            "+++, Длина номера должна быть 11 символов",
            "///, Длина номера должна быть 11 символов",
            "****, Длина номера должна быть 11 символов",
            "---, Длина номера должна быть 11 символов",
            "++++, Длина номера должна быть 11 символов",
            "№№№, Длина номера должна быть 11 символов",
            ";;;, Длина номера должна быть 11 символов",
            ":::, Длина номера должна быть 11 символов",
            "???, Длина номера должна быть 11 символов",
            "[[[, Длина номера должна быть 11 символов",
            "}}}, Длина номера должна быть 11 символов",
            "]]], Длина номера должна быть 11 символов",
            "{{{, Длина номера должна быть 11 символов",
            "$$%^, Длина номера должна быть 11 символов",
            "00000000000, Номер должен начинаться с цифры 7",
            "11111111111, Номер должен начинаться с цифры 7",
            "22222222222, Номер должен начинаться с цифры 7",
            "33333333333, Номер должен начинаться с цифры 7",
            "44444444444, Номер должен начинаться с цифры 7",
            "55555555555, Номер должен начинаться с цифры 7",
            "66666666666, Номер должен начинаться с цифры 7",
            "88888888888, Номер должен начинаться с цифры 7",
            "99999999999, Номер должен начинаться с цифры 7",
            "58456454, Длина номера должна быть 11 символов",
            "$$%^, Длина номера должна быть 11 символов",
            "$$%^, Длина номера должна быть 11 символов",
            "$$%^, Длина номера должна быть 11 символов",
            "$&%^#$%^, Длина номера должна быть 11 символов",
            "%$$^%^%$^, Длина номера должна быть 11 символов"})
    @ParameterizedTest(name = "Проверка поля номер телефона при регистрации с тестовыми данными: {0}")
    void registrationNegativeTest(String testData, String expectedResult) {
        step("Открываем сайт", () ->
                registrationPage.openPage());
        step("Нажать кнопку Вход", () ->
                registrationPage.clickAuthButton());
        step("Нажать ссылку Регистрация", () ->
                registrationPage.clickRegButton());
        step("Заполнить номер телефона", () ->
                registrationPage.typePhone(testData));
        step("Нажать на кнопку Продолжить", () ->
                registrationPage.clickContinueButton());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError(expectedResult));
    }

    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация")
    @Severity(SeverityLevel.BLOCKER)
    @CsvSource(value = {
            "1111, Данный код не найден",
            "2222, Данный код не найден",
            "3333, Данный код не найден",
            "4444, Данный код не найден",
            "5555, Данный код не найден",
            "6666, Данный код не найден",
            "7777, Данный код не найден",
            "8888, Данный код не найден",
            "1, Неверный код",
            "12, Неверный код",
            "123, Неверный код",
            "9999, Данный код не найден"})
    @ParameterizedTest(name = "Проверка поля ввода смс кода с тестовыми данными: {0}")
    void registrationSmsCodeTest(String testData, String expectedResult) {
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
                registrationPage.typeSmsCode(testData));
        step("Нажать на кнопку Продолжить", () ->
                registrationPage.clickContinueButton());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError(expectedResult));
    }

    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация на новый номер - проверка ошибки календаря")
    @Severity(SeverityLevel.BLOCKER)
    void registrationProfileDataTest() {
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
                registrationPage.typeBirthDay("12-02-9999"));
        step("Заполнить поле Пароль", () ->
                registrationPage.typePassword(password));
        step("Заполнить поле Подтвердить пароль", () ->
                registrationPage.typeConfirmPassword(confirmPassword));
        step("Установить чек-бокс", () ->
                registrationPage.typeConfirmCheckbox());
        step("Нажимаем кнопку Зарегистрироваться", () ->
                registrationPage.clickSubmit());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Дата рождения должна быть меньше текущей"));
    }

    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация на новый номер - проверка ошибки обязательности Имени")
    @Severity(SeverityLevel.BLOCKER)
    void registrationProfileFirstNameReqTest() {
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
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация на новый номер - проверка ошибки обязательности Фамилии")
    @Severity(SeverityLevel.BLOCKER)
    void registrationProfileLastNameReqTest() {
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
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация на новый номер - проверка ошибки обязательности Отчества")
    @Severity(SeverityLevel.BLOCKER)
    void registrationProfileMiddleNameReqTest() {
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
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация на новый номер - проверка ошибки обязательности Даты рождения")
    @Severity(SeverityLevel.BLOCKER)
    void registrationProfileBirthDayReqTest() {
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
        step("Заполнить поле Пароль", () ->
                registrationPage.typePassword(password));
        step("Заполнить поле Подтвердить пароль", () ->
                registrationPage.typeConfirmPassword(confirmPassword));
        step("Установить чек-бокс", () ->
                registrationPage.typeConfirmCheckbox());
        step("Нажимаем кнопку Зарегистрироваться", () ->
                registrationPage.clickSubmit());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация на новый номер - проверка ошибки обязательности Пароля")
    @Severity(SeverityLevel.BLOCKER)
    void registrationProfilePassReqTest() {
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
        step("Заполнить поле Подтвердить пароль", () ->
                registrationPage.typeConfirmPassword(confirmPassword));
        step("Установить чек-бокс", () ->
                registrationPage.typeConfirmCheckbox());
        step("Нажимаем кнопку Зарегистрироваться", () ->
                registrationPage.clickSubmit());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация на новый номер - проверка ошибки обязательности Повторения Пароля")
    @Severity(SeverityLevel.BLOCKER)
    void registrationProfileConfirmPassReqTest() {
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
        step("Установить чек-бокс", () ->
                registrationPage.typeConfirmCheckbox());
        step("Нажимаем кнопку Зарегистрироваться", () ->
                registrationPage.clickSubmit());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Заполните обязательное поле"));
    }

    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация")
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
    @ParameterizedTest(name = "Проверка поля пароля с тестовыми данными: {0}")
    void registrationPassTest(String testData, String expectedResult) {
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
                registrationPage.typePassword(testData));
        step("Заполнить поле Подтвердить пароль", () ->
                registrationPage.typeConfirmPassword(confirmPassword));
        step("Установить чек-бокс", () ->
                registrationPage.typeConfirmCheckbox());
        step("Нажимаем кнопку Зарегистрироваться", () ->
                registrationPage.clickSubmit());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError(expectedResult));
    }

    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация")
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
    @ParameterizedTest(name = "Проверка поля подтверждения пароля с тестовыми данными: {0}")
    void registrationConfirmPassTest(String testData, String expectedResult) {
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
                registrationPage.typePassword(testData));
        step("Заполнить поле Подтвердить пароль", () ->
                registrationPage.typeConfirmPassword(testData));
        step("Установить чек-бокс", () ->
                registrationPage.typeConfirmCheckbox());
        step("Нажимаем кнопку Зарегистрироваться", () ->
                registrationPage.clickSubmit());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError(expectedResult));
    }


    @Test
    @Tag("smoke")
    @Feature("Регистрация")
    @Story("Регистрация")
    @DisplayName("Регистрация - пароли должны совпадать")
    @Severity(SeverityLevel.BLOCKER)
    void registrationPassMatchTest() {
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
                registrationPage.typeConfirmPassword("123456789"));
        step("Установить чек-бокс", () ->
                registrationPage.typeConfirmCheckbox());
        step("Нажимаем кнопку Зарегистрироваться", () ->
                registrationPage.clickSubmit());
        step("Проверить отображение ошибки валидации", () ->
                registrationPage.checkInputError("Пароли должны совпадать"));
    }

}
