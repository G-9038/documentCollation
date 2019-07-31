package club.laomile.service;

import club.laomile.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionDeleteService {
    @Autowired
    QuestionDao questionDao;

    public int questionDelete(Integer question_id){
        Integer success = questionDao.deleteqQuestion(question_id);
        return success;
    }
}
