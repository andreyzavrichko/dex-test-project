package com.dex.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ChangePassPage {
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

    submitButton = $("[type=submit]"),
            successPassTitle = $(byText("Вы успешно восстановили пароль")),


    authRegButton = $(byText("Войти в аккаунт")),

    confirmButton = $(byText("Подтвердить"));

    public void openPage() {
        open("/");
    }

    public void clickAuthButton() {
        authButton.click();
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

    public void clickProfileButton() {
        profileButton.click();
    }
    public void clickExitButton() {
        exitButton.click();
    }

}
