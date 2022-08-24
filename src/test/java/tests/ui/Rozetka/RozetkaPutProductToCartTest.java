package tests.ui.Rozetka;

import Rozetka.fragments.Header;
import Rozetka.pages.ProductPage;
import Rozetka.pages.ResultPage;
import org.testng.annotations.Test;
import tests.ui.BaseUiTest;

public class RozetkaPutProductToCartTest extends BaseUiTest {

    private static final String SEARCH_PRODUCT = "Планшет Samsung Galaxy Tab A7";

    @Test
    public void putProductToCart() {
        Header header = new Header();
        header.waitUntilSearchFieldDisplayed()
                .setSearchText(SEARCH_PRODUCT)
                .pressEnter();

        ResultPage resultPage = new ResultPage();
        resultPage.waitUntilResultTitleDisplayed()
                .checkResultTitle(SEARCH_PRODUCT);

        resultPage.checkListMoreThanOneElement()
                .selectProduct();


        ProductPage productPage = new ProductPage();
        productPage.waitUntilProductTitleDisplayed()
                .checkProductTitle(SEARCH_PRODUCT)
                .waiteUntilBuyButtonDisplayed()
                .checkButtonIsEnables()
                .pressBuyButton();
    }
}
