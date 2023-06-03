package pl.sda.pol137.mvcspringquiz.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.pol137.mvcspringquiz.model.QuizViewModel;
import pl.sda.pol137.mvcspringquiz.service.AdminQuizService;

@Controller
@RequestMapping("/admin/quiz")
public class QuizAdminController {
    private final AdminQuizService quizService;

    public QuizAdminController(AdminQuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/create")
    public String createForm() {
        return "/quiz/create";
    }
    @PostMapping("/create")
    public String createQuiz(@Valid QuizViewModel quiz) {
        System.out.println(quiz.getOptions());
        System.out.println(quiz.getCorrectOption());
        return "/quiz/index";
    }
}
