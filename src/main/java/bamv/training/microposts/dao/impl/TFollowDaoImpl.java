package bamv.training.microposts.dao.impl;

import bamv.training.microposts.dao.TFollowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TFollowDaoImpl implements TFollowDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int countFollowingNumber(String userId) {
        String query = "SELECT COUNT(*) as count FROM t_follow WHERE following_user_id = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, userId);
    }

    @Override
    public int countFollowerNumber(String userId) {
        String query = "SELECT COUNT(*) as count FROM t_follow WHERE followed_user_id = ?";
        return jdbcTemplate.queryForObject(query, Integer.class, userId);
    }
}
