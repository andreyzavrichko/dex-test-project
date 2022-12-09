package com.dex.tests;

import com.dex.TestBase;

import com.dex.pages.ChangePassPage;
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

@DisplayName("Восстановление пароля")
class ChangePassTest extends TestBase {

    ChangePassPage changePassPagePage = new ChangePassPage();
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
    @Feature("Восстановление пароля")
    @Story("Восстановление пароля")
    @DisplayName("Восстановление пароля")
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
        // Предусловие, дальше вынесем в отдельный компонент
        step("Нажать кнопку Профиль", () ->
                changePassPagePage.clickProfileButton());
        step("Нажать кнопку Выход", () ->
                changePassPagePage.clickExitButton());
        step("Нажать кнопку Вход", () ->
                changePassPagePage.clickAuthButton());
        step("Нажать ссылку Восстановление пароля", () ->
                changePassPagePage.clickChangePassButton());
        step("Заполнить номер телефона", () ->
                changePassPagePage.typePhone(phone));
        step("Нажать на кнопку Восстановить", () ->
                changePassPagePage.clickReestablishButton());
        step("Ввести код из смс", () ->
                changePassPagePage.typeSmsCode(smsCode));
        step("Нажать на кнопку Восстановить", () ->
                changePassPagePage.clickReestablishButton());
        step("Заполнить поле Пароль", () ->
                changePassPagePage.typePassword(password));
        step("Заполнить поле Подтвердить пароль", () ->
                changePassPagePage.typeConfirmPassword(confirmPassword));
        step("Нажать кнопку Готово", () ->
                changePassPagePage.clickSubmitButton());
        step("Проверить успешность смены пароля", () ->
                changePassPagePage.checkSuccessPassTitle("Вы успешно восстановили пароль"));
    }

    // Негативные сценарии

    @Tag("regress")
    @Feature("Восстановление пароля")
    @Story("Восстановление пароля")
    @DisplayName("Восстановление пароля - пустой номер телефона")
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
    @ParameterizedTest(name = "Проверка поля номер телефона при восстановлении с тестовыми данными: {0}")
    void changePassNegativeTest(String testData, String expectedResult) {
        step("Открываем сайт", () ->
                changePassPagePage.openPage());
        step("Нажать кнопку Вход", () ->
                changePassPagePage.clickAuthButton());
        step("Нажать ссылку Восстановление пароля", () ->
                changePassPagePage.clickChangePassButton());
        step("Заполнить номер телефона", () ->
                changePassPagePage.typePhone(testData));
        step("Нажать на кнопку Восстановить", () ->
                changePassPagePage.clickReestablishButton());
        step("Проверить отображение ошибки валидации", () ->
                changePassPagePage.checkInputError(expectedResult));
    }

    @Tag("regress")
    @Feature("Восстановление пароля")
    @Story("Восстановление пароля")
    @DisplayName("Восстановление пароля")
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
    void changePassSmsCodeTest(String testData, String expectedResult) {
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
        // Предусловие, дальше вынесем в отдельный компонент
        step("Нажать кнопку Профиль", () ->
                changePassPagePage.clickProfileButton());
        step("Нажать кнопку Выход", () ->
                changePassPagePage.clickExitButton());
        step("Нажать кнопку Вход", () ->
                changePassPagePage.clickAuthButton());
        step("Нажать ссылку Восстановление пароля", () ->
                changePassPagePage.clickChangePassButton());
        step("Заполнить номер телефона", () ->
                changePassPagePage.typePhone(phone));
        step("Нажать на кнопку Восстановить", () ->
                changePassPagePage.clickReestablishButton());
        step("Ввести код из смс", () ->
                changePassPagePage.typeSmsCode(testData));
        step("Нажать на кнопку Восстановить", () ->
                changePassPagePage.clickReestablishButton());
        step("Проверить отображение ошибки валидации", () ->
                changePassPagePage.checkInputError(expectedResult));
    }

    @Tag("regress")
    @Feature("Восстановление пароля")
    @Story("Восстановление пароля")
    @DisplayName("Восстановление пароля")
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
    void changePassTest(String testData, String expectedResult) {
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
        // Предусловие, дальше вынесем в отдельный компонент
        step("Нажать кнопку Профиль", () ->
                changePassPagePage.clickProfileButton());
        step("Нажать кнопку Выход", () ->
                changePassPagePage.clickExitButton());
        step("Нажать кнопку Вход", () ->
                changePassPagePage.clickAuthButton());
        step("Нажать ссылку Восстановление пароля", () ->
                changePassPagePage.clickChangePassButton());
        step("Заполнить номер телефона", () ->
                changePassPagePage.typePhone(phone));
        step("Нажать на кнопку Восстановить", () ->
                changePassPagePage.clickReestablishButton());
        step("Ввести код из смс", () ->
                changePassPagePage.typeSmsCode(smsCode));
        step("Нажать на кнопку Восстановить", () ->
                changePassPagePage.clickReestablishButton());
        step("Заполнить поле Пароль", () ->
                changePassPagePage.typePassword(testData));
        step("Заполнить поле Подтвердить пароль", () ->
                changePassPagePage.typeConfirmPassword(confirmPassword));
        step("Нажать кнопку Готово", () ->
                changePassPagePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                changePassPagePage.checkInputError(expectedResult));
    }

    @Tag("smoke")
    @Feature("Восстановление пароля")
    @Story("Восстановление пароля")
    @DisplayName("Восстановление пароля")
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
    void changeConfirmPassTest(String testData, String expectedResult) {
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
        // Предусловие, дальше вынесем в отдельный компонент
        step("Нажать кнопку Профиль", () ->
                changePassPagePage.clickProfileButton());
        step("Нажать кнопку Выход", () ->
                changePassPagePage.clickExitButton());
        step("Нажать кнопку Вход", () ->
                changePassPagePage.clickAuthButton());
        step("Нажать ссылку Восстановление пароля", () ->
                changePassPagePage.clickChangePassButton());
        step("Заполнить номер телефона", () ->
                changePassPagePage.typePhone(phone));
        step("Нажать на кнопку Восстановить", () ->
                changePassPagePage.clickReestablishButton());
        step("Ввести код из смс", () ->
                changePassPagePage.typeSmsCode(smsCode));
        step("Нажать на кнопку Восстановить", () ->
                changePassPagePage.clickReestablishButton());
        step("Заполнить поле Пароль", () ->
                changePassPagePage.typePassword(testData));
        step("Заполнить поле Подтвердить пароль", () ->
                changePassPagePage.typeConfirmPassword(testData));
        step("Нажать кнопку Готово", () ->
                changePassPagePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации", () ->
                changePassPagePage.checkInputError(expectedResult));
    }

    @Test
    @Tag("smoke")
    @Feature("Восстановление пароля")
    @Story("Восстановление пароля")
    @DisplayName("Восстановление пароля - пароли должны совпадать")
    @Severity(SeverityLevel.BLOCKER)
    void passMatchTest() {
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
        // Предусловие, дальше вынесем в отдельный компонент
        step("Нажать кнопку Профиль", () ->
                changePassPagePage.clickProfileButton());
        step("Нажать кнопку Выход", () ->
                changePassPagePage.clickExitButton());
        step("Нажать кнопку Вход", () ->
                changePassPagePage.clickAuthButton());
        step("Нажать ссылку Восстановление пароля", () ->
                changePassPagePage.clickChangePassButton());
        step("Заполнить номер телефона", () ->
                changePassPagePage.typePhone(phone));
        step("Нажать на кнопку Восстановить", () ->
                changePassPagePage.clickReestablishButton());
        step("Ввести код из смс", () ->
                changePassPagePage.typeSmsCode(smsCode));
        step("Нажать на кнопку Восстановить", () ->
                changePassPagePage.clickReestablishButton());
        step("Заполнить поле Пароль", () ->
                changePassPagePage.typePassword(password));
        step("Заполнить поле Подтвердить пароль", () ->
                changePassPagePage.typeConfirmPassword("111111111"));
        step("Нажать кнопку Готово", () ->
                changePassPagePage.clickSubmitButton());
        step("Проверить отображение ошибки валидации ", () ->
                changePassPagePage.checkInputError("Пароли должны совпадать"));
    }


}
