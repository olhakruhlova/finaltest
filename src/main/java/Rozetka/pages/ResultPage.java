package Rozetka.pages;

import Rozetka.fragments.Header;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultPage {

    private static final By RESULT_TITLE = By.cssSelector("[class ='catalog-heading ng-star-inserted']");

    public ResultPage waitUntilResultTitleDisplayed() {
        $(RESULT_TITLE).shouldBe(visible);
        return this;
    }

    public ResultPage checkResultTitle(String title) {
        $(RESULT_TITLE).shouldHave(text(title));
        return this;
    }

    public static final By PRODUCTS_LIST = By.cssSelector("[class='goods-tile__inner'");

    public ResultPage checkListMoreThanOneElement() {
        $$(PRODUCTS_LIST).shouldHave(CollectionCondition.sizeGreaterThan(1));
        return this;
    }

    public ResultPage selectProduct() {
        $$(PRODUCTS_LIST).get(1).click();
        return this;
    }
}