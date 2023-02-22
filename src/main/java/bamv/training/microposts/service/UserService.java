package bamv.training.microposts.service;

import bamv.training.microposts.dto.UserDto;

public interface UserService {
    UserDto selectUser(String userId);

    int createNewUser(String userId, String name, String password);
}
