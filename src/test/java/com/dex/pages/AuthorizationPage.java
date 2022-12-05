package com.dex.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {

    SelenideElement
            authButton = $(byText("Вход")),
            phoneInput = $("[name=phone]"),

            passwordInput = $("[name=password]"),
            submitButton = $("[type=submit]"),
            newsLink = $(byText("новости")),


            confirmButton = $(byText("Подтвердить"));


    public void clickAuthButton() {
        authButton.click();
    }

    public void openPage() {
        open("/");
    }

    public void typePhone(String value) {
        phoneInput.setValue(value);
    }

    public void typePassword(String value) {
        passwordInput.setValue(value);
    }
    public void checkNewsLink() {
        newsLink.shouldBe(visible);
    }

    public void clickSubmit() {
        submitButton.click();
    }



}
