package model;

public class QuestionItem {
    Integer idquestion;
    String username;
    String questionTitle;
    String question;
    String answerTitle;
    String answer;

    public Integer getIdquestion() {
        return idquestion;
    }

    public String getUsername() {
        return username;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getAnswer() {
        return answer;
    }

    public String getAnswerTitle() {
        return answerTitle;
    }

    public QuestionItem(Integer idquestion, String username, String questionTitle, String question, String answerTitle,
            String answer) {
        this.idquestion = idquestion;
        this.username = username;
        this.questionTitle = questionTitle;
        this.question = question;
        this.answerTitle = answerTitle;
        this.answer = answer;
    }
}
