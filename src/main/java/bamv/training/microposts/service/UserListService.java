package bamv.training.microposts.service;

import bamv.training.microposts.dto.UserDto;

import java.util.List;

public interface UserListService {
    List<UserDto> findAll();

    int follow(String userId, String followeeId);

    int unfollow(String userId, String followeeId);
}
