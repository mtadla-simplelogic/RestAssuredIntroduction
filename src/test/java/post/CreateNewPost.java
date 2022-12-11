package post;

import base.TestBase;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateNewPost extends TestBase {

    String body = "{\n" +
            "    \"userId\": 123123123,\n" +
            "    \"title\": \"etasdasdum autem\",\n" +
            "    \"body\": \"delectu123n eum modi\"\n" +
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