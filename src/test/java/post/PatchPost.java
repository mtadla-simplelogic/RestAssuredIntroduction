package post;

import base.TestBase;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchPost extends TestBase {
    String fullBody = "{\n" +
            "    \"userId\": 123123123,\n" +
            "    \"title\": \"new title\",\n" +
            "    \"body\": \"some new body\"\n" +
            "}";


    @Test
    public void shouldPatchPost(){
        Response response =
                given()
                        .pathParam("postId", "3")
                        .body(fullBody)
                        .contentType(ContentType.JSON).
                when()
                        .patch(baseUrl + posts + "/{postId}").
                then()
                        .statusCode(200)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("id").toString(), "3");
        Assert.assertEquals(jsonPath.get("userId").toString(), "123123123");
        Assert.assertEquals(jsonPath.get("title"), "new title");
        Assert.assertEquals(jsonPath.get("body"), "some new body");
    }

    String partOfBody = "{\n" +
            "    \"body\": \"some new body\"\n" +
            "}";

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
