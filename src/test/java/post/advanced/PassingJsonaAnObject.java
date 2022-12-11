package post.advanced;

import base.TestBase;
import io.restassured.http.ContentType;
import models.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PassingJsonaAnObject  extends TestBase {

    @Test
    public void shouldGetFirstPostAndValidateJson() {
        Post post =
                when()
                        .get(baseUrl + posts + "/1").
                then()
                        .statusCode(200)
                        .extract()
                        .response()
                        .as(Post.class);

        Assert.assertEquals(post.getTitle(), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        Assert.assertEquals(post.getId(), 1);
    }

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
