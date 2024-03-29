package pl.sda.pol137.mvcspringquiz.repository;

import org.springframework.stereotype.Component;
import pl.sda.pol137.mvcspringquiz.model.Quiz;

import java.util.*;
@Component
public class QuizRepositoryInMemory {
    public QuizRepositoryInMemory() {
        this.map = new HashMap<>();
    }

    final private Map<Long, Quiz> map;
    private int index = 0;

    public List<Quiz> findAll(){
        return new ArrayList<>(map.values());
    }
    public Optional<Quiz> findById(long id){
        return Optional.ofNullable(map.get(id));
    }
    public void save(Quiz quiz){
        quiz.setId(++index);
        map.put(quiz.getId(), quiz);
    }
    public void deleteById(long id){
        map.remove(id);
    }
    public void update(Quiz quiz){
        map.replace(quiz.getId(), quiz);
    }
}
