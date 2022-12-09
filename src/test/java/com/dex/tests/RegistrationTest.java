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


}
