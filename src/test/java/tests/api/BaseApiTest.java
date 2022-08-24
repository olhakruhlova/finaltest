package tests.api;

import Rozetka.fragments.Header;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseApiTest {

    public static final String BASE_URL = "https://itunes.apple.com";
    public RequestSpecification requestSpecification;

    protected static final ObjectMapper MAPPER = new ObjectMapper();

    @BeforeClass
    public void setUp() {
     requestSpecification = new RequestSpecBuilder()
                .addHeader("Content-Type","application/jcon")
                .setBaseUri(BASE_URL)
                .build();

    }
}


