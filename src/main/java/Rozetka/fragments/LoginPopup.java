package Rozetka.fragments;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPopup {

    private static final By ROOT = By.xpath("//h3[text()='Вхід']/../..");

    private static final By EMAIL_FIELD = By.cssSelector("#auth_email");

    private static final By PASSWORD_FIELD = By.cssSelector("[id = 'auth_pass']");

    private static final By ENTER_BUTTON = By.cssSelector("[class = 'button button--large button--green auth-modal__submit ng-star-inserted']");

    private SelenideElement getRootElement() {
        return $(ROOT);
    }

    public SelenideElement getEmailField() {
        return getRootElement().find(EMAIL_FIELD);
    }

    public SelenideElement getPasswordField() {
        return getRootElement().find(PASSWORD_FIELD);
    }

    public SelenideElement getEnterButton() {
        return getRootElement().find(ENTER_BUTTON);
    }
}
