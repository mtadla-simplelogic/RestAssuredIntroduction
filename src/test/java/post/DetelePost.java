package post;

import base.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DetelePost extends TestBase {
    private String posts = "/posts";

    @Test
    public void shouldDeletePost() {
        given()
                .pathParam("postId", "1").
        when()
                .delete(baseUrl + posts + "/{postId}").
        then()
                .statusCode(200);
    }
}
