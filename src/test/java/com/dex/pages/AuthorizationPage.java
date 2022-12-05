package com.dex.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {

    SelenideElement
            emailInput = $("#email"),
            passwordInput = $("#password"),
            submitButton = $("[type=submit]"),
            showPasswordButton = $(".ant-input-suffix"),
            forgotPasswordButton = $(byText("Забыли пароль?")),
            visibleProfile = $(".ant-menu"),
            visibleTitle = $(byText("Вход в аккаунт")),
            errorMessage = $(".ant-message-notice"),
            modalConfirmMessage = $(".ant-modal-confirm-body"),
            exitButton = $(byText("Выход")),
            cancelButton = $(byText("Отмена")),
            modalClick = $(".ant-modal-wrap"),
            confirmButton = $(byText("Подтвердить"));

    public void openPage() {
        open("/auth");
    }

    public void typeEmail(String value) {
        emailInput.setValue(value);
    }

    public void typePassword(String value) {
        passwordInput.setValue(value);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void clickShowPassword() {
        showPasswordButton.click();
    }

    public void clickForgotPassword() {
        forgotPasswordButton.click();
    }

    public void checkShowPassword(String value) {
        passwordInput.shouldHave(value(value));
    }

    public void checkVisible() {
        visibleProfile.shouldBe(visible);
    }

    public void checkVisibleTitle() {
        visibleTitle.shouldBe(visible);
    }

    public void checkErrorMessage(String error) {
        errorMessage.shouldHave(text(error));
    }

    public void clickExit() {
        exitButton.click();
    }

    public void clickConfirm() {
        confirmButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public void clickOnMouse() {
        modalClick.click();
    }

    public void checkModalConfirmMessage() {
        modalConfirmMessage.shouldBe(visible);
    }

    public void Authorization() {
        emailInput.setValue("test@gmail.com");
        passwordInput.setValue("005");
        submitButton.click();
    }

}
