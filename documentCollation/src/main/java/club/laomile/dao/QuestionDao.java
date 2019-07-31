package club.laomile.dao;

import club.laomile.bean.QuestionBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionDao {
    public abstract Integer insertIntoQuestion(QuestionBean qb);
    public abstract List<QuestionBean> findquestionList(@Param("question") String question,@Param("file_user_id") Integer file_user_id);
    public abstract  Integer deleteqQuestion(Integer question_id);
}
