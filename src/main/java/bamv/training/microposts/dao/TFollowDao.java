package bamv.training.microposts.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface TFollowDao {
    int countFollowingNumber(String userId);

    int countFollowerNumber(String userId);
}
