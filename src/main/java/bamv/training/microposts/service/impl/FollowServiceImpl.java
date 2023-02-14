package bamv.training.microposts.service.impl;

import bamv.training.microposts.dao.TFollowDao;
import bamv.training.microposts.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private TFollowDao tFollowDao;
    @Override
    public int selectFollowNumber(String userId) {
        int cnt = tFollowDao.countFollowingNumber(userId);
        return cnt;
    }
    @Override
    public int selectFollowerNumber(String userId) {
        int cnt = tFollowDao.countFollowerNumber(userId);
        return cnt;
    }
}