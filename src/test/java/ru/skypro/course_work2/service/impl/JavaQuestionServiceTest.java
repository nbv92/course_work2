package ru.skypro.course_work2.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.skypro.course_work2.service.impl.model.Question;
import ru.skypro.course_work2.service.impl.service.impl.JavaQuestionServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class JavaQuestionServiceTest {
    private final JavaQuestionServiceImpl questionService = new JavaQuestionServiceImpl();

    @Test
    public void shouldCorrectlyAddQuestion() {
        //giv
        Question question = new Question("a", "b");
        //when
        Question addedQuestion = questionService.add(question);
        //then
        Assertions.assertEquals(question, addedQuestion);
    }

    //remove
    @Test
    public void shouldCorrectlyRemoveQuestion() {
        //give
        Question question = new Question("a", "b");
        questionService.add(question);
        //when
        Question questionRemove = questionService.remove(question);
        //then
        Assertions.assertEquals(question, questionRemove);
    }

    //getAll
    @Test
    public void shouldCorrectlyGetAll () {
        //give
        Question question1 = new Question("a","b");
        Question question2 = new Question("a2", "b2");
        //when
        Collection<Question> actualQuestions = questionService.getAll();
        //then
        assertIterableEquals(List.of(question1,question2), actualQuestions);
    }

    @Test
    public void shouldCorrectlyGetRandomQuestion() {
        //give
        Question question1 = new Question("a","b");
        Question question2 = new Question("a2", "b2");

        questionService.add(question1);
        questionService.add(question2);
        //when
        Question randomQuestion = questionService.getRandomQuestion();
        //then
        assertTrue(Set.of(question1, question2).contains(randomQuestion));
    }
}
