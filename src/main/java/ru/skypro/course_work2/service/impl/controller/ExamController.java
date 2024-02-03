package ru.skypro.course_work2.service.impl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.course_work2.service.impl.model.Question;
import ru.skypro.course_work2.service.impl.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("get/{amount}")

    public Collection<Question> getQuestions (@PathVariable(value = "amount") int amount) {
        return examinerService.getQuestions(amount);
    }

}
