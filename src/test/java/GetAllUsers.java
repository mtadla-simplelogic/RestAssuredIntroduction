import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetAllUsers extends TestBase {
    private String users = "/users";

    @Test
    public void shouldGetAllPosts() {
        when()
                .get(baseUrl + users).
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetFirstPost() {
        when()
                .get(baseUrl + users + "/1").
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetFirstPostAndValidateJson() {
        Response response =
                when()
                        .get(baseUrl + users + "/1").
                then()
                        .statusCode(200)
                        .extract()
                        .response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("address.geo.lat"), "-37.3159");
    }
}
