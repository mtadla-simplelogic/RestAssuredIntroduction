package post.advanced;

import base.TestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
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
        Post post = new Post(4,"some title", "some text");

        given()
                .body(post)
                .contentType(ContentType.JSON).
        when()
                .post(baseUrl + posts).
        then()
                .statusCode(201);
    }

    @Test
    public void shouldUpdatePatchWithLimitedBody(){
        Response response =
                given()
                        .pathParam("postId", "3")
                        .body(partOfBody)
                        .contentType(ContentType.JSON).
                        when()
                        .patch(baseUrl + posts + "/{postId}").
                        then()
                        .statusCode(200)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("id").toString(), "3");
        Assert.assertEquals(jsonPath.get("userId").toString(), "1");
        Assert.assertEquals(jsonPath.get("title"), "ea molestias quasi exercitationem repellat qui ipsa sit aut");
        Assert.assertEquals(jsonPath.get("body"), "some new body");
    }

}
