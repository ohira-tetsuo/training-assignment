package bamv.training.microposts.dao;

import bamv.training.microposts.entity.TMicropost;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TMicropostDao {
    int countMicropostNumber(String userId);
    List<TMicropost> searchFollowingMicropost(String userId, int page);
    List<TMicropost> searchUserMicropost(String userId, int page);
    int addNewMicropost(String userId, String content);
}
