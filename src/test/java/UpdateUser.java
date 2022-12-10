import org.testng.annotations.Test;

public class UpdateUser extends TestBase {
    private String users = "/users";

    // tutaj pełne body usera
    String fullBody = "";


    @Test
    public void shouldUpdateUser() {
        // 3 asercje z użyciem JSONPath
    }

    // tutaj okrojone body usera
    String partOfBody = "";

    @Test
    public void shouldUpdateUserWithLimitedBody() {
        // 3 asercje z użyciem JSONPath
    }
}
