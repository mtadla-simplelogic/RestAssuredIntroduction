import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser extends TestBase {
    private String users = "/users";

    String fullBody = "{\n" +
            "    \"name\": \"mat\",\n" +
            "    \"username\": \"mat1\",\n" +
            "    \"email\": \"Sincere@april.biz\",\n" +
            "    \"address\": {\n" +
            "        \"street\": \"Kulas Light\",\n" +
            "        \"suite\": \"Apt. 556\",\n" +
            "        \"city\": \"Gwenborough\",\n" +
            "        \"zipcode\": \"92998-3874\",\n" +
            "        \"geo\": {\n" +
            "            \"lat\": \"-37.3159\",\n" +
            "            \"lng\": \"81.1496\"\n" +
            "        }\n" +
            "    },\n" +
            "    \"phone\": \"1-770-736-8031 x56442\",\n" +
            "    \"website\": \"hildegard.org\",\n" +
            "    \"company\": {\n" +
            "        \"name\": \"Romaguera-Crona\",\n" +
            "        \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
            "        \"bs\": \"harness real-time e-markets\"\n" +
            "    }\n" +
            "}";


    @Test
    public void shouldUpdateUser() {
        Response response =
                given()
                        .pathParam("userId", "1")
                        .body(fullBody)
                        .contentType(ContentType.JSON).
                when()
                        .put(baseUrl + users + "/{userId}").
                then()
                        .statusCode(200)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("id").toString(), "1");
        Assert.assertEquals(jsonPath.get("name"), "mat");
        Assert.assertEquals(jsonPath.get("email"), "Sincere@april.biz");
    }

    // tutaj okrojone body usera
    String partOfBody = "{\n" +
            "    \"name\": \"mat\"\n" +
            "}";

    @Test
    public void shouldUpdateUserWithLimitedBody() {
        Response response =
                given()
                        .pathParam("userId", "1")
                        .body(partOfBody)
                        .contentType(ContentType.JSON).
                when()
                        .put(baseUrl + users + "/{userId}").
                then()
                        .statusCode(200)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("id").toString(), "1");
        Assert.assertEquals(jsonPath.get("name"), "mat");
        Assert.assertNull(jsonPath.get("email"));
    }
}
