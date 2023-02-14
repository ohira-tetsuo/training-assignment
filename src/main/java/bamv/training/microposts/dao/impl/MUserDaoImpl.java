package bamv.training.microposts.dao.impl;

import bamv.training.microposts.dao.MUserDao;
import bamv.training.microposts.entity.MUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MUserDaoImpl implements MUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MUser findUser(String userId) {
        RowMapper<MUser> rowMapper = new BeanPropertyRowMapper<>(MUser.class);
        String query = "SELECT * FROM m_user WHERE user_id = ?";
        return jdbcTemplate.queryForObject(query, rowMapper, userId);
    }

    public int addNewUser(String userId, String name, String password) {
        String query = "insert into m_user (user_id, name, password) values (?, ?, ?)";
        return jdbcTemplate.update(query, userId, name, password);
    }
}
