package club.laomile.service;

import club.laomile.bean.QuestionBean;
import club.laomile.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionSelectService {
    @Autowired
    QuestionDao questionDao;

    public List<QuestionBean> questionSelect(String question,Integer file_user_id){
        List<QuestionBean> list = questionDao.findquestionList(question,file_user_id);
        return list;
    }
}
