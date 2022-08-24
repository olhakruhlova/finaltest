package tests.ui.Rozetka;

import Rozetka.fragments.Header;
import Rozetka.fragments.LoginPopup;
import org.testng.annotations.Test;
import tests.ui.BaseUiTest;

import static com.codeborne.selenide.Condition.visible;

public class RozetkaLoginFormFieldsTest extends BaseUiTest {

    @Test
    public void checkFieldsOnTheLoginForm() {

        Header header = new Header();
        header.waitUntilAccountButtonDisplayed()
                .clickAccountButton();

        LoginPopup loginPopup = new LoginPopup();
        loginPopup.getEmailField().shouldBe(visible);
        loginPopup.getPasswordField().shouldBe(visible);
        loginPopup.getEnterButton().shouldBe(visible).click();

    }
}