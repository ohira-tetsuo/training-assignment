package bamv.training.microposts.dao;

import bamv.training.microposts.entity.MSequence;
import org.springframework.stereotype.Repository;

@Repository
public interface MSequenceDao {
    MSequence findSequence(String idName);

    int incrementSequenceCurrentNumber(MSequence mSequence);
}