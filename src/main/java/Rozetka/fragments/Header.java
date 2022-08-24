package Rozetka.fragments;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Header {

    private static final By SEARCH_FIELD = By.cssSelector("[name='search']");

    public Header waitUntilSearchFieldDisplayed() {
        $(SEARCH_FIELD).shouldBe(visible);
        return this;
    }
    public Header setSearchText(String text) {
        $(SEARCH_FIELD).setValue(text);
        return this;
    }

    public Header pressEnter() {
        $(SEARCH_FIELD).pressEnter();
        return this;
    }

    private static final By ACCOUNT_BUTTON = By.cssSelector("[class='header__button ng-star-inserted']");

    public Header waitUntilAccountButtonDisplayed() {
        $(ACCOUNT_BUTTON).shouldBe(visible);
        return this;
    }

    public Header clickAccountButton() {
        $(ACCOUNT_BUTTON).click();
        return this;
    }
}
