package ru.skypro.course_work2.service.impl.service.impl;

import ru.skypro.course_work2.service.impl.exception.badRequestException;
import ru.skypro.course_work2.service.impl.model.Question;
import ru.skypro.course_work2.service.impl.service.ExaminerService;
import ru.skypro.course_work2.service.impl.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new badRequestException("Недостаточно вопросов в хранилище");
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
