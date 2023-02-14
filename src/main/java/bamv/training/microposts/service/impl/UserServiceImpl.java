package bamv.training.microposts.service.impl;

import bamv.training.microposts.dao.MUserDao;
import bamv.training.microposts.entity.MUser;
import bamv.training.microposts.dto.UserDto;
import bamv.training.microposts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MUserDao mUserDao;
    @Override
    public UserDto selectUser(String userId) {
        MUser mUser = mUserDao.findUser(userId);
        UserDto userDto = new UserDto(
                mUser.getUserId(),
                mUser.getName()
        );
        return userDto;
    }

    @Override
    public int createNewUser(String userId, String name, String password) {
        int result = mUserDao.addNewUser(userId, name, password);
        return result;
    }
}
