package bamv.training.microposts.service;

import bamv.training.microposts.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService{
    UserDto selectUser(String userId);
    UserDetails selectUserForLogin(String userId);
}
