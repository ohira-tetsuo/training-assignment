package bamv.training.microposts.service.impl;

import bamv.training.microposts.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private
    JdbcTemplate jdbcTemplate;
    @Override
    public int selectFollowNumber(String userId) {
        String query = "SELECT COUNT(*) as count FROM t_follow WHERE following_user_id = ?";
        int cnt = jdbcTemplate.queryForObject(query, Integer.class, userId);
        return cnt;
    }
    @Override
    public int selectFollowerNumber(String userId) {
        String query = "SELECT COUNT(*) as count FROM t_follow WHERE followed_user_id = ?";
        int cnt = jdbcTemplate.queryForObject(query, Integer.class, userId);
        return cnt;
    }
}