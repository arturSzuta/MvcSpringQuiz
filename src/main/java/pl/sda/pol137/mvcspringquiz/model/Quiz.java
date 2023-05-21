package pl.sda.pol137.mvcspringquiz.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class Quiz {
    private long id;
    private String title;
    private String question;
    private List<String> incorrectAnswers;
    private List<String> correctAnswers;

    public boolean isCorrect(List<String> answers) {
        HashSet<String> correctSet = new HashSet<>(correctAnswers);
        HashSet<String> answerSet = new HashSet<>(answers);
        return correctSet.equals(answerSet);
    }
}
