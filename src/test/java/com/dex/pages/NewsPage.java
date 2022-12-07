package com.dex.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewsPage {
    SelenideElement
            newsLink = $(byText("новости")),
            newsTitle = $("h1"),
            newItemTitle = $("h2");

    ElementsCollection
            newItem2Title = $$("h2");

    public void clickNewsLink() {
        newsLink.click();
    }


    public void checkNewsTitle(String value) {
        newsTitle.shouldHave(text(value));
    }

    public void checkNewItemTitle() {
        newItem2Title.shouldHave(sizeGreaterThan(2));
    }




}
