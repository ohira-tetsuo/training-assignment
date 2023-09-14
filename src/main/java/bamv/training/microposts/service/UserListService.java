package bamv.training.microposts.service;

import bamv.training.microposts.dto.UserDto;

import java.util.List;

public interface UserListService {
    //アクセス修飾子をすべて削除
    List<UserDto> findAll();

    int follow(String userId, String followeeId);

    int unfollow(String userId, String followeeId);
}
