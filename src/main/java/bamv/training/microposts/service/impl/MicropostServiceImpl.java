package bamv.training.microposts.service.impl;

import bamv.training.microposts.dto.MicropostDto;
import bamv.training.microposts.service.MicropostService;
import bamv.training.microposts.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MicropostServiceImpl implements MicropostService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    SequenceService sequenceService;

    @Override
    public int selectMicropostNumber(String userId) {
        RowMapper<MicropostDto> rowMapper = new BeanPropertyRowMapper<>(MicropostDto.class);
        String query = "SELECT COUNT(*) as count FROM t_micropost WHERE user_id = ?";
        int cnt = jdbcTemplate.queryForObject(query, Integer.class, userId);
        return cnt;
    }
    @Override
    public List<MicropostDto> selectFollowMicropost(String userId, int page) {
        RowMapper<MicropostDto> rowMapper = new BeanPropertyRowMapper<>(MicropostDto.class);
        int offset = 2 * (page - 1);

        String query = """
            SELECT
                mu.name as name,
                tm.content as content,
                tm.posted_datetime as postedDatetime
            FROM
                t_follow tf
            INNER JOIN
                t_micropost tm
            ON
                tf.followed_user_id = tm.user_id or tm.user_id = ?
            INNER JOIN
                m_user mu
            ON
                tm.user_id = mu.user_id
            ORDER BY
                tm.posted_datetime desc, tm.micropost_id desc
            limit ?, 2
        """;
        List<MicropostDto> tMicropostRecords = jdbcTemplate.query(query, rowMapper, userId, offset);
        return tMicropostRecords;
    }
    @Override
    @Transactional
    public void insertTestMicroposts() {
        for (int index = 0; index < 100; index++) {
            String query = """
                    INSERT INTO t_micropost
                    SELECT
                        ?
                        , ?
                        , ?
                        , ?
                    WHERE
                        NOT EXISTS (
                            SELECT 1 FROM t_micropost WHERE micropost_id=?
                        );
                        """;
            jdbcTemplate.update(query,
                    String.format("MP%08d", index),
                    "micro post" + String.valueOf(index),
                    "US00000002",
                    LocalDateTime.now(),
                    String.format("MP%08d", index));
        }
    }
    @Override
    @Transactional
    public void insertNewMicropost(String userId, String content) {
        String newMicropostId = sequenceService.issueSequence("micropost_id");
        String query = "INSERT INTO t_micropost values (?, ?, ?, ?)";
        jdbcTemplate.update(query,
                newMicropostId,
                content,
                userId,
                LocalDateTime.now());
    }
}
