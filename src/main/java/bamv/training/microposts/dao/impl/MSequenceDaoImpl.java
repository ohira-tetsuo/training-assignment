package bamv.training.microposts.dao.impl;

import bamv.training.microposts.dao.MSequenceDao;
import bamv.training.microposts.entity.MSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MSequenceDaoImpl implements MSequenceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public MSequence findSequence(String idName) {
        RowMapper<MSequence> rowMapper = new BeanPropertyRowMapper<>(MSequence.class);
        String query = "SELECT * FROM m_sequence WHERE id_name = ?";
        return jdbcTemplate.queryForObject(query, rowMapper, idName);
    }

    @Override
    public int incrementSequenceCurrentNumber(MSequence mSequence) {
        String updateQuery = "UPDATE m_sequence SET current_number = ? WHERE id_name = ?";
        return jdbcTemplate.update(updateQuery, mSequence.getCurrentNumber() + 1, mSequence.getIdName());
    }
}
