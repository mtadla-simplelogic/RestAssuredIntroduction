import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateNewPost extends TestBase {
    private String posts = "/posts";

    String body = "{\n" +
            "    \"userId\": 1,\n" +
            "    \"title\": \"some title\",\n" +
            "    \"body\": \"lorem ipsum\"\n" +
            "}";

    @Test
    public void shouldCreateNewPost() {
        given()
                .body(body)
                .contentType(ContentType.JSON).
        when()
                .post(baseUrl + posts).
        then()
                .statusCode(201);
    }
}
