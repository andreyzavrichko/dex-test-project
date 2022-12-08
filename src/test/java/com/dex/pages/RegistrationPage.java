package com.dex.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    SelenideElement
            authButton = $(byText("Вход")),
            regButton = $(byText("Регистрация")),
            phoneInput = $("[name=phone]"),

            continueButton = $(byText("Продолжить")),
            smsFormTitle = $(byText("подтвердите номер телефона")),
            profileTitle = $(byText("укажите ваши данные")),
            successTitle = $(byText("Вы успешно зарегистрировались")),
            authRegButton = $(byText("Войти в аккаунт")),
            smsCodeInput = $("[ type=text]"),
            firstNameInput = $("[name=firstName]"),
            middleNameInput = $("[name=middleName]"),
            lastNameInput = $("[name=lastName]"),
            birthDayInput = $("[name=birthDay]"),
            passwordInput = $("[name=password]"),
            confirmPasswordInput = $("[name=confirmPassword]"),
            confirmCheckbox = $("[for=checkBox]"),
            submitButton = $("[type=submit]"),
            newsLink = $(byText("новости")),
            confirmButton = $(byText("Подтвердить"));


    public void clickAuthButton() {
        authButton.click();
    }

    public void clickAuthRegButton() {
        authRegButton.click();
    }

    public void clickRegButton() {
        regButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void openPage() {
        open("/");
    }

    public void typePhone(String value) {
        phoneInput.setValue(value);
    }



    public void typeSmsCode(String value) {
        smsCodeInput.setValue(value);
    }


    public void checkNewsLink() {
        newsLink.shouldBe(visible);
    }

    public void checkSmsFormTitle(String value) {
        smsFormTitle.shouldHave(text(value));
    }

    public void checkProfileTitle(String value) {
        profileTitle.shouldHave(text(value));
    }


    public void clickSubmit() {
        submitButton.click();
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

    public void typePassword(String value) {
        passwordInput.setValue(value);
    }

    public void typeConfirmPassword(String value) {
        confirmPasswordInput.setValue(value);
    }

    public void typeConfirmCheckbox() {
        confirmCheckbox.click();
    }

    public void typeConfirmButton() {
        confirmButton.click();
    }

    public void checkSuccessTitle(String value) {
        successTitle.shouldHave(text(value));
    }


}
