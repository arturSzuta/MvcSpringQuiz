package pl.sda.pol137.mvcspringquiz.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class CalculatorData {
    private double a;
    private double b;
    private String operator;
    public double getResult() {
        return switch (operator) {
            case "add" ->  a + b;
            case "sub" ->  a - b;
            case "mul" ->  a * b;
            case "div" ->  a / b;
            default -> throw new IllegalArgumentException("Unknown operator");
        };
    }
    public String getOperator() {
        return switch (operator) {
            case "add" -> "+";
            case "sub" -> "-";
            case "mul" -> "*";
            case "div" -> "/";
            default -> "?";
        };
    }
}
