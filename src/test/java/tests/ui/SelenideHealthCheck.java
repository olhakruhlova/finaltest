package tests.ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class SelenideHealthCheck extends BaseUiTest{

    @Test
    public void SelenideTest() {
        Selenide.open("https://www.google.com");
    }

}
