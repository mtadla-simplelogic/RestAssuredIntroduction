package base;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public String baseUrl = "https://jsonplaceholder.typicode.com";
    public String posts = "/posts";
    public String users = "/users";

    @BeforeMethod
    public void setup(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
