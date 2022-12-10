import org.testng.annotations.Test;

public class UpdateUser extends TestBase {
    private String users = "/users";

    // tutaj pełne body usera
    String fullBody = "";


    @Test
    public void shouldUpdateUser() {
        // metoda Put do /users/{id}
        // 3 asercje z użyciem JSONPath  na otrzymanym response
    }

    // tutaj okrojone body usera
    String partOfBody = "";

    @Test
    public void shouldUpdateUserWithLimitedBody() {
        // metoda Put do /users/{id}
        // 3 asercje z użyciem JSONPath  na otrzymanym response
    }
}
