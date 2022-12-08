package com.dex.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {
    SelenideElement
            authButton = $(byText("Вход")),
            changePassButton = $(byText("Восстановить пароль")),
            phoneInput = $("[name=phone]"),
            smsCodeInput = $("[ type=text]"),
            continueButton = $(byText("Продолжить")),
            exitButton = $(byText("Выход")),
            passwordInput = $("[name=password]"),
            confirmPasswordInput = $("[name=confirmPassword]"),
            profileButton = $("[fill=none]"),
            profileLink = $(byText("Профиль")),
            profileTitle = $(byText("Профиль пользователя")),
            editButton = $(byText("Редактировать профиль")),
            profileNameTitle = $(byText("Имя:")),
            profileMiddleNameTitle = $(byText("Фамилия:")),
            profileLastNameTitle = $(byText("Отчество:")),
            rootElement = $("#root"),

    profileBirthdayTitle = $(byText("Дата рождения:")),
    profilePhoneTitle = $(byText("Телефон:")),

    submitButton = $("[type=submit]"),
            successPassTitle = $(byText("Вы успешно восстановили пароль")),

    firstNameInput = $("[name=firstName]"),
            middleNameInput = $("[name=middleName]"),
            lastNameInput = $("[name=lastName]"),
            birthDayInput = $("[name=birthDay]"),

    authRegButton = $(byText("Войти в аккаунт")),

    confirmButton = $(byText("Подтвердить"));

    public void openPage() {
        open("/");
    }

    public void clickAuthButton() {
        authButton.click();
    }
    public void clickProfileLink() {
        profileLink.click();
    }
    public void clickEditButton() {
        editButton.click();
    }

    public void clickAuthRegButton() {
        authRegButton.click();
    }

    public void clickChangePassButton() {
        changePassButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void typePhone(String value) {
        phoneInput.setValue(value);
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }

    public void typeSmsCode(String value) {
        smsCodeInput.setValue(value);
    }

    public void typePassword(String value) {
        passwordInput.setValue(value);
    }

    public void typeConfirmPassword(String value) {
        confirmPasswordInput.setValue(value);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
    public void checkSuccessPassTitle(String value) {
        successPassTitle.shouldHave(text(value));
    }
    public void checkProfileTitle(String value) {
        profileTitle.shouldHave(text(value));
    }




    public void clickProfileButton() {
        profileButton.click();
    }
    public void clickExitButton() {
        exitButton.click();
    }

    public void checkFirstName(String value) {
        rootElement.shouldHave(text(value));
    }

    public void checkLastName(String value) {
        rootElement.shouldHave(text(value));
    }

    public void checkMiddleName(String value) {
        rootElement.shouldHave(text(value));
    }

    public void checkBirthday(String value) {
        rootElement.shouldHave(text(value));
    }

    public void checkPhone(String value) {
        rootElement.shouldHave(text(value));
    }
    public void checkProfileNameTitle(String value) {
        profileNameTitle.shouldHave(text(value));
    }

    public void checkProfileMiddleNameTitle(String value) {
        profileMiddleNameTitle.shouldHave(text(value));
    }

    public void checkProfileLastNameTitle(String value) {
        profileLastNameTitle.shouldHave(text(value));
    }

    public void checkProfileBirthdayTitle(String value) {
        profileBirthdayTitle.shouldHave(text(value));
    }

    public void checkProfilePhoneTitle(String value) {
        profilePhoneTitle.shouldHave(text(value));
    }

    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void typeMiddleName(String value) {
        middleNameInput.setValue(value);
    }
    public void typeBirthDay(String value) {
        birthDayInput.setValue(value);
    }


}
