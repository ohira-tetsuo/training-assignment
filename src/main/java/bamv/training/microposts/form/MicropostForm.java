package bamv.training.microposts.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MicropostForm {
    @NotNull
    @Size(min = 1, max = 200)
    private String content;

    public MicropostForm(String userId, String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
