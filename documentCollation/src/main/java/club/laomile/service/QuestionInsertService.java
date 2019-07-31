package club.laomile.service;

import club.laomile.bean.QuestionBean;
import club.laomile.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionInsertService {
    @Autowired
    QuestionDao questionDao;

    public int questionInsert(QuestionBean questionBean){
        int success = questionDao.insertIntoQuestion(questionBean);
        return success;
    }
}
