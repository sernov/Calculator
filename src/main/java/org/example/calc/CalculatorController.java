package org.example.calc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculationRepository calculationRepository;

    @GetMapping("/calculator")
    public String showCalculatorForm(Model model) {
        model.addAttribute("calculation", new Calculation());
        model.addAttribute("calculations", calculationRepository.findAll());
        return "calculator";
    }

    @PostMapping("/calculator")
    public String performCalculation(@ModelAttribute("calculation") Calculation calculation, Model model) {
        double operand1 = calculation.getOperand1();
        double operand2 = calculation.getOperand2();
        String operator = calculation.getOperator();

        switch (operator) {
            case "+":
                calculation.setResult(operand1 + operand2);
                break;
            case "-":
                calculation.setResult(operand1 - operand2);
                break;
            case "*":
                calculation.setResult(operand1 * operand2);
                break;
            case "/":
                calculation.setResult(operand1 / operand2);
                break;
            case "^":
                calculation.setResult(Math.pow(operand1, operand2));
                break;
            default:
                model.addAttribute("error", "Invalid operator");
                return "calculator";
        }

        calculationRepository.save(calculation);
        return "redirect:/calculator";
    }
}