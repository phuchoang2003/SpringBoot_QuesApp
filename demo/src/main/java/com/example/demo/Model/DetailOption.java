package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "detail_answer")
public class DetailOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detail_answer_id;

    private String option1;
    private String option2;
    private String option3;

    public DetailOption() {
    }

    public DetailOption(Long detail_answer_id, String option1, String option2, String option3, String option4, Answer answer, Question question) {
        this.detail_answer_id = detail_answer_id;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.question = question;
    }

    public Long getDetail_answer_id() {
        return detail_answer_id;
    }

    public void setDetail_answer_id(Long detail_answer_id) {
        this.detail_answer_id = detail_answer_id;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    private String option4;

    @OneToOne(mappedBy = "detail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Answer answer;



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;

}
