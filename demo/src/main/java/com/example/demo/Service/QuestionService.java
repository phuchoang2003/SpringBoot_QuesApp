package com.example.demo.Service;

import com.example.demo.Model.Answer;
import com.example.demo.Model.DetailOption;
import com.example.demo.Model.Question;

import com.example.demo.Model.Subject;
import com.example.demo.Repository.AnswerRepository;
import com.example.demo.Repository.DetailOptionRepository;
import com.example.demo.Repository.QuestionRepository;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private DetailOptionRepository detailOptionRepository;


    public List<Question> findAllQuestionsBySubject(Subject subject){
        return questionRepository.findAllBySubject(subject);
    }


    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public Question addQuestion(Question question) {
        Question savedQuestion = questionRepository.save(question);



        DetailOption detailOption = question.getDetailOption();
        detailOption.setQuestion(savedQuestion);
        DetailOption savedDetailOption = detailOptionRepository.save(detailOption);

        Answer answer = question.getDetailOption().getAnswer();
        answer.setDetail(detailOption);
        Answer saveAnswer = answerRepository.save(answer);

        savedQuestion.setDetailOption(savedDetailOption);

        savedDetailOption.setAnswer(saveAnswer);
        detailOptionRepository.save(savedDetailOption);

        return savedQuestion;

    }

//    public QuestionModel updateQuestion(QuestionModel newQuestion,Long id){
//        QuestionModel oldQuestion = questionRepository.findById(id).orElse(null);
//        if(oldQuestion==null){
//            return null;
//        }
//        oldQuestion.
//        return questionRepository.save(newQuestion);
//
//    }
//}
}
