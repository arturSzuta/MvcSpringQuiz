package pl.sda.pol137.mvcspringquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.pol137.mvcspringquiz.model.Quiz;
import pl.sda.pol137.mvcspringquiz.repository.QuizRepositoryInMemory;

import java.util.List;
import java.util.Optional;

@Service
public class AdminQuizServiceInMemory implements AdminQuizService{
    private final QuizRepositoryInMemory repository;
    @Autowired
    public AdminQuizServiceInMemory(QuizRepositoryInMemory repository) {
        this.repository = repository;
    }

    @Override
    public void saveQuiz(Quiz quiz) {
        repository.save(quiz);
    }

    @Override
    public List<Quiz> findAllQuizzes() {
        return repository.findAll();
    }

    @Override
    public Optional<Quiz> findQuizById(long id) {
        return repository.findById(id);
    }

    @Override
    public void updateQuiz(Quiz quiz) {
        repository.update(quiz);
    }

    @Override
    public void deleteQuizById(long id) {
        repository.deleteById(id);
    }
}
