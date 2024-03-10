package com.example.demo.helper;

import com.example.demo.DTO.QuestionDetailAnswerDTO;
import com.example.demo.Model.Question;
import com.example.demo.Model.Answer;
import com.example.demo.Model.DetailOption;
import com.example.demo.Model.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class QuestionMapper {
    public Question toQuestion(QuestionDetailAnswerDTO dto){
        Question question = new Question();
        question.setContent(dto.getContent());

        DetailOption detail = new DetailOption();
        detail.setOption1(dto.getOption1());
        detail.setOption2(dto.getOption2());
        detail.setOption3(dto.getOption3());
        detail.setOption4(dto.getOption4());

        Answer answer = new Answer();
        answer.setCorrectAnswer(dto.getCorrectAnswer());

        detail.setAnswer(answer);
        question.setDetailOption(detail);

        return question;

    }
}





