package bamv.training.microposts.service;

import bamv.training.microposts.dto.MicropostDto;

import java.util.List;

public interface MicropostService {

    int selectMicropostNumber(String userId);

    List<MicropostDto> selectFollowMicropost(String userId, int page);
    void insertTestMicroposts();

    void insertNewMicropost(String userId, String content);
}
