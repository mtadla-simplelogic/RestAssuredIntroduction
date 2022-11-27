import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetAllPosts {

    @Test
    public void shouldGetAllPosts() {
        when()
                .get("https://jsonplaceholder.typicode.com/posts").
                then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void shouldGetFirstPost() {
        when()
                .get("https://jsonplaceholder.typicode.com/posts/1").
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
                        .get("https://jsonplaceholder.typicode.com/posts/1").
                then()
                        .statusCode(200)
                        .log()
                        .all()
                        .extract()
                        .response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("title"), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }
}
