package ru.skypro.course_work2.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.course_work2.service.impl.exception.badRequestException;
import ru.skypro.course_work2.service.impl.model.Question;
import ru.skypro.course_work2.service.impl.service.ExaminerService;
import ru.skypro.course_work2.service.impl.service.impl.ExaminerServiceImpl;
import ru.skypro.course_work2.service.impl.service.impl.JavaQuestionServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionServiceImpl javaQuestionServiceImpl;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowIncAmountExceptionWhenThereIsNotEnoughQuestions() {
        //give
        int amount = 10;
        when(javaQuestionServiceImpl.getAll()).thenReturn(List.of());
        //when
        //then
        Assertions.assertThrows(badRequestException.class, () -> {
            examinerService.getQuestions(amount);
        });
    }

    @Test
    public void shouldCorrectlyGetQuestions() {
        //give
        int amount = 3;
        List<Question> questions = List.of(
                new Question("a","a"),
                new Question("b","b"),
                new Question("c","c"),
                new Question("f","f"),
                new Question("g","g")
        );
        when(javaQuestionServiceImpl.getAll()).thenReturn(questions);

        when(javaQuestionServiceImpl.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(1),
                questions.get(0),
                questions.get(1),
                questions.get(2)
        );
        //when
        Collection<Question> actualQuestions = examinerService.getQuestions(amount);
        //then
        Assertions.assertEquals(Set.of(questions.get(0), questions.get(1), questions.get(2)),
                actualQuestions);
        verify(javaQuestionServiceImpl, times (6)).getRandomQuestion();

    }

}
