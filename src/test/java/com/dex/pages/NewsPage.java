package com.dex.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewsPage {
    SelenideElement
            newsLink = $(byText("новости")),
            newsTitle = $("h1");

    ElementsCollection
            newItem2Title = $$("h2");

    public void clickNewsLink() {
        newsLink.click();
    }


    public void checkNewsTitle(String value) {
        newsTitle.shouldHave(text(value));
    }

    // Проверяем количество карточек
    public void checkNewItemTitle() {
        newItem2Title.shouldHave(sizeGreaterThan(2));
    }




}
