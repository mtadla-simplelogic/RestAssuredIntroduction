import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetAllPosts {

    @Test
    public void shouldGetAllPosts() {
        when()
                .get("https://jsonplaceholder.typicode.com/posts").
        then()
                .statusCode(200);
    }
}
