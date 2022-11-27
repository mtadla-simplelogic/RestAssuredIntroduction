import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetAllPosts extends TestBase {
    private String posts = "/posts";

    @Test
    public void shouldGetAllPosts() {
        when()
                .get(baseUrl + posts).
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetFirstPost() {
        when()
                .get(baseUrl + posts + "/1").
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetFirstPostAndValidateJson() {
        Response response =
                when()
                        .get(baseUrl + posts + "/1").
                        then()
                        .statusCode(200)
                        .extract()
                        .response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("title"), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }
}
