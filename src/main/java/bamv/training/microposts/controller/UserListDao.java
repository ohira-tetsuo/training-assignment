package bamv.training.microposts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import  java.util.List;
import java.util.Map;

@Service
public class UserListDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    UserListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MicropostsController.User> findAll() {
        String query = "SELECT * FROM m_user";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
        List<MicropostsController.User> userList = result.stream()
                .map((Map<String, Object> row) -> new MicropostsController.User(
                        row.get("user_id").toString(),
                        row.get("name").toString(),
                        row.get("password").toString()))
                .toList();
        return userList;
    }
}
