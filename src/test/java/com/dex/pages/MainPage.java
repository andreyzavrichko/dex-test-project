package com.dex.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    SelenideElement
            header = $("header"),
            main = $("main"),
            headerLogo = $("[alt=image]"),
            mainLogo = $("[alt=MainPageLogo]");


    public void checkHeader() {
        header.shouldBe(visible);
    }

    public void checkMain() {
        main.shouldBe(visible);
    }

    public void checkHeaderLogo() {
        headerLogo.shouldBe(visible);
    }

    public void checkMainLogo() {
        mainLogo.shouldBe(visible);
    }


}



