package tests.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import iTunesSearchApiDto.SearchResultDto;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class iTunesSearchApiTest extends BaseApiTest {


    @Test(description = "Search without required parameters should return status code: 200 with empty values")
    public void searchWithoutRequiredParameters() throws JsonProcessingException {
        JsonPath jsonPath = given()
                .spec(requestSpecification)
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        SearchResultDto searchResultDto = MAPPER.readValue(jsonPath.prettyPrint(), SearchResultDto.class);
        Assert.assertEquals(searchResultDto.getResults().size(), 0);
        Assert.assertEquals(searchResultDto.getResultCount(), 0);
    }

    @Test(description = "Search with required parameters should return status code: 200 where result count equal contents of objects")
    public void searchWithRequiredParameters() throws JsonProcessingException {
        JsonPath jsonPath = given()
                .spec(requestSpecification)
                .params(Map.of("term", "Nirvana",
                        "country", "US"))
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        SearchResultDto searchResultDto = MAPPER.readValue(jsonPath.prettyPrint(), SearchResultDto.class);
        Assert.assertTrue(searchResultDto.getResultCount() > 1);
        Assert.assertEquals(searchResultDto.getResultCount(), searchResultDto.getResults().size());
    }

    @Test(description = "Search with only required parameter term and valid value should return status code: 200 where result country equal USA")
    public void searchWithOnlyTermParam() throws JsonProcessingException {
        JsonPath jsonPath = given()
                .spec(requestSpecification)
                .params(Map.of("term", "Nirvana"))
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        SearchResultDto searchResultDto = MAPPER.readValue(jsonPath.prettyPrint(), SearchResultDto.class);
        Assert.assertTrue(searchResultDto.getResultCount() > 1);
        Assert.assertTrue(searchResultDto.getResults().stream().allMatch(result -> result.getCountry().equals("USA")));
    }

    @Test(description = "Search with required parameters and media should return status code: 200 and objects where wrapperType has appropriate value")
    public void searchWithRequiredParametersAndMediaWithValidValue() throws JsonProcessingException {
        JsonPath jsonPath = given()
                .spec(requestSpecification)
                .params(Map.of("term", "Nirvana",
                        "country", "US",
                        "media", "audiobook"))
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        SearchResultDto searchResultDto = MAPPER.readValue(jsonPath.prettyPrint(), SearchResultDto.class);
        Assert.assertTrue(searchResultDto.getResults().stream().allMatch(result -> result.getMedia().equals("audiobook")));
    }

    @Test(description = "Search with required parameters and limit = 150 should return status code: 200 where result count equal contents of objects")
    public void searchWithRequiredParametersAndLimitWithValidValue() throws JsonProcessingException {
        JsonPath jsonPath = given()
                .spec(requestSpecification)
                .params(Map.of("term", "Nirvana",
                        "country", "US",
                        "limit", 150))
                .get("/search")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        SearchResultDto searchResultDto = MAPPER.readValue(jsonPath.prettyPrint(), SearchResultDto.class);
        Assert.assertEquals(searchResultDto.getResultCount(), 150);
        Assert.assertEquals(searchResultDto.getResultCount(), searchResultDto.getResults().size());
    }
}

