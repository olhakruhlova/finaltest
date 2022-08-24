package Rozetka.pages;

import Rozetka.fragments.Header;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    private static final By PRODUCT_TITLE = By.cssSelector("[class='product__title']");

    private static final By BUY_BUTTON = By.cssSelector("[class ='buy-button__label ng-star-inserted'");

    public ProductPage waitUntilProductTitleDisplayed() {
        $(PRODUCT_TITLE).shouldBe(visible);
        return this;
    }

        public ProductPage checkProductTitle(String title) {
            $(PRODUCT_TITLE).shouldHave(text(title));
            return this;
    }

    public ProductPage waiteUntilBuyButtonDisplayed() {
        $(BUY_BUTTON).shouldBe(visible);
        return this;
    }


    public ProductPage pressBuyButton() {
        $(BUY_BUTTON).click();
        return this;
    }
}


