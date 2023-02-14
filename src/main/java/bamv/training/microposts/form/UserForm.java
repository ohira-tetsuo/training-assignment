package bamv.training.microposts.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserForm {
    @NotNull
    @Size(min = 2, max = 10)
    private String userId;

    @NotNull
    @Size(min = 2, max = 32)
    private String userName;

    @NotNull
    @Size(min = 2, max = 32)
    private String password;

    public UserForm(String userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
