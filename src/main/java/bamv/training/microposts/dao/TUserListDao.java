package bamv.training.microposts.dao;

import bamv.training.microposts.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserListDao {

    //アクセス修飾子をすべて削除
    List<UserDto> findAllUser();

    int addNewFollow(String userId, String followeeId);

    int deleteExistFollow(String userId, String followeeId);
}
