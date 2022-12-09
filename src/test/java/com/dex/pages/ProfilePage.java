package com.dex.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class ProfilePage {
    SelenideElement

            passwordInput = $("[name=password]"),
            confirmPasswordInput = $("[name=confirmPassword]"),
            profileButton = $("[fill=none]"),
            profileLink = $(byText("Профиль")),
            exitLink = $(byText("Выход")),
            profileTitle = $(byText("Профиль пользователя")),
            editButton = $(byText("Редактировать профиль")),
            changePasswordButton = $(byText("Сменить пароль")),
            profileNameTitle = $(byText("Имя:")),
            profileMiddleNameTitle = $(byText("Фамилия:")),
            profileLastNameTitle = $(byText("Отчество:")),
            profileReturnButton = $(byText("Вернуться к профилю")),
            rootElement = $("#root"),
            profileBirthdayTitle = $(byText("Дата рождения:")),
            profilePhoneTitle = $(byText("Телефон:")),

            submitButton = $("[type=submit]"),

            successChangePassTitle = $(byText("Вы успешно сменили пароль")),

            firstNameInput = $("[name=firstName]"),
            middleNameInput = $("[name=middleName]"),
            lastNameInput = $("[name=lastName]"),
            birthDayInput = $("[name=birthDay]");


    public void clickProfileLink() {
        profileLink.click();
    }

    public void clickEditButton() {
        editButton.click();
    }

    public void clickProfileReturnButton() {
        profileReturnButton.click();
    }


    public void clickChangePasswordButton() {
        changePasswordButton.click();
    }

    public void clickExitLink() {
        exitLink.click();
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

    public void checkSuccessChangePassTitle(String value) {
        successChangePassTitle.shouldHave(text(value));
    }

    public void checkProfileTitle(String value) {
        profileTitle.shouldHave(text(value));
    }

    public void clickProfileButton() {
        profileButton.click();
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

    public void checkInputError(String value) {
        rootElement.shouldHave(text(value));
    }


    public void clearFirstNameInput() {
        firstNameInput.clear();
    }

    public void clearMiddleNameInput() {
        middleNameInput.clear();
    }

    public void clearLastNameInput() {
        lastNameInput.clear();
    }

    public void clearBirthDayInput() {
        birthDayInput.clear();
    }
}
