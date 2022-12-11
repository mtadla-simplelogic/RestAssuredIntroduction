package post;

import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.*;

public class GetAllPosts extends TestBase {

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

        assertEquals(jsonPath.get("title"), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }

    @Test
    public void shouldGetFirstPostWithPathVariable(){
        given()
                .pathParam("postId", "1").
                when()
                .get(baseUrl + posts + "/{postId}").
                then()
                .statusCode(200);
    }
    @Test
    public void shouldGetPostsWithForUserWithId4(){
        Response response =
                given()
                        .queryParam("userId", "4")
                        .queryParam("title", "provident vel ut sit ratione est").
                when()
                        .get(baseUrl + posts).
                then()
                        .statusCode(200)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get("[0].id").toString(), "37");
    }
}
