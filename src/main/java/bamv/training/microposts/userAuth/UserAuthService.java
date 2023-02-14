package bamv.training.microposts.userAuth;

import bamv.training.microposts.dao.MUserDao;
import bamv.training.microposts.entity.MUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {
    @Autowired
    private MUserDao mUserDao;
    public UserDetails searchUserForLogin(String userId) {
        MUser mUser = mUserDao.findUser(userId);
        UserDetails userDetails = new UserAuthUserDetails(
                mUser.getUserId(),
                mUser.getPassword()
        );
        return userDetails;
    }
}
