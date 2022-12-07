package com.dex.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class NewsPage {
    SelenideElement
            newsLink = $(byText("новости")),
            moreButton = $(byText("Показать ещё")),
            hideButton = $(byText("Скрыть все новости")),
            newsTitle = $("h1"),
            newsItemTitle = $("h2");

    ElementsCollection
            newItem = $$("h2");

    public void clickNewsLink() {
        newsLink.click();
    }

    public void clickMoreButton() {
        moreButton.click();
    }

    public void clickHideButton() {
        hideButton.click();
    }

    public void clickNewsItemTitle() {
        newsItemTitle.click();
    }

    public void checkNewsItemTitle(String value) {
        newsItemTitle.shouldHave(text(value));
    }

    public void checkNewsTitle(String value) {
        newsTitle.shouldHave(text(value));
    }

    // Проверяем количество карточек
    public void checkNewItem() {
        newItem.shouldHave(sizeGreaterThan(2));
    }

    public void checkMoreNewsItem() {
        newItem.shouldHave(sizeGreaterThan(5));
    }




}
