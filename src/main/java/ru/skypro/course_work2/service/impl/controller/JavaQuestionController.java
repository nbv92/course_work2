package ru.skypro.course_work2.service.impl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.course_work2.service.impl.model.Question;
import ru.skypro.course_work2.service.impl.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")

public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("add")
    public Question add (String question, String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("remove")
    public Question remove(String question, String answer) {
        return questionService.remove(new Question(question, answer));
    }

    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
