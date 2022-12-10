import org.testng.annotations.Test;

public class PatchUser extends TestBase {
    private String users = "/users";

    // tutaj pełne body usera
    String fullBody = "";


    @Test
    public void shouldPatchUser() {
        // metoda Patch do /users/{id}
        // 3 asercje z użyciem JSONPath na otrzymanym response
    }

    // tutaj okrojone body usera
    String partOfBody = "";

    @Test
    public void shouldPatchUserWithLimitedBody() {
        // metoda Patch do /users/{id}
        // 3 asercje z użyciem JSONPath na otrzymanym response
    }
}
