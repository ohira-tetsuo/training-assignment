package bamv.training.microposts.service;

import bamv.training.microposts.dto.MicropostDto;

import java.util.List;

public interface MicropostService {

    int countMicropostNumber(String userId);

    List<MicropostDto> searchFollowMicropost(String userId, int page);

    List<MicropostDto> searchUserMicropost(String userId, int page);

    int addNewMicropost(String userId, String content);
}
