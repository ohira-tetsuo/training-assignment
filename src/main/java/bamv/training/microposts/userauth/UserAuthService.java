package bamv.training.microposts.userauth;

import bamv.training.microposts.dao.MUserDao;
import bamv.training.microposts.entity.MUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthService {
    @Autowired
    private MUserDao mUserDao;

    public UserDetails searchUserForLogin(String userId) {
        List<MUser> mUserList = mUserDao.searchUser(userId);
        if (mUserList.size() == 0) throw new UsernameNotFoundException("");
        return new UserAuthUserDetails(
                mUserList.get(0).getUserId(),
                mUserList.get(0).getPassword()
        );
    }
}
