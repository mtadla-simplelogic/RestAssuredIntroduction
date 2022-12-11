package post.advanced;

import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;

public class PassingJsonaAnObject  extends TestBase {

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

}
