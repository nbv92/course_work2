package ru.skypro.course_work2.service.impl.service;

import ru.skypro.course_work2.service.impl.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions (int amount);

}
