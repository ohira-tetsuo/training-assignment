package bamv.training.microposts.service.impl;

import bamv.training.microposts.dto.UserDto;
import bamv.training.microposts.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class SequenceServiceImpl implements SequenceService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String issueSequence(String idName) {
        /* SELECT */
        String selectQuery = "SELECT * FROM m_sequence WHERE id_name = ?";
        Map<String, Object> result = jdbcTemplate.queryForMap(selectQuery, idName);
        String prefix = result.get("prefix").toString();
        int currentNumber = ((Integer) result.get("current_number"));

        /* UPDATE */
        String updateQuery = "UPDATE m_sequence SET current_number = ? WHERE id_name = ?";
        jdbcTemplate.update(updateQuery, currentNumber + 1, idName);

        /* 新しいIDを生成 */
        String issuedId = String.format("MP%08d", currentNumber + 1);
        return issuedId;
    }
}
