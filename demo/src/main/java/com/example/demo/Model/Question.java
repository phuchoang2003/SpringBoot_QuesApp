package com.example.demo.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_id;


    private String content;

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DetailOption getDetailOption() {
        return detailOption;
    }

    public void setDetailOption(DetailOption detailOption) {
        this.detailOption = detailOption;
    }



    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DetailOption detailOption;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @JsonIgnore
    private Subject subject;


    public Question() {
    }

    public Question(Long question_id, String content, DetailOption detailOption, Subject subject) {
        this.question_id = question_id;
        this.content = content;
        this.detailOption = detailOption;
        this.subject = subject;
    }
}
