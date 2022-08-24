package tests;

import org.testng.annotations.BeforeMethod;
import com.codeborne.selenide.Configuration;


public class BaseTest {

    @BeforeMethod
    public void parentSetUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 20000;
        Configuration.browserSize = "1920x1080";
    }
}
