package configreader;

import org.aeonbits.owner.Config;
import static org.aeonbits.owner.Config.Sources;

@Sources("classpath:framework-config.properties")
public interface FrameworkProperties extends Config {

    @Key("driver.remote")
    boolean isRemote();

    @Key("driver.baseUrl")
    String baseUrl();

    @Key("driver.browserName")
    String browserName();

    @Key("driver.browserVersion")
    String browserVersion();

    @Key("api.baseUrl")
    String apiBaseUrl();
}
