package tests.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import configreader.FrameworkProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    static FrameworkProperties frameworkProperties =
            ConfigFactory.create(FrameworkProperties.class);

    public static final String BASE_URL = frameworkProperties.apiBaseUrl();
    public RequestSpecification requestSpecification;

    protected static final ObjectMapper MAPPER = new ObjectMapper();

    @BeforeClass
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/jcon")
                .setBaseUri(BASE_URL)
                .build();

    }
}


