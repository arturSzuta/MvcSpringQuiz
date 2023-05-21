package pl.sda.pol137.mvcspringquiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name, @RequestParam Integer age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "welcome";
    }
}
