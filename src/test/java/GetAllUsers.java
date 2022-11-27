import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetAllUsers extends TestBase {
    private String users = "/users";

    @Test
    public void shouldGetAllUsers() {
        when()
                .get(baseUrl + users).
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetFirstUser() {
        when()
                .get(baseUrl + users + "/1").
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetFirstUserAndValidateJson() {
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

    @Test
    public void shouldGetFirstUserWithPathVariable(){
        given()
                .pathParam("userId", "1").
                when()
                .get(baseUrl + users + "/{userId}").
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetUserFromGwenborough(){
        Response response =
                given()
                        .queryParam("address.city", "Gwenborough").
                when()
                        .get(baseUrl + users).
                then()
                        .statusCode(200)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get("[0].id").toString(), "1");
    }
}
