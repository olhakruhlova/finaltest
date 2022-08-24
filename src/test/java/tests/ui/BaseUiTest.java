package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import configreader.FrameworkProperties;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

public class BaseUiTest {

    @BeforeMethod
    public void baseUiSetup() throws MalformedURLException {
        Configuration.timeout = 20000;

        FrameworkProperties frameworkProperties =
                ConfigFactory.create(FrameworkProperties.class);

        if (frameworkProperties.isRemote()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", frameworkProperties.browserName());
            capabilities.setCapability("browserVersion", frameworkProperties.browserVersion());
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities
            );
            WebDriverRunner.setWebDriver(driver);
            Selenide.open(frameworkProperties.baseUrl());
        } else {
            Selenide.open(frameworkProperties.baseUrl());
        }
    }

    @AfterMethod
    public void closedDriver() {
        WebDriverRunner.closeWebDriver();
    }


}
