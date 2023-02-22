package bamv.training.microposts.dto;

import java.time.LocalDateTime;

public class MicropostDto {
    private String name;

    private String content;

    private LocalDateTime postedDatetime;

    public MicropostDto(String name, String content, LocalDateTime postedDatetime) {
        this.name = name;
        this.content = content;
        this.postedDatetime = postedDatetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostedDatetime() {
        return postedDatetime;
    }

    public void setPostedDatetime(LocalDateTime postedDatetime) {
        this.postedDatetime = postedDatetime;
    }
}