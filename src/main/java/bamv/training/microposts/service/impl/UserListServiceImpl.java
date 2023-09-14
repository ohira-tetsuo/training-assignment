package bamv.training.microposts.service.impl;

import bamv.training.microposts.dao.TUserListDao;
import bamv.training.microposts.dto.UserDto;
import bamv.training.microposts.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserListServiceImpl implements UserListService {

        @Autowired
        private TUserListDao tUserListDao;

        public List<UserDto> findAll() {
            return tUserListDao.findAllUser();
        }
        public int follow(String userId, String followeeId) {
            return tUserListDao.addNewFollow(userId, followeeId);
        }

        public int unfollow(String userId, String followeeId) {
            return tUserListDao.deleteExistFollow(userId, followeeId);
    }

}
