package bamv.training.microposts.service.impl;

import bamv.training.microposts.dao.MSequenceDao;
import bamv.training.microposts.entity.MSequence;
import bamv.training.microposts.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SequenceServiceImpl implements SequenceService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MSequenceDao mSequenceDao;

    @Override
    @Transactional
    public String issueSequence(String idName) {
        MSequence mSequence = mSequenceDao.findSequence(idName);
        mSequenceDao.incrementSequenceCurrentNumber(mSequence);
        if (idName.equals("micropost_id"))
            return String.format("MP%08d", mSequence.getCurrentNumber() + 1);
        //SequenceSericveをつかいたいインスタンスが増えたらめんどくさくなる
        return String.format("FL%08d", mSequence.getCurrentNumber() + 1);
    }
}
