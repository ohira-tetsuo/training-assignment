package bamv.training.microposts.service.impl;

import bamv.training.microposts.dao.MSequenceDao;
import bamv.training.microposts.dto.UserDto;
import bamv.training.microposts.entity.MSequence;
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
    @Autowired
    private MSequenceDao mSequenceDao;

    @Override
    public String issueSequence(String idName) {
        MSequence mSequence = mSequenceDao.findSequence(idName);
        mSequenceDao.incrementSequenceCurrentNumber(mSequence);
        String issuedId = String.format("MP%08d", mSequence.getCurrentNumber() + 1);
        return issuedId;
    }
}
