package bamv.training.microposts.entity;

import java.time.LocalDateTime;

public class TMicropost {
    private String micropostId;

    private String content;

    private String userId;

    private LocalDateTime postedDatetime;

    public String getMicropostId() {
        return micropostId;
    }

    public void setMicropostId(String micropostId) {
        this.micropostId = micropostId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getPostedDatetime() {
        return postedDatetime;
    }

    public void setPostedDatetime(LocalDateTime postedDatetime) {
        this.postedDatetime = postedDatetime;
    }
}
