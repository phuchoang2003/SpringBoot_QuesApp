package com.example.demo.Controller;

import com.example.demo.DTO.QuestionDetailAnswerDTO;
import com.example.demo.Model.Question;
import com.example.demo.Model.Subject;
import com.example.demo.Service.QuestionService;
import com.example.demo.Service.SubjectService;
import com.example.demo.helper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{name}/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private SubjectService subjectService;


    @GetMapping("/all-questions")
    public ResponseEntity<List<Question>> getAllQuestions(@PathVariable String name){
        Subject subject = subjectService.getSubjectByName(name);

        List<Question> questions = questionService.findAllQuestionsBySubject(subject);
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@PathVariable String name, @RequestBody QuestionDetailAnswerDTO questionDetailAnswerDTO) {
        // Chuyển đổi từ DTO sang Model
        Question question = questionMapper.toQuestion(questionDetailAnswerDTO);
        question.setSubject(subjectService.getSubjectByName(name));
        // Thực hiện lưu câu hỏi và chi tiết câu hỏi
        Question savedQuestion = questionService.addQuestion(question);

        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }




}
