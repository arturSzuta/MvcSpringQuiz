package pl.sda.pol137.mvcspringquiz.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Controller
public class ExerciseController {
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public void sendHello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String name = request.getParameter("name");
        final String age = request.getParameter("age");
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        final PrintWriter writer = response.getWriter();
        writer.println("Hi " + name + ". Your age is " + age + "! Hello from Spring");
    }

    @GetMapping("/greeting")
    @ResponseBody
    public String sendWelcome(
            @RequestParam(name = "name", defaultValue = "anonymous") String name,
            @RequestParam(required = false) Integer age
    ){
        return age == null ? "Greetings " + name + "!" : "Greetings " + name + "! Your age is " + age + ". Hello from Spring";
    }
    @GetMapping("/calculate")
    @ResponseBody
    public String calculate(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam(defaultValue = "add") String op
    ){
        return switch (op) {
            case "add" -> String.format("%f + %f = %f", a, b, a + b);
            case "sub" -> String.format("%f - %f = %f", a, b, a - b);
            case "mul" -> String.format("%f * %f = %f", a, b, a * b);
            case "div" -> String.format("%f / %f = %f", a, b, a / b);
            default -> "Error";
        };
    }
}
