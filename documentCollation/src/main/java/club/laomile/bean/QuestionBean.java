package club.laomile.bean;

public class QuestionBean {
    private Integer question_id;
    private Integer question_file_id;
    private String question;
    private String answer;

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Integer getQuestion_file_id() {
        return question_file_id;
    }

    public void setQuestion_file_id(Integer question_file_id) {
        this.question_file_id = question_file_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionBean(Integer question_id, Integer question_file_id, String question, String answer) {
        this.question_id = question_id;
        this.question_file_id = question_file_id;
        this.question = question;
        this.answer = answer;
    }

    public QuestionBean() {
    }

    public QuestionBean(Integer question_file_id, String question, String answer) {
        this.question_file_id = question_file_id;
        this.question = question;
        this.answer = answer;
    }
}
