package pl.sda.pol137.mvcspringquiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.pol137.mvcspringquiz.dto.RequestCalculatorDto;
import pl.sda.pol137.mvcspringquiz.model.CalculatorData;

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

    @GetMapping("/calculator")
    public String calculator(
            @Validated
            RequestCalculatorDto dto,
            Model model
    ) {
        final CalculatorData calculatorData = CalculatorData
                .builder()
                .operator(dto.getOp())
                .a(dto.getA())
                .b(dto.getB())
                .build();

        model.addAttribute("calculatorData", calculatorData);
        return "calculator";
    }
    @GetMapping("/calculator-form")
    public String calculatorForm(){
        return "calculator-form";
    }
    @GetMapping("/power-form")
    public String powerForm() {
        return "power-form";
    }
    @GetMapping("/power")
    public String power(@RequestParam double a, Model model){
        model.addAttribute("power", a * a);
        return "power";
    }
}
