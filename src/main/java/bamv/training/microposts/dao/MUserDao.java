package bamv.training.microposts.dao;

import bamv.training.microposts.entity.MUser;
import org.springframework.stereotype.Repository;

@Repository
public interface MUserDao {
    MUser findUser(String userId);

    int addNewUser(String userId, String name, String password);
}
