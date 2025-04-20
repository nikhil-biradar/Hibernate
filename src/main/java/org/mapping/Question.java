package org.mapping;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;

    @OneToOne
    @JoinColumn(name = "a_id")
    private Answer answer;

    public Question() {
        super();
    }

    public Question(Answer answer, String question, int questionId) {
        this.answer = answer;
        this.question = question;
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}