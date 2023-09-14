package bamv.training.microposts.controller;

import bamv.training.microposts.dto.UserDto;
import bamv.training.microposts.service.impl.SequenceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import  java.util.List;
import java.util.Map;

@Service
public class UserListDao {
    private final JdbcTemplate jdbcTemplate;
    private final SequenceServiceImpl sequenceService;

    @Autowired
    UserListDao(JdbcTemplate jdbcTemplate, SequenceServiceImpl sequenceService) {
        this.jdbcTemplate = jdbcTemplate;
        this.sequenceService = sequenceService;
    }

    public List<UserDto> findAll() {
        String query = "SELECT user_id AS userId, name FROM m_user";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
        List<UserDto> userList = result.stream()
                .map((Map<String, Object> row) -> new UserDto (
                        row.get("userId").toString(),
                        row.get("name").toString()))
                .toList();
        return userList;
    }

    //INSERTの実行前に同一userId, followeeIdでレコードがあれば何もせずにreturnする
    public int follow(String userId, String followeeId) {
        String checkDuplicateSql = "SELECT COUNT(*) FROM t_follow WHERE following_user_id = ? AND followed_user_id = ?";
        int count = jdbcTemplate.queryForObject(checkDuplicateSql, Integer.class, userId, followeeId);
        if (count != 0) //すでにフォローしている
            return 0;

        String newFollowId = sequenceService.issueSequence("follow_id");
        int number = jdbcTemplate.update("INSERT INTO t_follow (follow_id, following_user_id, followed_user_id) VALUES (?, ?, ?)", newFollowId, userId, followeeId);
        return number;
    }

    public int unfollow(String userId, String followeeId) {
        int number = jdbcTemplate.update("DELETE FROM t_follow WHERE following_user_id = ? AND followed_user_id = ?", userId, followeeId);
        return number;
    }

}
