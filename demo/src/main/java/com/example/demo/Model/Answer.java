package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    public Long getAnswer_id() {
        return answer_id;
    }

    public DetailOption getDetail() {
        return detail;
    }

    public void setDetail(DetailOption detail) {
        this.detail = detail;
    }

    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;
    public enum CorrectAnswer{A,B,C,D}

    public CorrectAnswer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(CorrectAnswer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Enumerated(EnumType.STRING)
    private CorrectAnswer correctAnswer;


    public Answer() {
    }

    public Answer(Long answer_id, CorrectAnswer correctAnswer, DetailOption detail) {
        this.answer_id = answer_id;
        this.correctAnswer = correctAnswer;
        this.detail = detail;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="detail_answer_id")
    @JsonIgnore
    private DetailOption detail;
}
