import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetAllUsers {

    @Test
    public void shouldGetAllPosts() {
        when()
                .get("https://jsonplaceholder.typicode.com/users").
                then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void shouldGetFirstPost() {
        when()
                .get("https://jsonplaceholder.typicode.com/users/1").
                then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void shouldGetFirstPostAndValidateJson() {
        Response response =
                given().
                        log().
                        all().
                when()
                        .get("https://jsonplaceholder.typicode.com/users/1").
                then()
                        .statusCode(200)
                        .log()
                        .all()
                        .extract()
                        .response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("address.geo.lat"), "-37.3159");
    }
}
