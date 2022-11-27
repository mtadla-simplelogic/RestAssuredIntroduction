import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateNewUser extends TestBase {
    private String users = "/users";

    String body = "{\n" +
            "    \"name\": \"Mateusz Tadla\",\n" +
            "    \"username\": \"mtadla\",\n" +
            "    \"email\": \"mtadla@sii.pl\",\n" +
            "    \"address\": {\n" +
            "        \"street\": \"Usa\",\n" +
            "        \"suite\": \"Wall Street\",\n" +
            "        \"city\": \"N\",\n" +
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
    public void shouldCreateNewPost() {
        Response response =
                given()
                        .body(body)
                        .contentType(ContentType.JSON).
                        when()
                        .post(baseUrl + users).
                        then()
                        .statusCode(201)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get("username"), "mtadla");
    }
}
