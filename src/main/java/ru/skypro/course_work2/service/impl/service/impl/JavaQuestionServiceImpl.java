package ru.skypro.course_work2.service.impl.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.skypro.course_work2.service.impl.model.Question;
import ru.skypro.course_work2.service.impl.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    private final Random random = new Random();

    @PostConstruct
    public void init() {
        add("Who is mr.X?", "mr.X");
        add("Do you like music?", "Yes" );
    }
    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question (question,answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {

        Random random = new Random(0);
        int randomIndex = random.nextInt(questions.size());
        return new ArrayList<Question>(questions).get(randomIndex);
    }
}
