package pl.sda.pol137.mvcspringquiz.service;

import pl.sda.pol137.mvcspringquiz.model.Quiz;

import java.util.List;
import java.util.Optional;

public interface AdminQuizService {
    void saveQuiz(Quiz quiz);

    List<Quiz> findAllQuizzes();
    Optional<Quiz> findQuizById(long id);
    void updateQuiz(Quiz quiz);
    void deleteQuizById(long id);
}
